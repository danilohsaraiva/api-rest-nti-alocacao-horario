package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Professor;
import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record ProfessorDto(String nomeProfessor, List<PreferenciaGradeDto> preferenciaGrades, @NotNull List<DisciplinaDto> disciplinas) {
    public ProfessorDto(Professor professor){
        this(
                professor.getNome(),
                Optional.ofNullable(professor.getPreferencias()).orElse(Collections.emptyList()).stream().map(PreferenciaGradeDto::new).collect(Collectors.toList()),
                Optional.ofNullable(professor.getDisciplinas()).orElse(Collections.emptyList()).stream().map(DisciplinaDto::new).collect(Collectors.toList())
        );
    }

    public Professor toModel() {
        Professor professor = new Professor();

        professor.setNome(this.nomeProfessor);
        professor.setDisciplinas(this.disciplinas.stream().map(DisciplinaDto::toModel).collect(Collectors.toList()));
        professor.setPreferencias(this.preferenciaGrades.stream().map(PreferenciaGradeDto::toModel).collect(Collectors.toList()));

        return professor;
    }
}