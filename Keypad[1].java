import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//Authors: Andrew Buxton
/**
 * The Keypad class models a cellphone keypad and display.
 *
 * @author Brad Richards
 * @version 2009.9.13
 */

public class Keypad implements ActionListener {
   JPanel displayPanel; // The panel that holds the display
   JTextArea display;   // The text display
   JFrame frame;        // The frame that holds the display and key panels
   JButton[] buttons;   // All of the buttons
   PhoneInterface method;       // The converter object that maps keys to letters
   String title;        // Allow all methods to access window's title
   /**
    * Handle button press events
    * @param e  The event to be handled
    */
   public void actionPerformed(ActionEvent e) {
	   int i;
      for(i=0; i<buttons.length; i++)      // Search through array of buttons
         if (e.getSource() == buttons[i])  // for the one that was pressed
            break;
      String oldText = display.getText();
     String newText = method.append(oldText, i);
      display.setText(newText);
      System.out.println(title+": "+
         (double)method.getNumPresses()/newText.length()+" presses/char");
      frame.setVisible(true);
   }

   /**
    * The constructor takes an object that handles key presses, and a
    * String to use as the title of the window.  It builds and displays
    * the keypad, registering this object as the one to be notified
    * when a button is pressed.
    * @param method  An object that interprets key presses
    * @param title   A string to use as the window's title
    */
   public Keypad(PhoneInterface method, String title) {
      this.method = method;
      this.title = title;

      // There are 12 buttons -- 0..9, * and #.
      buttons = new JButton[12];

      // Build the frame holding the keypad components
      frame = new JFrame(title);
      frame.setBackground(Color.LIGHT_GRAY);
      frame.setSize(300,400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());

      // Display is in a separate panel -- the NORTH panel of border layout
      display = new JTextArea(3, 20);
      display.setEditable(false);
      display.setLineWrap(true);
      display.setWrapStyleWord(true);
      displayPanel = new JPanel();
      displayPanel.add(display);

      // There's a panel in the CENTER of the layout holding all of the
      // digit keys.
      JPanel keypad = new JPanel();
      keypad.setLayout(new GridLayout(4,0));

      // Create all of the buttons and register this object as listener
      // for each.
      buttons[0] = new JButton("0 <next>");
      buttons[1] = new JButton("1");
      buttons[2] = new JButton("2 abc");
      buttons[3] = new JButton("3 def");
      buttons[4] = new JButton("4 ghi");
      buttons[5] = new JButton("5 jkl");
      buttons[6] = new JButton("6 mno");
      buttons[7] = new JButton("7 pqrs");
      buttons[8] = new JButton("8 tuv");
      buttons[9] = new JButton("9 wxyz");
      buttons[10] = new JButton("* <shift>");
      buttons[11] = new JButton("# <space>");
      for(int i=0; i<buttons.length; i++)
         buttons[i].addActionListener(this);

      // Add buttons to the panel in specific order.  The loop adds
      // 1..10, then we want 0, and finally the space key (11).
      for(int i=1; i<=10; i++)
         keypad.add(buttons[i]);
      keypad.add(buttons[0]);
      keypad.add(buttons[11]);

      // Add the display and digits panels to the frame
      frame.add(displayPanel, BorderLayout.NORTH);
      frame.add(keypad, BorderLayout.CENTER);
      frame.setVisible(true);
   }//Keypad
}//class
