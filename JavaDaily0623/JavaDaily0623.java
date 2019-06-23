abstract class List{
	private int size;
	
	public void (int val){
		insert(size,val);
	}
	
	public void pushFront(int val){
		insert(0,val);
	}
	
	public abstract void insert(int index,int val);
	
	protected void incSize(){
		size++;
	}
	
	public int getSize(){
		return size;
	}
	
	
	abstract public  void display();
	
}
class Node{
	int val;
	Node next;
	
	Node(int val){
		this.val=val;
	}
}
class Linkedlist extends List{
	private Node head;
	
	@Override
	public void insert(int index,int val){
		Node cur=head;
		if(index==0){
			Node node=new Node(val);
			node.next=head;
			head=node;
		}else{
			for(int i=0;i<index-1;i++){
				cur=cur.next;
			}
			Node node=new Node(val);
			node.next=cur.next;
			cur.next=node;
		}
		incSize();
		
	}
	@Override
	public void display(){
		Node cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
	}
	
}
class ArrayList extends List{
	private int[] array=new int[10];
	
	@Override
	public void insert(int index,int val){
		for(int i=getSize();i>index;i--){
			array[i]=array[i-1];
		}
		
		array[index]=val;
		
		incSize();
	}
	
	@Override
	public void display(){
		for(int i=0;i<getSize();i++){
			System.out.println(array[i]);
		}
		
	}
	
}
public class JavaDaily0623{
	public static void main(String[] args){
		Linkedlist linkedlist=new Linkedlist();
		linkedlist.pushBack(1);
		linkedlist.pushBack(2);
		linkedlist.pushBack(3);
		linkedlist.pushFront(30);
		linkedlist.display();
		
		ArrayList arrayList=new ArrayList();
		arrayList.pushBack(1);
		arrayList.pushBack(2);
		arrayList.pushBack(3);
		arrayList.pushFront(30);
		arrayList.display();
	}
}