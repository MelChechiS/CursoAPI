package br.com.etec.mel.cursoapi.repository;

import br.com.etec.mel.cursoapi.model.Aluno;
import br.com.etec.mel.cursoapi.repository.filter.AlunoFilter;
import br.com.etec.mel.cursoapi.repository.projections.AlunoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<AlunoDto> filtrar(AlunoFilter alunoFilter, Pageable pageable);
}
