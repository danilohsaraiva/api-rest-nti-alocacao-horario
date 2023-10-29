package estudos.dio.apirestntialocacaohorario.domain.controller;

import estudos.dio.apirestntialocacaohorario.domain.dtos.PreferenciaGradeDto;
import estudos.dio.apirestntialocacaohorario.domain.model.PreferenciaGrade;
import estudos.dio.apirestntialocacaohorario.domain.service.PreferenciaGradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/preferencia-grade")
public class PreferenciaGradeController {
    private final PreferenciaGradeService preferenciaGradeService;

    public PreferenciaGradeController(PreferenciaGradeService preferenciaGradeService) {
        this.preferenciaGradeService = preferenciaGradeService;
    }

    @PostMapping
    public ResponseEntity<PreferenciaGrade> create(@RequestBody PreferenciaGradeDto preferenciaGradeDto) {

        var preferenciaParaCriar = preferenciaGradeService.create(preferenciaGradeDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(preferenciaParaCriar).toUri();
        return ResponseEntity.created(location).body(preferenciaParaCriar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreferenciaGrade> findById(@PathVariable Long id) {
        return ResponseEntity.ok(preferenciaGradeService.findById(id));
    }

}
