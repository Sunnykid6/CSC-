/*
Name: Victor Sun
Student Number: V00894734
*/
public class MedListRefBased implements List<Medication>{
	
	private MedicationNode head;
	private MedicationNode tail;
	private int count;
	
	public MedListRefBased(){
		this.head = null;
		this.tail = null;
		count = 0;
	}
	/*
	param@ item - The item you want to insert into the list
	param@ index - The location at where you want to insert the item at
	Add method determines if the location specified is valid then determines
	where in the linked list it is and inserts it accordingly. Increments count
	for every addition into the array
	*/
	public void add(Medication item, int index){
		MedicationNode temp = new MedicationNode(item);
		if(index < 0 || index > count){
			throw new IndexOutOfBoundsException();
		}
		else if(count == 0){
			head = temp;
			tail = temp;
		}
		else if(index == 0){
			head.prev = temp;
			temp.next = head;
			head = head.prev;
		}
		else if(index == count){
			tail.next = temp;
			temp.prev = tail;
			tail = tail.next;
		}
		else{
			MedicationNode curr = head;
			for(int i = 0; i < index; i++){
				curr = curr.next;
			}
			MedicationNode prev = curr.prev;
			prev.next = temp;
			temp.prev = prev;
			temp.next = curr;
			curr.prev = temp;
		}
		count++;
	}
	/*
	param@ index - the location in the linked list the medication is
	Returns the medicine located at the index specified.
	Get method traverses the linked list by next until it is at the index
	specified and returns the element.
	*/
	public Medication get(int index){
		if (index < 0 || index >= count){
			throw new IndexOutOfBoundsException();
		}
		else{
			MedicationNode curr = head;
			for(int i = 0; i < index; i++){
				curr = curr.next;
			}
			return curr.item;
		}
	}
	/*
	checks to see if count is greater than 0
	if it equals zero than it returns true, else the linked list is 
	occupied and returns false
	*/
	public boolean isEmpty(){
		if(count == 0){
			return true;
		}
		return false;
	}
	/*
	returns count, which is the size/number of items in the linked list
	*/
	public int size(){
		return count;
	}
	/*
	param@ item - the item you want to find the index of 
	indexOf method traverses the linked list until the item matches the node's item and
	returns the int of where it is located
	*/
	public int indexOf(Medication item){
		MedicationNode curr = head;
		for(int i = 0; i < count; i++){
			if(item.equals(curr.item)){
				return i;
			}
			curr = curr.next;
		}
		return -1;	
	}
	/*
	param@ index - the location of the item you want to remove
	Depending on where the location is, the head and tail are referenced differently
	as such once the item is removed count is decremented.
	*/
	public void remove(int index){
		if(index < 0 || index >= count){
			throw new IndexOutOfBoundsException();
		}
		else if(index == 0){
			head = head.next;
			head.prev = null;
			count--;
		}
		else if(index == count -1){
			tail = tail.prev;
			tail.next = null;
			count--;
		}
		else {
			MedicationNode curr = head;
			for(int i = 0; i < index; i++){
				curr = curr.next;
			}
			MedicationNode prev = curr.prev;
			MedicationNode next = curr.next;
			prev.next = curr.next;
			next.prev = prev;
			count--;
		}
	}
	/*
	removes everything from the linked list by 
	setting the head and tail to null and sets count = 0
	*/
	public void removeAll(){
		head = null;
		tail = null;
		count = 0;
	}
	/*
	param@ value - the value of the medicine that you want to remove
	Removes medicine in the array with the same value as the one inputed.
	Removes duplicates of the value given
	*/
	public void remove(Medication value){
		MedicationNode curr = head;
		int i = 0;
		if(value.equals(curr.item)){
				remove(i);
		}
		for(i = 0; i < count; i++){
			curr = curr.next;
			if(value.equals(curr.item)){
				remove(i);
				
			}
		}
	}
	/*
	A printout of the list
	*/
	public String toString(){
			MedicationNode curr = head;
			String str = "";
			while( head != null){
				str += curr.item;
				curr = curr.next;
			}
			return str;
	
	}
	
	public static void main(String[] args){
		List<Medication> list = null;
		list = new MedListRefBased();
		System.out.println(list.isEmpty());
		Medication m1 = new Medication("ibuprofen",200);
		Medication m2 = new Medication("meperidol",100);
		Medication m3 = new Medication("cimetidine",300);
		Medication m4 = new Medication("ibuprofen",200);
		list.add(m1,0);
		list.add(m2,1);
		list.add(m3,2);
		list.add(m4,1);
		list.remove(3);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		//System.out.println(list.indexOf(m2));
		/*
		list.removeAll();
		System.out.println();
		System.out.println(list.isEmpty());
		/*
		System.out.println(list.size());
		System.out.println();
		System.out.println(list.isEmpty());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println();
		list.remove(m1);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		list.remove(1);
		System.out.println();
		System.out.println(list.get(0));
		*/
	}
}