package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UI_Stack {
	private static Scanner input;
	public static void main (String[] args) {
		stack s = new stack();
		while(true) {
		
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1 - Push");
		System.out.println("2 - Pop");
		System.out.println("3 - Peek");
		System.out.println("4 - Get size");
		System.out.println("5 - Check if empty");
		System.out.println("6 - Close the program");		
		System.out.println("====================================================================");
/////////////////////////////////////////////////////////////////////////////////////////////////////////
				
			try {
		input = new Scanner(System.in);
		int number = input.nextInt();
		
		switch (number) {
		
		case 1 : System.out.println("Push element in the stack");
			     String a = input.next();
			     try {
			    	 s.push(a);
			     }
		         catch (RuntimeException e) {
		        	 System.out.println("Null object is passed");
		         }
		         break;
		        
		case 2 : try {
			     System.out.println(s.pop());
		       }
		       catch(EmptyStackException e) {
		    	   System.out.println("The stack is empty");
		       }
		         break;
		         
		case 3 : try {
		     System.out.println(s.peek());
	       }
	       catch(EmptyStackException e) {
	    	   System.out.println("The stack is empty");
	       }
	         break;
				 
		case 4 : System.out.println(s.size());
			     break;
			      
		case 5 : System.out.println(s.isEmpty());
		         break;
			
		case 6 : break;
		
		default : System.out.println("Enter a number from 1 to 6"); break;
		} 
		if(number == 6) {
			break;
		}
		}
			catch(InputMismatchException e) {
				System.out.println("Enter a number from 1 to 8");
				
			}
		}	
	}
}