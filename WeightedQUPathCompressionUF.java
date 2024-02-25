
public class WeightedQUPathCompressionUF {
		
	private int[]id;
	private int[]size;
	
	
	public WeightedQUPathCompressionUF(int N) {
		
		id = new int[N];
		size = new int[N];
		
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
			
	public int root(int p) {
		
		while (p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}
		
		return p;
	}
	
	public boolean connected(int p, int q) {
		
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		
		int rootP = root(p);
		int rootQ = root(q);
		
		if(rootP == rootQ)
			return;
		
		if(size[rootP] < size[rootQ]) {
			id[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}else {
			id[rootQ] = rootP;
			size[rootP] += size[rootQ];
	}
}
}
