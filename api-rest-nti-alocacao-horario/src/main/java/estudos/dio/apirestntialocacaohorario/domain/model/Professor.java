package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="tb_professor")

public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long idProfessor;

    private String nomeProfessor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "disciplinas_professores", joinColumns = @JoinColumn(name = "fk_professor"), inverseJoinColumns = @JoinColumn(name = "fk_disciplina"))
    private List<Disciplina> listaDisciplinas;

    @OneToOne(mappedBy = "professor", cascade = CascadeType.ALL)
    private GradeProfessor gradeProfessor;


}
