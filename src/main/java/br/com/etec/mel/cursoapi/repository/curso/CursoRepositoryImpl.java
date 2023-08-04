package br.com.etec.mel.cursoapi.repository.curso;

import br.com.etec.mel.cursoapi.model.Curso;
import br.com.etec.mel.cursoapi.repository.filter.CursoFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryImpl implements CursoRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

   @Override
    public Page<Curso> Filtrar(CursoFilter cursoFilter, Pageable pageble) {

       CriteriaBuilder builder = manager.getCriteriaBuilder();
       CriteriaQuery<Curso> criteria = builder.createQuery(Curso.class);
       Root<Curso> root = criteria.from(Curso.class);

       Predicate[] predicates = criarRestricoes(cursoFilter, builder, root);
       criteria.where(predicates);
       criteria.orderBy(builder.asc(root.get("nomecurso")));

       TypedQuery<Curso> query = manager.createQuery(criteria);
       

        return null;
    }

    private Long totalDePaginas(CursoFilter cursoFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder(); //criação de consulta
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class); //select que retorna a qtde de registros da pág
        Root<Curso> root = criteria.from(Curso.class); // é o pai, mostra qual é  a classe pai do sql

        Predicate[] predicates = criarRestricoes(cursoFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecurso")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();

    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Curso> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(CursoFilter cursoFilter, CriteriaBuilder builder, Root<Curso> root) {

       List<Predicate> predicates = new ArrayList();

       if (!StringUtils.isEmpty(cursoFilter.getNomecurso())) {
           predicates.add(builder.like(builder.lower(root.get("nomecurso")),
           "%" + cursoFilter.getNomecurso().toLowerCase() + "%"));
       }
       return predicates.toArray(new Predicate[predicates.size()]);
    }
}
