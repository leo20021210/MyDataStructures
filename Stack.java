package cs102Graph;

public class Stack {
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
