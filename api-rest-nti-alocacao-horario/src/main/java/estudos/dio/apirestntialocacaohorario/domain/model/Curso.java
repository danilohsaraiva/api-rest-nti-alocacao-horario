package estudos.dio.apirestntialocacaohorario.domain.model;

import estudos.dio.apirestntialocacaohorario.domain.dtos.CursoDto;
import estudos.dio.apirestntialocacaohorario.domain.dtos.UniversidadeDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_curso")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "universidade_id")
    public Universidade universidade;
    String nome;
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    List<Semestre> semestres;
}
