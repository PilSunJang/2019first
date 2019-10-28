package midtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game1 {

	public static void main(String[] args) {
		MyPuzzle1 mp1 = new MyPuzzle1();
		
		mp1.display();

	}

}

class MyPuzzle1 extends JFrame implements ActionListener {
	
	JButton btn[],reset;
	JPanel panel;
	JLabel lb;
	Font myfont;
	Color mycolor;
	MyPuzzle1()
	{

		myfont = new Font("µ¸À½",Font.BOLD,30);
		mycolor = new Color(0,0,0);
		btn = new JButton[17];
		reset = new JButton(new ImageIcon("img/333.jpg"));
		reset.setBorderPainted(false);
		reset.setFont(myfont);
		reset.addActionListener(this);
		panel = new JPanel(new GridLayout(4, 4));
		for(int i=0;i<16;i++) 
		{
			btn[i] = new JButton(""+(i+1));
			btn[i].setFont(myfont);
			btn[i].setBackground(mycolor);
			btn[i].setForeground(Color.WHITE);
			btn[i].addActionListener(this);
			panel.add(btn[i]);
		}
		btn[15].setText("");
	}
	void display()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		setLayout(new BorderLayout());
		add(panel,BorderLayout.CENTER);
		add(reset,BorderLayout.SOUTH);
		setTitle("¾ÆÁÖ Áñ°Å¿î °ÔÀÓ");
		setSize((int)width,(int)height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	      if(e.getSource() == reset) {
	         int u[] = MyPuzzle1.makeRnum();
	         for(int i=0; i<16; i++) {
	            btn[i].setText(""+u[i]);
	         }//end for i
	         btn[15].setText("");
	      }
	      
	      if(e.getSource() == btn[0]){
	         if(btn[1].getText().equals("")){
	              btn[1].setText(btn[0].getText());
	              btn[0].setText("");
	         }
	         if(btn[4].getText().equals("")){
	            btn[4].setText(btn[0].getText());
	              btn[0].setText("");
	         }
	      }
	      
	      if(e.getSource() == btn[1]){
	         if(btn[0].getText().equals("")){
	             btn[0].setText(btn[1].getText());
	             btn[1].setText("");
	         }
	         if(btn[2].getText().equals("")){
	              btn[2].setText(btn[1].getText());
	              btn[1].setText("");
	          }
	         if(btn[5].getText().equals("")){
	             btn[5].setText(btn[1].getText());
	             btn[1].setText("");
	         }
	      }
	      
	      if(e.getSource() == btn[2]){
	          if(btn[1].getText().equals("")){
	              btn[1].setText(btn[2].getText());
	              btn[2].setText("");
	          }
	          if(btn[3].getText().equals("")){
	              btn[3].setText(btn[2].getText());
	              btn[2].setText("");
	          }
	          if(btn[6].getText().equals("")){
	              btn[6].setText(btn[2].getText());
	              btn[2].setText("");
	          }
	      }
	      
	      if(e.getSource() == btn[3]){
	         if(btn[2].getText().equals("")){
	            btn[2].setText(btn[3].getText());
	            btn[3].setText("");
	         }
	         if(btn[7].getText().equals("")){
	             btn[7].setText(btn[3].getText());
	             btn[3].setText("");
	         }
	          
	      }

	      if(e.getSource() == btn[4]){
	         if(btn[0].getText().equals("")){
	             btn[0].setText(btn[4].getText());
	             btn[4].setText("");
	         }
	         if(btn[5].getText().equals("")){
	            btn[5].setText(btn[4].getText());
	             btn[4].setText("");
	         }
	         if(btn[8].getText().equals("")){
	              btn[8].setText(btn[4].getText());
	              btn[4].setText("");
	         }
	         
	      }

	      if(e.getSource() == btn[5]){
	         if(btn[1].getText().equals("")){
	               btn[1].setText(btn[5].getText());
	               btn[5].setText("");
	               }
	         if(btn[4].getText().equals("")){
	              btn[4].setText(btn[5].getText());
	              btn[5].setText("");
	          }
	         if(btn[6].getText().equals("")){
	              btn[6].setText(btn[5].getText());
	              btn[5].setText("");
	         }
	         if(btn[9].getText().equals("")){
	              btn[9].setText(btn[5].getText());
	              btn[5].setText("");
	          }
	      }
	      
	      if(e.getSource() == btn[6]){
	         if(btn[2].getText().equals("")){
	             btn[2].setText(btn[6].getText());
	             btn[6].setText("");
	         }
	         if(btn[5].getText().equals("")){
	              btn[5].setText(btn[6].getText());
	              btn[6].setText("");
	          }
	         if(btn[7].getText().equals("")){
	              btn[7].setText(btn[6].getText());
	              btn[6].setText("");
	         }
	         if(btn[10].getText().equals("")){
	              btn[10].setText(btn[6].getText());
	              btn[6].setText("");
	          }
	      }

	      if(e.getSource() == btn[7]){
	         if(btn[3].getText().equals("")){
	              btn[3].setText(btn[7].getText());
	              btn[7].setText("");
	          }
	         if(btn[6].getText().equals("")){
	              btn[6].setText(btn[7].getText());
	              btn[7].setText("");
	          }
	         if(btn[11].getText().equals("")){
	              btn[11].setText(btn[7].getText());
	              btn[7].setText("");
	          }
	      }

	      if(e.getSource() == btn[8]){
	         if(btn[4].getText().equals("")){
	              btn[4].setText(btn[8].getText());
	              btn[8].setText("");
	          }
	          if(btn[9].getText().equals("")){
	              btn[9].setText(btn[8].getText());
	              btn[8].setText("");
	          }
	          if(btn[12].getText().equals("")){
	              btn[12].setText(btn[8].getText());
	              btn[8].setText("");
	          }
	      }
	      if(e.getSource() == btn[9]){
		         if(btn[5].getText().equals("")){
		              btn[5].setText(btn[9].getText());
		              btn[9].setText("");
		      }
		         if(btn[10].getText().equals("")){
		              btn[10].setText(btn[9].getText());
		              btn[9].setText("");
		      }
		         if(btn[8].getText().equals("")){
		              btn[8].setText(btn[9].getText());
		              btn[9].setText("");
		      }
		         if(btn[13].getText().equals("")){
		              btn[13].setText(btn[9].getText());
		              btn[9].setText("");
		      }
	      }
	      if(e.getSource() == btn[10]){
		         if(btn[6].getText().equals("")){
		              btn[6].setText(btn[10].getText());
		              btn[10].setText("");
		      }
		         if(btn[11].getText().equals("")){
		              btn[11].setText(btn[10].getText());
		              btn[10].setText("");
		      }
		         if(btn[14].getText().equals("")){
		              btn[14].setText(btn[10].getText());
		              btn[10].setText("");
		      }
		         if(btn[9].getText().equals("")){
		              btn[9].setText(btn[10].getText());
		              btn[10].setText("");
		      }
	      }
	      if(e.getSource() == btn[11]){
		         if(btn[7].getText().equals("")){
		              btn[7].setText(btn[11].getText());
		              btn[11].setText("");
		      }
		         if(btn[10].getText().equals("")){
		              btn[10].setText(btn[11].getText());
		              btn[11].setText("");
		      }
		         if(btn[15].getText().equals("")){
		              btn[15].setText(btn[11].getText());
		              btn[11].setText("");
		      }
		      
	      }
	      if(e.getSource() == btn[12]){
		         if(btn[8].getText().equals("")){
		              btn[8].setText(btn[12].getText());
		              btn[12].setText("");
		      }
		         if(btn[13].getText().equals("")){
		              btn[13].setText(btn[12].getText());
		              btn[12].setText("");
		      }
		      
	      }
	      if(e.getSource() == btn[13]){
		         if(btn[9].getText().equals("")){
		              btn[9].setText(btn[13].getText());
		              btn[13].setText("");
		      }
		         if(btn[12].getText().equals("")){
		              btn[12].setText(btn[13].getText());
		              btn[13].setText("");
		      }
		         if(btn[14].getText().equals("")){
		              btn[14].setText(btn[13].getText());
		              btn[13].setText("");
		      }
		      
	      }
	      if(e.getSource() == btn[14]){
		         if(btn[10].getText().equals("")){
		              btn[10].setText(btn[14].getText());
		              btn[14].setText("");
		      }
		         if(btn[13].getText().equals("")){
		              btn[13].setText(btn[14].getText());
		              btn[14].setText("");
		      }
		         if(btn[15].getText().equals("")){
		              btn[15].setText(btn[14].getText());
		              btn[14].setText("");
		      }
		      
	      }
	      if(e.getSource() == btn[15]){
		         if(btn[14].getText().equals("")){
		              btn[14].setText(btn[15].getText());
		              btn[15].setText("");
		      }
		         if(btn[11].getText().equals("")){
		              btn[11].setText(btn[15].getText());
		              btn[15].setText("");
		      }
		      
	      }
	   }//end actionperformed
		
				
	
	static int [] makeRnum()
	{
		Random r = new Random();
		int result[] = new int[17];
		int x=0;
		for(int i=0;i<16;i++)
		{
			result[i] = r.nextInt(17)+1;
			for(int k=0;k<i;k++)
			{
				if(result[i] == result[k])
				{
					x=r.nextInt(17)+1;
					result[i]=x;
					i=i-1;
					break;
				}
			}
		}
		return result;
	}
}

