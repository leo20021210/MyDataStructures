
class Graph {
	// egdes and number of nodes, vers and ele are only for my coding convenience.
	int[][] edges;
	int num;
	boolean[] vers;
	Stack ele=new Stack();

	// If you do not specify, the defualt node number is 5.
	public Graph() {
		this(5);
	}

	// You tell me the number of nodes by constructor.
	public Graph(int num) {
		this.num = num;
		this.edges = new int[num][num];
		this.vers =new boolean[num];
	}

	//connect two nodes
	public void connect(int a, int b) {
		if(a>=num&&b>=num) {
			System.out.println("We do not have edges");
			return;
		}
		edges[a-1][b-1]=1;
		edges[b-1][a-1]=1;
	}
	
	public boolean connected(int a, int b) {
		if(a>=num&&b>=num) {
			return false;
		}
		return edges[a-1][b-1]==1;
	}
	
	public void disconnect(int a, int b) {
		if(a>=num&&b>=num) {
			System.out.println("We do not have edges");
			return;
		}
		edges[a-1][b-1]=0;
		edges[b-1][a-1]=0;
	}
	
	public int getUnvisitedNode(int cur) {
		for(int i=0;i<num;i++) {
			if(this.edges[cur][i]==1&&this.vers[i]==false) {
				return i;
			}
		}
		return -1;
	}
	
	public int DFS(int i) {
		int count=1;
		vers[i-1]=true;
		System.out.println(i-1);
		ele.push(i-1);
		while(!ele.isEmpty()) {
			int v=this.getUnvisitedNode(ele.peek());
			if(v!=-1) {
				count++;
				vers[v]=true;
				System.out.println(v);
				ele.push(v);
			}else {
				ele.pop();
			}
		}
		for(int j=0;j<vers.length;j++) {
			vers[j]=false;
		}
		
		return count;
	}
	
	public int DFS() {
		int count=1;
		vers[0]=true;
		ele.push(0);
		while(!ele.isEmpty()) {
			int v=this.getUnvisitedNode(ele.peek());
			if(v!=-1) {
				count++;
				vers[v]=true;
				ele.push(v);
			}else {
				ele.pop();
			}
		}
		for(int j=0;j<vers.length;j++) {
			vers[j]=false;
		}
		
		return count;
	}
	
	public boolean connected() {
		return this.DFS()==num;
	}
	
	private int viewed() {
		for(int i=0;i<num;i++) {
			if(!this.vers[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private int DFS1(int i) {
		int count=1;
		vers[i]=true;
		ele.push(i);
		System.out.println(i);
		while(!ele.isEmpty()) {
			int v=this.getUnvisitedNode(ele.peek());
			if(v!=-1) {
				count++;
				vers[v]=true;
				System.out.println(v);
				ele.push(v);
			}else {
				ele.pop();
			}
		}
		
		return count;
	}
	
	private int DFS2(int i) {
		int count=1;
		vers[i]=true;
		ele.push(i);
		while(!ele.isEmpty()) {
			int v=this.getUnvisitedNode(ele.peek());
			if(v!=-1) {
				count++;
				vers[v]=true;
				ele.push(v);
			}else {
				ele.pop();
			}
		}
		
		return count;
	}
	
	public int showSet() {
		int count=0;
		while(true) {
			int view=viewed();
			if(view==-1) {
				for(int j=0;j<vers.length;j++) {
					vers[j]=false;
				}
				return count;
			}
			this.DFS1(view);
			count++;
			System.out.println();
		}
	}
	
	private int Set() {
		int count=0;
		while(true) {
			int view=viewed();
			if(view==-1) {
				for(int j=0;j<vers.length;j++) {
					vers[j]=false;
				}
				return count;
			}
			this.DFS2(view);
			count++;
		}
	}
	
	public boolean generalconnected(int a, int b) {
		vers[a-1]=true;
		ele.push(a-1);
		while(!ele.isEmpty()) {
			int v=this.getUnvisitedNode(ele.peek());
			if(v!=-1) {
				if(v==b-1) {
					return true;
				}
				vers[v]=true;
				ele.push(v);
			}else {
				ele.pop();
			}
		}
		return false;
	}
	
	public int articulation() {
		for(int i=0;i<vers.length;i++) {
			int previous=this.Set();
			vers[i]=true;
			if(this.Set()!=previous) {
				return i+1;
			}
		}
		return -1;
	}
}

class Stack {
	public int max=20;
	public int cur;
	public int[] ele;
	public Stack() {
		this.cur=-1;
		this.ele=new int[max];
	}
	public int peek() {
		if(cur==-1) {
			return -1;
		}else {
			return ele[cur];
		}
	}
	public void push(int i) {
		ele[++cur]=i;
	}
	public int pop() {
		return ele[cur--];
	}
	public boolean isEmpty() {
		return cur==-1;
	}
}

class Test {

	public static void main(String[] args) {
		Graph g=new Graph(7);
		g.connect(3, 4);
		g.connect(1, 2);
		g.connect(2, 4);
		g.connect(2, 5);
		g.connect(1, 3);
		g.connect(6, 7);
		System.out.println(g.connected(3, 4));
		System.out.println(g.DFS(7));
		System.out.println(g.connected());
		g.showSet();
		System.out.println(g.generalconnected(3, 5));
		System.out.println(g.generalconnected(3, 6));
		System.out.println(g.articulation());
	}
}
