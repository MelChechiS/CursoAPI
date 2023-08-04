package br.com.etec.mel.cursoapi.repository.cidade;

import br.com.etec.mel.cursoapi.model.Cidade;
import br.com.etec.mel.cursoapi.repository.filter.CidadeFilter;
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

public class CidadeRepositoryImpl implements CidadeRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Cidade> Filtrar(CidadeFilter cidadeFilter, Pageable pageble) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cidade> criteria = builder.createQuery(Cidade.class);
        Root<Cidade> root = criteria.from(Cidade.class);

        Predicate[] predicates = criarRestricoes(cidadeFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecidade")));

        TypedQuery<Cidade> query = manager.createQuery(criteria);

        return null;
    }

    private Long totalDePaginas (CidadeFilter cidadeFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Cidade> root = criteria.from(Cidade.class);

        Predicate[] predicates = criarRestricoes(cidadeFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecidade")));
        criteria.orderBy(builder.asc(root.get("UF")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Cidade> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(CidadeFilter cidadeFilter, CriteriaBuilder builder, Root<Cidade> root) {

        List<Predicate> predicates = new ArrayList();

        if (!StringUtils.isEmpty(cidadeFilter.getNomecidade())) {
            predicates.add(builder.like(builder.lower(root.get("nomecidade")),
                    "%" + cidadeFilter.getNomecidade().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(cidadeFilter.getUf())){
            predicates.add(builder.like(builder.upper(root.get("UF")),
                    "%" + cidadeFilter.getUf().toUpperCase() + "%"));
            ;
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
