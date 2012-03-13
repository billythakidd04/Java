import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BlackJack extends Applet 
{
	protected void makeLabel(String name,JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column, int row)
	{//create label method
		JLabel label = new JLabel(name);		
		gridbag.setConstraints(label, c);
		c.gridy = row;
		c.gridx = column;
		panel.add(label,c);
	}
	
	protected void makeTextfield (String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column,int row)
	{// TextField method
		TextField textfield = new TextField(name);		
		gridbag.setConstraints(textfield, c);
		c.gridy = row;
		c.gridx= column;
		panel.add(textfield,c);
	}
	protected void makeButton(String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int row, int column) 
	{   // create button method
		Button button = new Button(name);
        gridbag.setConstraints(button, c);
        c.gridx = column;
        c.gridy = row;
        panel.add(button,c);
	}
	
	public void init(JFrame frame)  
	{
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout gridbag = new GridBagLayout();
		JPanel cards = new JPanel();
		JPanel bet = new JPanel();
		
		cards.setLayout(gridbag);
		cards.setLayout(gridbag);
	   
		makeLabel("Dealer's Cards", cards, gridbag,c,1,1);

		makeTextfield("card1",cards,gridbag,c,1,2);
		makeTextfield("card2",cards,gridbag,c,2,2);
		makeTextfield("card3",cards,gridbag,c,3,2);
		makeTextfield("card4",cards,gridbag,c,4,2);
		makeTextfield("card5",cards,gridbag,c,5,2);
		
        makeButton("HIT ME",bet,gridbag,c,3,1);
        
		makeLabel("Your Hand",cards,gridbag,c,1,3);
		
		makeTextfield("card1",cards,gridbag,c,1,4);
		makeTextfield("card2",cards,gridbag,c,2,4);
		makeTextfield("card3",cards,gridbag,c,3,4);
		makeTextfield("card4",cards,gridbag,c,4,4);
		makeTextfield("card5",cards,gridbag,c,5,4);
		
        makeButton("Place Bet ",bet,gridbag,c,3,5);
        makeTextfield("bet amount",bet,gridbag,c,4,3);
        
        frame.add(cards,BorderLayout.NORTH);
        
        frame.add(bet,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) 
	{// setting up frame
		BlackJack START = new BlackJack();
		JFrame frame = new JFrame ("BlackJack");
		
		START.init(frame);  // run frame guts
		
		frame.setLocationRelativeTo(null);			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
