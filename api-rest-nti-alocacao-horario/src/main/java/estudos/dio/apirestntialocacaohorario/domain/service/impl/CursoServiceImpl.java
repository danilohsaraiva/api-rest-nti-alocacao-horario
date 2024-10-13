package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.dtos.CursoDto;
import estudos.dio.apirestntialocacaohorario.domain.model.*;
import estudos.dio.apirestntialocacaohorario.domain.repository.*;
import estudos.dio.apirestntialocacaohorario.domain.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepositorio cursoRepositorio;
    private final GradeCursoRepositorio gradeCursoRepositorio;
    private final SemestreRepositorio semestreRepositorio;
    private final UniversidadeRepositorio universidadeRepositorio;
    private final DisciplinaRepositorio disciplinaRepositorio;

    public CursoServiceImpl(CursoRepositorio cursoRepositorio, GradeCursoRepositorio gradeCursoRepositorio, SemestreRepositorio semestreRepositorio, UniversidadeRepositorio universidadeRepositorio, DisciplinaRepositorio disciplinaRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
        this.gradeCursoRepositorio = gradeCursoRepositorio;
        this.semestreRepositorio = semestreRepositorio;
        this.universidadeRepositorio = universidadeRepositorio;
        this.disciplinaRepositorio = disciplinaRepositorio;
    }

    @Override
    public Curso findByID(Long id) {
        return cursoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Curso create(CursoDto cursoDto) {

        Curso curso = new Curso();
        GradeCurso gradeCurso;


        curso.setNomeCurso(cursoDto.getNomeCurso());

        if (cursoDto.getUniversidadeId() == null) {
            throw new RuntimeException("ID da Universidade não pode ser null");
        } else {
            Universidade universidade = universidadeRepositorio.findById(cursoDto.getUniversidadeId().longValue())
                    .orElseThrow(() -> new RuntimeException("Universidade não encontrada"));
            curso.setUniversidade(universidade);
        }

        List<Semestre> semestres = semestreRepositorio.findAllByIdSemestreIn(cursoDto.getListaIdSemestres());
        if (semestres == null) {
            semestres = new ArrayList<>();
        }


        curso.setListaSemestres(semestres);
        if (cursoDto.getGradeCursoId() != null) {
            gradeCurso = gradeCursoRepositorio.findById(cursoDto.getGradeCursoId().longValue()).orElse(null);
        } else {
            gradeCurso = null;
        }

        curso.setGradeCurso(gradeCurso);

        List<Disciplina> disciplinas = disciplinaRepositorio.findAllByIdDisciplinaIn(cursoDto.getListaIdsDisciplinas());
        if (disciplinas == null) {
            disciplinas = new ArrayList<>();
        }

        curso.setDisciplinas(disciplinas);

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
