package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.Grade;
import estudos.dio.apirestntialocacaohorario.domain.model.GradeProfessor;

public interface GradeProfessorService {
    Grade findById(Long id);
    Grade create(GradeProfessor preferenciaGrade);
}
