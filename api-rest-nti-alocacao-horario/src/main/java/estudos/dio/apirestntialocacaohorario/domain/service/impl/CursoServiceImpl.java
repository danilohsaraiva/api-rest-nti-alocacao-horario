package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.dtos.CursoDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.model.GradeCurso;
import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;
import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;
import estudos.dio.apirestntialocacaohorario.domain.repository.CursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.GradeCursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.SemestreRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.UniversidadeRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepositorio cursoRepositorio;
    private final GradeCursoRepositorio gradeCursoRepositorio;
    private final SemestreRepositorio semestreRepositorio;
    private final UniversidadeRepositorio universidadeRepositorio;

    public CursoServiceImpl(CursoRepositorio cursoRepositorio, GradeCursoRepositorio gradeCursoRepositorio, SemestreRepositorio semestreRepositorio, UniversidadeRepositorio universidadeRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
        this.gradeCursoRepositorio = gradeCursoRepositorio;
        this.semestreRepositorio = semestreRepositorio;
        this.universidadeRepositorio = universidadeRepositorio;
    }

    @Override
    public Curso findByID(Long id) {
        return cursoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Curso create(CursoDto cursoDto) {

        Curso curso = new Curso();

        curso.setNomeCurso(cursoDto.getNomeCurso());

        if (cursoDto.getUniversidadeId() == null) {
            throw new RuntimeException("ID da Universidade não pode ser null");
        } else {
            Universidade universidade = universidadeRepositorio.findById(cursoDto.getUniversidadeId().longValue())
                    .orElseThrow(() -> new RuntimeException("Universidade não encontrada"));
            curso.setUniversidade(universidade);
        }

        if (cursoDto.getListaIdSemestres() != null && !cursoDto.getListaIdSemestres().isEmpty()) {
            curso.setListaSemestres(semestreRepositorio.findAllByIdSemestreIn(cursoDto.getListaIdSemestres()));
        }
        List<Semestre> semestres = semestreRepositorio.findAllByIdSemestreIn(cursoDto.getListaIdSemestres());
        if (semestres.isEmpty() || semestres == null) {
            semestres = Collections.emptyList();
        }
        curso.setListaSemestres(semestres);

        GradeCurso gradeCurso = gradeCursoRepositorio.findById(cursoDto.getGradeCursoId().longValue()).orElse(null);

        curso.setGradeCurso(gradeCurso);


        curso.setAnoInicioCurso(cursoDto.getAnoInicioCurso());
        curso.setAnoFimCurso(cursoDto.getAnoFimCurso());

        return cursoRepositorio.save(curso);
    }

    public List<Curso> findAll() {

        return cursoRepositorio.findAll().stream().toList();
    }

    public Curso delete(Long id) {
        Curso dbCurso = this.findByID(id);
        cursoRepositorio.delete(dbCurso);
        return dbCurso;
    }

    @Override
    public List<Curso> findByIdList(List<Long> listaIdCursos) {
        return cursoRepositorio.findAllByIdCursoIn(listaIdCursos);
    }

    @Override
    public Curso findByNome(String nome) {
        Curso curso = cursoRepositorio.findByNomeCurso(nome);
        return curso;
    }

}
