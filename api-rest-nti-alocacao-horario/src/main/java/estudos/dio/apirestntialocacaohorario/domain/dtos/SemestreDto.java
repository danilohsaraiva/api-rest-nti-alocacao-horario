package estudos.dio.apirestntialocacaohorario.domain.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SemestreDto implements Serializable {

    private int anoSemestre;
    private int numeroSemestre;
    private List<Long> idsDisciplinas;
    private Long idCurso;
}
