package cps_geti.model;

class Head {
	
	private Applicant first = null;
	private Applicant last = null;
	public int elements = 0;
	
	public Applicant getFirst() {
		return first;
	}
	
	public void setFirst(Applicant first) {
		this.first = first;
	}
	
	public Applicant getLast() {
		return last;
	}
	
	public void setLast(Applicant last) {
		this.last = last;
	}
}

public class ApplicantList {

	private Head head = new Head();
	
    public void addFront(Applicant Applicant) {
        try {
            if (this.head == null) {
            	this.head = new Head();
                this.head.setFirst(Applicant);
                this.head.setLast(Applicant);
                this.head.elements += 1;
                return;
            }

            Applicant.setNext(this.head.getFirst());
            this.head.getFirst().setPrevious(Applicant);
            this.head.setFirst(Applicant);
            this.head.elements += 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }
    
    
    public void addBack(Applicant Applicant) {
        try {
            if (this.head.elements == 0) {
            	this.head.setFirst(Applicant);
                this.head.setLast(Applicant);
                this.head.elements += 1;
                return;
            }

            Applicant.setPrevious(this.head.getLast());
            this.head.getLast().setNext(Applicant);
            this.head.setLast(Applicant);
            this.head.elements += 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }
    
    
    public Applicant removeFront() {
        Applicant ApplicantRemovido = this.head.getFirst();
        this.head.elements -= 1;
        
        if (ApplicantRemovido == null || this.head.elements <= 0) {
        	this.head.setLast(null);
        	this.head.setFirst(null);
        	this.head.elements = 0;
        	return ApplicantRemovido;
        }
        
        this.head.setFirst(ApplicantRemovido.getNext());
        return ApplicantRemovido;
    }
    
    
    public Applicant removeBack() {
        Applicant ApplicantRemovido = this.head.getLast();
        this.head.elements -= 1;
        
        if (ApplicantRemovido == null || this.head.elements <= 0) {
        	this.head.setLast(null);
        	this.head.setFirst(null);
        	this.head.elements = 0;
        	return ApplicantRemovido;
        }
        
        this.head.setLast(this.head.getLast().getPrevious()); 
        return ApplicantRemovido;
    } 
    
    
    public Applicant removeAnyPosition(int pos) {
        Applicant ApplicantRemovido = null;

        try {
            Applicant current = this.head.getFirst();

            if (pos == 0) {
                ApplicantRemovido = current;
                this.head.setFirst(current.getNext());
            } else {
                current = getSomeElement(current, pos);

                ApplicantRemovido = current.getNext();

                if (ApplicantRemovido.getNext() != null) {
                    ApplicantRemovido.getNext().setPrevious(current);
                    current.setNext(ApplicantRemovido.getNext());
                } else {
                    current.setNext(null);
                }
            }
            this.head.elements -= 1;

        } catch (NullPointerException e) {
            System.out.println("This operation can not be executed. Empty list.");
        }

        return ApplicantRemovido;
    }
    
    
    public Applicant getSomeElement(Applicant head, int pos) {
        if (pos <= 1) {
            return head;
        } else {
            return getSomeElement(head.getNext(), pos-1);
        }
    }
    
    
    public Object[][] formatList() {
    	Object[][] data = new Object[this.head.elements][5];
    	Applicant current = this.head.getFirst();
    	
    	for (int i = 0; i < this.head.elements; i++) {
    		Object[] arr = {
    				current.getName(),
    				current.getEmail(),
    				current.getCPF(),
    				current.getCEP(),
    				current.getStatus()
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
    
    
    public boolean checkUser(Applicant head, String cpf) {
    	Applicant current = head;
    	while (current != null) {
    		if (current.getCPF().equals(cpf)) {
    			return true;
    		}
    		current = current.getNext();
    	}
    	return false;
    }
    
    
    public Applicant getUser(String cpf) {
    	return returnUser(this.head.getFirst(), cpf);
    }
    
    
    public Applicant returnUser(Applicant head, String cpf) {
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
    
    
    public Applicant getfirst() {
    	return this.head.getFirst();
    }
    
    
    public Applicant getLast() {
    	return this.head.getLast();
    }
    
    
    public boolean isTrue() {
    	return this.head != null;
    }   
}
