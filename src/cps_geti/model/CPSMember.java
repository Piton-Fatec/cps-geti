package cps_geti.model;

public class CPSMember {

    private int id;
    private String name;
    private String password;
    private String position;
    
    private CPSMember next;
    
    public CPSMember(String name, String password) {
    	this.name = name;
    	this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getPosicao() {
        return position;
    }

    public void setPosicao(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public CPSMember getNext() {
        return next;
    }

    public void setNext(CPSMember member) {
        this.next = member;
    }
    
    @Override
    public String toString() {
    	return this.name + "," + this.password;
    }
}
