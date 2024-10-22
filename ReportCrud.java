package projectdb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReportCrud implements ActionListener,KeyListener
{
	JLabel l1;
	JFrame frm;
	JTable tab;
	Font fon1,fon2;
	JScrollPane sp;
	JButton b1;
	String[] head = {"Roll Number","Student Name","Mark 1","Mark 2","Mark 3","Mark 4","Mark 5","Total","Average","Result"};

	
	DefaultTableModel dtm = new DefaultTableModel(0,0);
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement st;
	Object[] row=new Object[10];
	
	
	public void getdata() {
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3308/projectdb","root","");
			 ps=con.prepareStatement("select * from Crud_student");
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				 row[0]=rs.getInt(1);
				 row[1]=rs.getString(2);
				 row[2]=rs.getInt(3);
				 row[3]=rs.getInt(4);
				 row[4]=rs.getInt(5);
				 row[5]=rs.getInt(6);
				 row[6]=rs.getInt(7);
				 row[7]=rs.getInt(8);
				 row[8]=rs.getDouble(9);
				 row[9]=rs.getString(10);
				 dtm.addRow(row);
				 
			 }
			 

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return;
	}
	public void setObj() {
		
		tab=new JTable();
		sp=new JScrollPane(tab);
		dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(head);
		tab.setModel(dtm);
		
		fon1=new Font("Bookman Old Style", Font.BOLD, 20);
		fon2=new Font("calibri", Font.BOLD, 16);
		tab.setFont(fon2);
		tab.getTableHeader().setFont(fon2);
		
		
		
		l1=new JLabel("REPORT");
		l1.setFont(fon1);
		
		
		b1=new JButton("Back");
		
		JFrame.isDefaultLookAndFeelDecorated();
		  frm=new JFrame("Report Crud Operation"); 
		  frm.setSize(800, 800);
		  frm.setLocationRelativeTo(frm);
		  frm.setResizable(false);
		  frm.setLayout(null);
		  frm.setDefaultCloseOperation(3);
		  frm.getContentPane().setBackground(Color.MAGENTA);
		frm.setVisible(true);
		
		l1.setBounds(350, 40, 150, 40);
		sp.setBounds(20, 100, 750, 400);
		b1.setBounds(350, 550, 100, 30);
		

		tab.getColumnModel().getColumn(1).setPreferredWidth(150);
		frm.add(l1);
		frm.add(sp);
		frm.add(b1);
		
		b1.addActionListener(this);
		frm.addKeyListener(this);
			
		
	}

	public static void main(String[] args) {
		ReportCrud rc= new ReportCrud();
		rc.setObj();
		rc.getdata();
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			int confirm = JOptionPane.showConfirmDialog(frm, "Are you sure you want to get back?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
			frm.dispose();
			Crud_Prg.main(null);
			b1.setEnabled(false);
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            
            frm.dispose(); 
            Crud_Prg.main(null); 
        }
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
