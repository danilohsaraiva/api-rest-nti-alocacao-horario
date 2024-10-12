package estudos.dio.apirestntialocacaohorario.domain.model;

import estudos.dio.apirestntialocacaohorario.domain.dtos.CursoDto;
import estudos.dio.apirestntialocacaohorario.domain.dtos.UniversidadeDto;
import jakarta.persistence.*;
import lombok.*;
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
