 import java.awt.*;
 import java.applet.Applet;

 public class flowlayout extends Applet
 {
     Button button1, button2, button3, button4, button5;
     public void init() 
     {
         button1 = new Button("adds");
         button2 = new Button("buttons");
         button3 = new Button("in this order");
         button4 = new Button("puts a fourth button here as default");
         button5 = new Button ("auto adjusts to the size of the text");
         add(button1);
         add(button2);
         add(button3);
         add(button4);
         add(button5);
     }
 }
 