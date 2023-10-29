package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;

import java.util.Collections;
import java.util.Optional;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public record SemestreDto(int ano, int numeroSemestre, List<DisciplinaDto> disciplinaList) {
    public SemestreDto(Semestre semestre) {
        this(
                semestre.getAno(),
                semestre.getSemestreNumero(),
                Optional.ofNullable(semestre.getDisciplinas()).orElse(Collections.emptyList()).stream().map(DisciplinaDto::new).collect(Collectors.toList())
        );
    }

    public Semestre toModel() {

        Semestre semestre = new Semestre();

        semestre.setAno(this.ano);
        semestre.setSemestreNumero(this.numeroSemestre);
        semestre.setDisciplinas(Optional.ofNullable(this.disciplinaList).orElse(Collections.emptyList()).stream().map(DisciplinaDto::toModel).collect(Collectors.toList()));

        return semestre;
    }
}
