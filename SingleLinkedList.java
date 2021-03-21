import java.util.ListIterator;

//Rather than just building the LinkedList, I used OOP developing mode Iterator
class LinkedList<T> {
	private Node<T> first;
	private LinkedListIterator iter;

	public Node<T> getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first;
	}
	
	public boolean isEmpty(){
		return first==null;
	}

	public LinkedList() {
		first = null;
	}

	public void addFirst(T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}
	
	public T find(int index) {
		iter=this.listIiterator();
		for(int i=0;i<=index;i++) {
			iter.next();
		}
		return iter.position.data;
	}
	
	public int find(T key) {
		int count=0;
		iter=this.listIiterator();
		while(!iter.next().equals(key)) {
			if(!iter.hasNext()) {
				return -1;
			}
			count++;
		}
		return count;
	}
	
	public T remove(int index) {
		iter=this.listIiterator();
		for(int i=0;i<=index;i++) {
			iter.next();
		}
		T data=iter.position.data;
		iter.remove();
		return data;
	}
	
	public T remove(T key) {
		int index=find(key);
		if(index==-1) {
			throw new NoSuchElementException();
		}
		if(index==0) {
			return removeFirst();
		}
		iter=this.listIiterator();
		for(int i=0;i<=index;i++) {
			iter.next();
		}
		iter.remove();
		return key;
	}
	
	public T update(int index,T data) {
		iter=this.listIiterator();
		for(int i=0;i<=index;i++) {
			iter.next();
		}
		iter.set(data);
		return data;
	}
	
	public T update(T key, T data) {
		int index=find(key);
		return update(index,data);
	}

	public T removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T obj = first.data;
		Node<T> temp=first;
		first = first.next;
		temp=null;
		return obj;
	}
	
	public void add(T e) {
		iter=this.listIiterator();
		while(iter.hasNext()) {
			iter.next();
		}
		iter.add(e);
	}
	
	public void add(int key,T e) {
		iter=this.listIiterator();
		if(key==0) {
			addFirst(e);
			return;
		}
		for(int i=0;i<key;i++) {
			iter.next();
		}
		iter.add(e);
	}
	
	public int size() {
		iter=this.listIiterator();
		int i=0;
		while(iter.hasNext()) {
			iter.next();
			i++;
		}
		return i;
	}
	
	public void display() {
		iter=this.listIiterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
	}

	public LinkedListIterator listIiterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements ListIterator<T>{
		private Node<T> previous;
		private Node<T> position;
		private int index;

		public LinkedListIterator() {
			previous=null;
			position=null;
			index=0;
		}

		@Override
		public void add(T e) {
			index++;
			if(position==null) {
				addFirst(e);
				position=first;
				previous=position;
				return;
			}
			Node<T> newNode=new Node<T>();
			newNode.data=e;
			newNode.next=position.next;
			position.next=newNode;
			position=newNode;
			previous=position;
		}

		@Override
		public boolean hasNext() {
			if(position==null) {
				return first!=null;
			}
			if(position.next==null) {
				return false;
			}
			return true;
		}

		@Override
		public boolean hasPrevious() {
			return previous==null;
		}

		@Override
		public T next() {
			index++;
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			previous=position;
			if(position==null) {
				position= first;
				return position.data;
			}
			position=position.next;
			return position.data;
		}

		@Override
		public int nextIndex() {
			return index+1;
		}
		
		public int currentIndex() {
			return index;
		}

		@Override
		public T previous() {
			return previous.data;
		}

		@Override
		public int previousIndex() {
			return index-1;
		}

		@Override
		public void remove() {
			index--;
			if(position==previous) {
				throw new NoSuchElementException();
			}
			if(position==first) {
				removeFirst();
				position=null;
			}
			Node<T> temp=previous.next;
			previous.next=position.next;
			temp.next=null;
			position=previous;
		}

		@Override
		public void set(T e) {
			if(position==null) {
				throw new NoSuchElementException();
			}
			position.data=e;
		}

	}
}

class Node<T> {
	public T data;
	public Node next;
}

class test {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println(list.isEmpty() + " means it is null");
		System.out.println("Add Alice to the list--------------");
		list.addFirst("Alice");
		System.out.println(list.isEmpty() + " means it is not null");
		list.display();
		System.out.println("The size of the list is " + list.size());
		list.addFirst("Bob");
		System.out.println("Add Bob to the list--------------");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Add Charlie to the list--------------");
		list.addFirst("Charlie");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Add David to the list--------------");
		list.addFirst("David");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Add Anakin to the list--------------");
		list.addFirst("Anakin");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Replace Charlie with Obiwan--------------");
		list.update("Charlie", "Obiwan");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Replace Anakin with Yoda--------------");
		list.update("Anakin", "Yoda");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Replace Bob with Vader--------------");
		list.update("Bob", "Vader");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Replace Bob with Vader when Bob has already not been in the list--------------");
		try {
			list.update("Bob", "Vader");
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Remove David--------------");
		list.remove("David");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Remove Yoda--------------");
		list.remove("Yoda");
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println("Remove Anakin when Anaking has already not been in the list--------------");
		try {
			list.remove("Anakin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println(list.isEmpty() + " means it is not null");
		System.out.println("Call removeFirst for three times to clear the list--------------");
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();
		System.out.println("The size of the list is " + list.size());
		System.out.println(list.isEmpty() + " means it is null");
//		LinkedList<String> list=new LinkedList<String>();
//		System.out.println(list.isEmpty()+" means it is null");
//		list.addFirst("Alice");
//		System.out.println(list.isEmpty()+" means it is not null");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.addFirst("Bob");
//		System.out.println(list.isEmpty()+" means it is not null");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.addFirst("Charlie");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.addFirst("David");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.addFirst("Kenobi");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.add("Vader");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.add(3,"Anakin");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		System.out.println("David is at index "+list.find("David"));
//		System.out.println(list.find(0)+" is at index 0");
//		System.out.println(list.find(4)+" is at index 4");
//		list.remove("David");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.remove("Alice");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.update(3, "Yoda");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.update(1, "LukeSkywalker");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.remove(1);
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.update("Vader", "DarthVader");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.update("Yoda", "MasterYoda");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.remove("MasterYoda");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
//		list.remove("DarthVader");
//		System.out.println(list.size());
//		list.display();
//		System.out.println();
	}

}
