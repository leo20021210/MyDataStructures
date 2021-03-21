public class Heap {
	double[] ele = new double[20];
	int cur;

	public Heap() {
		this.ele = new double[20];
		cur = 0;
	}

	public double deletemin() {
		int index = 1;
		double flag = ele[0];
		ele[0] = ele[cur - 1];
		cur--;
		while (index < cur / 2) {
			if (ele[index * 2 - 1] > ele[index * 2]) {
				index=index*2+1;
			} else {
				index=index*2;
			}
			if(ele[index/2-1]<=ele[index-1]) {
				return flag;
			}
			double temp = ele[index/2-1];
			ele[index/2-1] = ele[index - 1];
			ele[index - 1] = temp;
		}
		return flag;
	}

	public void insert(double add) {
		cur++;
		if (cur == 1) {
			ele[0] = add;
			return;
		}
		try {
			ele[cur - 1] = add;
		} catch (Exception e) {
			System.out.println("Heap is full");
		}
		int temp = cur;
		do {
			if (ele[temp - 1] < ele[temp / 2 - 1]) {
				double flag = ele[temp - 1];
				ele[temp - 1] = ele[temp / 2 - 1];
				ele[temp / 2 - 1] = flag;
				temp = temp / 2;
			} else {
				return;
			}
		} while (temp == 0);
	}

	public void display() {
		for (int i = 0; i < cur; i++) {
			System.out.print(ele[i] + " ");
		}
		System.out.println();
	}
}

class Test {

	public static void main(String[] args) {
		Heap heap=new Heap();
		heap.insert(0.9);
		heap.insert(0.8);
		heap.insert(0.5);
		heap.insert(1.7);
		heap.insert(2.8);
		heap.insert(4.5);
		heap.insert(3.5);
		heap.insert(1.33);
		heap.display();
		heap.deletemin();
		heap.deletemin();
		heap.insert(1.66);
		System.out.println(heap.deletemin());
		heap.display();
	}

}
