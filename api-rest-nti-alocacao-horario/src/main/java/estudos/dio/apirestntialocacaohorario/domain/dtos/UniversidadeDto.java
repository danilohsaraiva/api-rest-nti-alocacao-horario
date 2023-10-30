package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record UniversidadeDto(String nome, List<CursoDto> cursos) {
    public UniversidadeDto(Universidade universidade) {
        this(
                universidade.getNome(),
                Optional.ofNullable(universidade.getCursos()).orElse(Collections.emptyList()).stream().map(CursoDto::new).collect(Collectors.toList())
        );
    }

    public Universidade toModel() {
        Universidade universidade = new Universidade();
        universidade.setCursos(Optional.ofNullable(this.cursos).orElse(Collections.emptyList()).stream().map(CursoDto::toModel).collect(Collectors.toList()));
        universidade.setNome(this.nome);
        return universidade;
    }
}
