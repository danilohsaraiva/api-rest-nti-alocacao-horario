package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.GradeCursoServiceImpl;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.SemestreServiceImpl;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.UniversidadeServiceImpl;

import java.io.Serializable;
import java.util.List;

public class CursoDto implements Serializable {

    //@NotBlank e @NotNull
    private Long universidadeId;
    private String nomeCurso;
    private String anoInicioCurso;
    private String anoFimCurso;
    private Long gradeCursoId;
    private List<Long> listaIdSemestres;

    public Curso toModel(SemestreServiceImpl semestreService, UniversidadeServiceImpl universidadeService, GradeCursoServiceImpl gradeCurso) {

        Curso curso = new Curso();

        curso.setAnoFimCurso(anoFimCurso);
        curso.setAnoInicioCurso(anoInicioCurso);

        curso.setUniversidade(universidadeService.findById(universidadeId));
        curso.setListaSemestres(semestreService.findAllById(listaIdSemestres));
        curso.setGradeCurso(gradeCurso.findById(gradeCursoId));

        return curso;
    }
}