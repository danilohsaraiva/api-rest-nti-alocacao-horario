package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.model.Universidade;
import estudos.dio.apirestntialocacaohorario.domain.service.UniversidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/universidade")
public class UniversidadeController {
    private final UniversidadeService universidadeService;

    UniversidadeController(UniversidadeService universidadeService) {
        this.universidadeService = universidadeService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Universidade> findById(@PathVariable Long id) {
        return ResponseEntity.ok(universidadeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Universidade> create (@RequestBody Universidade universidade) {
        var universidadeParaCriar = universidadeService.create(universidade);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(universidade.getId()).toUri();
        return ResponseEntity.created(location).body(universidadeParaCriar);
    }
}
