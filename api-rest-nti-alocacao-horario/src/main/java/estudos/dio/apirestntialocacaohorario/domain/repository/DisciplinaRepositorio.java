package estudos.dio.apirestntialocacaohorario.domain.repository;

import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Long> {
    Disciplina findByIdDisciplina(Long id);

    List<Disciplina> findAllByIdDisciplinaIn(List<Long> idsDisciplinas);
}
