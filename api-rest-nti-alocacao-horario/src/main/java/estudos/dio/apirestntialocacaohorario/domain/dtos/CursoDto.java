package estudos.dio.apirestntialocacaohorario.domain.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CursoDto implements Serializable {

    //@NotBlank e @NotNull
    private Long universidadeId;
    private String nomeCurso;
    private String anoInicioCurso;
    private String anoFimCurso;
    private Long gradeCursoId;
    private List<Long> listaIdSemestres = new ArrayList<>();

}