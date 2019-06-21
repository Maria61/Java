class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        //1.复制结点值和next
        //2.复制random
        //3.拆分链表
        if(pHead==null){
            return null;
        }
        RandomListNode cur=pHead;
        while(cur!=null){
            RandomListNode node=new RandomListNode(cur.label);
            node.next=cur.next;
            cur.next=node;
            cur=cur.next.next;
        }
        cur=pHead;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        RandomListNode newList=pHead.next;
        cur=pHead;
        while(cur!=null){
            RandomListNode node=cur.next;
            cur.next=node.next;
            if(node.next!=null){
                node.next=node.next.next;
            }
            cur=cur.next;
        }
        return newList;
    }
	
	public void print(RandomListNode pHead){
		RandomListNode cur=pHead;
		while(cur!=null){
			System.out.printf("（%s,%d(%s),%s）",cur.random,cur.label,cur,cur.next);
			cur=cur.next;
			System.out.println();
		}
		System.out.println();
	}
}
public class LeetCode{
	public static void test(){
		RandomListNode n1=new RandomListNode(1);
		RandomListNode n2=new RandomListNode(2);
		RandomListNode n3=new RandomListNode(3);
		RandomListNode n4=new RandomListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n1.random=n2;
		n2.random=n1;
		n3.random=n3;
		RandomListNode m1=new Solution().Clone(n1);
		new Solution().print(n1);
		new Solution().print(m1);
	}
	public static void main(String[] args){
		test();
	}
}