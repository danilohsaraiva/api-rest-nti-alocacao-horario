package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.DisciplinaDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;
import estudos.dio.apirestntialocacaohorario.domain.service.DisciplinaService;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.DisciplinaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaServiceImpl disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping()
    public ResponseEntity<Disciplina> create(@RequestBody DisciplinaDto disciplinaDto) {

        Disciplina disciplinaParaCriar = disciplinaService.create(disciplinaDto.toModel());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplinaParaCriar.getIdDisciplina()).toUri();

        return ResponseEntity.created(location).body(disciplinaParaCriar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.findById(id));
    }
}
