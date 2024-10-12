package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Grade;
import estudos.dio.apirestntialocacaohorario.domain.model.GradeProfessor;
import jakarta.persistence.ElementCollection;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PreferenciaGradeDto implements Serializable {
    public GradeProfessor toModel() {
    GradeProfessor grade = new GradeProfessor();
    return grade;
    }
}
