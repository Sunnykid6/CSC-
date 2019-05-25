/*
Name: Victor Sun
Student Number: V00894734
Date: July 28, 2018
Project: Assignment 5 Heap
*/
import java.util.NoSuchElementException;
import java.util.Vector;

public class Heap<E extends Comparable<E>>{

	private Vector<E> heapArray;
	private final int INITIAL_SIZE = 1;
	private final int VECTOR_INCREMENT = 1;

	/*
	Create an empty heap.
	*/
	public Heap(){
		heapArray = new Vector<E>(INITIAL_SIZE, VECTOR_INCREMENT);
	}
	/*
	Returns:
	True if the heap is empty, false if it is not.
	*/
	public boolean isEmpty(){
		return this.heapArray.isEmpty();
	}
	/*
	Returns:
	The number of items in the heap.
	*/
	public int size(){
		return this.heapArray.size();
	}
	/*
	Inserts an item into the heap.
	Parameters:
	item - The newly added item.
	*/
	public void insert(E item){
		this.heapArray.add(item);
		bubbleUp(size() - 1);
	}
	/*
	Helper Method for insert method
	*/
	private void bubbleUp(int index){
		int parentIndex = ((index + 1) / 2) - 1;
		E child = this.heapArray.get(index);
		if(index == 0 || child.compareTo(this.heapArray.get(parentIndex)) >= 0){
			return;
		}
		this.heapArray.set(index, this.heapArray.get(parentIndex));
		this.heapArray.set(parentIndex, child);
		bubbleUp(parentIndex);
	}
	/*
	Removes the item at the root node of the heap.
	Returns:
	The item at the root of the heap.
	Throws:
	java.util.NoSuchElementException - if the heap is empty.
	*/
	public E removeRootItem() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("The heap is empty.");
		}
		if(size() == 1){
			return this.heapArray.remove(0);
		}
		E temp = this.heapArray.get(0);
		this.heapArray.set(0, this.heapArray.remove(size() - 1));
		bubbleDown(0);
		return temp;
	}
	/*
	Helper Method for removeRootItem
	*/
	public void bubbleDown(int parentIndex){
		if(this.heapArray.isEmpty()){
			throw new NoSuchElementException("The heap is empty.");
		}
		if(parentIndex + 1 > size() / 2){
			return;
		}
		int childIndexRight = parentIndex * 2 + 2;
		boolean childRightExist = childIndexRight < size();
		E rightChild = null;
		if(childRightExist){
			rightChild = this.heapArray.get(childIndexRight);
		}
		int childIndexLeft = parentIndex * 2 + 1;
		boolean childLeftExist = childIndexLeft < size();
		E leftChild = null;
		if(childLeftExist){
			leftChild = this.heapArray.get(childIndexLeft);
		}
		E parent = this.heapArray.get(parentIndex);
		if(childLeftExist && childRightExist){
			if(leftChild.compareTo(rightChild) <= 0 && parent.compareTo(leftChild) > 0){
				this.heapArray.set(parentIndex, leftChild);
				this.heapArray.set(childIndexLeft, parent);
				bubbleDown(childIndexLeft);
			}	
			else if(parent.compareTo(rightChild) > 0){
				this.heapArray.set(parentIndex, rightChild);
				this.heapArray.set(childIndexRight, parent);
				bubbleDown(childIndexRight);
			}
		}
		else if(childLeftExist && parent.compareTo(leftChild) > 0){
			this.heapArray.set(parentIndex, leftChild);
			this.heapArray.set(childIndexLeft, parent);
			bubbleDown(childIndexLeft);
		}
		else if(childRightExist && parent.compareTo(rightChild) > 0){
			this.heapArray.set(parentIndex, rightChild);
			this.heapArray.set(childIndexRight, parent);
			bubbleDown(childIndexRight);
		}
	}
	/*
	Retrieves, without removing the item in the root.
	Returns:
	The top item in the tree.
	Throws:
	java.util.NoSuchElementException - if the heap is empty.
	*/
	public E getRootItem() throws NoSuchElementException{
		if(isEmpty()){
           throw new NoSuchElementException("The heap is empty.");
		}
		return this.heapArray.get(0);
	}
	/*
	Returns:
	String representation of the heapArray
	*/
	public String toString(){
		return this.heapArray.toString();
	}
	
	public static void main(String[] args){
		Heap<Integer> test = new Heap<>();
		System.out.println("size = "+test.size());
		System.out.println(test.isEmpty());
		System.out.println(test);
		test.insert(84);
		test.insert(2);
		test.insert(78);
		test.insert(3);
		test.insert(4);
		test.insert(6);
		System.out.println(test);
		test.removeRootItem();
		System.out.println(test);
		test.removeRootItem();
		System.out.println(test);
		test.removeRootItem();
		System.out.println(test);
		System.out.println("root = "+test.getRootItem());
		System.out.println("size = "+test.size());
		System.out.println(test.isEmpty());
		test.removeRootItem();
		test.removeRootItem();
		//test.removeRootItem();
		//test.removeRootItem();
	}
}
