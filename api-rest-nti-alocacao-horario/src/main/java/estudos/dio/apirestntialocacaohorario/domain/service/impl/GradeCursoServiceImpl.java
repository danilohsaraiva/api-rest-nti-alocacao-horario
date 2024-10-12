package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.GradeCurso;
import estudos.dio.apirestntialocacaohorario.domain.repository.GradeCursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.GradeCursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GradeCursoServiceImpl implements GradeCursoService {

    public final GradeCursoRepositorio gradeCursoRepositorio;

    public GradeCursoServiceImpl(GradeCursoRepositorio gradeCursoRepositorio) {
        this.gradeCursoRepositorio = gradeCursoRepositorio;
    }

    @Override
    public GradeCurso findById(Long id) {
        return gradeCursoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public GradeCurso create(GradeCurso gradeCurso) {
        if((gradeCurso.getId()!= null && gradeCursoRepositorio.existsById(gradeCurso.getId()))) {
            throw new IllegalArgumentException("Id já existe");
        }
        GradeCurso grade = gradeCursoRepositorio.save(gradeCurso);
        return grade;
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
