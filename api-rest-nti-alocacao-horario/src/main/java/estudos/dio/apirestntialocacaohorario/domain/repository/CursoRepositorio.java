package estudos.dio.apirestntialocacaohorario.domain.repository;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    List<Curso> findAll();

    Curso findByNomeCurso(String nome);

    boolean existsByNomeCurso(String nome);

    List<Curso> findAllByIdCursoIn(List<Long> ids);
}
