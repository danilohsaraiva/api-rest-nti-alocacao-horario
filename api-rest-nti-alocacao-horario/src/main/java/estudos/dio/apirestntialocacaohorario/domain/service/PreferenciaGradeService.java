package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.PreferenciaGrade;

public interface PreferenciaGradeService {
    PreferenciaGrade findById(Long id);
    PreferenciaGrade create(PreferenciaGrade preferenciaGrade);
}
