package linked_list;

public class LinkNode<E> {
	public E theObject;
	public LinkNode next; // reference to the next node in the linked list
	
	public LinkNode(E theObject, LinkNode next) {
		this.theObject = theObject;
		this.next = next;
	}
}
