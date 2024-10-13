package estudos.dio.apirestntialocacaohorario.domain.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DisciplinaDto implements Serializable {
    private String nomeDisciplina;
    private int cargaHorariaDisciplina;
    private List<Long> idsProfessores;
    private Long idSemestre;
    private List<Long> listaIdsCursos;

}
