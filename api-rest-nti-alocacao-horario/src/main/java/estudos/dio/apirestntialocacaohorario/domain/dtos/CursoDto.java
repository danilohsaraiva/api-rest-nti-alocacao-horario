package estudos.dio.apirestntialocacaohorario.domain.dtos;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record CursoDto( String nome,  List<SemestreDto> semestres) {

    //@NotBlank e @NotNull

    public  CursoDto(Curso curso) {
        this(
                curso.getNome(),
                Optional.ofNullable(curso.getSemestres()).orElse(Collections.emptyList()).stream().map(SemestreDto::new).collect(Collectors.toList())
        );
    }

    public Curso toModel() {
        Curso curso = new Curso();
        curso.setNome(this.nome);
        curso.setSemestres(Optional.ofNullable(this.semestres).orElse(Collections.emptyList()).stream().map(SemestreDto::toModel).collect(Collectors.toList()));
        return curso;
    }
}



