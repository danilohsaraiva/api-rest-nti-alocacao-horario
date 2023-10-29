package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.ProfessorDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Professor;
import estudos.dio.apirestntialocacaohorario.domain.service.ProfessorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) { this.professorService = professorService; }
    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        var professorDb = professorService.findById(id);
        return ResponseEntity.ok(professorDb);
    }

    @PostMapping
    //@PatchMapping atualizar
    public ResponseEntity<Professor> create(@RequestBody ProfessorDto professorDto) {


        var professorCriado = professorService.create(professorDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professorCriado.getId()).toUri();
        return ResponseEntity.created(location).body(professorCriado);

        //return ResponseEntity.ok(professorService.create(professor));
    }
}
