# API Rest Alocação de Horários
## Contextualizando Domínio
Instituição Superior

### Necessidades do Projeto

O projeto precisa desenvolver um sistema que permita aos professores alocar suas
disciplinas na grade de horários da semana e indicar suas preferências de dias e horários.

 -  Criar um sistema de cadastro para professores, cursos e disciplinas.

### Diagrama de Classes
```mermaid
classDiagram
  class Universidade {
    - String nome
    - List<Curso> curso
  }
  class Curso {
    - String nome
    - List<Semestre> semestres
  }
  class Semestre {
    - int ano
    - int semestre_numero
    - List<Disciplina> disciplinas
  }
  class Disciplina {
    - String nome
    - int carga_horaria
    - List<Professor> professores
    - List<GradeDisciplina> grade_disciplina
  }
  class Professor {
    - String nome
    - List<Disciplina> disciplinas
    - List<GradeProfessor> grade_professor
    - List<HorarioPreferencial> horarios_preferenciais
  }
  class GradeDisciplina {
    - String dia_da_semana
    - List<HorarioGrade> horario_grade
  }
  class GradeProfessor {
    - String dia_da_semana
    - List<HorarioAula> horario_aula
  }
  class HorarioGrade {
    - String professor
    - String horario
  }
  class HorarioAula {
    - String disciplina
    - String hora
  }
  class HorarioPreferencial {
    - String hora
  }

Universidade --> Curso
Curso --> Semestre
Semestre --> Disciplina
Disciplina --> Professor
Disciplina --> GradeDisciplina
Professor --> GradeProfessor
Professor --> HorarioPreferencial
GradeDisciplina --> HorarioGrade
GradeProfessor --> HorarioAula

```
