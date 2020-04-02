package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;
/**
 * This class is an implementation of the stack
 */
public class stack implements IStack {
	/**
	 * The node class of the stack
	 *
	 */
	public class Node {
		  public Object element;
		  public Node next = null;
		}
	private Node top =null;
	private int size =0;
	/**
	* Removes the element at the top of stack and returns that element.
	*
	* @return top of stack element, or through EmptyStackException if empty
	*/
	public Object pop() {
		if(top==null) {
			throw new EmptyStackException();
		}
	else {
		Object e = top.element;
		top=top.next;
		size--;
		return e;
	}
	}
	/**
	 * Get the element at the top without removing it from the stack, or through EmptyStackException if empty
	 * @return the top element of the stack
	 */
	public Object peek() {
		if(top==null) {
			throw new EmptyStackException();
		} 
		else {
			return top.element;
		}
	}
	/**
	 * Push an element in the top of the stack
	 * @param element
	 * to insert in the stack
	 */
	public void push(Object element) {
		if(element==null) {
			throw new NullPointerException("Null object is passed");
		}
		else {
		Node n = new Node();
		n.element=element;
		n.next=top;
		top=n;
		size++;
	} }
	/**
	 * Check if the stack is empty or not
	 * @return true if empty and false if not empty
	 */
	public boolean isEmpty() {
		if(top==null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * Get the number of elements in the stack
	 * @return the number of elements in the stack
	 */
	public int size() {
		return size;
	}
}