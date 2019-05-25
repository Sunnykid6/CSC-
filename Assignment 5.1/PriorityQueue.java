import java.util.NoSuchElementException;

/*
 * The shell of the class, to be completed as part of the
 * CSC115 Assignment 5 : Emergency Room
 */

/*
 * Complete this class as per the Heap.html specification document.
 * Fill in any of the parts that have the comment:
 *	/********  COMPLETE *******/
 /*
 * Do not change method headers or code that has been supplied.
 * Delete all messages to you, including this one, before submitting.
 */

public class PriorityQueue<E extends Comparable<E>> {
	
	private Heap<E> heap;

	public PriorityQueue() {
		heap = new Heap();
	}
	
	public void enqueue(E item){
		heap.insert(item);
	}
	
	public E dequeue() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty.");
		}
		return heap.removeRootItem();
	}
			
	public E peek() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty.");
		}
		return heap.getRootItem();
	}
	
	public boolean isEmpty(){
		return heap.isEmpty();
	}
	
	public String toString(){
		return heap.toString();
	}
	
	public static void main(String[] args){
		PriorityQueue p = new PriorityQueue();
		ER_Patient a = new ER_Patient("Life-threatening");
		ER_Patient b = new ER_Patient("Walk-in");
		ER_Patient c = new ER_Patient("Chronic");
		ER_Patient d = new ER_Patient("Major fracture");
		p.enqueue(a);
		p.enqueue(b);
		p.enqueue(c);
		p.enqueue(d);
		System.out.println(p);
		System.out.println(p.peek());
	}
}

