package cps_geti.model;

public class MembroCPS {

    private int id;
    private String nome;
    private String senha;
    private String posicao;
    
    private MembroCPS next;
    
    public MembroCPS(String nome, String senha) {
    	this.nome = nome;
    	this.senha = senha;
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

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public MembroCPS getNext() {
        return next;
    }

    public void setNext(MembroCPS membro) {
        this.next = membro;
    }
    
    @Override
    public String toString() {
    	return this.nome + "," + this.senha;
    }
}
