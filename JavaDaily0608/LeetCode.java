class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
class LeetCode {
	/**问题描述：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
	请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
	**/
	/*思路：创建两个链表分别存放奇数结点，偶数结点。
			遍历链表的奇数结点，奇数结点，尾插法插入到奇数链表中；
			奇数结点的下一个为偶数结点，尾插法插入到偶数链表中；
			找到下一个奇数结点，循环继续，直到当前结点为空；
	*/
    public static ListNode oddEvenList(ListNode head) {
        ListNode even=null;
        ListNode evenLast=null;
        ListNode odd=null;
        ListNode oddLast=null;
        ListNode cur=head;
        while(cur!=null){
            if(odd==null){
                odd=cur;
            }else{
                oddLast.next=cur;
            }
            oddLast=cur;
            if(even==null){
                even=cur.next;
            }else{
                evenLast.next=cur.next;
            }
            evenLast=cur.next;
           
            if(cur.next!=null){
                cur=cur.next.next;
				
            }else{
                cur=cur.next;
            }
        }
		if(oddLast!=null){
			oddLast.next=even;
		}
        
        return odd;
    }
	/**
	问题描述：两数相加
	给出两个 非空 的链表用来表示两个非负的整数。
	其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
	如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	**/
	/*思路：取出链表对应结点的值，相加结果存到新链表对应的结点，
	由于每个结点只存一位数，而相加结果有可能是两位，因此需要进位，每次相加时将进位加入计算。
		具体如下：	
			创建两个结点用来分别遍历两个链表，都指向对应链表的首结点。
			创建两个结点用来分别遍历两个链表，都指向对应链表的首结点。
			创建新链表存放结果，初始化值为0，创建一个结点用来存放每次的结果，
			遍历两链表，直到两链表都为空
				取出两链表的值与进位carry相加为sum，该值可能大于10，因此用carry保存每次相加的结果的进位进位值carry=sum/10,
				将sum的个位（sum%10）存入新链表中下一个结点
			用于遍历的结点前进一步。
			最后，遍历结束，判断carry是否为0，若不为0，则将carry的值存入新链表的下一个结点
	*/
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1=l1;
		ListNode cur2=l2;
		ListNode result=new ListNode(0);
		ListNode cur=result;
		int carry=0;
		int x=0;
		int y=0;
		int sum=0;
		while(cur1!=null||cur2!=null){
			if(cur1!=null){
				x=cur1.val;
			}else{
				x=0;
			}
			if(cur2!=null){
				y=cur2.val;
			}else{
				y=0;
			}
			sum=x+y+carry;
			carry=sum/10;
			cur.next=new ListNode(sum%10);
			cur=cur.next;
			
			if(cur1!=null){
				cur1=cur1.next;
			}
			if(cur2!=null){
				cur2=cur2.next;
			}
		}
		if(carry!=0){
			cur.next=new ListNode(carry);
		}
		
        return result.next;
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
	//打印
	public static void print(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.printf("%d-->",cur.val);
			cur=cur.next;
		}
		System.out.println("null");
	}
	//测试
	public static void main(String[] args){
		ListNode head=new ListNode(9);
		ListNode n2=new ListNode(4);
		ListNode n3=new ListNode(8);
		ListNode n4=new ListNode(3);
		ListNode n5=new ListNode(9);
		//ListNode n6=new ListNode(9);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		//n5.next=n6;
		print(head);
		ListNode head2=new ListNode(1);
		//ListNode m2=new ListNode(2);
		//ListNode m3=new ListNode(3);
		//ListNode m4=new ListNode(4);
		//ListNode m5=new ListNode(5);
		//head2.next=m2;
		//m2.next=m3;
		//m3.next=m4;
		//m4.next=m5;
		print(head2);
		//head=oddEvenList(head);
		//print(head);
		
		ListNode head3=addTwoNumbers(head,head2);
		print(head3);
		print(partition(head3,4));
		
	}
}