package Principal;

import java.util.Date;

public class Cliente {
    private String nome;
    private String tema;
    private String endereco;
    private Date dataEvento; 

    
    public Cliente(String nome, String tema, String endereco, Date dataEvento) {
        this.nome = nome;
        this.tema = tema;
        this.endereco = endereco;
        this.dataEvento = dataEvento;
    }

 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) { 
        this.dataEvento = dataEvento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tema='" + tema + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataEvento=" + dataEvento + 
                '}';
    }
}
