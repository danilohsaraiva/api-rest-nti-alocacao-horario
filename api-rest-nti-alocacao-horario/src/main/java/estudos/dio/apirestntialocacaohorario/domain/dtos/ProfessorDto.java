package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.PreferenciaGrade;
import estudos.dio.apirestntialocacaohorario.domain.model.Professor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record ProfessorDto(String nome, List<DisciplinaDto> disciplinaDtoList, List<PreferenciaGradeDto> preferenciaGrades) {

    public ProfessorDto(Professor professor){
        this(
                professor.getNome(),
                Optional.ofNullable(professor.getDisciplinas()).orElse(Collections.emptyList()).stream().map(DisciplinaDto::new).collect(Collectors.toList()),
                Optional.ofNullable(professor.getPreferencias()).orElse(Collections.emptyList()).stream().map(PreferenciaGradeDto::new).collect(Collectors.toList())
        );
    }

    public Professor toModel() {
        Professor professor = new Professor();

        professor.setNome(this.nome);
        professor.setDisciplinas(Optional.ofNullable(this.disciplinaDtoList).orElse(Collections.emptyList()).stream().map(DisciplinaDto::toModel).collect(Collectors.toList()));
        professor.setPreferencias(Optional.ofNullable(this.preferenciaGrades).orElse(Collections.emptyList()).stream().map(PreferenciaGradeDto::toModel).collect(Collectors.toList()));

        return professor;
    }
}