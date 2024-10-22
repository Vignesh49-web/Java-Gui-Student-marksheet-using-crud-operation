package projectdb;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class ModifyCrud implements ActionListener,ItemListener,KeyListener
{
	JFrame frm;
	JLabel l1,rno,name,m1,m2,m3,m4,m5,tot,avg,res;
	JTextField n,ma1,ma2,ma3,ma4,ma5,t,a,result;
	String operation;
	Choice cho;
	JButton b1,b2,b3,b4;
	Font fon1,fon2;
	Color col;
	int rollnumber;
	
	public void setObj() {
		fon1=new Font("Bookman Old Style", Font.BOLD, 20);
		fon2=new Font("Calibri",Font.TYPE1_FONT,17);
		
		
		l1=new JLabel("Shivashri Academy");
		l1.setFont(fon1);
		rno=new JLabel("Roll Number");
		rno.setFont(fon2);
		name=new JLabel("Name");
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
		tot=new JLabel("Total Mark");
		tot.setFont(fon2);
		avg=new JLabel("Average Mark");
		avg.setFont(fon2);
		res=new JLabel("Result");
		res.setFont(fon2);
		l1.setForeground(Color.black);
		rno.setForeground(Color.black);
		name.setForeground(Color.black);
		m1.setForeground(Color.black);
		m2.setForeground(Color.black);
		m3.setForeground(Color.black);
		m4.setForeground(Color.black);
		m5.setForeground(Color.black);
		tot.setForeground(Color.black);
		avg.setForeground(Color.black);
		res.setForeground(Color.black);
		
		
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
		
		cho=new Choice();
		cho.add("Select");
		
		
		b1=new JButton("New");
		b2=new JButton("Save");
		b3=new JButton("Back");
		b4=new JButton("Update");
		
		JFrame.isDefaultLookAndFeelDecorated();
		  frm=new JFrame("Modify Crud Operation"); 
		  frm.setSize(800, 800);
		  frm.setLocationRelativeTo(null);
		  frm.setResizable(false);
		  frm.setLayout(null);
		  frm.setDefaultCloseOperation(3);
		  frm.getContentPane().setBackground(Color.lightGray);
		frm.setVisible(true);
		
		l1.setBounds(320, 40, 250, 30);
		
		rno.setBounds(120, 120, 150, 30);
		cho.setBounds(280, 120, 100, 30);
		
		name.setBounds(480, 120, 150, 30);
		n.setBounds(530, 120, 150, 30);
		
		m1.setBounds(300, 200, 150, 30);
		ma1.setBounds(360, 200, 150, 30);
		
		m2.setBounds(300, 250, 150, 30);
		ma2.setBounds(360, 250, 150, 30);
		
		m3.setBounds(300, 300, 150, 30);
		ma3.setBounds(360, 300, 150, 30);
		
		m4.setBounds(300, 350, 150, 30);
		ma4.setBounds(360, 350, 150, 30);
		
		m5.setBounds(300, 400, 150, 30);
		ma5.setBounds(360, 400, 150, 30);
		
		tot.setBounds(70, 480, 150, 30);
		t.setBounds(150, 480, 130, 30);
		
		avg.setBounds(530, 480, 150, 30);
		a.setBounds(635, 480, 130, 30);
		
		res.setBounds(310, 480, 150, 30);
		result.setBounds(360, 480, 150, 30);
		
		b1.setBounds(150, 570, 100, 30);
		b2.setBounds(300, 570, 100, 30);
		b3.setBounds(450, 570, 100, 30);
		b4.setBounds(600, 570, 100, 30);
		
		frm.add(rno);
		frm.add(l1);
		frm.add(name);
		frm.add(m1);
		frm.add(m2);
		frm.add(m3);
		frm.add(m4);
		frm.add(m5);
		frm.add(tot);
		frm.add(avg);
		frm.add(res);
		frm.add(n);
		frm.add(ma1);
		frm.add(ma2);
		frm.add(ma3);
		frm.add(ma4);
		frm.add(ma5);
		frm.add(t);
		frm.add(a);
		frm.add(result);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(b4);
		frm.add(cho);
		
		cho.addItemListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		frm.addKeyListener(this);
		cho.addKeyListener(this);
		
		
		try {
	        
	        Class.forName("com.mysql.jdbc.Driver");

	        
	        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/projectdb", "root", "");

	        
	        java.sql.Statement statement = con1.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT rollno,name,m1,m2,m3,m4,m5,total,average,Result FROM crud_student");

	        
	        while (resultSet.next()) {
	            String choice = resultSet.getString("rollno");
	            cho.add(choice);
	        }

	        
	        resultSet.close();
	        statement.close();
	        con1.close();

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    }
		
	

	public static void main(String[] args) {
		ModifyCrud mc=new ModifyCrud();
		mc.setObj();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{   
			clrtxt();
			JOptionPane.showConfirmDialog(null, "Confirm before Clear the Details Entered");
		}
		if(e.getSource()==b3) {
			int confirm = JOptionPane.showConfirmDialog(frm, "Are you sure you want to get back", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
			frm.dispose();
			Crud_Prg.main(null);
			b3.setEnabled(false);
			}
		}
		if(e.getSource()==b4) {
			String selected_rno=cho.getSelectedItem();
			if(!selected_rno.isEmpty()) {
			int total = 0, marks1, marks2, marks3, marks4, marks5, avg = 0;

		    try {
		        
		        marks1 = Integer.parseInt(ma1.getText());
		        marks2 = Integer.parseInt(ma2.getText());
		        marks3 = Integer.parseInt(ma3.getText());
		        marks4 = Integer.parseInt(ma4.getText());
		        marks5 = Integer.parseInt(ma5.getText());

		        
		        total = marks1 + marks2 + marks3 + marks4 + marks5;
		        avg = total / 5; 
		        
		        if (marks1 >= 50 && marks2 >= 50 && marks3 >= 50 && marks4 >= 50 && marks5 >= 50) {
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
		       	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}
		
		if(e.getSource()==b2) {
			
			String selected_rno=cho.getSelectedItem();
			if(!selected_rno.isEmpty())
			try {
				int rollnumber;
				rollnumber = Integer.parseInt(selected_rno);
				String name=n.getText();
				String mark1=ma1.getText();
				String mark2=ma2.getText();
				String mark3=ma3.getText();
				String mark4=ma4.getText();
				String mark5=ma5.getText();
				String tot=t.getText();
				String average=a.getText();
				String res=result.getText();
				
				Connection con=null;
				PreparedStatement pst=null;
				String sql;
				sql="update Crud_student set name=?,m1=?,m2=?,m3=?,m4=?,m5=?,total=?,average=?,Result=? where rollno=?";
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3308/projectdb","root","");
				pst=(PreparedStatement) con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, mark1);
				pst.setString(3, mark2);
				pst.setString(4, mark3);
				pst.setString(5, mark4);
				pst.setString(6, mark5);
				pst.setString(7, tot);
				pst.setString(8, average);
				pst.setString(9, res);
				pst.setInt(10, rollnumber);
				
				
				int ans=pst.executeUpdate();
				if(ans==1)
				{
					JOptionPane.showMessageDialog(null, "Record stored");;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Record not stored...!");
				}
				}
			
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			
		}
		
	}

	public void clrtxt() {
		n.setText(" ");
		ma1.setText(" ");
		ma2.setText(" ");
		ma3.setText(" ");
		ma4.setText(" ");
		ma5.setText(" ");
		t.setText(" ");
		a.setText(" ");
		result.setText(" ");
		n.requestFocus();
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cho) {
			
		 String choice=cho.getSelectedItem();
		 
		 try {
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3308/projectdb","root","");
			
			 PreparedStatement st =con1.prepareStatement("SELECT * FROM crud_student WHERE rollno = ?");
			 st.setString(1, choice);
			 ResultSet rs=st.executeQuery();
			 if(rs.next())
			 {
				    String name=rs.getString("name");
				    n.setText(name);
					String mark1=rs.getString("m1");
					ma1.setText(mark1);
					String mark2=rs.getString("m2");
					ma2.setText(mark2);
					String mark3=rs.getString("m3");
					ma3.setText(mark3);
					String mark4=rs.getString("m4");
					ma4.setText(mark4);
					String mark5=rs.getString("m5");
					ma5.setText(mark5);
					String total=rs.getString("total");
					t.setText(total);
					String average=rs.getString("average");
					a.setText(average);
					String result1=rs.getString("Result");
					result.setText(result1);	 
			 }
			 con1.close();
			 st.close();
			 rs.close();
		     }
		 catch(Exception e1) {
			 e1.printStackTrace();
		 }
		}
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource()==cho && e.getKeyCode()==KeyEvent.VK_ENTER) {
			  b2.requestFocus();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            
            frm.dispose(); 
            Crud_Prg.main(null); 
        }
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	


	}



