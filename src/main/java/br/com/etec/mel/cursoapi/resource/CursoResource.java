package br.com.etec.mel.cursoapi.resource;

import br.com.etec.mel.cursoapi.model.Curso;
import br.com.etec.mel.cursoapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")

public class CursoResource {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/todos")
    public List<Curso> ListarTodosCursos() {
        return cursoRepository.findAll();
    }
}
