class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode{

	public static boolean isPalindrome(ListNode head) {
        int a=0;
        int b=0;
        int c=0;
        ListNode cur=head;
        while(cur!=null){
            a=a*10+cur.val;
            c=c*10;
            if(c==0){
                c=1;
            }
            b=c*cur.val+b;
            cur=cur.next;
        }
        if(a==b){
            return true;
        }else{
            return false;
        }
    }
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(2);
		ListNode n4=new ListNode(1);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		System.out.println(isPalindrome(head));
	}
}