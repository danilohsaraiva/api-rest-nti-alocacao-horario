package estudos.dio.apirestntialocacaohorario.domain.repository;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    public List<Curso> findAll();

    public Curso findByNomeCurso(String nome);

    public boolean existsByNomeCurso(String nome);
}
