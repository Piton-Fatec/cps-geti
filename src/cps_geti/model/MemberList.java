package cps_geti.model;

public class MemberList {

    private CPSMember head = null;


    public boolean isEmpty() {
        return this.head == null;
    }


    public void addFront(CPSMember member) {
        try {
            if (this.head == null) {
                this.head = member;
                return;
            }
            member.setNext(this.head);
            this.head = member;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }


    public void addBack(CPSMember member) {
        try {
            if (this.head == null) {
                this.head = member;
                return;
            }

            CPSMember lastMember = getLastElement(this.head);
            lastMember.setNext(member);

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }


    public CPSMember getLastElement(CPSMember head) {
        if (head.getNext() == null) {
            return head;
        } else {
            return getLastElement(head.getNext());
        }
    }


    public void addAnyPosition(CPSMember member, int pos) {
        try {
            if (this.head == null) {
                this.head = member;
                return;
            } else if (pos == 0) {
                addFront(member);
                return;
            }

            CPSMember current = getSomeElement(this.head, pos);

            member.setNext(current.getNext());
            current.setNext(member);

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("This operation can not be executed.");
        }
    }


    public CPSMember getSomeElement(CPSMember head, int pos) {
        if (pos <= 1) {
            return head;
        } else {
            return getSomeElement(head.getNext(), pos-1);
        }
    }


    public CPSMember removeFront() {
    	CPSMember removedMember = null;

        try {
        	removedMember = this.head;
            this.head = this.head.getNext();
        } catch (NullPointerException e) {
            return null;
        }
        return removedMember;
    }


    public CPSMember removeBack() {
    	CPSMember removedMember = null;

        try {
        	CPSMember current = this.head;

            if (current.getNext() == null) {
            	removedMember = current;
                this.head = null;
            } else {
                current = getLastButOneElement(current);
                removedMember = current.getNext();
                current.setNext(null);
            }
        } catch (NullPointerException e) {
        	return null;
        }
        return removedMember;
    }


    public CPSMember getLastButOneElement(CPSMember head) {
        if (head.getNext().getNext() == null) {
            return head;
        } else {
            return getLastButOneElement(head.getNext());
        }
    }


    public CPSMember removeAnyPosition(int pos) {
    	CPSMember removedMember = null;

        try {
        	CPSMember current = this.head;

            if (pos == 0) {
            	removedMember = current;
                this.head = current.getNext();
            } else {
                current = getSomeElement(current, pos);
                removedMember = current.getNext();
                current.setNext(current.getNext().getNext());
            }
        } catch (NullPointerException e) {
            System.out.println("This operation can not be executed. Empty list.");
        }
        return removedMember;
    }
     
 
    public boolean contains(String user) {
    	if (this.head == null) {
    		return false;
    	}
    	return checkUser(this.head, user);
    }
    
    
    public boolean checkUser(CPSMember head, String user) {
    	if (head.getNome().equals(user)) {
    		return true;
    	} else if (head.getNext() == null) {
            return false;
        } else {
        	return checkUser(head.getNext(), user);
        }
    }
    
    
    public CPSMember getUser(String user) {
    	return returnUser(this.head, user);
    }
    
    
    public CPSMember returnUser(CPSMember head, String user) {
    	if (head.getNome().equals(user)) {
    		return head;
    	} else if (head.getNext() == null) {
            return null;
        } else {
        	return returnUser(head.getNext(), user);
        }
    }
}
