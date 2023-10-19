package estudos.dio.apirestntialocacaohorario.domain.repository;

import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepositorio extends JpaRepository<Semestre, Long> {

}
