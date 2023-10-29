package estudos.dio.apirestntialocacaohorario.domain.service;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;

import java.util.List;

public interface CursoService {
    Curso findByID(Long id);

    Curso create(Curso cursoParaCriar);

    List<Curso> findAll();

    Curso findByNome(String nome);

}
