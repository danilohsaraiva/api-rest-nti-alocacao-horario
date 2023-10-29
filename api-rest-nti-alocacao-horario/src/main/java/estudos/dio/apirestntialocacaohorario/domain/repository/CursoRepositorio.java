package estudos.dio.apirestntialocacaohorario.domain.repository;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    public List<Curso> findAll();

    public Curso findByNome(String nome);

    public boolean existsByNome(String nome);
}
