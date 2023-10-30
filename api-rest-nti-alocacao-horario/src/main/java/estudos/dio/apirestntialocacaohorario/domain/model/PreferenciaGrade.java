package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "tb_preferencia")
public class PreferenciaGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dia;
    @ElementCollection
    private List<String> horariosPreferiveis = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
