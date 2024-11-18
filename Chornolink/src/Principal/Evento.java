package Principal;

public class Evento {
    private int id;
    private String nome;
    private String tema;
    private String endereco;
    private String data;

    
    public Evento(int id, String nome, String tema, String endereco, String data) {
        this.id = id;
        this.nome = nome;
        this.tema = tema;
        this.endereco = endereco;
        this.data = data;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTema() {
        return tema;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getData() {
        return data;
    }
}