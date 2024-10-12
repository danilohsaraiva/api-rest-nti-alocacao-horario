package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.dtos.CursoDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Curso;

import java.util.List;

public interface CursoService {
    Curso findByID(Long id);

    Curso create(CursoDto cursoDto);

    List<Curso> findAll();

    Curso findByNome(String nome);

    Curso delete(Long id);

    List<Curso> findByIdList(List<Long> listaIdCursos);

}
