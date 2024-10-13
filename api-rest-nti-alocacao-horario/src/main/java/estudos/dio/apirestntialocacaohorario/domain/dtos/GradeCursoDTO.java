package estudos.dio.apirestntialocacaohorario.domain.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GradeCursoDTO implements Serializable {
    private int periodo;
    private Long idCurso;
    private List<Long> listIdDisciplinas;

}
