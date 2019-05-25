/*
Name: Victor Sun
Student Number: V00894734
Date: July 28, 2018
Project: Assignment 5 PriorityQueue
*/
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {
	
	private Heap<E> heap;
	/*
	Inserts an item into the queue.
	Parameters:
	item - The item to insert.
	*/
	public PriorityQueue() {
		heap = new Heap<>();
	}
	/*
	Removes the highest priority item from the queue.
	Returns:
	The item.
	Throws:
	java.util.NoSuchElementException - if the queue is empty.
	*/
	public void enqueue(E item){
		this.heap.insert(item);
	}
	/*
	Removes the highest priority item from the queue.
	Returns:
	The item.
	Throws:
	java.util.NoSuchElementException - if the queue is empty.
	*/
	public E dequeue() throws NoSuchElementException{
		return this.heap.removeRootItem();
	}
	/*
	Retrieves, but does not remove the next item out of the queue.
	Returns:
	The item with the highest priority in the queue.
	Throws:
	java.util.NoSuchElementException - if the queue is empty.
	*/	
	public E peek() throws NoSuchElementException{
		return this.heap.getRootItem();
	}
	/*
	Returns:
	True if the queue is empty, false if it is not.
	*/
	public boolean isEmpty(){
		return this.heap.isEmpty();
	}
	/*
	Returns:
	String representation of the PriorityQueue
	*/
	public String toString(){
		return this.heap.toString();
	}
	
	public static void main(String[] args){
		String s = "bobafett";
		String t = s.substring(2);
		System.out.println(t);
	}
}
