import java.util.NoSuchElementException;

class LinkedList<T> {
	private Node<T> first;

	public int size() {
		Node<T> current = first;
		if (isEmpty()) {
			return 0;
		}
		int count = 1;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public LinkedList(T data) {
		this.first = new Node<T>(data, null, null);
	}

	public LinkedList() {
		this.first = new Node<T>();
	}

	public boolean isEmpty() {
		return first.data == null;
	}

	public T getFirst() {
		return first.data;
	}

	public void addFirst(T e) {
		if (isEmpty()) {
			Node<T> newNode = new Node<T>(e, null, null);
			first = newNode;
			return;
		}
		Node<T> newNode = new Node<T>(e, null, first);
		first.previous = newNode;
		first = newNode;
	}

	public T removeFirst() {
		if (isEmpty()) {
			System.out.println("You have already removed every element in the list");
			return null;
		}
		T temp = first.data;
		if (first.next == null) {
			first.data = null;
		} else {
			Node<T> temp1 = first;
			first = first.next;
			temp1 = null;
		}
		return temp;
	}

	public T remove(T key) {
		if (key.equals(first.data)) {
			removeFirst();
			return key;
		}
		Node<T> check = first;
		while (check.next != null && check.next.data != key) {
			check = check.next;
		}
		if (check.next == null) {
			return null;
		}
		Node temp = check.next;
		if (check.next.next == null) {
			check.next = null;
			temp = null;
			return key;
		}
		check.next = temp.next;
		temp.next = null;
		check.next.previous = check;
		temp.previous = null;
		return key;

		/*
		 * if(key.equals(first.data)) { removeFirst(); return key; } Node<T>
		 * current=first; while(current.next!=null) { if(key.equals(current.next.data))
		 * { if(current.next.next==null) { current.next=null; return key; }
		 * current.next=current.next.next; Node<T> temp1=current.next;
		 * current.next=temp1.next; temp1.next=null; temp1.previous=null;
		 * current.next.previous=current; return key; } current=current.next; }
		 * System.out.println("There is no such element "+key); return null;
		 */
	}

	public T update(T key, T newValue) {
		if (key.equals(first.data)) {
			first.data = newValue;
			return newValue;
		}
		Node<T> current = first;
		while (current.next != null) {
			if (current.next.data.equals(key)) {
				current.next.data = newValue;
				return newValue;
			}
			current = current.next;
		}
		System.out.println("There is no such element " + key);
		return null;
	}

	public void displayList() {
		if (isEmpty()) {
			System.out.println("The list is empty");
			return;
		}
		Node<T> current = first;
		while (current.next != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println(current.data);
	}
}

class Node<T> {
	public T data;
	public Node<T> previous;
	public Node<T> next;
	public Node() {
	}
	public Node(T data, Node<T> previous, Node<T> next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
}

class test {

	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println(list.isEmpty()+" means it is null");
		System.out.println("Add Alice to the list--------------");
		list.addFirst("Alice");
		System.out.println(list.isEmpty()+" means it is not null");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		list.addFirst("Bob");
		System.out.println("Add Bob to the list--------------");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Add Charlie to the list--------------");
		list.addFirst("Charlie");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Add David to the list--------------");
		list.addFirst("David");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Add Anakin to the list--------------");
		list.addFirst("Anakin");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Replace Charlie with Obiwan--------------");
		list.update("Charlie", "Obiwan");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Replace Anakin with Yoda--------------");
		list.update("Anakin","Yoda");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Replace Bob with Vader--------------");
		list.update("Bob","Vader");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Replace Bob with Vader when Bob has already not been in the list--------------");
		list.update("Bob","Vader");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Remove Alice--------------");
		list.remove("Alice");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Remove Yoda--------------");
		list.remove("Yoda");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println("Remove Anakin when Anaking has already not been in the list--------------");
		list.remove("Anakin");
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println(list.isEmpty()+" means it is not null");
		System.out.println("Call removeFirst for three times to clear the list--------------");
		list.removeFirst();
		list.displayList();
		list.removeFirst();
		list.displayList();
		list.removeFirst();
		list.displayList();
		System.out.println("The size of the list is "+list.size());
		System.out.println(list.isEmpty()+" means it is null");
	}

}
