

public class Estudante {
    private long id;
    private String nome;
    private int matricula;
    private String curso;

    public Estudante() {
        
    }

    public Estudante(long id, String nome, int matricula, String curso) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    
}