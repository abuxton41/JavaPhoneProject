 //Authors: Gianna Ritzko & Andrew Buxton
/**
 * This test class creates a new keypad that uses an instance of
 * the Digits class to map key presses to characters (digits).
 * @author Brad Richards
 * @version 2009.9.13
 */
import java.util.Scanner;
public class TestKeypad{
	public static void main(String[] args) {
		 String firstMsg="Choose type of input method: multitap, reordered, or digits";
		 System.out.println(firstMsg);
	  	 Scanner readIn= new Scanner(System.in);
	  	 String sentence= readIn.nextLine();
	  	 while(sentence != null){
	  		if (sentence.toString().toLowerCase().equals("multitap"))
	  		{
	  			Keypad tk0 = new Keypad(new Multitap(), "multitap");
	  			sentence=null;
	  		}//if
	  		else if (sentence.toString().toLowerCase().equals("reordered"))
	  		{
	  			Keypad tk1 = new Keypad(new ReorderedMultitap(), "reordered");
	  			sentence=null;
	  		}//if
	  		else if (sentence.toString().toLowerCase().equals("digits"))
	  		{
	  			Keypad tk2 = new Keypad(new Digits(), "Digits");
	  			sentence=null;
	  		}//if
	  		else{
	  			System.out.println("invalid choice for input "+firstMsg);
	  			sentence= readIn.nextLine();
	  		}//else
	  	 }//while
	}//main
}//class
