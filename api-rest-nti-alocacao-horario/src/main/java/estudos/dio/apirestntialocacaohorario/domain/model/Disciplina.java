package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity(name = "tb_disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int cargaHoraria;
    @ManyToMany(mappedBy = "disciplinas" ,cascade = CascadeType.ALL)
    private List<Professor> professores;
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Disciplina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}
