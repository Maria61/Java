class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
		next = null;
	}
}
public class LeetCode {
    public static boolean hasCycle(ListNode head) {
        int flag = 19990224;    //设置一个奇葩数字不会在给定数据中
        while(head != null){
			if(head.val == flag){
				return true;
			}else{
				head.val = flag;
			} 
			head = head.next;
		}
      return false;
    }
	public static boolean hasCycle2(ListNode head) {
		if(head == null) return false;
		if(head.next == head) return true;
		ListNode q = head;  //快指针
		while(q != null){
		  if(q.next == null){
			return false;  
		  } 
		  head = head.next;   //慢指针
		  q = q.next.next;
		  if(head == q){
			return true;   //相遇即有环
		  }			    
		}
		return false;
    }
	public static void print(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n3;
		//print(head);
		System.out.println(hasCycle(head));
	}
}