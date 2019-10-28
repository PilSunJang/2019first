package midtest;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Canvastest {
	
	public static void main(String[] args) {
		MyOvalFrame mo = new MyOvalFrame();
		mo.display();

	}

}

class MyOvalFrame extends JFrame  implements MouseMotionListener,ActionListener
{
	MyMakeCanvas myCanvas;
	JButton clear;
	
	MyOvalFrame()
	{
		myCanvas = new MyMakeCanvas();
		myCanvas.setSize(1750,1000);
		myCanvas.setBackground(Color.green);
		myCanvas.addMouseMotionListener(this);
		add(myCanvas);
		clear = new JButton("clear");
		add(clear);
		clear.addActionListener(this);
	}
	void display()
	{
		setTitle("내가 만든 켄버스");
		setLayout(new FlowLayout());
		setSize(1950,1100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		myCanvas.x=e.getX();
		myCanvas.y=e.getY();
		myCanvas.repaint();
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 Graphics g = myCanvas.getGraphics();
	        g.clearRect(0, 0, 1950, 1100);
		
	} 
}
class MyMakeCanvas extends Canvas {
int x=100, y=100;
public void paint(Graphics g) {
   
   g.setColor(Color.black); //연필색
   g.fillOval(x, y, 10, 10); //동그라미
   
}
public void update(Graphics g) {
   paint(g);
}
}