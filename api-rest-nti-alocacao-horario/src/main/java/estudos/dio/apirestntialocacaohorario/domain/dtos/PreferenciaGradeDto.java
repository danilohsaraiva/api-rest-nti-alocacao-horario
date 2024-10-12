package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.GradeProfessor;

import java.io.Serializable;

public class PreferenciaGradeDto implements Serializable {
    public GradeProfessor toModel() {
    GradeProfessor grade = new GradeProfessor();
    return grade;
    }
}
