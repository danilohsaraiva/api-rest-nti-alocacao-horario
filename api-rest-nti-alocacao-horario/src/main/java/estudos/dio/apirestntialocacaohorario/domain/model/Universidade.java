package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_universidade")

public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversidade;
    private String nomeUniversidade;
    private String siglaUniversidade;
    private String ufUiversidade;
    private String municipioUniversidade;
    private String categoriaAdministrativaUniversidade; //publica ou privada
    private String credenciaisUniversidade; //EAD, presencial
    @OneToMany(mappedBy = "universidade", cascade = CascadeType.ALL)
    private List<Curso> listaCursos;
}
