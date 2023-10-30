package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_preferencia")
public class PreferenciaGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dia;
    @ElementCollection
    private List<String> horariosPreferiveis = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;



    public PreferenciaGrade() {

    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<String> getHorariosPreferiveis() {
        return horariosPreferiveis;
    }

    public void setHorariosPreferiveis(List<String> horariosPreferiveis) {
        this.horariosPreferiveis = horariosPreferiveis;
    }
}
