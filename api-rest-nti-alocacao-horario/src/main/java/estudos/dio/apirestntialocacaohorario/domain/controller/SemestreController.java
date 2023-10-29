package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.SemestreDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Semestre;
import estudos.dio.apirestntialocacaohorario.domain.service.SemestreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/semestre")
public class SemestreController {
    private final SemestreService semestreService;

    public SemestreController (SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @PostMapping
    public ResponseEntity<Semestre> create(@RequestBody SemestreDto semestreDto) {

        var semestreParaCriar = semestreDto.toModel();
        semestreService.create(semestreParaCriar);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(semestreParaCriar.getId()).toUri();
        return ResponseEntity.created(location).body(semestreParaCriar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semestre> findById(Long id) {
        return  ResponseEntity.ok(semestreService.findById(id));
    }
}
