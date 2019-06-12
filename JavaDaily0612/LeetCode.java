class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){
		this.val=val;
	}
}
public class LeetCode{
	/**问题描述：
	给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
	**/
	public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        do{					//判断是否有环，快慢指针一个走两步，一个走一步，如果有环，一定可以遇到
            fast=fast.next;
            if(fast==null){
                break;
            }
            slow=slow.next;
            fast=fast.next;
        }while(fast!=null&&fast!=slow);
        if(fast==null){
            return null;
        }
        ListNode p=head;
        ListNode q=slow;
        while(p!=q){	//公式：L=R-c+(m-1)R	//L指的是环入口前的路程，C指的是环内相遇的路程，R指的是环的周长
            p=p.next;	//一个引用从首节点开始，一个引用从相遇点开始，共同移动，最终会在环入口相遇
            q=q.next;
        }
        return p;
    }
	/**问题描述：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
	**/
	/*思路：创建两个引用，慢引用指向首节点，快引用指向首节点的下一个，再创建一个跟随引用用来跟随慢的那个引用
			两个引用指向的结点值进行比较，
				如果不相等，三个引用共同移动一步；进入下一个循环
				如果相等，快引用移动，直到找到与慢引用所指结点值不同或者快引用指向空为止
					找到后，慢引用的前一个结点的下一个指向快引用，即跟随引用的下一个指向快引用
					更新三个引用，慢引用指向快引用，快引用指向下一个
					进入下一个循环。
	*/
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        ListNode q=head.next;
        ListNode pre=null;
        while(q!=null){
            if(p.val!=q.val){
                pre=p;
                p=p.next;
                q=q.next;
            }else{
                while(q!=null&&q.val==p.val){
                    q=q.next;
                }
                if(pre==null){
                    head=q;
                }else{
                    pre.next=q;
                }
                p=q;
                if(q!=null){
                    q=q.next;
                }
            }
        }
        return head;
    }
}