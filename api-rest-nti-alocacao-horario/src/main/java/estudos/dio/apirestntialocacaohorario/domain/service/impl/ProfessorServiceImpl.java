package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.Professor;
import estudos.dio.apirestntialocacaohorario.domain.repository.ProfessorRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.ProfessorService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepositorio professorRepositorio;

    public ProfessorServiceImpl(ProfessorRepositorio professorRepositorio) {
        this.professorRepositorio = professorRepositorio;
    }
    @Override
    public Professor findById(Long id) {
        return professorRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Professor create(Professor professorParaCriar) {
        if(professorParaCriar.getId() != null && professorRepositorio.existsById(professorParaCriar.getId())) {
            throw new IllegalArgumentException("ID já existe!");
        }
        var professorCriado = professorRepositorio.save(professorParaCriar);
        return professorCriado;
    }
}
