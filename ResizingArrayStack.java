
public class ResizingArrayStack <T>{

	private T[] stack;
	private int N = 0;
	
	
	public ResizingArrayStack() {
		stack = (T[]) new Object[1];
	}
	
	
	public void push(T item) {
		if (N == stack.length) resize(stack.length);
		
		stack[N++] = item;
	}
	
	public T pop() {
		if( N == 0) throw new IllegalStateException("Stack is Empty");
		T item = stack[--N];
		stack[N] = null;
		
		if(N > 0 && N == stack.length / 4) resize(stack.length * 1/2);
		
		return item;
	}
	
	public void resize(int newSize) {
		T[] newStack = (T[]) new Object[newSize];
		
		for(int i = 0; i < N; i++)
			newStack[i] = stack[i];
	}
	
	public static void main(String[] args) {
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		
		stack.push("A");
		
		System.out.println(stack.pop());
		
		
	}
}
