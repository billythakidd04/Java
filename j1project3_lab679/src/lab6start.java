import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;



public class lab6start implements ActionListener
{
	JTextField custNameTxt;
	JTextField acctNumTxt;
	JTextField dateCreatedTxt;
	JButton checkingBtn;
	JButton savingsBtn;
	JTextField witAmountTxt;
	JButton withDrawBtn;
	JTextField depAmountTxt;
	JButton depositBtn;
	
	lab6start()
	{
		JFrame bankTeller = new JFrame("Welcome to Suchnsuch Bank");
		bankTeller.setSize(500, 280);
		bankTeller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bankTeller.setResizable(false);
		bankTeller.setLayout(new GridBagLayout());
		
		bankTeller.setBackground(Color.gray);
		
		//bankTeller.getContentPane().add(everything, BorderLayout.CENTER);
		
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel acctInfo = new JPanel(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.insets = new Insets(5,5,5,5);
		bankTeller.add(acctInfo, c);
		c.gridwidth = 1;
		
		//labels
		c.anchor = GridBagConstraints.WEST;
		c.ipadx = 1;
		//c.fill = GridBagConstraints.NONE;
		//name acct# balance interestRate dateCreated
		JLabel custNameLbl = new JLabel("Name");
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(custNameLbl, c);
		
		custNameTxt = new JTextField("customer name");
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(custNameTxt,c);
		custNameTxt.requestFocusInWindow();
		
		JLabel acctNumLbl = new JLabel("Account Number");
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(acctNumLbl,c);
		
		acctNumTxt = new JTextField("account number");
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(acctNumTxt,c);
		
		JLabel dateCreatedLbl = new JLabel("Date Created");
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(dateCreatedLbl,c);
		
		dateCreatedTxt = new JTextField("date created");
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(dateCreatedTxt,c);
				
		//buttons
		checkingBtn = new JButton("Checking");
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(checkingBtn,c);

		savingsBtn = new JButton("Savings");
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(5,5,5,5);
		acctInfo.add(savingsBtn,c);
		
//end of info panel
		
		JPanel withDraw = new JPanel(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5,5,5,5);
		bankTeller.add(withDraw, c);
		
		witAmountTxt = new JTextField("Amount to Withdraw:");
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		withDraw.add(witAmountTxt,c);
		
		withDrawBtn = new JButton("Withdraw");
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		withDraw.add(withDrawBtn,c);
		
		//add check balance
		
//end of withdraw panel
		
		JPanel deposit = new JPanel(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5,5,5,5);
		bankTeller.add(deposit, c);
		
		depAmountTxt = new JTextField("Amount to Deposit");
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		deposit.add(depAmountTxt,c);
		
		depositBtn = new JButton("Deposit");
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		deposit.add(depositBtn,c);		
		
		bankTeller.pack();
		bankTeller.setVisible(true);
		
		// action/event 
		checkingBtn.addActionListener(this);
		savingsBtn.addActionListener(this);
		withDrawBtn.addActionListener(this);
		depositBtn.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()== checkingBtn)
		{
			String cxName = custNameTxt.getText();
			String acctNum = acctNumTxt.getText();
			String dateCreated = dateCreatedTxt.getText();
			//java.util.Date.
			//checkInput(cxName, acctNum, null);
			witAmountTxt.requestFocusInWindow();
			//checking newCheckAcct = new checking();
		}
		
	}
	
	private void checkInput(String cxName, String acctNum, java.util.Date date)
	{
		
	}
}


/*
		String accountType = null;
		accountType = JOptionPane.showInputDialog(null, "Checking or Savings?");
		
		if (accountType.equalsIgnoreCase("checking"))
		{
			checking c_Account = new checking();
		}
		else if (accountType.equalsIgnoreCase("savings"))
		{
		//	savings s_Account = new savings();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Selection");
		}
		
	*/