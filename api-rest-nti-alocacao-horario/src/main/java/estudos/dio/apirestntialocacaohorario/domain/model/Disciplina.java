package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_disciplina")

public class Disciplina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisciplina;
    private String nomeDisciplina;
    private int cargaHorariaDisciplina;
    @ManyToMany(mappedBy = "listaDisciplinas", cascade = CascadeType.ALL)
    private List<Professor> listaProfessores;
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

}