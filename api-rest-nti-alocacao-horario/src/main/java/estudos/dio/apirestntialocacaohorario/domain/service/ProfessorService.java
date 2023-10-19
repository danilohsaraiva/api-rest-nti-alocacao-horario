package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.Professor;

public interface ProfessorService {
    Professor findById(Long id);
    Professor create(Professor professorParaCriar);

}
