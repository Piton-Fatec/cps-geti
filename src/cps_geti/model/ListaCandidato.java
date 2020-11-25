package cps_geti.model;

class Head {
	
	private Candidato first = null;
	private Candidato last = null;
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

	private Head head = new Head();
	
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
            if (this.head.elements == 0) {
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
        this.head.elements -= 1;
        
        if (candidatoRemovido == null || this.head.elements <= 0) {
        	this.head.setLast(null);
        	this.head.setFirst(null);
        	this.head.elements = 0;
        	return candidatoRemovido;
        }
        
        this.head.setFirst(candidatoRemovido.getNext());
        return candidatoRemovido;
    }
    
    
    public Candidato removeBack() {
        Candidato candidatoRemovido = this.head.getLast();
        this.head.elements -= 1;
        
        if (candidatoRemovido == null || this.head.elements <= 0) {
        	this.head.setLast(null);
        	this.head.setFirst(null);
        	this.head.elements = 0;
        	return candidatoRemovido;
        }
        
        this.head.setLast(this.head.getLast().getPrevious()); 
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
    	Candidato current = head;
    	while (current != null) {
    		if (current.getCPF().equals(cpf)) {
    			return true;
    		}
    		current = current.getNext();
    	}
    	return false;
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
