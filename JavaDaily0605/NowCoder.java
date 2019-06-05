class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}
public class NowCoder{
    public static ListNode merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode cur1=list1;
        ListNode cur2=list2;
        ListNode newList=null;
        ListNode last=newList;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                ListNode next=cur1.next;
                if(newList==null){
                    cur1.next=newList;
                    newList=cur1;
                }else{
                    last.next=cur1;
                }
                last=cur1;
                cur1=next;
            }else{
                ListNode next=cur2.next;
                if(newList==null){
                    cur2.next=newList;
                    newList=cur2;
                }else{
                    last.next=cur2;
                }
                last=cur2;
                cur2=next;
            }
        }
        if(cur1==null&&last!=null){
            last.next=cur2;
        }
        if(cur2==null&&last!=null){
            last.next=cur1;
        }
        return newList;
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
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		print(head);
		ListNode head2=new ListNode(1);
		ListNode m2=new ListNode(2);
		ListNode m3=new ListNode(3);
		ListNode m4=new ListNode(4);
		head2.next=m2;
		m2.next=m3;
		m3.next=m4;
		print(head2);
		print(merge(head,head2));
	}
}
