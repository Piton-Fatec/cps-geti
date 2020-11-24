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
    
    
    public Candidato removeAnyPosition(int pos) {
        Candidato candidatoRemovido = null;

        try {
            Candidato current = this.head.getFirst();

            if (pos == 0) {
                candidatoRemovido = current;
                this.head.setFirst(current.getNext());
            } else {
                current = getSomeElement(current, pos);

                candidatoRemovido = current.getNext();

                if (candidatoRemovido.getNext() != null) {
                    candidatoRemovido.getNext().setPrevious(current);
                    current.setNext(candidatoRemovido.getNext());
                } else {
                    current.setNext(null);
                }
            }
            this.head.elements -= 1;

        } catch (NullPointerException e) {
            System.out.println("This operation can not be executed. Empty list.");
        }

        return candidatoRemovido;
    }
    
    
    public Candidato getSomeElement(Candidato head, int pos) {
        if (pos <= 1) {
            return head;
        } else {
            return getSomeElement(head.getNext(), pos-1);
        }
    }
    
    
    public Object[][] formatList() {
    	Object[][] data = new Object[this.head.elements][5];
    	
    	Candidato current = this.head.getFirst();
    	
    	for (int i = 0; i < this.head.elements; i++) {
    		Object[] arr = {
    				current.getNome(),
    				current.getEmail(),
    				current.getCPF(),
    				current.getCEP(),
    				current.getSituacao()
    				};
    		data[i] = arr;
    		current = current.getNext();
    	}
    	
    	return data;
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
}
