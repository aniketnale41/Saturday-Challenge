

/*Given a linked list, swap every two adjacent nodes
and return its head. You must solve the problem without
modifying the values in the list's nodes (i.e., only nodes
themselves may be changed.)
*/

import java.util.*;


class LinkedList {
	Node head;
	
	
	static class Node {
		int data;
		Node next;
		
		 Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void addFirst(int d) {
		Node new_Node = new Node(d);
		new_Node.next = head;
		head = new_Node;
	}
	
	
	
	
	
	
	
	public void display() {
		Node temp = head;
		if(temp == null) {
			System.out.println("Empty Linked List");
			return;
		}
		System.out.print("[");
		while(temp!=null) {
			System.out.print(temp.data);
			temp = temp.next;
			if(temp!=null) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		System.out.println();
	}
	
	
	
	
	
	public void swapTwo(int pos) {
		
		if(pos==0) {
			Node first = head;
			head = head.next;
			Node third = head.next;
			head.next = first;
			first.next = third;
		} else {
			Node temp = head;
			while(pos>1) {
				temp = temp.next;
				pos--;
			}//[2,1,3,4]
			
			Node forwardLink = temp.next.next.next;
			Node first = temp.next;
			Node second = temp.next.next;
			temp.next = second;
			temp.next.next = first;
			temp.next.next.next = forwardLink;
			
		}
	}


	
}

public class SwapChallenge {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();//input =  [1,2,3,4]
		
		
		if(str.length()<=2) {
			System.out.println("[]");
		} else if(str.length()==3) {
			System.out.println(str);
		}
		else {
			LinkedList ls = new LinkedList();
			String strArr[] = str.replace("[", "").replace("]", "").split(",");		
			for(int i=strArr.length-1;i>=0;i--) {
				ls.addFirst(Integer.parseInt(strArr[i]));
			}
			ls.display();
			for(int i=0;i<strArr.length-1;i=i+2) {
				ls.swapTwo(i);
			}
			ls.display();
			
		}
		

	}

}
