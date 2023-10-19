package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;
import estudos.dio.apirestntialocacaohorario.domain.repository.SemestreRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.SemestreService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class SemestreServiceImpl implements SemestreService {
    private final SemestreRepositorio semestreRepositorio;

    public SemestreServiceImpl(SemestreRepositorio semestreRepositorio) {
        this.semestreRepositorio = semestreRepositorio;
    }
    @Override
    public Semestre findById(Long id) {
        return semestreRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Semestre create(Semestre semestre) {
        if(semestre.getId() != null && semestreRepositorio.existsById(semestre.getId())) {
            throw new IllegalArgumentException("ID já existe");
        }
        return semestreRepositorio.save(semestre);
    }
}
