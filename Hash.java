package HashTable;

class HashTable {
	private int max;
	private DataItem[] datas;
	private DataItem nonItem;

	public HashTable(int max) {
		this.max = max;
		datas=new DataItem[max];
	}
	
	public HashTable(int max, String data) {
		this.max = max;
		datas[Hash(data)]=new DataItem(data);
	}
	
	public int Hash(String data) {
		return Math.abs(data.hashCode()%max);
	}
	
	public String delete(String data) {
		int position=Hash(data);
		DataItem temp=datas[position];
		nonItem=datas[position];
		if(temp==null) {
			System.out.println("element not found");
			return null;
		}
		if(temp.data.equals(data)) {
			datas[position]=datas[position].next;
			return nonItem.data;
		}
		while(temp.next!=null&&!temp.next.data.equals(data)) {
			temp=temp.next;
		}
		if(temp.next==null) {
			System.out.println("element not found");
			return null;
		}
		nonItem=temp.next;
		temp=temp.next.next;
		return nonItem.data;
	}
	
	public DataItem search(String key){
		int position=Hash(key);
		nonItem=datas[position];
		if(nonItem==null) {
			System.out.println("element not found");
			return null;
		}
		if(nonItem.data.equals(key)) {
			return nonItem;
		}
		if(nonItem.next!=null&&!nonItem.next.data.equals(key)) {
			nonItem=nonItem.next;
		}
		if(nonItem.next==null) {
			System.out.println("element not found");
		}
		return nonItem.next;
	}
	
	public void add(String key){
		int position=Hash(key);
		if(datas[position]==null) {
			datas[position]=new DataItem(key);
			return;
		}
		nonItem=datas[position];
		while(nonItem.next!=null) {
			nonItem=nonItem.next;
		}
		nonItem.next=new DataItem(key);
	}
	
	public void display() {
		for(int i=0;i<max;i++) {
			if(datas[i]!=null) {
				System.out.println(datas[i].data);
				nonItem=datas[i];
				while(nonItem.next!=null) {
					nonItem=nonItem.next;
					System.out.println(nonItem.data);
				}
			}
		}
	}
}

class DataItem {
	public String data;
	public DataItem next;
	public DataItem(String data) {
		this.data = data;
		next=null;
	}
	public DataItem() {
		next=null;
	}
}

class Test {

	public static void main(String[] args) {
		HashTable hash=new HashTable(10);
		hash.add("anakin");
		hash.add("anakin");
		hash.add("obiwan");
		hash.display();
		System.out.println(hash.search("anakin").data);
		hash.delete("anakin");
		hash.display();
	}

}
