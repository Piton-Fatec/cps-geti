package cps_geti.model;

class Head {
	
	private Candidato first;
	private Candidato last;
	public int elements = 0;
	
	public Candidato getFirst() {
		return first;
	}
	public void setFirst(Candidato first) {
		this.first = first;
	}
	public Candidato getLast() {
		return last;
	}
	public void setLast(Candidato last) {
		this.last = last;
	}
}

public class ListaCandidato implements ListaInterface {

	private Head head;
	
    public void addFront(Candidato candidato) {
        try {
            if (this.head == null) {
            	this.head = new Head();
                this.head.setFirst(candidato);
                this.head.setLast(candidato);
                this.head.elements += 1;
                return;
            }

            candidato.setNext(this.head.getFirst());
            this.head.getFirst().setPrevious(candidato);
            this.head.setFirst(candidato);
            this.head.elements += 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }

    
    public void addBack(Candidato candidato) {
        try {
            if (this.head == null) {
            	this.head = new Head();
                this.head.setFirst(candidato);
                this.head.setLast(candidato);
                this.head.elements += 1;
                return;
            }

            candidato.setPrevious(this.head.getLast());
            this.head.getLast().setNext(candidato);
            this.head.setLast(candidato);
            this.head.elements += 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }

    
    public Candidato removeFront() {
        Candidato candidatoRemovido = this.head.getFirst();
        
        if (candidatoRemovido == null) {
        	this.head.setFirst(null);
        } else {
        	this.head.setFirst(this.head.getFirst().getNext());
        }
        
        this.head.elements -= 1;
        return candidatoRemovido;
    }
    
    
    public Candidato removeBack() {
        Candidato candidatoRemovido = this.head.getLast();

        if (candidatoRemovido == null) {
        	this.head.setLast(null);
        } else {
        	this.head.setLast(this.head.getLast().getPrevious());   
        }
        this.head.elements -= 1;
        return candidatoRemovido;
    }
    
    
    public boolean contains(String cpf) {
    	if (this.head == null) {
    		return false;
    	}
    	return checkUser(this.head.getFirst(), cpf);
    }
    
    
    public boolean checkUser(Candidato head, String cpf) {
    	if (head == null) {
    		return false;
    	} else if (head.getCPF().equals(cpf)) {
    		return true;
    	} else if (head.getNext() == null) {
            return false;
        } else {
        	return checkUser(head.getNext(), cpf);
        }
    }
    
    
    public Candidato getUser(String cpf) {
    	return returnUser(this.head.getFirst(), cpf);
    }
    
    
    public Candidato returnUser(Candidato head, String cpf) {
    	if (head.getCPF().equals(cpf)) {
    		return head;
    	} else if (head.getNext() == null) {
            return null;
        } else {
        	return returnUser(head.getNext(), cpf);
        }
    }
    
    public int getLength() {
    	return this.head.elements;
    }
    
    public Candidato getfirst() {
    	return this.head.getFirst();
    }
    
    public Candidato getLast() {
    	return this.head.getLast();
    }
}
