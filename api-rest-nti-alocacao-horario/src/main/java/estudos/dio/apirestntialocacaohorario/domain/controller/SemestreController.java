package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.service.SemestreService;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.SemestreServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semestre")
public class SemestreController {
    private final SemestreService semestreService;

    public SemestreController (SemestreServiceImpl semestreService) {
        this.semestreService = semestreService;
    }
    /*

    @PostMapping
    public ResponseEntity<Semestre> create(@RequestBody SemestreDto semestreDto) {

        var semestreParaCriar = semestreDto.toModel();
        semestreService.create(semestreParaCriar);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(semestreParaCriar.getIdSemestre()).toUri();
        return ResponseEntity.created(location).body(semestreParaCriar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semestre> findById(Long id) {
        return  ResponseEntity.ok(semestreService.findById(id));
    }

     */
}
