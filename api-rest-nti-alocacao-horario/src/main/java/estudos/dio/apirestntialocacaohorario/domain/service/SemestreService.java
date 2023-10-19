package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;

public interface SemestreService {
    public Semestre findById(Long id);
    public Semestre create(Semestre semestre);
}
