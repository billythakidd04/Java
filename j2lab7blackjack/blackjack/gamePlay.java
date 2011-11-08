import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
//import javax.swing.JTable;


public class gamePlay extends Thread
{
	int DhandTotal = 0;
	int PhandTotal = 0;
	String player;
	BlackJack game;
	shoe deck;
	int bank = 10000;
	int bet;
	Statement statement;
	ResultSet resultset;
	String temp;
	public gamePlay(BlackJack Game, String name/*int Bank*/)
	{
		player = name;
		try
		{
			loadDrivers();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		game = Game;
		try 
		{
			resultset = statement.executeQuery("select * from players where playerName = \""+name+"\";");
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "there was an issue with querying the database for your name");
		}
		catch (NullPointerException e)
		{
		JOptionPane.showMessageDialog(null, "there was a null pointer issue with querying the database for your name");
		}
		
		try 
		{
			if (!resultset.next())
			{
				bank = Integer.parseInt((JOptionPane.showInputDialog(null, "How much money would you like to start with?")));
				statement.executeUpdate(
						"insert into players(" +
							"playerName, wins, losses, bank)values(\""+name+"\", 0,0,\""+bank+"\");");
			}
			else
			{
				if(resultset.getString("playerName").equalsIgnoreCase(name))
				{
					bank = resultset.getInt("bank");
				}
			}
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch (HeadlessException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//bank = Bank;
		deck = new shoe();
		this.start();
	}
	
	public boolean takeBets()
	{
		boolean goodBet = true;
		String temp = game.betAmt.getText();
		try
		{
			bet = Integer.parseInt(temp);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please enter a correct amount to bet");
			goodBet = false;
		}
		bank -= bet;
		return goodBet;
	}
	
	public void deal()
	{
		game.p1.setText(deck.getcard());
		PhandTotal = cardValue(game.p1.getText(),PhandTotal);
		game.d1.setText(deck.getcard());
		DhandTotal = cardValue(game.d1.getText(),DhandTotal);
		game.p2.setText(deck.getcard());
		PhandTotal += cardValue(game.p2.getText(),PhandTotal);
		game.d2.setText(deck.getcard());
		DhandTotal += cardValue(game.d2.getText(),DhandTotal);
		game.d2.setVisible(false);
	}
	
	public String dealCard()
	{
		String card = deck.getcard();
		PhandTotal += cardValue(card,PhandTotal);
		return card;
	}
	
	public int hit()
	{
		int slot=0;
		if(game.p3.getText().charAt(0)=='c')
		{
			slot = 3;
		}
		else if(game.p4.getText().charAt(0)=='c')
		{
			slot = 4;
		}
		else if(game.p5.getText().charAt(0)=='c')
		{
			slot = 5;
		}
		return slot;
	}
	
	public int dealerRun()
	{
		while (DhandTotal < 17)
		{
			String card = dealCard();
			switch (hit())
			{
			case 3:
				game.d3.setText(card);
				break;
			case 4:
				game.d4.setText(card);
				break;
			case 5:
				game.d5.setText(card);
				break;	
			}
			DhandTotal += cardValue(card,DhandTotal);
			game.Dhand.setText(Integer.toString(DhandTotal));
		}
		return DhandTotal;
	}
	
	public int cardValue(String card, int handTotal)
	{
		int val = 0;
		switch(card.charAt(0))
		{
		case 'A':
			if(handTotal > 10)
			{
				val = 1;
			}
			else
			{
				val = 11;
			}
			break;
		case '2':
			val = 2;
			break;
		case '3':
			val = 3;
			break;
		case '4':
			val = 4;
			break;
		case '5':
			val = 5;
			break;
		case '6':
			val = 6;
			break;
		case '7':
			val = 7;
			break;
		case '8':
			val = 8;
			break;
		case '9':
			val = 9;
			break;
		case '1':
			val = 10;
			break;
		case 'J':
			val = 10;
			break;
		case 'Q':
			val = 10;
			break;
		case 'K':
			val = 10;
			break;
		}
		return val;
	}
	
	public boolean checkHand(int handTotal)
	{
		boolean good = true;
		if (handTotal > 21)
		{
			good = false;
		}
		return good;
	}
	
	public void playerWon()
	{
		int wins = 0;
		bank += (bet * 2);
		game.bank.setText(Integer.toString(bank));
		try 
		{
			resultset = statement.executeQuery("select * from players where playerName =\""+player+"\";");
			resultset.next();
			wins = resultset.getInt("wins");
			++wins;
			statement.executeUpdate("update players set bank ="+bank+" where playerName =\""+player+"\";");
			statement.executeUpdate("update players set wins ="+wins+" where playerName =\""+player+"\";");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "error setting bank to database");
		}
		game.newbtn.setEnabled(true);
	}
	
	public void playerLost()
	{
		int loss = 0;
		try 
		{
			resultset = statement.executeQuery("select * from players where playerName =\""+player+"\";");
			resultset.next();
			loss = resultset.getInt("losses");
			++loss;
			statement.executeUpdate("update players set bank ="+bank+" where playerName =\""+player+"\";");
			statement.executeUpdate("update players set losses ="+loss+" where playerName =\""+player+"\";");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "error setting bank to database");
		}
		game.newbtn.setEnabled(true);
	}
	
	public int getPhand()
	{
		return PhandTotal;
	}
	
	public int getDhand()
	{
		return DhandTotal;
	}
	
	public int getBank()
	{
		return bank;
	}
	public  void loadDrivers() throws Exception
	{
		try{
			Class.forName("com/mysql/jdbc/Driver");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Driver is loaded");
		try 
		{
			database();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public  gamePlay()
	{
		
	}
	public void database() throws SQLException
	{
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/records","root","");
		//JOptionPane.showMessageDialog(null, "database connected");
		// create a statement
		statement = connect.createStatement();
		//execute statement
		statement.executeUpdate("create database if not exists records;");
		statement.executeUpdate("use records");
		statement.executeUpdate("create table if not exists players (playerName char(20), wins int(3), losses int(3), bank int(7));");
		
	}
	public void ShowScores()
	{
		try
		{
			statement.executeUpdate("use records");
		    resultset = statement.executeQuery("select * from players ORDER BY wins DESC"); 
		    
			//while (resultset.next()!= null)
		    {
		    //	temp += resultset.getString(player)+ "\n";
		    }
		    //JTable.setText(temp);
		} 
		catch (SQLException e) 
		{
			//System.out.println("Error code = " + e.getErrorCode());
			//System.out.println("SQL State = " + e.getSQLState());
			System.out.println("SQL msg = " + e.getMessage());
			JOptionPane.showMessageDialog(null, "records not found");
		}
	}
}
