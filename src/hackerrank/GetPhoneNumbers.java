package hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GetPhoneNumbers {
	 private static Map telephoenDir = new HashMap<String, Integer>();
	 private static String[] names = new String[4];
	    
	   public static void main(String []argh)
	   {
	      Scanner in = new Scanner(System.in);
	      int n=in.nextInt();
	      in.nextLine();
	      for(int i=0;i<n;i++)
	      {
	         String name=in.nextLine();
	         int phone=in.nextInt();
	         in.nextLine();
	         telephoenDir.put(name, phone);
	      }
	      int i = 0;
	      while(i <= 3)
	      {
	         String s=in.nextLine();
	         names[i] = s;
	         i++;
	      }
	      
	      for(int j = 0;j < names.length;j++)
	      {
	    	  System.out.println(names[j]);
	      }
	      
	      for(int j = 0;j < names.length;j++)
	      {
	    	  lookupPhoneNo(names[j]);
	      }
	   }
	   
	   public static void lookupPhoneNo(String name){
		   int phone;
		   Set telephoneKeys = telephoenDir.keySet();
		   
		   if(!telephoenDir.containsKey(name)){
			   System.out.println("Not found");
		   }
		   
		   Iterator<String> telephoneIterator = telephoneKeys.iterator();
		   while(telephoneIterator.hasNext()){
			   String personName = telephoneIterator.next();
			   if(name.equalsIgnoreCase(personName)){
				  phone = (Integer)telephoenDir.get(name);
				  System.out.println(name + " : " + phone);
			   }
		   }
	   }
}

