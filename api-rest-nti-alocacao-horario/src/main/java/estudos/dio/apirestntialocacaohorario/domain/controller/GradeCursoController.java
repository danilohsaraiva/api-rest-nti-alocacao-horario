package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.model.GradeCurso;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.CursoServiceImpl;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.DisciplinaServiceImpl;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.GradeCursoServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gradeCurso")
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
