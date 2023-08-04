package br.com.etec.mel.cursoapi.repository.aluno;

import br.com.etec.mel.cursoapi.repository.filter.AlunoFilter;
import br.com.etec.mel.cursoapi.repository.projections.AlunoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoRepositoryQuery {

    public Page<AlunoDto> filtrar(AlunoFilter alunoFilter, Pageable pageable);

    Page<AlunoDto> Filtrar(AlunoFilter alunoFilter, Pageable pageble);
}
