import java.util.Iterator;


public class Queue<T> implements Iterable<T> {
	
	private int n;
	private Node first, last;
	
private class Node {
	
	public T item;
	public Node next;	
}
	
	public Queue() {
		first = null;
		last = null;
		n = 0;
	}
	
	public void enqueue(T item) {
		
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if (isEmpty()) first = last;		
		else oldlast.next = last;

		n++;
		
		}
	
	public T dequeue() {
		
		if(isEmpty()) throw new IllegalStateException("Underflow");
		
		T item = first.item;
		first = first.next;
		n--;
		
		if (isEmpty()) last = null;
		
		return item;
		}
	
	public boolean isEmpty() {
		return first == null;
		}
	
	public int size() {
		return n;
	}
	
	public void shift() {
		
		if (isEmpty() || size() == 1) return;

		Node oldLast = last;
	    last = new Node();
	    last.item = oldLast.item;
	    last.next = first;
	    first = last;
	}
	
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
private class QueueIterator implements Iterator<T>{

    private Node current = first;

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
    	T item = current.item;
    	current = current.next;
        return item;
    }       	        
}

	public static void main(String[] args) {
	
	    Queue<Integer> queue = new Queue<>();
	
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	
	    queue.shift();
	
	    System.out.println(queue.dequeue());
	    System.out.println(queue.dequeue());
	    System.out.println(queue.dequeue());
	}
}




