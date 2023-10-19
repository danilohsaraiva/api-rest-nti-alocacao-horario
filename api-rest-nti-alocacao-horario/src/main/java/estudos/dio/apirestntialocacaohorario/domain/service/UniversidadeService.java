package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;

public interface UniversidadeService {
    public Universidade findById(Long id);
    public Universidade create(Universidade universidade);
}
