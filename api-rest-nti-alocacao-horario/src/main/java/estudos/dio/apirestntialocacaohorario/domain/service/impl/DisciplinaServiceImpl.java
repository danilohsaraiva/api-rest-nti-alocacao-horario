package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.dtos.DisciplinaDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.model.Professor;
import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;
import estudos.dio.apirestntialocacaohorario.domain.repository.CursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.DisciplinaRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.ProfessorRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.SemestreRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.DisciplinaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {
    private final DisciplinaRepositorio disciplinaRepositorio;
    private final SemestreRepositorio semestreRepositorio;
    private final ProfessorRepositorio professorRepositorio;
    private final CursoRepositorio cursoRepositorio;

    public DisciplinaServiceImpl(DisciplinaRepositorio disciplinaRepositorio, SemestreRepositorio semestreRepositorio, ProfessorRepositorio professorRepositorio, CursoRepositorio cursoRepositorio) {
        this.disciplinaRepositorio = disciplinaRepositorio;
        this.semestreRepositorio = semestreRepositorio;
        this.professorRepositorio = professorRepositorio;
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public Disciplina findById(Long id) {
        return disciplinaRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Disciplina create(DisciplinaDto disciplinaDto) {
        Disciplina disciplina = new Disciplina();
        List<Professor> professores = new ArrayList<>();
        Semestre semestre = new Semestre();

        disciplina.setNomeDisciplina(disciplinaDto.getNomeDisciplina());
        disciplina.setCargaHorariaDisciplina(disciplinaDto.getCargaHorariaDisciplina());

        if (disciplinaDto.getIdsProfessores() != null) {
            professores = professorRepositorio.findAllById(disciplinaDto.getIdsProfessores());
        }

        disciplina.setListaProfessores(professores);

        if (disciplinaDto.getIdSemestre() != null) {
            semestre = semestreRepositorio.findById(disciplinaDto.getIdSemestre()).orElse(null);
        } else {
            semestre = null;
        }

        List<Curso> cursos = cursoRepositorio.findAllByIdCursoIn(disciplinaDto.getListaIdsCursos());
        if (cursos == null) {
            cursos = new ArrayList<>();
        }

        disciplina.setCursos(cursos);


        disciplina.setSemestre(semestre);

        return disciplinaRepositorio.save(disciplina);
    }
}
