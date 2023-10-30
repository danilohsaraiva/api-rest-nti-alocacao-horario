package estudos.dio.apirestntialocacaohorario.domain.model;

import jakarta.persistence.*;

import java.util.List;
@Entity(name = "tb_universidade")
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy ="universidade", cascade = CascadeType.ALL)
    private List<Curso> cursos;


    public Universidade() {
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
