package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.model.PreferenciaGrade;
import estudos.dio.apirestntialocacaohorario.domain.service.PreferenciaGradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/preferencia-grade")
public class PreferenciaGradeParaController {
    private final PreferenciaGradeService preferenciaGradeService;

    public PreferenciaGradeParaController(PreferenciaGradeService preferenciaGradeService) {
        this.preferenciaGradeService = preferenciaGradeService;
    }

    @PostMapping
    public ResponseEntity<PreferenciaGrade> create(@RequestBody PreferenciaGrade preferenciaGrade) {
        var preferenciaParaCriar = preferenciaGradeService.create(preferenciaGrade);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(preferenciaGrade).toUri();
        return ResponseEntity.created(location).body(preferenciaParaCriar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreferenciaGrade> findById(@PathVariable Long id) {
        return ResponseEntity.ok(preferenciaGradeService.findById(id));
    }

}
