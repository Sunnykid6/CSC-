import java.util.NoSuchElementException;
import java.util.Vector;

/*
 * The shell of the class, to be completed as part
 * of CSC115 Assignment 5: Emergency Room.
 *
 /


/*
 * Complete this class as per the Heap.html specification document.
 * Fill in any of the parts that have the comment:
 *	/********  COMPLETE *******/
 /*
 * Do not change method headers or code that has been supplied.
 * Delete all messages to you, including this one, before submitting.
 */

public class Heap<E extends Comparable<E>> {

	private Vector<E> heapArray;
	private int size;
	private static final int CAPACITY = 100;

	public Heap() {
		heapArray = new Vector<E>(CAPACITY);
		for(int i = 0; i < CAPACITY; i++){
			heapArray.add(null);
		}
	}

	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public int size(){
		return this.size;
	}
	
	public void insert(E item){
		int place = size;
		int parent = (place - 1)/2;
		this.heapArray.set(size++, item);
		while(parent >= 0 && this.heapArray.get(place).compareTo(this.heapArray.get(parent)) < 0){
			E temp = this.heapArray.get(parent);
			this.heapArray.set(parent, this.heapArray.get(place));
			this.heapArray.set(place, temp);
			place = parent;
			parent = (place - 1)/2;
		}
	}
	
	public E removeRootItem() throws NoSuchElementException{
		if(this.isEmpty()){
			throw new NoSuchElementException("Heap is empty.");
		}
		E temp = this.heapArray.get(0);
		this.heapArray.set(0, this.heapArray.get(this.size - 1));
		this.heapArray.set(this.size--, null);
		rebuild(0);
		return temp;
	}
	
	private void rebuild(int root){
		int leftChild = 2 * root + 1;
		int rightChild = 2 * root + 2;
		int child = leftChild;
		if(this.heapArray.get(leftChild) != null){
			if(this.heapArray.get(rightChild) != null && this.heapArray.get(rightChild).compareTo(this.heapArray.get(leftChild)) < 0){
				child = rightChild;
			}
			if(this.heapArray.get(root).compareTo(this.heapArray.get(child)) > 0){
				E temp = this.heapArray.get(root);
				this.heapArray.set(root, this.heapArray.get(child));
				this.heapArray.set(child, temp);
				rebuild(child);
			}
		}
	}
	
	public E getRootItem() throws NoSuchElementException{
		if(isEmpty())
           throw new NoSuchElementException("The heap is empty.");
       return this.heapArray.get(0);
	}
	
	public String toString(){
       String heap = new String();
       heap = "{";
       if(!isEmpty())
           heap += heapArray.get(0);
       for(int i = 1; i < size(); i++){
           heap += ", " + heapArray.get(i);
       }
       heap += "}";
       return heap;
   }
	
	public static void main(String[] args){
		Heap heap = new Heap();
		System.out.println(heap.isEmpty());
		System.out.println("Size = " + heap.size());
		int z = 4;
		int a = 0;
		int b = 1;
		int c = 2;
		heap.insert(z);
		heap.insert(a);
		heap.insert(b);
		heap.insert(c);
		System.out.println(heap);
		System.out.println(heap.isEmpty());
		System.out.println("Size = " + heap.size());
		System.out.println(heap.getRootItem());
		System.out.println(heap);
		System.out.println(heap.removeRootItem());
		System.out.println(heap);
		
	}
}

