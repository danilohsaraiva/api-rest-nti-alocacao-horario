package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.DisciplinaServiceImpl;

import java.util.List;

public interface DisciplinaService {
    Disciplina findById(Long id);

    Disciplina create(Disciplina disciplina);
}
