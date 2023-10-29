package estudos.dio.apirestntialocacaohorario.domain.model;

import estudos.dio.apirestntialocacaohorario.domain.dtos.CursoDto;
import jakarta.persistence.*;

import java.util.List;
@Entity(name = "tb_curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    @OneToMany(cascade = CascadeType.ALL)
    List<Semestre> semestres;
    public Curso() {

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

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }
}
