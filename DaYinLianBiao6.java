package jianzhioffer;

import java.util.Stack;

/*从尾到头打印链表：
 * 考虑用栈的思想实现链表*/
public class DaYinLianBiao6 {
	public static void main(String[] args) {
	ListNode a=new ListNode();	
	ListNode b=new ListNode();	
	ListNode c=new ListNode();
	a.next=b;
	b.next=c;
	a.value=1;
	b.value=2;
	c.value=3;
	fanzhuan(a);
	}
	static void fanzhuan(ListNode x) {
		Stack<ListNode> temp=new Stack<ListNode>();
		while(x!=null) {
			temp.push(x);
			x=x.next;
		}
		while(!temp.isEmpty()) {
			System.out.println(temp.pop().value);
		}
		
	}
}
class ListNode{
	//首先定义链表
	ListNode next;
	int value;
}

