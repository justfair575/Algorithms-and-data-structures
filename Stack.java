import java.util.Iterator;

public class Stack<T> implements Iterable<T> {


    private class Node {
        public T item;
        public Node next;
    }

    private Node first = null;
    private int size = 0;
    
    public Stack(){
    }

    public void push (T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        
        size++;
    }

    public T pop() {
    	if(first == null)
    		throw new IllegalStateException("Underflow");
    	T item = first.item;
    	
    	first = first.next;
    	size--;
        return item;
    }

    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        for(String value:stack) {
            System.out.println(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>{

    private Node current = first;

        @Override
    public boolean hasNext() {
        return current != null;
    }

        @Override
    public T next() {
    	T item = current.item;
    	current = current.next;
        return item;
    }


    }
}

 
