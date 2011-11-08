import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI 
{
	JFrame frame = null;
	public GUI()
	{
		frame = guiInit(frame);
		buildGUI();
	}
	
	private JFrame guiInit(JFrame frame)
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(800, 600);                              
		frame.setLocationRelativeTo(null);                    
		frame.setVisible(true);                               
		frame.setResizable(false);  
		frame.setLayout(new BorderLayout());
		
		return frame;
	}
	
	private void buildGUI()
	{
		JPanel cards = new JPanel();
		
		cards.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//DEALER CARDS SETUP
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		cards.add(new JLabel("Dealer's Cards"),c);
		
		JTextField d1 = new JTextField("dealers first card");
		c.gridx = 0;
		c.gridy = 1;
		cards.add(d1,c);
		
		JTextField d2 = new JTextField("dealers second card");
		c.gridx = 1;
		cards.add(d2,c);
		
		JTextField d3 = new JTextField("dealers third card");
		c.gridx = 2;
		cards.add(d3,c);
		
		JTextField d4 = new JTextField("dealers fourth card");
		c.gridx = 3;
		cards.add(d4,c);
		
		JTextField d5 = new JTextField("dealer's fifth card");
		c.gridx = 4;
		cards.add(d5,c);
		//PLAYER CARDS SETUP
		c.gridx = 0;
		c.gridy = 2;
		cards.add(new JLabel("Player's Cards"),c);
		
		JTextField p1 = new JTextField("player's first card");
		c.gridx = 0;
		c.gridy = 3;
		cards.add(p1,c);
		
		JTextField p2 = new JTextField("players second card");
		c.gridx = 1;
		cards.add(p2,c);
		
		JTextField p3 = new JTextField("dealers third card");
		c.gridx = 2;
		cards.add(p3,c);
		
		JTextField p4 = new JTextField("dealers fourth card");
		c.gridx = 3;
		cards.add(p4,c);
		
		JTextField p5 = new JTextField("dealers fifth card");
		c.gridx = 4;
		cards.add(p5,c);
		
		frame.add(cards,BorderLayout.NORTH);
		
		JPanel bet = new JPanel();
		bet.setLayout(new GridBagLayout());
		
		JLabel wallet = new JLabel("You currently have $"/*+cash*/);//will use cash in next lab
		c.gridx = 0;
		c.gridy = 0;
		bet.add(wallet,c);
		
		JLabel currentHand = new JLabel("your current hand is: "/*+strCurrentHand*/ +" hit or stand?");//strCurrentHand will be a string in the next lab
		c.gridy = 1;
		bet.add(currentHand,c);
		
		JButton hit = new JButton("Hit!");
		c.gridy = 2;
		bet.add(hit,c);
		
		JButton stand = new JButton("Stand!");
		c.gridx = 1;
		bet.add(stand,c);
		
		JLabel lblBetAmnt = new JLabel("Bet Amount:");
		c.gridx = 2;
		bet.add(lblBetAmnt,c);
		
		JTextField txtBetAmnt = new JTextField("enter amount");
		c.gridx = 3;
		bet.add(txtBetAmnt,c);
		
		JButton newGame = new JButton("New Game");
		c.gridx = 4;
		bet.add(newGame,c);
		
		frame.add(bet,BorderLayout.SOUTH);
		frame.pack();
	}
}
