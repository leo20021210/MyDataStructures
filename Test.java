package cs102Graph;

public class Test {

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
