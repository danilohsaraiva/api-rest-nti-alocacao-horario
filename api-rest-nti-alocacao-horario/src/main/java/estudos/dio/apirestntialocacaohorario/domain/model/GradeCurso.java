package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
@Data
@Entity(name = "tb_grade_curso")
@NoArgsConstructor
@AllArgsConstructor
public class GradeCurso extends Grade{

    private int periodoCurso;
    @OneToOne
    private Curso curso;
    @OneToMany
    private List<Disciplina> disciplinas;
}
