package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_disciplina")

public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int cargaHoraria;
    @ManyToMany(mappedBy = "disciplinas", cascade = CascadeType.ALL)
    private List<Professor> professores;
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

}