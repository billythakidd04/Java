import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BlackJack extends Thread implements ActionListener
{	
	JFrame 	frame;
	JTextField p1;
	JTextField p2;
	JTextField p3;
	JTextField p4;
	JTextField p5;
	JButton hit;
	JTextField d1;
	JTextField d2;
	JTextField d3;
	JTextField d4;
	JTextField d5;
	JButton betBtn;
	JTextField betAmt;
	JButton exitBtn;
	JButton newbtn;
	gamePlay game;
	JLabel bank;
	JButton stand;
	JLabel Dhand;
	JLabel Phand;
	JMenuBar menuBar;
	JMenu about;
	JMenuItem scores;
	JMenuItem aboutBox;
	JTable listbox;
	
	
	public BlackJack()
	{
		frame = new JFrame ("BlackJack");
		
		String temp = JOptionPane.showInputDialog(null, "Please enter your name?");
		game = new gamePlay(this, temp);
		this.init(frame);  // run frame guts

		//String temp = JOptionPane.showInputDialog(null, "How much money would you like to gamble with?");
		//int wallet = Integer.parseInt(temp);
		
		frame.setLocationRelativeTo(null);			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		this.start();
	}
	
	public void init(JFrame frame)  
	{
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout gridbag = new GridBagLayout();
		gui gui = new gui();
		JPanel cards = new JPanel();
		JPanel bet = new JPanel();
		
		cards.setLayout(gridbag);
		bet.setLayout(gridbag);
		
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		
		menuBar = new JMenuBar();
		about = new JMenu("About");
		scores = new JMenuItem("Score Sheet");
		aboutBox = new JMenuItem("About");
		
		about.add(scores);
		about.add(aboutBox);
		menuBar.add(about);
		
		c.gridx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		cards.add(menuBar,c);
		c.fill = GridBagConstraints.NONE;
	   
		gui.makeLabel("Dealer's Cards", cards, gridbag,c,1,1);
		Dhand = gui.makeLabel(Integer.toString(game.getDhand()), cards, gridbag, c, 2, 1);
		bank = gui.makeLabel("Bank: " + Integer.toString(game.getBank()), cards, gridbag, c, 5, 1);
        
		d1 = gui.makeTextfield("card1",cards,gridbag,c,1,2);
		d2 = gui.makeTextfield("card2",cards,gridbag,c,2,2);
		d3 = gui.makeTextfield("card3",cards,gridbag,c,3,2);
		d4 = gui.makeTextfield("card4",cards,gridbag,c,4,2);
		d5 = gui.makeTextfield("card5",cards,gridbag,c,5,2);
		
        
        
		gui.makeLabel("Your Hand",cards,gridbag,c,1,3);
		Phand = gui.makeLabel(Integer.toString(game.getPhand()), cards, gridbag, c, 2, 3);
		
		p1 = gui.makeTextfield("card1",cards,gridbag,c,1,4);
		p2 = gui.makeTextfield("card2",cards,gridbag,c,2,4);
		p3 = gui.makeTextfield("card3",cards,gridbag,c,3,4);
		p4 = gui.makeTextfield("card4",cards,gridbag,c,4,4);
		p5 = gui.makeTextfield("card5",cards,gridbag,c,5,4);
		
		
		betAmt = gui.makeTextfield("bet amount",bet,gridbag,c,1,0);
        betBtn = gui.makeButton("Place Bet ",bet,gridbag,c,1,1);
        hit = gui.makeButton("HIT ME",bet,gridbag,c,1,2);
        stand = gui.makeButton("Stand", bet, gridbag, c, 1, 3);
        exitBtn = gui.makeButton("exit", bet, gridbag, c, 1, 4);
        newbtn = gui.makeButton("New Game", bet, gridbag, c, 1, 5);
        
        hit.setEnabled(false);
        betAmt.setEditable(true);
        newbtn.setEnabled(false);
        
        frame.add(cards,BorderLayout.PAGE_START);
        
        frame.add(bet,BorderLayout.SOUTH);
        
        hit.addActionListener(this);
        betBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        stand.addActionListener(this);
        newbtn.addActionListener(this);
        aboutBox.addActionListener(this);
        scores.addActionListener(this);
	}
	
	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()== exitBtn)
		{
			System.exit(0);
		}
		else if (e.getSource()==betBtn)
		{
			if(game.takeBets())
			{
				bank.setText("Bank: " + Integer.toString(game.getBank()));
				game.deal();
				Phand.setText(Integer.toString(game.getPhand()));
				Dhand.setText(Integer.toString(game.getDhand()));
				Dhand.setVisible(false);
				betBtn.setEnabled(false);
				hit.setEnabled(true);
			}
		}
		else if (e.getSource()==scores )
		{
			JFrame aboutframe = new JFrame("scores");
			listbox = new JTable();
			aboutframe.setLocationRelativeTo(null);			
			aboutframe.setSize(300, 300);
			aboutframe.setVisible(true);
			aboutframe.add(listbox);
			game.ShowScores();
		}
		else if (e.getSource()== hit)
		{
			switch (game.hit())
			{
			case 3:
				p3.setText(game.dealCard());
				break;
			case 4:
				p4.setText(game.dealCard());
				break;
			case 5:
				p5.setText(game.dealCard());
				break;
			default:
				JOptionPane.showMessageDialog(null, "5 CARD CHARLIE!!!! YOU WIN!!!!");
				betBtn.setEnabled(false);
				hit.setEnabled(false);
				game.playerWon();
			}
			Phand.setText(Integer.toString(game.getPhand()));
			if (!game.checkHand(Integer.parseInt(Phand.getText())))
			{
				JOptionPane.showMessageDialog(null, "OOPS!! You're busted!!");
				hit.setEnabled(false);
				stand.setEnabled(false);
				betBtn.setEnabled(false);
				game.playerLost();
			}
		}
		else if (e.getSource()==stand)
		{
			d2.setVisible(true);
			Dhand.setVisible(true);
			int dealer = game.dealerRun();
			int player = Integer.parseInt(Phand.getText());
			if ((player > dealer)||(dealer > 21))
			{
				if(player < 22)
				{
					JOptionPane.showMessageDialog(null, "YOU WIN!!!!");
					hit.setEnabled(false);
					stand.setEnabled(false);
					betBtn.setEnabled(false);
					game.playerWon();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Sorry! House Wins");
				hit.setEnabled(false);
				stand.setEnabled(false);
				betBtn.setEnabled(false);				
				game.playerLost();
			}
		}
		else if (e.getSource()==newbtn)
		{
			new BlackJack();
			frame.dispose();
			this.stop();
		}
	}
	public static void main(String[] args) 
	{
		new BlackJack();	
	}
}
