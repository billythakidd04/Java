import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class datbase implements ActionListener
{                    
	JLabel lblEmpID = new JLabel("Employee ID");
	JLabel lblFname = new JLabel("First Name");
	JLabel lblLname = new JLabel("Last Name");
	JLabel lblPayRate = new JLabel("Pay Rate");
	JTextField txtEmpID = new JTextField("enter employee id");
	JTextField txtFname = new JTextField("enter first name");
	JTextField txtLname = new JTextField("enter last name");
	JTextField txtPayRate = new JTextField("enter pay rate");
	JButton btnadd = new JButton("Add");
	JButton btnmodify = new JButton("Modify");
	JButton btndelete = new JButton("Delete");
	JButton btnclear = new JButton("Clear");
	JButton btnclose = new JButton("Close");
	Statement statement;
	int i = 0;
	
	public static void loadDrivers() throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		JOptionPane.showMessageDialog(null, "Driver is loaded");
	}
	
	public  datbase() throws SQLException
	{
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/test");
		JOptionPane.showMessageDialog(null, "database connected");
		// create a statement
		statement = connect.createStatement();
		//execute statement
		ResultSet resultset;
		statement.executeUpdate("drop database Java_demo");
		statement.executeUpdate("create database Java_demo");
		statement.executeUpdate("use Java_demo");
		statement.executeUpdate("create table students (id integer primary key,Fname char(26),Lname char(26),VirtLib char(3))");
		statement.executeUpdate("insert into students values("+ i + ", " + " \"Jim\" " + ", " + " \"Scandale\" " + ", " + "  \"yes\" "  + ")" );
		statement.executeUpdate("insert into students values("+ ++i + ", " + " \"Pat\" " + ", " + " \"Hoey\" " + ", " + "  \"yes\" "  + ")" );
		statement.executeUpdate("insert into students values("+ ++i + ", " + " \"LoudMouth\" " + ", " + " \"Homo\" " + ", " + "  \"yes\" "  + ")" );
		statement.executeUpdate("insert into students values("+ ++i + ", " + " \"Carlos\" " + ", " + " \"Cintron\" " + ", " + "  \"yes\" "  + ")" );
		statement.executeUpdate("insert into students values("+ ++i + ", " + " \"Sara\" " + ", " + " \"Stillings\" " + ", " + "  \"yes\" "  + ")" );
		statement.executeUpdate("insert into students values("+ ++i + ", " + " \"Bill\" " + ", " + " \"Caffery\" " + ", " + "  \"no\" "  + ")" );
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		loadDrivers();
		datbase foo = new datbase();
		foo.makegui();
	}
	
	public void makegui()
	{
		gui gui = new gui();
		JFrame frame = new JFrame("Connect to database");
		gui.init(frame, 640, 480);
		JPanel txtPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		txtPanel.setLayout(new GridBagLayout());
		btnPanel.setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 0;
		txtPanel.add(lblEmpID,c);
		
		c.gridy = 1;
		txtPanel.add(lblFname,c);
		
		c.gridy = 2;
		txtPanel.add(lblLname,c);
		
		c.gridy = 3;
		txtPanel.add(lblPayRate,c);
		
		c.gridx = 1;
		c.gridy = 0;
		txtPanel.add(txtEmpID,c);
		
		c.gridy = 1;
		txtPanel.add(txtFname,c);
		
		c.gridy = 2;
		txtPanel.add(txtLname,c);
		
		c.gridy = 3;
		txtPanel.add(txtPayRate,c);
		
		c.gridx = 0;
		c.gridy = 0;
		btnPanel.add(btnadd,c);
		
		c.gridx = 1;
		btnPanel.add(btnmodify,c);
		
		c.gridx = 2;
		btnPanel.add(btndelete,c);
		
		c.gridx = 3;
		btnPanel.add(btnclear,c);
		
		c.gridx = 4;
		btnPanel.add(btnclose,c);
		
			
		gui.addPanel2Frame(txtPanel, frame, BorderLayout.NORTH);
		gui.addPanel2Frame(btnPanel, frame, BorderLayout.SOUTH);
		frame.pack();
		
		btnclear.addActionListener(this);
		btnclose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnadd)
		{
			String Fname = txtFname.getText();
			Fname = "\"" + Fname + "\"";
			String Lname = txtLname.getText();
			Lname = "\"" + Lname + "\"";
			try 
			{
				statement.executeUpdate("insert into students values(" + ++i + ", " + txtFname + ", " + Lname + ", " + "  \"yes\" "  + ")" );
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}	
		}
		else if (e.getSource() == btnclear)
		{
			txtEmpID.setText("");
			txtFname.setText("");
			txtLname.setText("");
			txtPayRate.setText("");
		}
		else if (e.getSource()==btnclose)
		{
			JOptionPane.showMessageDialog(null, "You're exiting!!");
			System.exit(0);
		}
	}

}