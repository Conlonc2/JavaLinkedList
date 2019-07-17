package BuildingBlocks;

public class Node {
	private Object data;
	private Node next;
	private Node last;
	
	// Constructors 
	public Node(Object data) {
		this.data = data;
		this.next = null;
		this.last = null;
	}
	public Node() {
		this.data = null;
		this.next = null;
		this.last = null;
	}
	
	// Print method
	public String toString() {
		String toReturn = this.getData().toString();
		return toReturn;
	}

	
	// Getters and Setters
	public Object getData() {
		return this.data;

	}
	
	public void setData(Object newData) {
		this.data = newData;
	}
	
	public Node getNext() {
		return this.next;
	}
	public void setNext(Node nextNode) {
		this.next = nextNode;
	}
	public Node getLast() {
		return this.last;
	}
	public void setLast(Node lastNode) {
		this.last = lastNode;
	}
	

}
