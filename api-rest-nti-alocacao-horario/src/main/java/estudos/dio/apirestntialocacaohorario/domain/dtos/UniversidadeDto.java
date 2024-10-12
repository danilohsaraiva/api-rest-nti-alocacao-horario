package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.CursoServiceImpl;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class UniversidadeDto implements Serializable {
    private String nomeUniversidade;
    private String siglaUniversidade;
    private String ufUniversidade;
    private String municipioUniversidade;
    private String categoriaAdministrativaUniversidade;
    private String credencialUniversidade;
    private List<Long> listaIdCursos = new ArrayList<>();

}
