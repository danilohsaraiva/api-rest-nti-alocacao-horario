package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_semestre")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ano;
    private int semestreNumero;
    @OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL)
    private List<Disciplina> disciplinas;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Semestre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestreNumero() {
        return semestreNumero;
    }

    public void setSemestreNumero(int semestreNumero) {
        this.semestreNumero = semestreNumero;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
