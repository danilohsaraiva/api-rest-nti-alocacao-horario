package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name ="tb_professor")

public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long id;
    private String nome;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "disciplinas_professores", joinColumns = @JoinColumn(name = "fk_professor"), inverseJoinColumns = @JoinColumn(name = "fk_disciplina"))
    private List<Disciplina> disciplinas;
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<PreferenciaGrade> preferencias;
}
