package midtest;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calctest {

	public static void main(String[] args) {
		MyCalc mc = new MyCalc();
		mc.display();

	}

}

class MyCalc extends JFrame implements ActionListener {
	JPanel panel;  
	JButton btn[]; 
	JButton opbtn[]; 
	JTextField tf; 
	String op1="",op2="",operator;
	float i,j,k; 

	MyCalc()
	{
		panel = new JPanel(new GridLayout(4, 4));
		btn = new JButton[12]; 
		opbtn = new JButton[4]; 
		
		for(int i=0;i<10;i++)
		{
			btn[i] = new JButton(""+i);
			btn[i].addActionListener(this);
			panel.add(btn[i]);
		}
		
		btn[10] = new JButton("=");
		btn[10].addActionListener(this);
		panel.add(btn[10]);
		
		btn[11] = new JButton("Clear");
		btn[11].addActionListener(this);
		panel.add(btn[11]);
		
		opbtn[0] = new JButton("+");opbtn[1] = new JButton("-");
		opbtn[2] = new JButton("*");opbtn[3] = new JButton("/");
		
		for(int i=0;i<4;i++)
		{
			opbtn[i].addActionListener(this);
			panel.add(opbtn[i]);
		}
		
		tf = new JTextField(23);
		tf.setHorizontalAlignment(4);
		add(tf);
		
	}
	void display()
	{
		setTitle("내가 만든 계산기");
		setLayout(new FlowLayout());
		setSize(500,500);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn[11]) 
		{
			op1 = "";
			tf.setText(op1);
		}
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==btn[i])
			{
				op1 += e.getActionCommand(); 
				tf.setText(op1);
				// tf.setText(e.getActionCommand());
			}
		}
		if((e.getActionCommand()=="+")|(e.getActionCommand()=="-")|
		   (e.getActionCommand()=="*")|(e.getActionCommand()=="/"))
		{
			operator = e.getActionCommand(); 
			op2=op1; 
			op1="";
			i=Float.parseFloat(op2); 
		}
		if(e.getActionCommand()=="=")
		{
			j=Float.parseFloat(op1); 
			tf.setText(""+oper(operator,i,j)); 
		}
	}
	public float oper(String operator,float i,float j)
	{
		if(operator.equals("+"))
		{
			k=i+j;
		}

		else if(operator.equals("-"))
		{
			k=i-j;
		}
		else if(operator.equals("*"))
		{
			k=i*j;
		}
		else if(operator.equals("/"))
		{
			k=i/j;
		}
		return k;
	}
}