import java.util.Arrays;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
class LeetCode{
	/**问题描述：链表中的下一个更大结点
	每个节点都可能有下一个更大值（next larger value）：
	对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
	那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。
	如果不存在这样的 j，那么下一个更大值为 0 。
	**/
	/*思路：一个快指针，一个慢指针，快指针遍历链表找第一个 值大于慢指针的结点，并将该值计入数组
	1.创建一个数组，数组长度为链表长度
	2.判断链表是否降序排列，如果是降序排列，直接返回新数组
	3.开始遍历比较链表结点：
		慢指针从首指针开始，快指针为慢指针的下一个；
		比较快指针的值是否大于慢指针的值：
			如果大于，将快指针的值计入数组，并跳出循环，慢指针走下一个；
			否则，快指针走下一个，直到找到比慢指针值大的第一个结点，如果找不到，将0计入数组；
			
	*/
    public static int[] nextLargerNodes(ListNode head){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        int[] answer=new int[len];
        cur=head;
        while(cur.next!=null){
            if(cur.next.val>cur.val){
                break;
            }
            cur=cur.next;
        }
        if(cur==null){
            return answer;
        }
        ListNode pre=head;
        int i=0;
        while(pre!=null){
            cur=pre.next;
            while(cur!=null){
                if(cur.val>pre.val){
                    answer[i]=cur.val;
                    break;
                }else{
                    cur=cur.next;
                }
            }
            if(cur==null){
                answer[i]=0;
            }
            pre=pre.next;
            i++;
        }
        return answer;
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
		int[] answer=nextLargerNodes(head);
		System.out.println(Arrays.toString(answer));
	}
}