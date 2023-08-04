package br.com.etec.mel.cursoapi.repository.cidade;

import br.com.etec.mel.cursoapi.model.Cidade;
import br.com.etec.mel.cursoapi.repository.filter.CidadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadeRepositoryQuery {
    public Page<Cidade> Filtrar(CidadeFilter cidadeFilter, Pageable pageble);
}
