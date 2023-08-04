package br.com.etec.mel.cursoapi.resource;

import br.com.etec.mel.cursoapi.model.Aluno;
import br.com.etec.mel.cursoapi.repository.AlunoRepository;
import br.com.etec.mel.cursoapi.repository.filter.AlunoFilter;
import br.com.etec.mel.cursoapi.repository.projections.AlunoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AlunoResource{

@Autowired
private AlunoRepository alunoRepository;

@GetMapping("/todos")
public List<Aluno> listarTodosAlunos() {
    return alunoRepository.findAll();
}

    @GetMapping()
    public Page<AlunoDto> pesquisar(AlunoFilter alunoFilter, Pageable pageable){
        return alunoRepository.filtrar(alunoFilter, pageable);
    }
}


