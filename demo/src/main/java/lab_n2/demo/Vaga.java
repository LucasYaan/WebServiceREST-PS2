package lab_n2.demo;

public class Vaga {
    private long id;
    private String titulo;
    private String descricao;
    private String requisitos;

    public Vaga() {
        
    }

    public Vaga(long id, String titulo, String descricao, String requisitos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.requisitos = requisitos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
