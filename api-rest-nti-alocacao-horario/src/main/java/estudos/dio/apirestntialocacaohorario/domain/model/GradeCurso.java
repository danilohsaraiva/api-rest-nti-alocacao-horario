package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
