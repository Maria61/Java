class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class LeetCode{
	/**问题描述：
	 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
	 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
	**/
    public static ListNode deleteDuplication(ListNode pHead)
    {
		//如果只有一个结点或链表为空则返回
        if(pHead==null||pHead.next==null){
            return pHead;
        }
		/*比较相邻两结点n1和n2(n2为n1的后继)：
			1.如果相同，遍历链表，查找与n1值不相等的结点,前面这些节点由于值相同，被舍弃
			找到后，将找到的结点传入方法，递归
			2.如果不同，保留该结点n1，n1的下一个为递归n2的返回值
			
		*/
		if(pHead.val==pHead.next.val){
			ListNode node=pHead.next;
			//找到与当前结点pHead不相等的结点
			while(node!=null&&node.val==pHead.val){
				node=node.next;
			}
			return deleteDuplication(node);
		}else{
			pHead.next=deleteDuplication(pHead.next);
		}
		return pHead;
        
    }
	/**问题描述：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	**/
	public static ListNode deleteDuplicates(ListNode head) {
        /*思路：遍历链表，比较结点和它的下一个是否相等
			if(相等){
				遍历查找不相等的结点
				if(找到){
					将原来的结点的后继指向找到的结点
				}else{
					原来的结点的后继为空
				}
				
			}
			
			继续遍历；
		*/	
		if(head==null||head.next==null){
			return head;
		}
		ListNode cur=head;
		while(cur!=null){
			if(cur.next!=null){
				if(cur.val==cur.next.val){
					ListNode node=cur.next;
					while(node!=null&&node.val==cur.val){
						node=node.next;
					}
					if(node==null){
						cur.next=null;
						break;
					}
					cur.next=node;
				}
			}
			
			cur=cur.next;
		}
		return head;
    }
	//打印
	public static void display(ListNode head){
		for(ListNode cur=head;cur!=null;cur=cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");
	} 
	
	public static void main(String[] args){
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(2);
		ListNode n4=new ListNode(3);
		ListNode n5=new ListNode(3);
		ListNode n6=new ListNode(5);
		ListNode n7=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		
		ListNode head=n1;
		display(head);
		//head=deleteDuplication(head);
		//display(head);
		head=deleteDuplicates(head);
		display(head);
	}
}