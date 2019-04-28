 //Authors: Gianna Ritzko & Andrew Buxton
/**
 * This class implements a digits-only entry method for our
 * cellphone keypad.  When keys are pressed, we need to
 * display their numeric value instead of cycling through
 * possible letter values.
 * @author Brad Richards
 * @version 2009.9.13
 */

public class Digits implements PhoneInterface {

private int presses = 0;  // Counter for total number of presses
   /**
    * Accessor for returning the total number of presses.
    * @return Total number of presses
    */
   public int getNumPresses() { return presses; }

   /**
    * This method is invoked by the keypad whenever a key is
    * pressed.  It's passed the entire contents of the display
    * along with the number of the pressed key.  We just tack
    * a new character onto the display's text and return the
    * new string.
    * @param txt  The text entered by the keypad so far
    * @param key  The number of the key that's been pressed
    * @param return  Updated text for the display
    */
   public String append(String txt, int key) {
      presses++;
      if (key > 9)
         return txt;        // No contribution from * or # keys
      else
         return txt + key;  // Append new digit to existing display
   }//append
}//class