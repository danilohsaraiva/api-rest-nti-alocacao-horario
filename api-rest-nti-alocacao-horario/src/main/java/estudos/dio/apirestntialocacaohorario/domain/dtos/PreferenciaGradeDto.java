package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.PreferenciaGrade;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record PreferenciaGradeDto(String dia, List<String> horariosList) {
    public PreferenciaGradeDto(PreferenciaGrade preferenciaGrade) {
        this (
                preferenciaGrade.getDia(),
                Optional.ofNullable(preferenciaGrade.getHorariosPreferiveis()).orElse(Collections.emptyList()).stream().map(Object::toString).collect(Collectors.toList()));
        ;
    }

    public  PreferenciaGrade toModel() {
        PreferenciaGrade preferenciaGrade = new PreferenciaGrade();

        preferenciaGrade.setDia(this.dia);
        preferenciaGrade.setHorariosPreferiveis(this.horariosList);

        return preferenciaGrade;
    }
}
