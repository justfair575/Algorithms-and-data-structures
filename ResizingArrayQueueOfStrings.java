
public class ResizingArrayQueueOfStrings {

	private String[] queue;
	private int first, last;
	
	public ResizingArrayQueueOfStrings() {
		queue = new String[1];
		first = -1;
		last = -1;
	}
	
	private void resize(int newSize) {
		String[] newQueue = new String[newSize];
		
		 for (int i = 0; i < size(); i++) 
			 newQueue[i] = queue[(first + i) % queue.length];	
		 
		 first = 0;
		 last = size() - 1;
		 queue = newQueue;
	}
	
	public boolean isEmpty() {
		return first == -1;
	}
	
	public int size() {		
		if(first == -1) return 0;
		
		if(first <= last) return last - first + 1;
		else return queue.length - (first - last - 1);
	}
	
	private int next(int index) {
		return(index + 1) % queue.length;
	
	}
	
	public void enqueue(String item) {
	    if(size() == queue.length)
	        resize(2 * queue.length);

	    last = next(last);
	    queue[last] = item;

	    if(first == -1) first = 0;
	}
	
	public String dequeue() {
		if(first == -1) 
			throw new IllegalStateException("Underflow");
		
		String item = queue[first];
		queue[first] = null;
		
		if(first == last) {
			first = -1;
			last = -1;
		}else {
			first = next(first);
		}
		
		if(queue.length/4 == size()) 
			resize(queue.length/2);
		
		return item;
	}
	
	public void shift() {
		int size = size();
		
		    if (size > 0) {
		        for (int i = 0; i < queue.length; i++) {
		            if (i < size) {
		                queue[i] = queue[(first + i) % queue.length];
		            } else {
		                queue[i] = null;
		            }
		        }

		        first = 0;
		        last = size - 1;
		    }
	}
		
	public String toString() {
		String s = " ";
		
		for(int i = 0; i < queue.length; i++) {
			if(queue[i] == null) {
				s += "null | ";
			}else {
				s += queue[i] + " | ";				
			}
		}
		return s;
	}
	
	public static void main (String[] args) {
		
		ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
		
		System.out.println(queue);		
		queue.enqueue("A");
		System.out.println(queue);
		queue.enqueue("B");
		System.out.println(queue);
		queue.enqueue("C");
		System.out.println(queue);
		queue.enqueue("D");
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue);
		queue.enqueue("E");
		queue.enqueue("F");
		System.out.println(queue);
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue);
		queue.enqueue("G");
		queue.enqueue("H");
		System.out.println(queue);
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue);
		queue.shift();
		System.out.println(queue);	
		queue.enqueue("A");
		System.out.println(queue);
		}	
}
