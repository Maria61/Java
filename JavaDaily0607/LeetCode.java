class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode{
	/**问题描述：请判断一个链表是否为回文链表。
	**/
	/*思路：
		将链表值取出组成十进制数字，分别是
		按链表的顺序,先取出的数为高位，后取出的数为低位，组成一个数a;
		按链表顺序，先取出的数为低位，后取出的数为高位，组成一个数b;
		比较两数是否相等，相等，返回true，为回文链表，不相等返回false；
	*/
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