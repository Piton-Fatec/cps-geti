package cps_geti.model;

public class ListaMembros implements ListaInterface {

    private MembroCPS head = null;


    public boolean isEmpty() {
        return this.head == null;
    }


    public void addFront(MembroCPS membro) {
        try {
            if (this.head == null) {
                this.head = membro;
                return;
            }
            membro.setNext(this.head);
            this.head = membro;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }


    public void addBack(MembroCPS membro) {
        try {
            if (this.head == null) {
                this.head = membro;
                return;
            }

            MembroCPS lastCourse = getLastElement(this.head);
            lastCourse.setNext(membro);

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }


    public MembroCPS getLastElement(MembroCPS head) {
        if (head.getNext() == null) {
            return head;
        } else {
            return getLastElement(head.getNext());
        }
    }


    public void addAnyPosition(MembroCPS membro, int pos) {
        try {
            if (this.head == null) {
                this.head = membro;
                return;
            } else if (pos == 0) {
                addFront(membro);
                return;
            }

            MembroCPS current = getSomeElement(this.head, pos);

            membro.setNext(current.getNext());
            current.setNext(membro);

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }


    public MembroCPS getSomeElement(MembroCPS head, int pos) {
        if (pos <= 1) {
            return head;
        } else {
            return getSomeElement(head.getNext(), pos-1);
        }
    }



    public MembroCPS removeFront() {
    	MembroCPS membroRemovido = null;

        try {
            membroRemovido = this.head;
            this.head = this.head.getNext();
        } catch (NullPointerException e) {
            return null;
        }
        return membroRemovido;
    }


    public MembroCPS removeBack() {
    	MembroCPS membroRemovido = null;

        try {
        	MembroCPS current = this.head;

            if (current.getNext() == null) {
            	membroRemovido = current;
                this.head = null;
            } else {

                current = getLastButOneElement(current);

                membroRemovido = current.getNext();
                current.setNext(null);
            }

        } catch (NullPointerException e) {
        	return null;
        }

        return membroRemovido;
    }


    public MembroCPS getLastButOneElement(MembroCPS head) {
        if (head.getNext().getNext() == null) {
            return head;
        } else {
            return getLastButOneElement(head.getNext());
        }
    }



    public MembroCPS removeAnyPosition(int pos) {
    	MembroCPS membroRemovido = null;

        try {
        	MembroCPS current = this.head;

            if (pos == 0) {
                membroRemovido = current;
                this.head = current.getNext();
            } else {

                current = getSomeElement(current, pos);

                membroRemovido = current.getNext();
                current.setNext(current.getNext().getNext());
            }

        } catch (NullPointerException e) {
            System.out.println("This operation can not be executed. Empty list.");
        }
        return membroRemovido;
    }
    
    
    public boolean contains(String user) {
    	if (this.head == null) {
    		return false;
    	}
    	return checkUser(this.head, user);
    }
    
    
    public boolean checkUser(MembroCPS head, String user) {
    	if (head.getNome().equals(user)) {
    		return true;
    	} else if (head.getNext() == null) {
            return false;
        } else {
        	return checkUser(head.getNext(), user);
        }
    }
    
    
    public MembroCPS getUser(String user) {
    	return returnUser(this.head, user);
    }
    
    
    public MembroCPS returnUser(MembroCPS head, String user) {
    	if (head.getNome().equals(user)) {
    		return head;
    	} else if (head.getNext() == null) {
            return null;
        } else {
        	return returnUser(head.getNext(), user);
        }
    }
}
