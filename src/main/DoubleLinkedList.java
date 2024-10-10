/**
* the DoubleLinkedList class is a data structure class to store data in a double linked list
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

public class DoubleLinkedList<T> {
	public Node<T> head;
	public Node<T> tail;
	public int size;

	/**
	 * To construct a double linked list
	 * O(1)
	 */
	public DoubleLinkedList() {
		size = 0;
	}
	
	/**
	 * To return the first element stored in the double linked list
	 * @return Node<T>: the first node in the double linked list
	 * O(1)
	 */
	public Node<T> getFirst() {
		if(head == null) {
			return null;
		}else {
			return head;
		}
	}
	
	/**
	 * To insert a node at the end of Double Linked List
	 * @param element: the element stored in the node which would be inserted in the double linked list
	 * O(1)
	 */
	public void insert(T element) {
		Node<T> newNode = new Node<T>(element);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.prev = tail;
			newNode.prev.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	/**
	 * To delete the node in the double linked list which contains the determined element
	 * @param key: the key stored in the determined key
	 * @return T: if the determined node existing in the double linked list element T will be return, if not null will be return
	 *O(n)
	 */
	public T delete(T key) {
		Node<T> n = new Node<T>();
		n = head;
		while(n != null){
			if(n.getData().equals(key)) {
				if(head.equals(tail)){
					head = null;
					tail = null;
				}else {
					n.next.prev = n.prev;
					n.prev.next = n.next;
					if(n.equals(head)) {
						head = n.next;
					}else if(n.equals(tail)) {
						tail = n.prev;
					}
				}
				size--;
				return key;
			}
			n = n.next;
		}
		return null;
	}
	
	/**
	 * To check whether the node contains determined key exist in the double linked list
	 * @param key: the key stored in the determined key
	 * @return T: if the determined node existing in the double linked list element T will be return, if not null will be return
	 * O(n)
	 */
	public T get(T key) {
		Node<T> n = new Node<T>();
		n = head;
		while(n != null) {
			if(n.getData().equals(key)) {
				return key;
			}
			n = n.next;
		}
		return null;
	}
	
	/**
	 * To return how many nodes stored in the double linked list
	 * @return size: the integer represents how many nodes stored in the double linked list
	 * O(1)
	 */
	public int size() {
		return size;
	}
	
	@Override
	/**
	 * to return the String printing all the data of nodes stored in the double linked list
	 * O(n)
	 */
	public String toString() {
		String output = "";
		Node<T> n = new Node<T>();
		n = head;
		while(n != null) {
			output = output + n.data.toString();
			n = n.next;
		}
		return output;
	}
}
