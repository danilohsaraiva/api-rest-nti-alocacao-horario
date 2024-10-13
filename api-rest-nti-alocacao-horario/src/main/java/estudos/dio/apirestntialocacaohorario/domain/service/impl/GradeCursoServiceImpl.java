package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.dtos.GradeCursoDTO;
import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.model.GradeCurso;
import estudos.dio.apirestntialocacaohorario.domain.repository.CursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.DisciplinaRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.GradeCursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.GradeCursoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GradeCursoServiceImpl implements GradeCursoService {

    public final GradeCursoRepositorio gradeCursoRepositorio;
    public final CursoRepositorio cursoRepositorio;
    public final DisciplinaRepositorio disciplinaRepositorio;

    public GradeCursoServiceImpl(GradeCursoRepositorio gradeCursoRepositorio, CursoRepositorio cursoRepositorio, DisciplinaRepositorio disciplinaRepositorio) {
        this.gradeCursoRepositorio = gradeCursoRepositorio;
        this.cursoRepositorio = cursoRepositorio;
        this.disciplinaRepositorio = disciplinaRepositorio;
    }

    @Override
    public GradeCurso findById(Long id) {
        return gradeCursoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public GradeCurso create(GradeCursoDTO gradeCursoDto) {
        GradeCurso gradeCurso = new GradeCurso();
        List<Disciplina> disciplinas = new ArrayList<>();

        Curso curso = cursoRepositorio.findById(gradeCursoDto.getIdCurso().longValue()).orElse(null);

        if(gradeCursoDto.getListIdDisciplinas() != null) {
             disciplinas = disciplinaRepositorio.findAllById(gradeCursoDto.getListIdDisciplinas());
        }

        return gradeCurso;
    }

    @Override
    public List<GradeCurso> findAll() {
        return gradeCursoRepositorio.findAll().stream().toList();
    }

    @Override
    public GradeCurso deleteById(Long id) {
        Optional<GradeCurso> gradeCursoOpt= gradeCursoRepositorio.findById(id);

        if(gradeCursoOpt.isPresent()) {
            GradeCurso grade = gradeCursoOpt.get();
            gradeCursoRepositorio.deleteById(id);
            return grade;
        }
        throw new IllegalArgumentException("Id não existe");
    }

}
