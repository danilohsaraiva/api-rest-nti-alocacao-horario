package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.DisciplinaDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.service.DisciplinaService;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.DisciplinaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping()
    public ResponseEntity<Disciplina> create(@RequestBody DisciplinaDto disciplinaDto) {

        Disciplina disciplinaParaCriar = disciplinaService.create(disciplinaDto.toModel());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplinaParaCriar.getId()).toUri();

        return ResponseEntity.created(location).body(disciplinaParaCriar);
    }
}
