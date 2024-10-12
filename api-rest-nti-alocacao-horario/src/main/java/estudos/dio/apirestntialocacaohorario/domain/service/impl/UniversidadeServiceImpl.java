package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.dtos.UniversidadeDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;
import estudos.dio.apirestntialocacaohorario.domain.repository.CursoRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.repository.UniversidadeRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.UniversidadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UniversidadeServiceImpl implements UniversidadeService {
    private final UniversidadeRepositorio universidadeRepositorio;
    private final CursoRepositorio cursoRepositorio;

    public UniversidadeServiceImpl(UniversidadeRepositorio universidadeRepositorio, CursoRepositorio cursoRepositorio) {
        this.universidadeRepositorio = universidadeRepositorio;
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public Universidade findById(Long id) {
        return universidadeRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Universidade create(UniversidadeDto universidadeDto) {

        Universidade universidade = new Universidade();

        universidade.setNomeUniversidade(universidadeDto.getNomeUniversidade());
        universidade.setSiglaUniversidade(universidadeDto.getSiglaUniversidade());
        universidade.setUfUniversidade(universidadeDto.getUfUniversidade());
        universidade.setMunicipioUniversidade(universidadeDto.getMunicipioUniversidade());
        universidade.setCategoriaAdministrativaUniversidade(universidadeDto.getCategoriaAdministrativaUniversidade());
        universidade.setCredencialUniversidade(universidadeDto.getCredencialUniversidade());

        if (universidadeDto.getListaIdCursos() != null && !universidadeDto.getListaIdCursos().isEmpty()) {
            List<Curso> cursos = cursoRepositorio.findAllByIdCursoIn(universidadeDto.getListaIdCursos());
            universidade.setListaCursos(cursos);
        }

        return universidadeRepositorio.save(universidade);
    }

}
