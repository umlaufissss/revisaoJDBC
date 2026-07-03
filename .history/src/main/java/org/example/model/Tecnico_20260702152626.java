package org.example.model;

public class Tecnico 
{
    private int id;
    private String nome;
    private String especialidade;

    public Tecnico(String especialidade, int id, String nome) {
        this.especialidade = especialidade;
        this.id = id;
        this.nome = nome;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


}
