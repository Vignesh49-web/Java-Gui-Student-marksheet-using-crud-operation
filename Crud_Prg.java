package projectdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Crud_Prg implements ActionListener
{
	
	JFrame frm;
	JLabel l1,l2;
	
	JButton mod,add,del,view,rep,print,exit;
	Font fon1,fon2;
	GradientPanel p1, p2, p3;
	public void setObj()
	{
		  fon1=new Font("Bookman Old Style", Font.BOLD, 20);
		  fon2=new Font("Calibri",Font.TYPE1_FONT,13);
		  
	      l1=new JLabel("Shivashri Academy");
	      l2=new JLabel("82/2 Gandhi Road,Opposite ATC Depot,Raja Nagar,1st Cross Street,Hasthampatti,Salem,Tamilnadu-636007");
	      l1.setFont(fon1);
	      l2.setFont(fon2);
	      
	      add=new JButton("Add");
	      mod=new JButton("Modify");
	      del=new JButton("Delete");
	      view=new JButton("View");
	      rep=new JButton("Report");
	      print=new JButton("Print");
	      exit=new JButton("Exit");
	      
	      add.setPreferredSize(new Dimension(80,30));
	      mod.setPreferredSize(new Dimension(80,30));
	      del.setPreferredSize(new Dimension(80,30));
	      view.setPreferredSize(new Dimension(80,30));
	      rep.setPreferredSize(new Dimension(80,30));
	      print.setPreferredSize(new Dimension(80,30));
	      exit.setPreferredSize(new Dimension(80,30));
	     

	      p1 = new GradientPanel(Color.YELLOW, Color.ORANGE);
	      p1.setPreferredSize(new Dimension(100,10));
	      p1.add(add);
	      p1.add(mod);
	      p1.add(del);
	      p1.add(view);
	      p1.add(rep);
	      p1.add(print);
	      p1.add(exit);
			
	      p2 = new GradientPanel(Color.BLUE, Color.cyan);
	      p2.setPreferredSize(new Dimension(50,50));
	      p2.add(l1);
	      
	      p3 = new GradientPanel(Color.YELLOW, Color.GREEN);
	      p3.setPreferredSize(new Dimension(50,50));
	      p3.add(l2);
		  
	      frm=new JFrame("CRUD Operation"); 
		  frm.setSize(800, 800);
		  frm.setLocationRelativeTo(null);
		  frm.setLayout(new BorderLayout());
		  frm.setDefaultCloseOperation(3);
		  frm.add(p1 ,BorderLayout.WEST);
		  frm.add(p2,BorderLayout.NORTH);
		  frm.add(p3,BorderLayout.SOUTH);
		  frm.setVisible(true);
		  
		  exit.addActionListener(this);
		  add.addActionListener(this);
		  mod.addActionListener(this);
		  del.addActionListener(this);
		  view.addActionListener(this);
		  rep.addActionListener(this);
		  
		  return;
		  }

	public static void main(String[] args) {
		Crud_Prg cp= new Crud_Prg();
		cp.setObj();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			int confirm = JOptionPane.showConfirmDialog(frm, "Are you sure you want exit", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
			frm.dispose();
			}
			
		}
		if(e.getSource()==add) 
		{
			frm.dispose();
			AddCrud.main(null);
			add.setEnabled(false);
			p1.setVisible(true);
		}
		if(e.getSource()==mod) 
		{
			frm.dispose();
			ModifyCrud.main(null);
			mod.setEnabled(false);
			p1.setVisible(true);
		}
		if(e.getSource()==del) 
		{
			frm.dispose();
			DeleteCrud.main(null);
			del.setEnabled(false);
			p1.setVisible(true);
		}
		if(e.getSource()==view) 
		{
			frm.dispose();
			ViewCrud.main(null);
			view.setEnabled(false);
			p1.setVisible(true);
		}
		if(e.getSource()==rep) 
		{
			frm.dispose();
			ReportCrud.main(null);
			view.setEnabled(false);
			p1.setVisible(true);
		}
		
	}
	public class GradientPanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Color color1;
	    private Color color2;

	    public GradientPanel(Color color1, Color color2) {
	        this.color1 = color1;
	        this.color2 = color2;
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        int width = getWidth();
	        int height = getHeight();

	        // Create a gradient paint from color1 to color2
	        GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);
	        g2d.setPaint(gradient);
	        g2d.fillRect(0, 0, width, height);
	    }

}
}
