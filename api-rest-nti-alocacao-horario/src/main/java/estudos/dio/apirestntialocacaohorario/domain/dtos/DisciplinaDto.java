package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.model.Professor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record DisciplinaDto(String nomeDisciplina, int cargaHoraria, List<ProfessorDto> professorList) {

    public DisciplinaDto(Disciplina disciplina) {
        this(
                disciplina.getNome(),
                disciplina.getCargaHoraria(),
                Optional.ofNullable(disciplina.getProfessores()).orElse(Collections.emptyList()).stream().map(ProfessorDto::new).collect(Collectors.toList()));
    }

    public Disciplina toModel() {
        Disciplina disciplina = new Disciplina();

        disciplina.setNome(this.nomeDisciplina);
        disciplina.setCargaHoraria(this.cargaHoraria);

        return disciplina;

    }
}
