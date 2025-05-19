public class LinkList {
    private Link head ;

    public LinkList() {
        head = null ;
    }

    public boolean isEmpty() {
        return head == null ;
    }

    public void insertFirst(char d) {
        Link newLink = new Link(d) ;
        newLink.next = head ;
        head = newLink ;
    }

    public char deleteFirst() {
        Link temp = head ;
        head = head.next ;
        return temp.data ;   
    }

    public char displayFirst() {
        return head.data ;
    }

    public void displayList() {
        Link current = head ;
        while (current != null) {
            current.displayLink();
            current = current.next ;
        }
    }
}
