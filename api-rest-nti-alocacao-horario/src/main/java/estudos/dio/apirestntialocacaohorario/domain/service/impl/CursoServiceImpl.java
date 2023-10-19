package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.repository.CursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepositorio cursoRepositorio;

    public CursoServiceImpl(CursoRepositorio cursoRepositorio){
        this.cursoRepositorio = cursoRepositorio;
    }
    @Override
    public Curso findByID(Long id) {
        return cursoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Curso create(Curso cursoParaCriar) {
        if(cursoParaCriar.getId()!= null && cursoRepositorio.existsById(cursoParaCriar.getId())){
            throw new IllegalArgumentException("ID já existe!");
        }
        Curso cursoCriado = cursoRepositorio.save(cursoParaCriar);
        return cursoCriado;
    }

    public List<Curso> findAll() {

        return cursoRepositorio.findAll().stream().toList();
    }

    public Curso delete(Long id) {
        Curso dbCurso = this.findByID(id);
        cursoRepositorio.delete(dbCurso);
        return dbCurso;
    }
}
