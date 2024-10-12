package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data

@Entity(name = "tb_grade_professor")
public class GradeProfessor extends Grade{

    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
