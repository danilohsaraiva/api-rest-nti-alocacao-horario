package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    //Expor um DTO a quem está consumindo da API
    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        var cursoDb = cursoService.findByID(id);
        return ResponseEntity.ok(cursoDb);
    }
    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        var cursoCriado = cursoService.create(curso);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cursoCriado.getId()).toUri();
        return ResponseEntity.created(location).body(cursoCriado);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Curso>> findAll() {
         List<Curso> cursos = new ArrayList<>();
         cursos.addAll(cursoService.findAll());
         return ResponseEntity.ok(cursos);
    }
}
