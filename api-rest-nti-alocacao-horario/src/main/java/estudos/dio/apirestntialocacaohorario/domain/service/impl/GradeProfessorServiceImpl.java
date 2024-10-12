package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.Grade;
import estudos.dio.apirestntialocacaohorario.domain.model.GradeProfessor;
import estudos.dio.apirestntialocacaohorario.domain.repository.GradeProfessorRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.GradeProfessorService;
import org.springframework.stereotype.Service;

@Service
public class GradeProfessorServiceImpl implements GradeProfessorService {
    private final GradeProfessorRepositorio gradeProfessorRepositorio;
    GradeProfessorServiceImpl(GradeProfessorRepositorio gradeProfessorRepositorio) {
        this.gradeProfessorRepositorio = gradeProfessorRepositorio;
    }
    @Override
    public Grade findById(Long id) {
        return gradeProfessorRepositorio.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public Grade create(GradeProfessor preferenciaGrade) {
        if(preferenciaGrade.getId() != null && gradeProfessorRepositorio.existsById(preferenciaGrade.getId())) {
            throw new IllegalArgumentException("ID já existe!");
        }
        var preferenciaGradeParaCriar = gradeProfessorRepositorio.save(preferenciaGrade);
        return preferenciaGradeParaCriar;
    }
}
