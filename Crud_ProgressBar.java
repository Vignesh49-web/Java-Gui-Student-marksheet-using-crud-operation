package projectdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;


public class Crud_ProgressBar {
	JLabel l1;
	JFrame frm;
	GradientPanel p1;
	JPanel p2;
	JWindow win;
	JProgressBar jb;
	int i=0;
	Font fon;

	public void winCrea()
	{
		 p1 = new GradientPanel(Color.YELLOW, Color.cyan);
		 p1.setPreferredSize(new Dimension(100,250));
		p1.setBackground(Color.yellow);
		fon=new Font("Times New Roman", Font.BOLD, 20);
		l1=new JLabel("Crud Program");
		l1.setFont(fon);
		p1.add(l1);
		jb=new JProgressBar(JProgressBar.HORIZONTAL, 0, 2000);
		jb.setBackground(Color.white);
		jb.setPreferredSize(new Dimension(10, 20));
		jb.setValue(0);
		jb.setStringPainted(true);
		p2=new JPanel();
		 p2.setPreferredSize(new Dimension(10,10));
		p2.add(jb);
		frm=new JFrame();
		win=new JWindow(frm);
		l1.setBounds(150, 100, 200, 40);
		win.add(l1);
		win.setLayout(new BorderLayout());
		win.add(p1 ,BorderLayout.NORTH);
		win.add(p2,BorderLayout.SOUTH);
		win.setSize(400, 300);
		win.setLocationRelativeTo(null);
		win.add(jb);
		win.setVisible(true);
		
		proMeth();
	}
	public void proMeth()
	{
		while(i<=2000)
		{
			jb.setValue(i);
			i=i+20;
			
			try {
				Thread.sleep(10);
				
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		frm.dispose();
		Crud_Prg.main(null);
			
		}


	public static void main(String[] args) {
		Crud_ProgressBar cb= new Crud_ProgressBar();
		cb.winCrea();

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
