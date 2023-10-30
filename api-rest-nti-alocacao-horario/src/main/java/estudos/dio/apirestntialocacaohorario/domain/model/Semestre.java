package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_semestre")

public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ano;
    private int semestreNumero;
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Disciplina> disciplinas;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
