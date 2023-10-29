package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.CursoDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Curso;
import estudos.dio.apirestntialocacaohorario.domain.service.CursoService;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.CursoServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/curso")
@Transactional
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoServiceImpl cursoService) {
        this.cursoService = cursoService;
    }

    //Expor um DTO a quem está consumindo da API
    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        var cursoDb = cursoService.findByID(id);
        return ResponseEntity.ok(cursoDb);
    }
    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody @Valid CursoDto curso) {

        Curso cursoCriar = curso.toModel();
        cursoService.create(cursoCriar);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cursoCriar.getId()).toUri();
        return ResponseEntity.created(location).body(cursoCriar);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Curso>> findAll() {
         List<Curso> cursos = new ArrayList<>();
         cursos.addAll(cursoService.findAll());
         return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{nome}")
    public ResponseEntity findByNome(@PathVariable String nome) {
        var cursoDB = cursoService.findByNome(nome);
        return ResponseEntity.ok(cursoDB);
    }

    //Atualizar precisa da notação @Transactional em manipulações

}
