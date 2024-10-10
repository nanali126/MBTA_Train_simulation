/**
* the Node class is a data structure class to construct a double linked node
* 
* Known Bugs: <None>
*
* @author Nana Li 
* <kejiali@brandeis.edu> 
* <Oct, 17th, 2022> 
6
* COSI 21A PA1
*/
package main;

public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> prev;
	
	/**
	 * To construct a new node
	 */
	public Node() {
		
	}
	
	/**
	 * To construct a new node contains the determined data
	 * @param data: data stored in the node
	 * O(1)
	 */
	public Node(T data) {
		this.data = data;
	}
	
	/**
	 * to set the data of the node
	 * @param data: the data which need to be set into the node
	 * O(1)
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * to set the next node linked to this node
	 * @param next: the determined next node linked to this node
	 * O(1)
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * to set the previous node linked to this node
	 * @param prev: the determined previous node linked to this node
	 * O(1)
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	/**
	 * to get the next node 
	 * @return Node<T>: the next node linked to this node
	 * O(1)
	 */
	public Node<T> getNext() {
		if (next == null) {
			return null;
		}else {
			return next;
		}
	}
	
	/**
	 * to get the previous node
	 * @return Node<T>: the previous node linked to this node
	 * O(1)
	 */
	public Node<T> getPrev() {
		if (prev == null) {
			return null;
		}else {
			return prev;
		}
	}
	
	/**
	 * to return the data of the node
	 * @return T: the data stored in the node
	 * O(1)
	 */
	public T getData() {
		return data;
	}
	
	@Override
	/**
	 * to return the String which represents the data contains in the node
	 */
	public String toString() {
		return (String)data;
	}
	
	/**
	 * to check whether two node are the same one
	 */
	public boolean equals(Object o) {
		@SuppressWarnings("unchecked")
		Node<T> other = (Node<T>) o;
		return other.data.equals(this.data);
	}
}
