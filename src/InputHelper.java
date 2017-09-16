//	Alicia Zhong
//	ITP 368, Fall 2017
//	Assignment 03
//	azhong@usc.edu

import java.util.Scanner;

public class InputHelper {

	
	public static int readIntBetween(String prompt, int minInc, int maxInc) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		
		while(!isValid){
			System.out.println(prompt);
			if(sc.hasNextInt()){
				num = sc.nextInt();
				if(num >= minInc && num <= maxInc){
					isValid = true;
				}
				else{
					System.out.println("Number must be greater than " + minInc + " and less than " + maxInc);
					isValid = false;
				}
			}
			else{
				String garbage = sc.nextLine(); //clear the non-int away
				System.out.println(garbage + " wasn't recongized as an int.\n" + prompt);
			
			}
		}
	
		return num;
	}
	
	public static int readPositiveInt(String prompt) {
		return readIntBetween(prompt, 0, Integer.MAX_VALUE);
	}

	
	
	public static String readString(String promptToPrint) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(promptToPrint);
		String s = sc.nextLine();
		return s;
		
		
	}

	public static boolean readBoolean(String question) {
		 Scanner sc = new Scanner(System.in);
	        boolean isYes = true;

	        //make a variable to help figure out if the input from user is good
	        boolean isGoodInput = false; // assume NOT good to start
	        while(!isGoodInput){
	            System.out.println(question); 
	            String userAnswer = sc.next(); //want this to be yes or no

	            if(userAnswer.startsWith("y") || userAnswer.startsWith("Y")){
	                isYes = true;
	                isGoodInput = true;
	            }
	            else if(userAnswer.startsWith("n") || userAnswer.startsWith("N")){
	                isYes = false;
	                isGoodInput = true;
	            }
	            else{
	                // ask again b/c they entered wrong
	                System.out.println("ERROR: didn't recognize " + userAnswer + " as yes or no");
	                isGoodInput = false; // not needed here, but ok put
	            }
	        }
	  
	        return isYes;
	}
}
