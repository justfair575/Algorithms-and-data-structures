
public class QuickFindUF {

	private int[]id; 
	
	
	public QuickFindUF(int N) {
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		int idP = id[p];
		int idQ = id[q];
		for(int i = 0; i < id.length; i++) {
			if(id[i] == idP)
				id[i] = idQ;
		}
	}
	
	private static void doNUnionOperations(int N) {
		QuickFindUF uf = new QuickFindUF(N);
		for(int i = 0; i < N; i++) {
			int p = (int)(Math.random() * N);
			int q = (int)(Math.random() * N);
			uf.union(p, q);
		}
	}
	
	public static void main(String[] args) {
		int START = 5;
		
		double start = System.currentTimeMillis();
		doNUnionOperations(START);
		double end = System.currentTimeMillis();
		
		double previousElapsedTime = (end - start) / 1000.0;
		
		for(int N = START; N <= 100000000; N = N*2) {
			start = System.currentTimeMillis();
			doNUnionOperations(N);
			end = System.currentTimeMillis();
			
			double elapsedTime = (end - start) / 1000.0;
			
			double ratio = elapsedTime / previousElapsedTime;
			double lgRatio = Math.log(ratio) / Math.log(2);
			
			System.out.println(N + "\t" + elapsedTime + "\t" + lgRatio);
			
			previousElapsedTime = elapsedTime;
		}
	}
	
}
