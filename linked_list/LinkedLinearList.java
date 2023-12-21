package linked_list;

import java.util.NoSuchElementException;

public class LinkedLinearList<E> implements LinkedList<E>{

	private LinkNode<E> head; // node at the beginning of the linked list
	private int size;
	
	public LinkedLinearList() {
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int index) {
		if(indexIsValid(index)) {
			LinkNode<E> currentLinkNode = head;
			E theObject = head.theObject;
			if(index != 0) {
				for(int i = 0; i < index ; i++) {
					currentLinkNode = currentLinkNode.next;
				}
			}
			
			return currentLinkNode.theObject;
		}
		throw new IndexOutOfBoundsException("index + " + index + "  size: " + size);
	}

	/**
	 * @return int: the index of the object in the list
	 */
	@Override
	public int indexOf(Object object) {
		int index = 0;
		LinkNode<E> currentLinkNode = head;
//		loop through the list
		while(currentLinkNode != null) {
//			check if the object to be found matches the object in the current link node
			if(currentLinkNode.theObject == object) {
				return index;
			}
			
			currentLinkNode = currentLinkNode.next; // update ref to the current node
			index++; //update index
		}
//		if the compiler reaches here, the object was not found hence, throw an error
		throw new NoSuchElementException();
	}

	/**
	 * remove an object from the list and return that object
	 * 
	 * ensure that if the index is not 0, currentLinkNode should be the node just before the node to be removed before removing the node
	 */
	@Override
	public Object remove(int index) {
		if(!indexIsValid(index)) throw new IndexOutOfBoundsException("index: " + index + "size: " + size);
		
		LinkNode<E> removedLinkNode = null;
		if(index == 0) {
			removedLinkNode = head;
			head = head.next;
		}else {
			LinkNode<E> currentLinkNode = head;
			for(int i = 0; i < index; i++) {
				if(i == index - 1) {
					removedLinkNode = currentLinkNode.next;
					currentLinkNode.next = currentLinkNode.next.next; // remove the node
				}
				currentLinkNode = currentLinkNode.next;
			}
		}
		return removedLinkNode.theObject;
	}

	@Override
	public void add(int index, Object theObject) {
		if(!indexIsValid(index)) throw new IndexOutOfBoundsException();
		
		if(index == 0) {
			addFirst(theObject);
			return;
		}
		
		if(index == size-1) {
			addLast(theObject);
			return;
		}
		
		LinkNode<E> current = head;
		
		for(int i = 0; i < index-1; i++) {
			current = current.next;
		}
		LinkNode<E> temp = current.next;
		current.next = new LinkNode(theObject, temp);
		
		
	}

//	Add an object to the beginning of the list
	@Override
	public void addFirst(Object theObject) {
//		check if the list is not empty
		if(!isEmpty()) {
			head = new LinkNode(theObject, head);
		}else {
			head = new LinkNode(theObject, null);
		}
		size++;
	}

//	Add an object to the end of the list
	@Override
	public void addLast(Object theObject) {
//		if the list is empty, add the object as the first object
		if(isEmpty()) {
			addFirst(theObject);
		}else {
			//create a new LinkNode to store the object and set its reference to the next object to be null
			LinkNode<E> newLinkNode = new LinkNode(theObject, null); 
			//create a reference to the object at the beginning of the list
			LinkNode current = head; 
			// loop through the list
			while(current.next != null) {
				current = current.next;
			}
			// set the last node to reference the new node as the next node on the list
			current.next = newLinkNode;
		}
//		increase the size of the list
		size++;
	}

	@Override
	public String outputList() {
		String output = "[";
		LinkNode<E> current = head;
		while(current != null) {
			output += current.theObject + ", ";
			current = current.next;
		}
		if(size > 0) {
			output = output.substring(0, output.length() - 2);
		}
		return output + "]";
	}

	@Override
	public void clear() {
		head = null;
	}

	@Override
	public boolean isFound(Object theObject) {
		LinkNode<E> currentLinkNode = head;
		
//		loop through the list
		while(currentLinkNode != null) {
//			check if the object to be found matches the object in the current link node
			if(currentLinkNode.theObject == theObject) {
				return true;
			}
		
			currentLinkNode = currentLinkNode.next; // update ref to the current node
		}
		return false;
	}
	
	public boolean indexIsValid(int index) {
		return index >= 0 && index < size;
	}
	

}
