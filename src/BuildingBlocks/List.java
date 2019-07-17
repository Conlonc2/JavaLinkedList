package BuildingBlocks;

public class List extends Node{
	private Node head, tail;
	
	public List(Object data) {
		this.head = new Node(data);
		this.tail = head;
		
	}
	public List() {
		this.head = null;
		this.tail = null;
	}
	
	// Methods
	public String toString() {
		String toPrint = "";
		Node start = tail;
		
		while (start != null) {
			if (start != head) {
				toPrint += start.getData() + ",";
			}else {
				toPrint += start.getData();
			}
			start = start.getNext();
		}
		
		return toPrint;
	}
	
	public void append(Object x) {
		if( this.head == null ) {
			this.head = new Node(x);
			this.tail = this.head;
			return;
		}
		Node t = head;
		
		this.head.setNext(new Node(x));
		this.head = head.getNext();
		this.head.setLast(t);		
	}
	
	public Object indexOf(Object search) {
		Node startPointer = tail;
		Node endPointer = head;
		int indexStart = 0; // index from the begging of the list
		int indexEnd = this.length() - 1; // index from the end
		boolean found = false;
		
		while (!found) {
			if (startPointer.getData() == search) {
				return indexStart;
			}else if(endPointer.getData() == search){
				return indexEnd;
			}
			
			startPointer = startPointer.getNext();
			endPointer = endPointer.getLast();
			if (indexStart + 1 > indexEnd ) {
				break;
			}
			indexStart ++;
			indexEnd--;
		}
		
		return "Element not found";
	}
	
	// Returns the node at index
	public Node search(int index) {
		if (index >= this.length()) {
			throw new IndexOutOfBoundsException("Current exceptable positions in list are [0-"+ (this.length()-1)+"]");
		}
		else if(index == 0){
			return tail;
		}
		else if(index == this.length() -1) {
			return head;
		}
		Node toReturn;
		
		if(index > 0) {
			toReturn = this.tail;
			for(int x = 0; x < index; x ++) {
				toReturn = toReturn.getNext();
			}
		}
		else {
			toReturn = this.head;
			for(int x = -1; x > index ; x--) {
				toReturn = toReturn.getLast();
			}
		}
		
		return toReturn;
	}
	
	public int length() {
		Node start = head;
		int count = 0;
		while (start != null) {
			count++;
			start = start.getLast();
		}
		return count;
	}
	
	
	public void insert(Object toInsert, int position) {
		// Used to insert into the position of X:position
		if (position >= this.length() || position < 0) { 
			throw new IndexOutOfBoundsException("Current exceptable positions in list are [0-"+ (this.length()-1)+"]");
		}
		Node temp = new Node(toInsert);
		
		if (position == 0) {
			temp.setNext(this.tail);
			this.tail = temp;
			tail.getNext().setLast(temp);		
		}
		else if(position == this.length()-1){
			this.head.setNext(temp);
			temp.setLast(this.head);
			this.head = temp;
		}
		
		else {
			Node holder = this.search(position-1);
			temp.setNext(holder.getNext());
			temp.setLast(holder);
			holder.setNext(temp);
			temp.getNext().setLast(temp);
		}
		
	}
	
	public void delete(int index) {
		Node holder = this.search(index);
		Node prev = holder.getLast();
		Node next = holder.getNext();
		
		if(holder == this.tail) {
			this.tail.getNext().setLast(null);
			this.tail.setNext(null);
			this.tail = next;

		}
		else if(holder == this.head){
			this.head.getLast().setNext(null);
			this.head.setLast(null);
			this.head = prev;
		}
			

		else {
			prev.setNext(next);
			next.setLast(prev);
		}
		holder = null;
		
	}
	// Getter and Setters

}
