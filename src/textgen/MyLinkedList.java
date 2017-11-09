package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
	if(element == null) {
			throw new NullPointerException("");
			
		}
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		nodeToAdd.next = tail;
		nodeToAdd.prev = tail.prev;
		tail.prev.next= nodeToAdd;
		tail.prev = nodeToAdd;
		
		size++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0||index>size-1) {
			throw new IndexOutOfBoundsException("");
		}
		LLNode<E> current = head;
		for(int i=0;i<=index;i++) {
			current = current.next;
		}
		return current.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index<0||(index>0&&index > size-1) ){
			throw new IndexOutOfBoundsException("");
		}
		
		if(element == null) {
			throw new NullPointerException();
		}
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> current = head;
		for(int i=0;i<=index;i++) {
			current = current.next;
		}
		nodeToAdd.next = current;
		nodeToAdd.prev = current.prev;
		current.prev.next = nodeToAdd;
		current.prev = nodeToAdd;
		
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0||(index>0&&index > size-1) ){
			throw new IndexOutOfBoundsException("");
			}
		
		LLNode<E> nodeToRemove = head;
		for(int i = 0 ; i<= index; i++) {
			 nodeToRemove = nodeToRemove.next;
		}
		nodeToRemove.prev.next = nodeToRemove.next;
		nodeToRemove.next.prev = nodeToRemove.prev;
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
		size--;
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index<0||(index>0&&index > size-1) ){
			throw new IndexOutOfBoundsException("");
			}
		if(element == null) {
			throw new NullPointerException();
		}
		LLNode<E> nodeToSet = head;
		LLNode<E> nodeNew = new LLNode<E>(element);
		for(int i = 0; i<=index; i++) {
			nodeToSet = nodeToSet.next;
		}
		nodeToSet.data = nodeNew.data;
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
