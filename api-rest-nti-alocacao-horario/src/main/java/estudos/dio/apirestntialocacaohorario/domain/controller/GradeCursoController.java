package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.GradeCursoDTO;
import estudos.dio.apirestntialocacaohorario.domain.model.GradeCurso;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.CursoServiceImpl;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.DisciplinaServiceImpl;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.GradeCursoServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grade_curso")
@Transactional
public class GradeCursoController {
    private final GradeCursoServiceImpl gradeCursoService;
    private final CursoServiceImpl cursoService;
    private final DisciplinaServiceImpl disciplinaService;

    public GradeCursoController(GradeCursoServiceImpl gradeCursoService, CursoServiceImpl cursoService, DisciplinaServiceImpl disciplinaService) {
        this.gradeCursoService = gradeCursoService;
        this.cursoService = cursoService;
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<GradeCurso> create(@RequestBody GradeCursoDTO gradeCursoDTO) {
        GradeCurso gradeCurso = new GradeCurso();

        return ResponseEntity.ok(gradeCurso);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GradeCurso> findById(@PathVariable Long id) {
        var gradeCursoDB = gradeCursoService.findById(id);
        return ResponseEntity.ok(gradeCursoDB);
    }
    @GetMapping("/todos")
    public ResponseEntity<List<GradeCurso>> findAll() {
        List<GradeCurso> gradesCursos = new ArrayList<>();
        gradesCursos.addAll(gradeCursoService.findAll());
        return ResponseEntity.ok(gradesCursos);
    }
}
