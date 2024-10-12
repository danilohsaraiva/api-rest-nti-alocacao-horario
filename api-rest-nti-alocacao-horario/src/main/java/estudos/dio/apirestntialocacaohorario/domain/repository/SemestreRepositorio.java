package estudos.dio.apirestntialocacaohorario.domain.repository;

import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreRepositorio extends JpaRepository<Semestre, Long> {
    public List<Semestre> findAllByIdSemestreIn(List<Long> ids);
}
