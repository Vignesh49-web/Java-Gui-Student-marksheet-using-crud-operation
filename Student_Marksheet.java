package projectdb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class Student_Marksheet implements ActionListener,MouseListener,KeyListener
{
	JFrame frm;
	JLabel l1,rno,name,m1,m2,m3,m4,m5,tot,avg,res;
	JPanel p1,p2,p3;
	JTextField r,n,ma1,ma2,ma3,ma4,ma5,t,a,result;
	String operation;
	JButton b1,b2,b3,b4;
	Font fon1,fon2;
	SpringLayout sp;
	JTable tab;
	JScrollPane jsp;
	String[] head = {"Roll Number","Student Name","Mark 1","Mark 2","Mark 3","Mark 4","Mark 5","Total","Average","Result"};

	DefaultTableModel dtm = new DefaultTableModel(0,0);
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement st;
	Object[] row=new Object[10];
	
	public Student_Marksheet()
	{
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3308/projectdb","root","");
			  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
		public void getdata() {
		try
		{
			
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
		
	}
	

	
	public void setObj() {
		
		//SPRING LAYOUT
		sp=new SpringLayout();
		fon1=new Font("Bookman Old Style", Font.BOLD, 20);
		fon2=new Font("Calibri",Font.TYPE1_FONT,16);
		
		//TABLE
		tab=new JTable();
		jsp=new JScrollPane(tab);
		dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(head);
		tab.setModel(dtm);
		tab.setFont(fon2);
		tab.getTableHeader().setFont(fon2);
		jsp.setPreferredSize(new Dimension(900, 200));
		
		//LABELS
		l1=new JLabel("Shivashri Academy");
		l1.setFont(fon1);
		rno=new JLabel("Roll Number:");
		rno.setFont(fon2);
		name=new JLabel("Name:");
		name.setFont(fon2);
		m1=new JLabel("Mark 1:");
		m1.setFont(fon2);
		m2=new JLabel("Mark 2:");
		m2.setFont(fon2);
		m3=new JLabel("Mark 3:");
		m3.setFont(fon2);
		m4=new JLabel("Mark 4:");
		m4.setFont(fon2);
		m5=new JLabel("Mark 5:");
		m5.setFont(fon2);
		tot=new JLabel("Total Mark:");
		tot.setFont(fon2);
		avg=new JLabel("Average Mark:");
		avg.setFont(fon2);
		res=new JLabel("Result:");
		res.setFont(fon2);
		
		//TEXTFIELDS
		r=new JTextField(20);
		r.setFont(fon2);
		n=new JTextField(20);
		n.setFont(fon2);
		ma1=new JTextField(20);
		ma1.setFont(fon2);
		ma2=new JTextField(20);
		ma2.setFont(fon2);
		ma3=new JTextField(20);
		ma3.setFont(fon2);
		ma4=new JTextField(20);
		ma4.setFont(fon2);
		ma5=new JTextField(20);
		ma5.setFont(fon2);
		t=new JTextField(20);
		t.setFont(fon2);
		a=new JTextField(20);
		a.setFont(fon2);
		result=new JTextField(20);
		result.setFont(fon2);
		
		//BUTTONS
		b1=new JButton("New");
		b2=new JButton("update");
		b2.setEnabled(false);
		b3=new JButton("delete");
		b3.setEnabled(false);
		b4=new JButton("Exit");
		
		//FRAME		
		JFrame.isDefaultLookAndFeelDecorated();
		frm=new JFrame("Student Marksheet"); 
		  frm.setSize(1000, 900);
		  frm.setLayout(sp);
		  frm.setLocationRelativeTo(null);
		  frm.setDefaultCloseOperation(3);
		  frm.getContentPane().setBackground(Color.green);
		  frm.setVisible(true);
		  
		sp.putConstraint(SpringLayout.NORTH, l1, 10, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, l1, 400, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, rno, 80, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, rno, 80, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, r, 80, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, r, 175, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, name, 80, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.EAST, name, 570, SpringLayout.EAST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, n, 80, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.EAST, n, 840, SpringLayout.EAST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, m1, 150, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, m1, 350, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, ma1, 150, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, ma1, 410, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, m2, 200, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, m2, 350, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, ma2, 200, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, ma2, 410, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, m3, 250, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, m3, 350, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, ma3, 250, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, ma3, 410, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, m4, 300, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, m4, 350, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, ma4, 300, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, ma4, 410, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, m5, 350, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, m5, 350, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, ma5, 350, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, ma5, 410, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, tot, 400, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, tot, 85, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, t, 400, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, t, 170, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, avg, 400, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.EAST, avg, 570, SpringLayout.EAST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, a, 400, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.EAST, a, 840, SpringLayout.EAST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, res, 450, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, res, 365, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, result, 450, SpringLayout.NORTH, frm);
		sp.putConstraint(SpringLayout.WEST, result, 415, SpringLayout.WEST, frm);
		
		sp.putConstraint(SpringLayout.NORTH, jsp, 500, SpringLayout.NORTH, frm);
	    sp.putConstraint(SpringLayout.WEST, jsp, 40, SpringLayout.WEST, frm); 
	    
	    sp.putConstraint(SpringLayout.NORTH, b1, 720, SpringLayout.NORTH, frm);
	    sp.putConstraint(SpringLayout.WEST, b1, 150, SpringLayout.WEST, frm); 
	    
	    sp.putConstraint(SpringLayout.NORTH, b2, 720, SpringLayout.NORTH, frm);
	    sp.putConstraint(SpringLayout.WEST, b2, 350, SpringLayout.WEST, frm); 
	    
	    sp.putConstraint(SpringLayout.NORTH, b3, 720, SpringLayout.NORTH, frm);
	    sp.putConstraint(SpringLayout.WEST, b3, 550, SpringLayout.WEST, frm);
	    
	    sp.putConstraint(SpringLayout.NORTH, b4, 720, SpringLayout.NORTH, frm);
	    sp.putConstraint(SpringLayout.WEST, b4, 750, SpringLayout.WEST, frm);
	        
        frm.add(l1);
        frm.add(name);
		frm.add(rno);
		frm.add(m1);
		frm.add(m2);
		frm.add(m3);
		frm.add(m4);
		frm.add(m5);
		frm.add(tot);
		frm.add(avg);
		frm.add(res);
		frm.add(r);
		frm.add(n);
		frm.add(ma1);
		frm.add(ma2);
		frm.add(ma3);
		frm.add(ma4);
		frm.add(ma5);
		frm.add(t);
		frm.add(a);
		frm.add(result);
		frm.add(jsp);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b4.addActionListener(this);
		b3.addActionListener(this);
		
		tab.addMouseListener(this);
		
		r.addKeyListener(this);
		n.addKeyListener(this);
		ma1.addKeyListener(this);
		ma2.addKeyListener(this);
		ma3.addKeyListener(this);
		ma4.addKeyListener(this);
		ma5.addKeyListener(this);
		t.addKeyListener(this);
		a.addKeyListener(this);
		result.addKeyListener(this);
			
	}

	public static void main(String[] args) {
		Student_Marksheet sm=new Student_Marksheet();
		sm.setObj();
		sm.getdata();
	}
	public void clrtxt() {
		r.setText(" ");
		n.setText(" ");
		ma1.setText(" ");
		ma2.setText(" ");
		ma3.setText(" ");
		ma4.setText(" ");
		ma5.setText(" ");
		t.setText(" ");
		a.setText(" ");
		result.setText(" ");
		r.requestFocus();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			clrtxt();
		}
		if(e.getSource()==b4) {
			frm.dispose();
		}
		
		if(e.getSource()==b3) {
			try {
		        int row = tab.getSelectedRow();
		        if (row >= 0)
		        {
		        	String rollno = tab.getModel().getValueAt(row, 0).toString();
		            PreparedStatement st = con.prepareStatement("DELETE FROM crud_student WHERE rollno = ?");
		            st.setString(1, rollno);
		            int rowsDeleted = st.executeUpdate();
		           
		            if (rowsDeleted > 0) 
		            {
		                JOptionPane.showMessageDialog(frm, "Record Successfully Deleted!");
		            } 
		            else {
		                JOptionPane.showMessageDialog(frm, "Record not Deleted!");
		            }
		            
		            DefaultTableModel model = (DefaultTableModel) tab.getModel();
		            model.removeRow(row);
		            clrtxt();
		            b1.setEnabled(true);
		            b4.setEnabled(true);
		        } 
		        else 
		        {
		            JOptionPane.showMessageDialog(frm, "Please select a row to delete.");
		        }
			}
	        catch(Exception e1)
			{
				System.out.println(e1);
			}
	        
		}
		if(e.getSource()==b2) {
			try {
		        int row = tab.getSelectedRow();
		       
		        if (row >= 0)
		        {
		        	int total = 0, mark1, mark2, mark3, mark4, mark5, avg = 0;

				    try {
				        
				        mark1 = Integer.parseInt(ma1.getText());
				        mark2 = Integer.parseInt(ma2.getText());
				        mark3 = Integer.parseInt(ma3.getText());
				        mark4 = Integer.parseInt(ma4.getText());
				        mark5 = Integer.parseInt(ma5.getText());

				        
				        total = mark1 + mark2 + mark3 + mark4 + mark5;
				        avg = total / 5; 
				        
				        if (mark1 >= 50 && mark2 >= 50 && mark3 >= 50 && mark4 >= 50 && mark5 >= 50) {
				        	if(total>250 && total<=300)
				        		result.setText("Pass");
				        	else if(total>300 && total<=350)
				        		result.setText("Third Class");
				        	else if(total>350 && total<=400)
				        		result.setText("Second Class");
				        	else if(total>400 && total<=450)
				        		result.setText("First Class");
				        	else if(total>450 && total<=500)
				        		result.setText("Honours");
				        	else
				        		result.setText("Invalid");
				        		
				        } else {
				            result.setText("Fail");
				        }
				        t.setText(Integer.toString(total));
				        a.setText(Integer.toString(avg));
				        

				    } catch (Exception ex) {
				        JOptionPane.showMessageDialog(null, "Please enter valid marks.");
				    }	
		        	String rollno = tab.getModel().getValueAt(row, 0).toString();
		            
		        	PreparedStatement st = con.prepareStatement("UPDATE Crud_student SET name=?, m1=?, m2=?, m3=?, m4=?, m5=?, total=?, average=?, result=? WHERE rollno=?");
		            st.setString(1, n.getText());  // name
		            st.setInt(2, Integer.parseInt(ma1.getText()));  // mark1
		            st.setInt(3, Integer.parseInt(ma2.getText()));  // mark2
		            st.setInt(4, Integer.parseInt(ma3.getText()));  // mark3
		            st.setInt(5, Integer.parseInt(ma4.getText()));  // mark4
		            st.setInt(6, Integer.parseInt(ma5.getText()));  // mark5
		            st.setInt(7, Integer.parseInt(t.getText()));  // total
		            st.setDouble(8, Double.parseDouble(a.getText()));  // average
		            st.setString(9, result.getText());  // result
		            st.setString(10, rollno);  // roll number as where condition

		            // Execute the update
		            int rowsUpdated = st.executeUpdate();

		            if (rowsUpdated > 0) {
		                // Update the JTable with the new values
		                JOptionPane.showMessageDialog(frm, "Record Successfully Updated!");
		                DefaultTableModel model = (DefaultTableModel) tab.getModel();
		                model.setValueAt(n.getText(), row, 1);  // Update name in the table
		                model.setValueAt(ma1.getText(), row, 2);  // Update mark1
		                model.setValueAt(ma2.getText(), row, 3);  // Update mark2
		                model.setValueAt(ma3.getText(), row, 4);  // Update mark3
		                model.setValueAt(ma4.getText(), row, 5);  // Update mark4
		                model.setValueAt(ma5.getText(), row, 6);  // Update mark5
		                model.setValueAt(t.getText(), row, 7);  // Update total
		                model.setValueAt(a.getText(), row, 8);  // Update average
		                model.setValueAt(result.getText(), row, 9);  // Update result
		                b1.setEnabled(true);
		                b4.setEnabled(true);
		            } else {
		                JOptionPane.showMessageDialog(frm, "Record not Updated!");
		            }
		        } else {
		            JOptionPane.showMessageDialog(frm, "Please select a row to update.");
		        }
		        
			}
	        catch(Exception e1)
			{
				System.out.println(e1);
			
		}
	}
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==tab)
		{   
			b2.setEnabled(true);
			b3.setEnabled(true);
			b1.setEnabled(false);
			b4.setEnabled(false);

	        int row = tab.getSelectedRow();
	        try
			{
	        	String rollno = tab.getModel().getValueAt(row, 0).toString(); // assuming rollno is the first column
	            PreparedStatement st = con.prepareStatement("SELECT * FROM crud_student WHERE rollno = ?");
	            st.setString(1, rollno);
	            ResultSet rs = st.executeQuery();
				 if(rs.next())
				 {
				  r.setText(String.valueOf(rs.getInt(1)));
			      n.setText(rs.getString(2));
			      ma1.setText(String.valueOf(rs.getInt(3)));
			      ma2.setText(String.valueOf(rs.getInt(4)));
			      ma3.setText(String.valueOf(rs.getInt(5)));
			      ma4.setText(String.valueOf(rs.getInt(6)));
			      ma5.setText(String.valueOf(rs.getInt(7)));
			      t.setText(String.valueOf(rs.getInt(8)));
			      a.setText(String.valueOf(rs.getDouble(9)));
			      result.setText(rs.getString(10));
				 }

			}
	        catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==r && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(r.getText().equals("")) {
				r.setText("");
				r.requestFocus();
			}
			else {
				n.requestFocus();
			}
		}
		if(e.getSource()==n && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(n.getText().equals("")) {
				n.setText("");
				n.requestFocus();
			}
			else {
				ma1.requestFocus();
			}
		}
		if(e.getSource()==ma1 && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(ma1.getText().equals("")) {
				ma1.setText("");
				ma1.requestFocus();
			}
			else {
				ma2.requestFocus();
			}
		}
		if(e.getSource()==ma2 && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(ma2.getText().equals("")) {
				ma2.setText("");
				ma2.requestFocus();
			}
			else {
				ma3.requestFocus();
			}
		}
		if(e.getSource()==ma3 && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(ma3.getText().equals("")) {
				ma3.setText("");
				ma3.requestFocus();
			}
			else {
				ma4.requestFocus();
			}
		}
		if(e.getSource()==ma4 && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(ma4.getText().equals("")) {
				ma4.setText("");
				ma4.requestFocus();
			}
			else {
				ma5.requestFocus();
			}
		}
		if(e.getSource()==ma5 && e.getKeyCode()==KeyEvent.VK_ENTER) {
			
			int total = 0, mark1, mark2, mark3, mark4, mark5, avg = 0;

		    try {
		        
		        mark1 = Integer.parseInt(ma1.getText());
		        mark2 = Integer.parseInt(ma2.getText());
		        mark3 = Integer.parseInt(ma3.getText());
		        mark4 = Integer.parseInt(ma4.getText());
		        mark5 = Integer.parseInt(ma5.getText());

		        
		        total = mark1 + mark2 + mark3 + mark4 + mark5;
		        avg = total / 5; 
		        
		        if (mark1 >= 50 && mark2 >= 50 && mark3 >= 50 && mark4 >= 50 && mark5 >= 50) {
		        	if(total>250 && total<=300)
		        		result.setText("Pass");
		        	else if(total>300 && total<=350)
		        		result.setText("Third Class");
		        	else if(total>350 && total<=400)
		        		result.setText("Second Class");
		        	else if(total>400 && total<=450)
		        		result.setText("First Class");
		        	else if(total>450 && total<=500)
		        		result.setText("Honours");
		        	else
		        		result.setText("Invalid");
		        		
		        } else {
		            result.setText("Fail");
		        }
		        t.setText(Integer.toString(total));
		        a.setText(Integer.toString(avg));
		        

		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(null, "Please enter valid marks.");
		    }	
		    
		    String rollno=r.getText();
			String name=n.getText();
			String marks1=ma1.getText();
			String marks2=ma2.getText();
			String marks3=ma3.getText();
			String marks4=ma4.getText();
			String marks5=ma5.getText();
			String tot=t.getText();
			String average=a.getText();
			String res=result.getText();
			
			Connection con=null;
			PreparedStatement pst=null;
			String sql;
			try {
				sql="insert into Crud_student values(?,?,?,?,?,?,?,?,?,?)";
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3308/projectdb","root","");
				pst=(PreparedStatement) con.prepareStatement(sql);
				pst.setString(1, rollno);
				pst.setString(2, name);
				pst.setString(3, marks1);
				pst.setString(4, marks2);
				pst.setString(5, marks3);
				pst.setString(6, marks4);
				pst.setString(7, marks5);
				pst.setString(8, tot);
				pst.setString(9, average);
				pst.setString(10, res);
				
				int ans=pst.executeUpdate();
				if(ans==1)
				{
					int confirm = JOptionPane.showConfirmDialog(frm, "Are you sure you want to save", "Confirm ", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Record stored");
					
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Record not stored...!");
				}
				}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			finally {
				try {
					con.close();
					pst.close();
					
					
				} catch (Exception e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
			}
		}
			
		if(e.getSource()==t && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(t.getText().equals("")) {
				
				t.setText("");
				t.requestFocus();
			}
			else {
				result.requestFocus();
			}
		}
		if(e.getSource()==result && e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(result.getText().equals("")) {
				result.setText("");
				result.requestFocus();
			}
			else {
				a.requestFocus();
			}
		}
		if(e.getSource()==a && e.getKeyCode()==KeyEvent.VK_ENTER) {
			  b2.requestFocus();
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

	


