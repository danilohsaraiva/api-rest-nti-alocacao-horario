package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.dtos.UniversidadeDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;

public interface UniversidadeService {
    Universidade findById(Long id);

    Universidade create(UniversidadeDto universidadeDto);
}
