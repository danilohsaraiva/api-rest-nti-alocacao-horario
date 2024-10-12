package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;

import java.util.List;

public interface SemestreService {
    public Semestre findById(Long id);
    public Semestre create(Semestre semestre);
    public List<Semestre> findAllById(List<Long> ids);
}
