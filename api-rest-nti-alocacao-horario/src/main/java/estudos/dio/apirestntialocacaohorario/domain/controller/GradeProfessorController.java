package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.PreferenciaGradeDto;
import estudos.dio.apirestntialocacaohorario.domain.model.Grade;
import estudos.dio.apirestntialocacaohorario.domain.service.impl.GradeProfessorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/grade_professor")
public class GradeProfessorController {
    private final GradeProfessorServiceImpl preferenciaGradeService;

    public GradeProfessorController(GradeProfessorServiceImpl preferenciaGradeService) {
        this.preferenciaGradeService = preferenciaGradeService;
    }

    @PostMapping
    public ResponseEntity<Grade> create(@RequestBody PreferenciaGradeDto preferenciaGradeDto) {

        var preferenciaParaCriar = preferenciaGradeService.create(preferenciaGradeDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(preferenciaParaCriar).toUri();
        return ResponseEntity.created(location).body(preferenciaParaCriar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> findById(@PathVariable Long id) {
        return ResponseEntity.ok(preferenciaGradeService.findById(id));
    }
}
