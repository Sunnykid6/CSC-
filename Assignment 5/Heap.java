/**
 * Heap.java
 * Provide the necessary header information here, 
 * making sure to delete these lines.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

// This is the beginning of the source code to help you get started.
// Do not change the following:

public class Heap<E extends Comparable<E>> {

	private ArrayList<E> heap;
	private int size;
	private static final int CAPACITY = 100;

	/**
	 * Creates an empty heap.
	 */
	public Heap() {
		heap = new ArrayList<E>(CAPACITY);
		for (int i=0; i<CAPACITY; i++) {
			heap.add(null);
		}
	} 
	/*
	Checks to see if the heap is empty
	*/
	public boolean isEmpty(){
		return size() == 0;
	}
	/*
	Determines the size of the heap
	*/
	public int size(){
		return size;
	}
	/*
	Inserts an item into the heap
	@param item to insert
	*/
	public void insert(E element){
		int place = size;
		int parent = (place - 1)/2;
		heap.set(size++, element);
		while(parent >= 0 && heap.get(place).compareTo(heap.get(parent)) < 0){
			E temp = heap.get(parent);
			heap.set(parent, heap.get(place));
			heap.set(place, temp);
			place = parent;
			parent = (place - 1)/2;
		}
	}
	/*
	Removes the element at the root of the heap
	Throws NoSuchElementException if the heap is empty
	*/
	public E getRootItem() throws NoSuchElementException{
		int loc;
		if(isEmpty()){
			throw new NoSuchElementException("Heap is empty");
		}
		E rootItem = heap.get(0);
		loc = size()-1;
		heap.set(0, heap.get(loc));
		heap.remove(loc);
		heap.set(size--, null);
		rebuild(0);
		return rootItem;
	}
	/*
	Recursive helper for getRootItem()
	*/
	private void rebuild(int root){
		int leftChild = 2 * root + 1;
		int rightChild = 2 * root + 2;
		int child = leftChild;
		if(heap.get(leftChild) != null){
			if(heap.get(rightChild) != null && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0){
				child = rightChild;
			}
			if(heap.get(root).compareTo(heap.get(child)) > 0){
			E temp = heap.get(root);
			heap.set(root, heap.get(child));
			heap.set(child, temp);
			rebuild(child);
			}
		}
	}
	
	public static void main(String[] args){
		Heap<ERPatient> h = new Heap<ERPatient>();
		h.insert(new ERPatient("Bob", "Smith", "Life-threatening"));
		h.insert(new ERPatient("John", "Deaux", "Ambulatory"));
		h.insert(new ERPatient("Carl", "Sagan", "Chronic"));
		h.insert(new ERPatient("Derek", "Jennejohn", "Major fracture"));
		h.insert(new ERPatient("Christine", "Lee", "Life-threatening"));
		h.insert(new ERPatient("Michelle", "Park", "Life-threatening"));
		h.insert(new ERPatient("Ash", "Blue", "Acute"));
		h.insert(new ERPatient("Hudson", "McPherson", "Major fracture"));
		System.out.println(h.size());
		System.out.println(h.isEmpty());
		System.out.println(h.getRootItem());
		System.out.println(h.getRootItem());
		System.out.println(h.getRootItem());
		System.out.println(h.getRootItem());
		System.out.println(h.getRootItem());
		System.out.println(h.getRootItem());
		System.out.println(h.getRootItem());
		System.out.println(h.getRootItem());
		
		
	}
}
// Complete the rest below:
