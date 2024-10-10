/**
* the Queue class is a data structure class to create a queue which can contains various type of data
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

import java.util.NoSuchElementException;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	public int s;
	
	@SuppressWarnings("unchecked")
	/**
	 * to construct a new queue with determined capacity
	 * @param capacity
	 * O(1)
	 */
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		head  = 0;
		tail = 0;
		numEntries = 0;
		s = q.length; 
	}
	
	/**
	 * to add an element at the end of the queue
	 * @param element
	 * O(1)
	 */
	public void enqueue(T element) {
		q[tail] = element;
		tail++;
		numEntries++;
	}
	
	/**
	 * to delet the element at the front of the queue
	 * @throws NoSuchElementException
	 * O(1)
	 */
	public void dequeue() throws NoSuchElementException{ 
		q[head] = null;
		head++;
		numEntries--;
	}
	/**
	 * to return the first element of the queue
	 * @return T: the element at the front of the queue
	 * @throws NoSuchElementException
	 * O(1)
	 */
	public T front() throws NoSuchElementException{
		if(numEntries != 0) {
			return q[head];
		}
		return null;
	}
	
	/**
	 * to return how many elements storing in the queue
	 * @return int: integer representing how many elements storing in the queue
	 * O(1)
	 */
	public int size() {
		return numEntries;
	}
	
	@Override
	/**
	 * to return the String which contains all the elements of the queue
	 * O(n)
	 */
	public String toString() {
		String output ="";
		int a= head;
		for (int i = 0; i<numEntries; i++) {
			output = output + q[a].toString()+"\n";
			a++;
		}
		return output;
	}
}
