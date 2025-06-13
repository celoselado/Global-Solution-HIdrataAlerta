package br.com.climaconsciente.models;

public class Usuario {

    //-------  Atributos encapsulados  --------
    private String nome;
    private String bairro;

    //------- Construtores (Vazio e com parametros de nome e bairro) ---------
    public Usuario() {
    }

    public Usuario(String nome, String bairro) {
        this.nome = nome;
        this.bairro = bairro;
    }

    //-------  Metodos Getters e Setters   --------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    // ------- Metodos da classe   --------
    public void exibirInformacoes(){
        System.out.println("Usuario: "+ nome +"  | Bairro: "+ bairro);
    }


}
