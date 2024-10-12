package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.service.UniversidadeService;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.UniversidadeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/universidade")
public class UniversidadeController {
    private final UniversidadeService universidadeService;

    UniversidadeController(UniversidadeServiceImpl universidadeService) {
        this.universidadeService = universidadeService;
    }
    /*
    @GetMapping("/{id}")
    public ResponseEntity<Universidade> findById(@PathVariable Long id) {
        return ResponseEntity.ok(universidadeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Universidade> create (@RequestBody UniversidadeDto universidadeDto) {

        var universidadeParaCriar = universidadeService.create(universidadeDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(universidadeParaCriar.getIdUniversidade()).toUri();
        return ResponseEntity.created(location).body(universidadeParaCriar);
    }

     */
}
