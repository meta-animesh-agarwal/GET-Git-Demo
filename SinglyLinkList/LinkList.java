public class LinkList {

	Node start = null;
	Node last = null;
	
	void addElement(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		
		if(start == null) {
			start = newNode;		
		}
		else {
			last.next = newNode;
		}
		last = newNode;
	}
	
	void addElement(int data, int location) {
		Node newNode = new Node();
		newNode.data = data;
		Node tempStart = start;
		
		if(location == 1) {
			newNode.next = start;
			start = newNode;
		}
		else {
			for(int i = 1; (i < location - 1); i++) {
				tempStart = tempStart.next;
			}
			
			if(tempStart != null) {
				if(tempStart == last) {
					newNode.next = null;
				}
				else {
					newNode.next = tempStart.next;
				}
				tempStart.next = newNode;
			}
			else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
	}
	
	void removeElementByData(int data) {
		Node tempStart = start;
		
		while(tempStart.next != null) {
			if(tempStart.next.data == data) {
				break;
			}
			tempStart = tempStart.next;
		}
		tempStart.next = tempStart.next.next;
	}
	
	void removeElementByIndex(int index) {
		Node tempStart = start;
		
		for(int i = 1; (i < index) && (tempStart != null); i++) {
			tempStart = tempStart.next;
		}
		
		if(tempStart != null) {
			tempStart.next = tempStart.next.next;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	int dataByIndex(int index) {
		Node tempStart = start;
		
		for(int i = 1; (i < index) && (tempStart != null); i++) {
			tempStart = tempStart.next;
		}
		return(tempStart.data);
	}
	
	void reverseList() {
		int size = getSize();
		Node tempStart = start;
		int[] temp = new int[size];	
		
		for(int i = 0; i < size; i++) {
			temp[i] = tempStart.data;
			tempStart = tempStart.next;
		}
		
		tempStart = start;
		
		for(int i = size - 1; i >= 0; i--) {
			tempStart.data = temp[i];
			tempStart = tempStart.next;
		}
	}
	
	void sortList() {
		
		int size = getSize();
		Node tempStart = start;
		int[] temp = new int[size];	
		
		for(int i = 0; i < size; i++) {
			temp[i] = tempStart.data;
			tempStart = tempStart.next;
		}
		
		QuickSort q = new QuickSort();
		q.sort(temp, 0, size - 1);
		tempStart = start;
		
		for(int i = 0; i < size; i++) {
			tempStart.data = temp[i];
			tempStart = tempStart.next;
		}
	}
	
	private int getSize() {
		int size = 0;
		Node tempStart = start;
		
		while(tempStart != null) {
			size++;
			tempStart = tempStart.next;
		}
		return size;

	}
	void display() {
		Node tempStart = start;
		
		while(tempStart != null) {
			System.out.println(tempStart.data);
			tempStart = tempStart.next;
		}
	}
}