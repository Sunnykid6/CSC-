import java.util.Iterator;

/*
 * NOTE TO STUDENT:
 * Comment and implement all incomplete methods.
 * Any methods that have comments are already complete and
 * you must not change them.
 * You may add methods that you find helpful, remembering
 * that no public method allows acces to a TreeNode directly.
 * Remove this comment an provide your own header.
 */

/**
 * BinarySearchTree is an ordered binary tree, where the element in each node
 * comes after all the elements in the left subtree rooted at that node
 * and before all the elements in the right subtree rooted at that node.
 * For this assignment, we can assume that there are no elements that are
 * identical in this tree. 
 * A small modification will allow duplicates.
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	// the root is inherited from BinaryTree.

	/**
	 * Create an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		super();
	}

	/**
	 * Creates a BinarySearchTree with a single item.
	 * @param item The single item in the tree.
	 */
	public BinarySearchTree(E item) {
		super(item);
	}

	/**
 	 * <b>This method is not allowed in a BinarySearchTree.</b>
	 * It's description from the subclass:<br>
	 * <br>
	 * {@inheritDoc}
	 * @throws UnsupportedOperationException if this method is invoked.
	 */
	 /*
	Attaches a subtree to the left of the root node, replacing any subtree that was previously there.
	Overrides:
	attachLeftSubtree in class BinaryTree<E extends Comparable<E>>
	Parameters:
	left - The new left subtree of the root. This subtree may be empty. Once attached, this parameter reference is nullified to prevent multiple access to this tree.
	Throws:
	java.lang.UnsupportedOperationException - if this method is invoked.
	*/
	public void attachLeftSubtree(BinaryTree<E> left) {
		if(isEmpty()){
			throw new UnsupportedOperationException();
		}
		if(!isEmpty() && root.left != null){
			throw new UnsupportedOperationException();
		}
		root.left = left.getRoot();
		root.left = null;
	}
	/*
	Attaches a subtree to the right of the root node, replacing any subtree that was previously there.
	Overrides:
	attachRightSubtree in class BinaryTree<E extends Comparable<E>>
	Parameters:
	right - The new right subtree of the root. This subtree may be empty. Once attached, this parameter reference is nullified to prevent multiple access to this tree.
	Throws:
	java.lang.UnsupportedOperationException - if this method is invoked.
	*/
	public void attachRightSubtree(BinaryTree<E> right) {
		if(isEmpty()){
			throw new UnsupportedOperationException();
		}	
		if(!isEmpty() && root.right != null){
			throw new UnsupportedOperationException();
		}
		root.right = right.getRoot();
		root.right = null;
	}
	/*
	Inserts a new item into the tree, maintaining its order. If the item already exists in the tree, nothing happens.
	Parameters:
	item - The newest item.
	*/
	public void insert(E item) {
		this.root = insert(this.root, item);
	}
	/*
	recursive helper method for insert methods
	*/
	private TreeNode<E> insert(TreeNode<E> node, E item){
		if(node == null){
			return new TreeNode(item);
		}
		else if(item == node.item){
			return node;
		}
		else if(item.compareTo(node.item) < 0){
			if(node.left == null){
				node.left = new TreeNode(item);
			}
			else{
				insert(node.left, item);
			}
		}
		else if(item.compareTo(node.item) > 0){
			if(node.right == null){
				node.right = new TreeNode(item);
			}
			else{
				insert(node.right, item);
			}
		}
		return node;
	}
	
	/*
	Looks for the item in the tree that is equivalent to the item.
	Parameters:
	item - The item that is equivalent to the item we are looking for. Equality is determined by the equals method of the item.
	Returns:
	The item if it's in the tree, null if it is not.
	*/
	public E retrieve(E item) {
	TreeNode temp = retrieve(root, item);
		if(temp ==  null){
			return null;
		}
		else{
			return retrieve(root, item).item;
		}
	}
	/*
	recursive helper method for retieve
	*/
	private TreeNode<E> retrieve(TreeNode<E> node,E item){
		if(node == null){
			return null;
		}
		else if(item == node.item){
			return node;
		}
		else if(item.compareTo(node.item) < 0){
			return retrieve(node.left, item);
		}
		else if(item.compareTo(node.item) > 0){
			return retrieve(node.right, item);
		}
		return node;
	}
		
	/*
	Finds the item that is equivalent to the item and removes it, if it's in the tree.
	Parameters:
	item - The item that is equivalent to the item we are looking for. Equality is determined by the equals method of the item.
	Returns:
	The actual item that was removed, or null if it is not in the tree.
	*/
	public E delete(E item) {
		return delete(this.root, item).item;
	}
	/*
	recursive helper method for delete method
	Determines which deletion method to use based on child
	*/
	private TreeNode<E> delete(TreeNode<E> node, E item){
		if(node == null){
			return null;
		}
		else if(item.compareTo(node.item) < 0){
			node.left = delete(node.left, item);
		}
		else if(item.compareTo(node.item) > 0){
			node.right = delete(node.right, item);
		}
		else if(item == node.item){
			if(node.left == null && node.right == null){
				return null;
			}
			else if(node.left == null){
				return node.right;
			}
			else if(node.right == null){
				return node.left;
			}
			else{
				node.item = findRightSuccessor(node.right).item;
				node.right = deleteRightSuccssor(node.right);
				return node;
			}
		}
		return node;
	}
	/*
	recursive helper method
	finds the successor to the root if the root is deleted
	*/
	private TreeNode<E> findRightSuccessor(TreeNode node){
		if(node.left == null){
			return node;
		}
		else{
			return findRightSuccessor(node.left);
		}
	}
	/*
	recursive helper method 
	deletes the extra instance of the successor
	*/
	private TreeNode<E> deleteRightSuccssor(TreeNode node){
		if(node.left == null){
			return node.right;
		}
		else{
			node.left = deleteRightSuccssor(node.left);
			return node;
		}
	}
	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		// NOTE TO STUDENT: something to get you started.
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		String s1 = new String("optimal");
		String s2 = new String("needs");
		String s3 = new String("programmers");
		String s4 = new String("CSC115");
		String s5 = new String("Ivy");
		String s6 = new String("Drawing");
		String s7 = new String("pusheen");
		String s8 = new String("pusheen");
		String s9 = new String("pocket");
		tree.insert(s1);
		tree.insert(s2);
		tree.insert(s3);
		tree.insert(s4);
		tree.insert(s5);
		tree.insert(s6);
		tree.insert(s7);
		tree.insert(s8);
		tree.insert(s9);
		//tree.delete(s2);
		//tree.delete(s3);
		//tree.delete(s1);
		//tree.insert(s7);
		//tree.delete(s10);
		System.out.println(tree.retrieve(s1));
		//System.out.println(tree.retieve("pusheen"));
		//tree.delete(s5);
		//tree.delete(s4);
		
		String test = tree.retrieve("pusheen");
		if (test != null && !test.equals("")) {
			System.out.println("retrieving the node that contains "+s7);
			if (test.equals(s7)) {
				System.out.println("Confirmed");
			} else {
				System.out.println("retrieve returns the wrong item");
			}
		} else {
			System.out.println("retrieve returns nothing when it should not");
		}
		String temp = tree.delete(s3);
		if(temp.equals("optimal")){
			System.out.println("Deleted optimal");
		}
		else{
			System.out.println(temp);
		}
		Iterator<String> it = tree.inorderIterator();
		System.out.println("printing out the contents of the tree in sorted order:");
		while (it.hasNext()) {
			System.out.print(it.next()+" ");
		} 
		System.out.println();
		DrawableBTree<String> dbt = new DrawableBTree<String>(tree);
		dbt.showFrame();
	}
}

	

	
