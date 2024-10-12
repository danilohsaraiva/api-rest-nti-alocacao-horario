package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_curso")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;


    @ManyToOne
    @JoinColumn(name = "universidade_id")
    private Universidade universidade;
    private String nomeCurso;
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Semestre> listaSemestres;
    private GradeCurso gradeCurso;
    private String anoInicioCurso;
    private String anoFimCurso;
}
