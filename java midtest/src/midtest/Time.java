package midtest;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Time {

	public static void main(String[] args) {
		MycountDown01 md1 = new MycountDown01();
		md1.display();

	}

}

class MycountDown01 extends JFrame {
	JLabel count;
	MycountDown01()
	{
		count = new JLabel("����ð�");
		count.setFont(new Font("�ü�",Font.BOLD,50));
		add(count);
	}
	void display()
	{
		setLayout(new FlowLayout());
		setSize(550,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t1 = new Thread(new TimerCount());
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
	}
	class TimerCount implements Runnable
	{
		public void run()
		{
			while(true)
			{
				GregorianCalendar gc = new GregorianCalendar();
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException ie)
				{

				}
				count.setText(""+gc.get(gc.HOUR)+"��"+gc.get(gc.MINUTE)+"��"+gc.get(gc.SECOND)+"��");
				setTitle(""+gc.get(gc.HOUR)+"��"+gc.get(gc.MINUTE)+"��"+gc.get(gc.SECOND)+"��");
			}
		}
	}
}