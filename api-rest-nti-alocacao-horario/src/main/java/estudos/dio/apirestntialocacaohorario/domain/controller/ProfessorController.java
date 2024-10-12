package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.service.ProfessorService;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.ProfessorServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorServiceImpl professorService) { this.professorService = professorService; }
    /*
    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        var professorDb = professorService.findById(id);
        return ResponseEntity.ok(professorDb);
    }

    @PostMapping
    //@PatchMapping atualizar
    public ResponseEntity<Professor> create(@RequestBody ProfessorDto professorDto) {


        var professorCriado = professorService.create(professorDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professorCriado.getIdProfessor()).toUri();
        return ResponseEntity.created(location).body(professorCriado);

        //return ResponseEntity.ok(professorService.create(professor));
    }

 */
}
