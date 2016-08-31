package practicePrograms;

import java.util.Scanner;
import java.util.Stack;

public class DelimeterMatching {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a string");
		String str = scan.next();
		System.out.println(isValid(str));
	}
	
	public static boolean isValid(String inputStr){
		Stack stack = new Stack();
		
		char pushedChar;
		for(int i = 0; i < inputStr.length(); i++){
			pushedChar = inputStr.charAt(i);
			switch(pushedChar){
				case '[':
				case '{':
				case '(':
						stack.push(pushedChar);
						break;
				case ']':
				case '}':
				case ')':
						if(!stack.isEmpty()){
							char poppedChar = (char) stack.pop();
							if((pushedChar == ']' && poppedChar != '[') ||
									(pushedChar == '{' && poppedChar != '{') ||
									(pushedChar == ')' && poppedChar != '(')){
								System.out.println("Not balanced");
								return false;
							}
								
						} else{
							System.out.println("Not Balanced");
							return false;						
						}
				default:
						break;
					
			}
		}
		if ( !stack.isEmpty() ) {
			System.out.println("Not balanced");
			return false;
	    }
		System.out.println("Balanced");
		return true;
	}
}
