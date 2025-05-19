public class LinkStack {
    private LinkList theList ;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(char d) {
        theList.insertFirst(d);
    }

    public char pop() {
        return theList.deleteFirst() ;
    }

    public boolean isEmpty() {
        return theList.isEmpty() ;
    }

    public void displaystack() {
        System.out.println("Stack (Top --> Button)");
        theList.displayList();
        System.out.println("");
    }

    public char peek() {
        return theList.displayFirst();
    }
}