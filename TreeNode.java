class TreeNode<E>{
	
	E item;
	TreeNode<E> left;
	TreeNode<E> right;
	TreeNode<E> parent;
	
	public TreeNode(E item, TreeNode<E> left, TreeNode<E> right, TreeNode<E> parent){
		this.item = item;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public TreeNode(E item, TreeNode<E> left, TreeNode<E> right){
		this(item, left, right, null);
	}
	
	public TreeNode(E item){
		this(item, null, null);
	}
	
	public TreeNode(){
		this(null);
	}
}