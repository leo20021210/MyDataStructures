

//Bubble sort algorithm implemented without using recursion, time complexity O(n^2)
class BubbleSortNonRecursive {

	public static void main(String[] args) {
		int[] a= { 4, 77, 98, 30, 20, 50, 77, 22, 49, 2 };
		Bubble(a);
		System.out.println();
		System.out.println("The final result");
		for(int i:a) {
			System.out.println(i);
		}
	}

	public static void Bubble(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			System.out.println("a new round:");
			for(int j=0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
				for(int i1:a) {
					System.out.print(i1+" ");
				}
				System.out.println();
			}
		}
	}
}


//Bubble sort algorithm implemented using recursion, time complexity O(n^2)
class BubbleSortRecursive {

	public static void main(String[] args) {
		int[] a= { 4, 77, 98, 30, 20, 50, 77, 22, 49, 2 };
		Bubble(a,a.length);
		System.out.println();
		System.out.println("The final result");
		for(int i:a) {
			System.out.println(i);
		}
	}

	public static void Bubble(int[] a,int end) {
		if(end==1) {
			return;
		}
		System.out.println("end="+end+":");
		for(int j=0;j<end-1;j++) {
			if(a[j]>a[j+1]) {
				int temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
			for(int i:a) {
				System.out.print(i+" ");
			}
			System.out.print("  j="+j);
			System.out.println();
		}
		Bubble(a,end-1);
	}
}


//Insertion sort algorithm, time complexity O(n^2)
class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 4, 77, 98, 30, 20, 50, 77, 22, 49, 2 };
		Insertion(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static void Insertion(int[] a) {
		for (int i = 1; i < a.length; i++) {
			System.out.println();
			System.out.println("i="+i+":");
			int index = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] <= a[i]) {
					index = j + 1;
					break;
				}
			}
			for (int k = i - 1; k >= index; k--) {
				for (int i1 : a) {
					System.out.print(i1 + " ");
				}
				System.out.println();
				System.out.println("swap the "+(k+1)+"th element with the "+k+"th element");
				int temp = a[k + 1];
				a[k + 1] = a[k];
				a[k] = temp;
			}
			for (int i1 : a) {
				System.out.print(i1 + " ");
			}
			System.out.println();
		}
	}

}


//merge sort algorithm, time complexity O(nlog(n)), space complexity O(n^2)
class MergeSort {

	public static void main(String[] args) {
		int[] a = { 4, 77, 98, 30, 20, 50, 77, 22, 49, 2 };
		a=mergeSort(a, 0, a.length - 1);
		System.out.println();
		System.out.println("The final result");
		for (int i : a) {
			System.out.println(i);
		}
	}
	
	public static int[] mergeSort(int[] a,int start, int end) {
		if(start==end) {
			return new int[] {a[start]};
		}
		int middle=(start+end)/2;
		int[] b= merge(mergeSort(a,start,middle), mergeSort(a,middle+1,end));
		System.out.println("merge the list from "+start+" to "+middle+" and the list from "+(middle+1)+" to "+end);
		for (int i1 : b) {
			System.out.print(i1 + " ");
		}
		System.out.println();
		return b;
	}
	
	public static int[] merge(int[] a,int[] b) {
		int[] plus=new int[a.length+b.length];
		int i=0;
		int j=0;
		while(i<a.length||j<b.length) {
			if(i==a.length) {
				while(j<b.length) {
					plus[i+j]=b[j];
					j++;
				}
				break;
			}
			if(j==b.length) {
				while(i<a.length) {
					plus[i+j]=a[i];
					i++;
				}
				break;
			}
			if(a[i]<=b[j]) {
				plus[i+j]=a[i];
				i++;
			}else {
				plus[i+j]=b[j];
				j++;
			}
		}
		return plus;
	}

}


//Quick sort algorithm, time complexity O(nlog(n))< O() <O(n^2), usually close to O(nlog(n)). Space complexity O(n)
class QuickSort {

	public static void main(String[] args) {
		int[] a = { 4, 77, 98 };
		quickSort(a, 0, a.length - 1);
		System.out.println();
		System.out.println("The final result");
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static void quickSort(int[] arr, int start, int end) {
		System.out.println("sort the array from "+start+" to "+end);
		if (end-start<=1) {
			System.out.println("No need to sort, directly return");
			System.out.println();
			return;
		}
		int pivot = partition(arr, start, end);
		System.out.println("The pivot now goes to "+pivot);
		for (int i1 : arr) {
			System.out.print(i1 + " ");
		}
		System.out.println();
		System.out.println("Now we are going to sort the array from "+start+" to "+(pivot-1)+" and the array from "+(pivot+1)+" to "+end);
		System.out.println();
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot + 1, end);
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int j = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		arr[end] = arr[j];
		arr[j] = pivot;
		return j;
	}

}

//Selection sort algorithm, time complexity O(n^2)
class SelectionSort {

	public static void main(String[] args) {
		int[] a = { 4, 77, 98, 30, 20, 50, 77, 22, 49, 2 };
		Selection(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static void Selection(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int index = min(a, i);
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
			System.out.println("The smallest one in the array from "+i+" to the end is " + a[i] + " at " + index);
			System.out.println("swap the smallest value at "+index+" with the value at "+i);
			for (int i1 : a) {
				System.out.print(i1 + " ");
			}
			System.out.println();
			System.out.println();
		}
	}

	public static int min(int[] a, int start) {
		int min = a[start];
		int index = start;
		for (int i = start + 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
				index = i;
			}
		}
		return index;
	}

}
