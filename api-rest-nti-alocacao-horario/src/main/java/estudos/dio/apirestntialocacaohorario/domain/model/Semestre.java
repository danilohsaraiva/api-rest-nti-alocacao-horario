package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_semestre")

public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSemestre;
    private int anoSemestre;
    private int numeroSemestre;
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Disciplina> listaDisciplinas;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
