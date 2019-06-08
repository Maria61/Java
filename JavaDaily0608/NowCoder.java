class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class NowCoder {
	/**问题描述：判断回文链表
	对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构
	**/
	/*思路：创建一个新链表，将A的值取出，创建新结点，头插到新链表里，则新链表为A的逆序链表，
	遍历比较A和新链表，如果有值不相等，返回false
	遍历结束，全都相等，返回true;
	*/
    public static  boolean chkPalindrome(ListNode A) {
        ListNode cur=A;
        ListNode newList=null;
		ListNode cur1=null;
        while(cur!=null){
			cur1=new ListNode(cur.val);
            cur1.next=newList;
            newList=cur1;
            cur=cur.next;
        }
		cur=A;
        ListNode newCur=newList;
        while(cur!=null){
            if(cur.val!=newCur.val){
				
                return false;
            }
            cur=cur.next;
            newCur=newCur.next;
        }
		return true;
    }
	/**问题描述：分割链表
	以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
	给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
	注意：分割以后保持原来的数据顺序不变。
	**/
	/*思路：遍历链表，小于x值的结点尾插到一个存放小值得链表中，否则存放到大链表，
	遍历结束，将小链表和大链表连起来，返回小链表的头结点。
	特殊情况:
			当链表中的值全大于所给之时，即小链表为空，则返回大链表的头结点
	*/
	public static  ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode cur=pHead;
        ListNode lessList=null;
        ListNode moreList=null;
        ListNode lastL=null;
        ListNode lastM=null;
        while(cur!=null){
            if(cur.val<x){
                if(lessList==null){
                    lessList=cur;
                }else{
                    lastL.next=cur;
                }
                lastL=cur;
            }else{
                if(moreList==null){
                    moreList=cur;
                }else{
                    lastM.next=cur;
                }
                lastM=cur;
            }
            cur=cur.next;
        }
		if(lastM!=null){
			lastM.next=null;
		}
		if(lessList==null){
			return moreList;
		}
		if(lastL!=null){
			lastL.next=moreList;
		}
        return lessList;
    }
	/**问题描述：链表中环的入口结点
	给一个链表，其中包含环，请找出该链表的环的入口结点.
	**/
	/*思路：
	创建两个结点用于遍历链表，一个结点快，另一个结点紧跟其后，每次慢的结点的下一个指向bull,将遍历过的结点都断开。
	快的结点走先下一步之前，慢的结点指向快的结点，快的结点再走下一步，快的结点走到空时，慢的结点指向的是环的入口结点。
	*/
	public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode cur=pHead.next;
        ListNode pre=pHead;
        while(cur!=null){
            pre.next=null;
            pre=cur;
            cur=cur.next;
        }
        return pre;
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
		ListNode head=new ListNode(9);
		ListNode n2=new ListNode(9);
		ListNode n3=new ListNode(9);
		ListNode n4=new ListNode(9);
		ListNode n5=new ListNode(9);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		print(head);
		//System.out.println(chkPalindrome(head));
		head=partition(head,9);
		print(head);
		System.out.println(EntryNodeOfLoop(head).val);
	}
}