package projectdb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class AddCrud implements ActionListener,KeyListener 
{
	JFrame frm;
	JLabel l1,rno,name,m1,m2,m3,m4,m5,tot,avg,res;
	JTextField r,n,ma1,ma2,ma3,ma4,ma5,t,a,result;
	String operation;
	JButton b1,b2,b3;
	Font fon1,fon2;
	
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
		
		b1=new JButton("New");
		b2=new JButton("Save");
		b3=new JButton("Back");
		
		
		JFrame.isDefaultLookAndFeelDecorated();
		  frm=new JFrame("Add Crud Operation"); 
		  frm.setSize(800, 800);
		  frm.setLocationRelativeTo(null);
		  frm.setResizable(false);
		  frm.setLayout(null);
		  frm.setDefaultCloseOperation(3);
		  frm.getContentPane().setBackground(Color.YELLOW);
		frm.setVisible(true);
		
		l1.setBounds(320, 40, 250, 30);
		
		rno.setBounds(120, 120, 150, 30);
		r.setBounds(220, 120, 150, 30);
		
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
		b2.setBounds(360, 570, 100, 30);
		b3.setBounds(560, 570, 100, 30);
		
		
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
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
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
		
	return;}

	public static void main(String[] args) {
		AddCrud ac=new AddCrud();
		ac.setObj();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{   
			clrtxt();
			JOptionPane.showConfirmDialog(null, "Confirm before Clear the Details Entered");
		}
		if(e.getSource()==b3) {
			int confirm = JOptionPane.showConfirmDialog(frm, "Are you sure you want to get back", "Confirm ", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
			frm.dispose();
			Crud_Prg.main(null);
			b3.setEnabled(false);
			}
		}
		if(e.getSource()==b2) {
			
			
			String rollno=r.getText();
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
			try {
				sql="insert into Crud_student values(?,?,?,?,?,?,?,?,?,?)";
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3308/projectdb","root","");
				pst=(PreparedStatement) con.prepareStatement(sql);
				pst.setString(1, rollno);
				pst.setString(2, name);
				pst.setString(3, mark1);
				pst.setString(4, mark2);
				pst.setString(5, mark3);
				pst.setString(6, mark4);
				pst.setString(7, mark5);
				pst.setString(8, tot);
				pst.setString(9, average);
				pst.setString(10, res);
				
				
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
