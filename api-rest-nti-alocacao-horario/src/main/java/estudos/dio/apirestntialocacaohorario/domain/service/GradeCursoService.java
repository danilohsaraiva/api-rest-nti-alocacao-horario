package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.dtos.GradeCursoDTO;
import estudos.dio.apirestntialocacaohorario.domain.model.GradeCurso;

import java.util.List;

public interface GradeCursoService {
    GradeCurso findById(Long id);
    GradeCurso create(GradeCursoDTO gradeCurso);

    List<GradeCurso> findAll();

    GradeCurso deleteById(Long id);
}
