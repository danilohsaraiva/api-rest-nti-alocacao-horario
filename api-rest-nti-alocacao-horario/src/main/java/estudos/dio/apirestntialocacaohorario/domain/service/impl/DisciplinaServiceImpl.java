package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.repository.DisciplinaRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class DisciplinaServiceImpl implements DisciplinaService {
    private final DisciplinaRepositorio disciplinaRepositorio;

    public DisciplinaServiceImpl(DisciplinaRepositorio disciplinaRepositorio) {
        this.disciplinaRepositorio = disciplinaRepositorio;
    }
    @Override
    public Disciplina findById(Long id) {
        return disciplinaRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Disciplina create(Disciplina disciplinaParaCriar) {
        if(disciplinaParaCriar.getId() != null && disciplinaRepositorio.existsById(disciplinaParaCriar.getId())) {
            throw  new IllegalArgumentException("ID já existe");
        }
        Disciplina disciplinaNova = disciplinaRepositorio.save(disciplinaParaCriar);
        return disciplinaNova;
    }
}
