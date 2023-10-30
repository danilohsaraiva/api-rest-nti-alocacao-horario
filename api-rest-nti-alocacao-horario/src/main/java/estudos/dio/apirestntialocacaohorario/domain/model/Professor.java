package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity()
@Table(name ="tb_professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long id;
    private String nome;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "disciplinas_professores", joinColumns = @JoinColumn(name ="fk_professor"), inverseJoinColumns = @JoinColumn(name = "fk_disciplina"))
    private List<Disciplina> disciplinas;
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<PreferenciaGrade> preferencias;


    public Professor() {
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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<PreferenciaGrade> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(List<PreferenciaGrade> preferencias) {
        this.preferencias = preferencias;
    }
}
