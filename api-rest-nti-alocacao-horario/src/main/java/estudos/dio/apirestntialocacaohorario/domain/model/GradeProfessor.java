package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
@Data

@Entity(name = "tb_grade_professor")
public class GradeProfessor extends Grade{

    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
