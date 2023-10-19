package estudos.dio.apirestntialocacaohorario.domain.repository;

import estudos.dio.apirestntialocacaohorario.domain.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepositorio extends JpaRepository<Professor, Long> {
    
}
