package p4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkipList {
	private Node head;
	private Node tail;
	public static  int count = 0;
	public static int level= 0;
	public static int c = 1;
	public  int co = 1; 
	
public SkipList() {
		
		head = new Node(Integer.MIN_VALUE);
		tail = new Node(Integer.MAX_VALUE);
		
		head.setRight(tail);
		tail.setLeft(head);
	}
	
	public boolean search(Node l, int data) {
		Node current = l;
		count = 0;
		while (current != null) {
			
			while (current.right != null && current.right.data <= data ) {
				current = current.right;
				count ++;
				
			} 
			
			if (current.data == data) {
				
				return true;
				
			}
			
			current = current.down;
			
		}
		//count = 0;
		return false;
	}
	
	public boolean insert(int data) {
		
		Node current = this.head;
		
		List<Node> pointersToUpdate = new ArrayList<Node>();
		if (!search(current,data))
		{
		while (current != null) {
			while (current.right != null && current.right.data < data ) {
				current = current.right;
			}
			
			pointersToUpdate.add(current);
			current = current.down;
		}
		
		// insert after this node.
		level = 0;
		Node newNode = null;
		
		while (level == 0 || flipCoin()) {
			
			// now move up.
			if (newNode == null) {
				newNode = new Node(data);
			} else {
				newNode = new Node(newNode);
			}
			
			Node nodeToUpdate = null;
			
			if (pointersToUpdate.size() <= level) {
				createNewLayer();
				nodeToUpdate = this.head;
			} else {
				nodeToUpdate = pointersToUpdate.get(pointersToUpdate.size() - level - 1);
			}
			
			newNode.right = nodeToUpdate.right;
			newNode.left = nodeToUpdate;
			
			newNode.right.left = newNode;
			nodeToUpdate.right = newNode;
			
			level++;
		}
		
		return true;
	}
		else {
			return false;
		}
	}
	
	public boolean delete(int data) {
		
		Node current = this.head;
		if (search(current, data))
		{
		List<Node> pointersToUpdate = new ArrayList<Node>();
		
		while (current != null) {
			while (current.right != null && current.right.data < data ) {
				current = current.right;
			}
			
			if (current.right.data == data) {
				pointersToUpdate.add(current);
			}
			
			current = current.down;
		}
		
		for (int i = 0; i < pointersToUpdate.size(); i++) {
			
			Node nodeToUpdate = pointersToUpdate.get(i);
			
			Node nodeToDelete = nodeToUpdate.right;
			
			nodeToUpdate.right = nodeToDelete.right;
			nodeToDelete.right.left = nodeToUpdate;
			
			nodeToDelete.up = null;
			nodeToDelete.down = null;
		}
		
		return true;
	}
		else {
			return false;
		}
	}
	
	private void createNewLayer() {
		
		Node newHead = new Node(Integer.MIN_VALUE);
		Node newTail = new Node(Integer.MAX_VALUE);
		
		newHead.setRight(newTail);
		newTail.setLeft(newHead);
		
		this.head.up = newHead;
		newHead.down = this.head;
		this.head = newHead;
		
		this.tail.up = newTail;
		newTail.down = this.tail;
		this.tail = newTail;
		
	}
	
	private boolean flipCoin() {
		return Math.random() >= 0.5;
	}
	
	public void printAllLevel() {
		
		
		Node current = this.head;
		
		c= 1;
		while(current != null) {
			
			Node firstInLevel = current;
			firstInLevel = firstInLevel.right;
			System.out.print("Level " + c  + ": ");
			while (firstInLevel.right != null) {
				System.out.print(firstInLevel.data + " ");
				firstInLevel = firstInLevel.right;
			}
			c ++;
			
			current = current.down;
			System.out.println();
		}
		
		System.out.print("The number of layers is " + --c + "\n");
	}
    public void print_Specific_level(int num) {
		
		
		Node current = this.head;
		
		co = 1;
		while(current != null) {
			
			Node firstInLevel = current;
			firstInLevel = firstInLevel.right;
			if(co==num) {
				
				System.out.print("Level " + co  + ": ");
				while (firstInLevel.right != null) {
					System.out.print(firstInLevel.data + " ");
					firstInLevel = firstInLevel.right;
			}
			}
			co ++;
			//
			current = current.down;
		}
		System.out.println();
	}
	

	
	
	
	public static void main(String[] args) {
		SkipList list = new SkipList();
		boolean flag= true;
		System.out.println("Welcome to my skiplist ");
		System.out.println("what operations do you want to do in the skiplist");
		while (flag == true)
		{
		
		System.out.println("\n"
				+ "1- Insert a number\n"
				+ "2- search for a number\n"
				+ "3- delete a number\n"
				+ "4- print all the levels\n"
				+ "5- print specific level\n"
				+ "6- exit \n"
				+ "Enter you choice");
		Scanner in = new  Scanner(System.in);
		int n = in.nextInt();
		switch (n) {
		case 1:
			System.out.println("How many nodes do you want to insert ");
			int m = in.nextInt();
			System.out.println("Enter the numbers of nodes you want to insert ");
			for  (int i = 0 ; i<=m ; i++)
			{
			int s = in.nextInt();
			//list.insert(s);
			if (list.insert(s))
				 System.out.print("The number is insered \n");
		        else
		            System.out.println("the number is already in the list");
			}
			
			while (true)
			{
			System.out.println("1- print all levels and numbers of layers\n"
					+ "2- Back");
			int a = in.nextInt();
			if (a == 1)
				list.printAllLevel();
			else {
				break;
			}
			}
			break;
		case 2 :
			 System.out.println("Enter the number you want to search for ");
			 int s = in.nextInt();
			 if (list.search(list.head,s))
				 System.out.print("The number of shifts of number " + s +" to find the key is " +  count + "\n");
		        else
		            System.out.println("-1");
		     break;
		case 3 :
			while (true) {
			
			System.out.println("Enter the number you want to delete ");
			int d = in.nextInt();
			
			if (list.delete(d))
				 System.out.print("The number is found and deleted \n");
		        else
		            System.out.println("can't find the number");
			System.out.println("1- print all levels and numbers of layers\n"
					+ "2-Back ");
			
			int a1 = in.nextInt();
			if (a1 == 1)
				list.printAllLevel();
			
			else {
				break;
			}
			break;
		}
		    break;
		case 4 :
			list.printAllLevel();
		    break;
		case 5 :
			System.out.println("Enter the number of level you want to print");
			int l = in.nextInt();
			list.print_Specific_level(l);
		    break;
		case 6 :
			flag = false;
		    break;
		}
		
		}
		
		/*list.insert(2);
		list.insert(10);
		list.insert(15);
		list.insert(16);
		list.insert(31);
		list.insert(71);
		list.insert(86);
		list.insert(89);
		list.insert(91);
		list.insert(96);
		list.print_Specific_level(4);
		
		//list.search(list.head,16);
		
		System.out.print("The number of layers is " + c + "\n");
		if (list.search(list.head,86))
			 System.out.print("The number of shifts of " + "86" +" to find the key is " +  count + "\n");
	        else
	            System.out.println("-1");
		 if (list.search(list.head,16))
			 System.out.print("The number of shifts of " + "16" +" to find the key is " +  count + "\n");
	        else
	            System.out.println("-1");
		 if (list.search(list.head,100))
			 System.out.print("The number of shifts of " + "16" +" to find the key is " +  count + "\n");
	        else
	            System.out.println("-1");
		
		list.printAllLevel();
		//list.print();
		
		
		list.delete(1);
		
		//list.print();
		}*/
		
	
	}
	
	
public static class Node {
		
		private int data;
		
		private Node left;
		private Node right;
		private Node up;
		private Node down;
		
		public Node(int data) {
			this.data = data;
			
			this.left = null;
			this.right = null;
			this.up = null;
			this.down = null;
		}
		
		public Node(Node lowerLevelNode) {
			this.data = lowerLevelNode.data;
			
			this.left = null;
			this.right = null;
			this.up = null;
			this.down = lowerLevelNode;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
		
		public Node getUp() {
			return up;
		}
		
		public void setUp(Node up) {
			this.up = up;
		}
		
		public Node getDown() {
			return down;
		}
		
		public void setDown(Node down) {
			this.down = down;
		}
	}

}