package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.GradeCurso;

import java.io.Serializable;
import java.util.List;

public class GradeCursoDTO implements Serializable {
    private Long idCurso;
    private List<Long> listIdDisciplinas;

    public GradeCurso toModel() {
        GradeCurso gradeCurso  = new GradeCurso();

        return gradeCurso;
    }
}
