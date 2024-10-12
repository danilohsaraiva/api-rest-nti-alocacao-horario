package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;
import estudos.dio.apirestntialocacaohorario.domain.repository.UniversidadeRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.UniversidadeService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class UniversidadeServiceImpl implements UniversidadeService {
    private final UniversidadeRepositorio universidadeRepositorio;

    public UniversidadeServiceImpl(UniversidadeRepositorio universidadeRepositorio) {
        this.universidadeRepositorio = universidadeRepositorio;
    }
    @Override
    public Universidade findById(Long id) {
        return universidadeRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Universidade create(Universidade universidade) {
        if(universidade.getIdUniversidade() != null && universidadeRepositorio.existsById(universidade.getIdUniversidade())) {
            throw new IllegalArgumentException("ID já existe!");
        }
        return universidadeRepositorio.save(universidade);
    }
}
