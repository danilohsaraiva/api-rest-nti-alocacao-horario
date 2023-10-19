package estudos.dio.apirestntialocacaohorario.domain.service.impl;

import estudos.dio.apirestntialocacaohorario.domain.model.PreferenciaGrade;
import estudos.dio.apirestntialocacaohorario.domain.repository.PreferenciaGradeRepositorio;
import estudos.dio.apirestntialocacaohorario.domain.service.PreferenciaGradeService;
import org.springframework.stereotype.Service;

@Service
public class PreferenciaGradeServiceImpl implements PreferenciaGradeService {
    private final PreferenciaGradeRepositorio preferenciaGradeRepositorio;
    PreferenciaGradeServiceImpl(PreferenciaGradeRepositorio preferenciaGradeRepositorio) {
        this.preferenciaGradeRepositorio = preferenciaGradeRepositorio;
    }
    @Override
    public PreferenciaGrade findById(Long id) {
        return preferenciaGradeRepositorio.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public PreferenciaGrade create(PreferenciaGrade preferenciaGrade) {
        if(preferenciaGrade.getId() != null && preferenciaGradeRepositorio.existsById(preferenciaGrade.getId())) {
            throw new IllegalArgumentException("ID já existe!");
        }
        var preferenciaGradeParaCriar = preferenciaGradeRepositorio.save(preferenciaGrade);
        return preferenciaGradeParaCriar;
    }
}
