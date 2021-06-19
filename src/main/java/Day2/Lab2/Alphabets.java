package Day2.Lab2;

import java.util.Scanner;

public class Alphabets {  
    public static void main(String[] args) {  
        
        System.out.print("Enter the first input:");  
        Scanner word = new Scanner(System.in);  
        char[] value = word.nextLine().toCharArray();  
        for (char c : value) { 
            AlphaTest isLetter = (x) -> Character.isLetter(c);
            if (isLetter.test(c)) {
                System.out.println("The character '" + c + "' is a letter. ");
            } else {  
                System.out.println("The character '" + c + "' is not a letter."); 
            }
         
        }    
    }  
}  