package estudos.dio.apirestntialocacaohorario.domain.dtos;

import estudos.dio.apirestntialocacaohorario.domain.model.Disciplina;

import java.io.Serializable;

public class DisciplinaDto implements Serializable {

    public Disciplina toModel() {
        Disciplina disciplina = new Disciplina();
        return disciplina;

    }
}
