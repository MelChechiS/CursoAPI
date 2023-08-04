package br.com.etec.mel.cursoapi.repository;

import br.com.etec.mel.cursoapi.model.Cidade;
import br.com.etec.mel.cursoapi.repository.cidade.CidadeRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>, CidadeRepositoryQuery {
}
