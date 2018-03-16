public class BinaryTree<E>{
	
	private TreeNode<E> root;
	
	public BinaryTree(E item, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		root = new TreeNode<E>(item, leftTree.root, rightTree.root);
	}
	
	public BinaryTree(E item){
		root = new TreeNode<E>(item);
	}

	public BinaryTree(){
	
	}
	
	protected TreeNode<E> getRoot(){
		return root;
	}
	
	public static void main(String args[]){
		BinaryTree<String> i = new BinaryTree<String>("Cougar");
		BinaryTree<String> h = new BinaryTree<String>("Fred");
		BinaryTree<String> f = new BinaryTree<String>("Matt");
		BinaryTree<String> g = new BinaryTree<String>("Mack");
		BinaryTree<String> d = new BinaryTree<String>("Victor", h, i);
		BinaryTree<String> e = new BinaryTree<String>("Oliver", f, g);
		BinaryTree<String> a = new BinaryTree<String>("Kamel");
		BinaryTree<String> b = new BinaryTree<String>("Tibor", d, e);
		BinaryTree<String> c = new BinaryTree<String>("Daniel", a, b);
		DrawableBTree<String> dbt = new DrawableBTree<String>(c);
		dbt.showFrame();
	}
}