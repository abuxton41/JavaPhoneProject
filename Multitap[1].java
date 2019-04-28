 //Authors: Andrew Buxton
public class Multitap implements PhoneInterface   {
		   protected String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","","  ","  "};
           private int lastKey=-1;
           private boolean isStar=false;
           private boolean newLetter=false;

           /**
            * This method returns the desired letter.
            * @param key Integer that keeps track of which button was pressed to determine which of the strings in keys will be used
            * @param pos Integer that keeps track of which position the desired character is located at in the string
            * @return Returns the most recent value for the character to display
            */

            public String getLetter(int key, int pos){
            	lastKey=key;
                  String prevLetter = keys[key].substring(pos, pos + 1);
                  if(isStar){
                	  prevLetter=prevLetter.toUpperCase();
                	  isStar=false;
                  }//if
                  return prevLetter;
            }//getLetter

            /**
             * append takes in a string and key and returns the text that needs to be displayed
             * @param txt String that stores the characters that need to be displayed on the screen
             * @param key Integer that takes in the button pressed by the user
             */

            public String append(String txt, int key) {
                if(key<0 || key>12){
                	throw new IllegalArgumentException("invalid key: value must be between 0 and 12, value passed was "+ key);
                }//if
            	int index=0;
                  String element = keys[key];
                  if(key==10){
                  	isStar=!isStar;
                  	return txt;
                  }//if
                  else if(txt.length()>0){
                        if(element.length()> 2){
                        	int presses=element.indexOf(txt.toLowerCase().charAt(txt.length()-1));
                        	if(newLetter){
                        		presses=-1;
                        	}//if
                        	if(presses<0){
                        		newLetter = false;
                        		return txt+getLetter(key,0);
                        	}//if
                        	else{
	                        	presses=(presses+1)%element.length();
	                        	if(newLetter){
	                        		presses=-1;
	                        	}//if
	                        	if(txt.toUpperCase().charAt(txt.length()-1)==txt.charAt(txt.length()-1)){
	                        		isStar=true;
	                        	}//if
	                        	newLetter = false;
	                            return txt.substring(0,txt.length()-1)+getLetter(key,presses);
                        	}//else
                        }//if
                       else if(element.length() == 0){
                              lastKey = -1;
                              newLetter = true;
                              return txt;
                        }//if

                  }else{
                	  	if(element.length()==0) {
                	  		return "";
                	  	}//if
                        return getLetter(key,index);
                  }//else
                  return txt + getLetter(key,index);
            }//append

            /**
             * getNumPresses resets the presses
             * @return returns 0 to reset value
             */

            public int getNumPresses() {
                  return 0;
            }//getNumPresses
}//class
