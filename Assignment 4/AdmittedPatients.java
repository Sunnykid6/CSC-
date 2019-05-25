public class AdmittedPatients{
	
	protected TreeNode root;
	/*
	Creates an empty BinarySearchTree to admit patients
	*/
	public AdmittedPatients(){
		this.root = null;
	}
	/*
	Recursive Method to help admit patients
	@Param The patient that has been admitted
	@Param TreeNode head is the root TreeNode to compare if the patient
		   is greater than or less than it using the CompareTo Method
	*/
	private void insertItem(TreeNode admitPatient, TreeNode head){
		int compInt = admitPatient.item.compareTo(head.item);
		if(compInt < 0){
			if(head.left == null){
				head.left = admitPatient;
			}
			else{
				insertItem(admitPatient, head.left);
			}
		}
		else if(compInt > 0){
			if(head.right == null){
				head.right = admitPatient;
			}
			else{
				insertItem(admitPatient, head.right);
			}
		}
		return;
	}
	/*
	inserts a new patient into the binary tree maintaining the order of the tree
	Ordering is determined by the compareTo method of the HospitalPatient class
	@Param The patient that has been admitted
	*/
	public void admit(HospitalPatient patient){
		TreeNode admitPatient = new TreeNode(patient);
		if(this.root == null){
			this.root = admitPatient;
		}
		else{
			insertItem(admitPatient, this.root);
		}
	}
	/*
	Recursive Method to help retrieve the patient info
	@Param Id to retrieve/determine where it is from
	@Param TreeNode head is the root Treenode to compare to 
	*/
	private TreeNode retrieveItem(String id, TreeNode head){
		/*if(compareTomethod is < 0){
			if (node left == null){
				return this one;
			}
			else{
				redo again to determine node
			}
		}
		else if (compareTomethod is > 0){
			if(node right == null)
				return this one;
			else{
				redo again to determine node
			}
		}
		else return the root one
		*/
		int compInt = id.compareTo(head.item.getId());
		if(compInt < 0){
			if(head.left == null){
				return null;
			}
			return retrieveItem(id, head.left);
		}
		else if(compInt > 0){
			if(head.right == null){
				return null;
			}
			return retrieveItem(id, head.right);
		}
		return head;
	}
	/*
	Retrieves the information about a patient, given an id number. The patient's record remains
	in its current location in the tree.
	@param The id of the patient
	Returns the complete record of that patient or null if the patient is not in the hospital
	*/
	public HospitalPatient getPatientInfo(String id){
		return retrieveItem(id, root).item;
	}
	
	private TreeNode deleteItem(TreeNode head, String id) {
		/*
		check each pointin the tree, at the top to check if it is null
		check the left side tree and right side tree recursively
		Need to check if it has children or not
		no children make it null
		if one child, swap with the parent and then make it null
		if there are two children we basically need to do the same, but a little more complicated
		*/
		return head;	
	}
	/*
	Removes a patients record from the BinarySearchTree. IF the record is not there, nothing changes.
	If the record is a node with no children, then that node is removed from the tree. If the record is
	in a node with one child, then that child requires the removed node in the tree(it becomes the child
	of the removed node's parent) If the record is in a node with two children, then the tree is adjusted
	as described on page 609 of the textbook. Essentially, it is replaced by it's inorder successor/
	@Param The record to remove
	*/
	public void discharge(HospitalPatient patient){
		//this.root = deleteItem(this.root, patient.getId());
	}
	/*
	Recursive helper method for an inorder traversal
	@Param starting tree
	*/
	public void inOrderTraversal(TreeNode head){
		if(head == null){
			return;
		}
		inOrderTraversal(head.left);
		inOrderTraversal(head.right);
	}
	/*
	Prints out a list of patient locations in alphabetical order, one entry per line. Formatting is defined by the getLocation method of HospitalPatient.
	*/
	public void printLocations(){
		inOrderTraversal(this.root);
	}
	
	public static void main(String[] args){
		AdmittedPatients admitted = new AdmittedPatients(); 
		HospitalPatient p1 = new HospitalPatient(new SimpleDate(2018,2,27),"Duck","Donald",'C',123);
		HospitalPatient p2 = new HospitalPatient(new SimpleDate(2018,1,20),"Mouse","Minnie",'B',307);
		HospitalPatient p3 = new HospitalPatient(new SimpleDate(2018,3,1),"Dog","Goofie",'A',422);
		HospitalPatient p4 = new HospitalPatient(new SimpleDate(2017,12,25),"Newman","Alfred",'X',111);
		HospitalPatient p5 = new HospitalPatient(new SimpleDate(2017,9,23),"Sun","Victor",'D',142);
		HospitalPatient p6 = new HospitalPatient(new SimpleDate(2018,5,12),"Duck","Daisy",'F',320);
		HospitalPatient p7 = new HospitalPatient(new SimpleDate(2016,3,25),"Disney","Walt",'G',333);
		admitted.admit(p1);
		admitted.admit(p2);
		admitted.admit(p3);
		admitted.admit(p4);
		admitted.admit(p5);
		admitted.admit(p6);
		admitted.admit(p7);
		System.out.println(p1.getLocation());
		//System.out.println(p1.getId());
		//System.out.println(p2.getId());
		//System.out.println(p3.getId());
		//admitted.printLocations();
		//admitted.discharge(p1);
		//admitted.discharge(p5);
		//System.out.println(admitted.getPatientInfo("Duck_0"));
		//System.out.println(admitted.getPatientInfo("Dog_2"));
		//System.out.println(admitted.getPatientInfo("Disney_6"));
		//System.out.println(admitted.getPatientInfo("Duck_0"));
		// these two lines cause the tree to be viewed in a little
		// resizable window.
		ViewableTree dbt = new ViewableTree(admitted);
		dbt.showFrame();
	}
}