package hackerrank;

import java.util.Scanner;

import practicePrograms.DoublyLinkedList;

public class TestDLL {
	public static void main(String[] args) {
		
		 Scanner scan = new Scanner(System.in);
		 DoublyLinkedList list = new DoublyLinkedList();
		 
		 /*System.out.println("Linked List Test");
        System.out.println("Enter the size of List to be created");
        int n = scan.nextInt();
		
        linkedList = new int[n];
		
        for(int i = 0; i < linkedList.length; i++){
       	 System.out.println("Enter element " + (i + 1));
       	 int ele = scan.nextInt();
       	 Node node = new Node(ele);
       	 linkedList[i] = node.getData();
        }*/
		 
		
		char ch;
		do{
			System.out.println("===================");
           System.out.println("Linked List Operations");
           System.out.println("1. Insert");
           System.out.println("2. Delete");
           System.out.println("3. Search");
           System.out.println("4. Check empty");
           System.out.println("5. Check full");
           System.out.println("6. Size");
           System.out.println("7. Exit");
           System.out.println("===================");
           int choice = scan.nextInt();
           
           switch(choice){
	            case 1: 
	            	System.out.println("Enter an element to insert");
		            	try{
		            		list.insert(scan.nextInt());
		            	} catch(Exception e){
		            		System.out.println(e.getMessage());
		            	}break;
	            case 2: 
	            	System.out.println("Enter an element to delete");
		            	try{
		            		//insert(scan.nextInt());
		            	} catch(Exception e){
		            		System.out.println(e.getMessage());
		            	}break;
	            case 3: 
	            	System.out.println("Enter an element to search");
		            	try{
		            		//insert(scan.nextInt());
		            	} catch(Exception e){
		            		System.out.println(e.getMessage());
		            	}break;
	            case 4:
	            	try{
	            			System.out.print("Empty status: " + list.isEmpty());
		            	} catch(Exception e){
		            		System.out.println(e.getMessage());
		            	}break;
		        default:
		        	System.out.println("Wrong Entry \n ");
	                break;
           }
           //list.display();            
           System.out.println("\nDo you want to continue (Type y or n) \n");
           ch = scan.next().charAt(0);
			
		} while(ch == 'Y' || ch == 'y');
	}
}
