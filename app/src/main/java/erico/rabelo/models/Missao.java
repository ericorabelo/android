package erico.rabelo.models;

public class Missao {
    private long id;
    private String nome;
    private String Descrição;

    public Missao() {
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

    public String getDescrição() {
        return Descrição;
    }

    public void setDescrição(String descrição) {
        Descrição = descrição;
    }

    @Override
    public String toString() {
        return "Missoes{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", Descrição='" + Descrição + '\'' +
                '}';
    }
}
