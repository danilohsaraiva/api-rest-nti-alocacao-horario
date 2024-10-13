package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.dtos.DisciplinaDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;

public interface DisciplinaService {
    Disciplina findById(Long id);

    Disciplina create(DisciplinaDto disciplinaDto);
}
