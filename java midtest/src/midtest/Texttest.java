package midtest;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Texttest {

	public static void main(String[] args) {
		MyTexttest01 mtt = new MyTexttest01();
		mtt.display();

	}

}

class MyTexttest01 extends JFrame {
	JLabel lb;
	MyTexttest01()
	{
		lb = new JLabel("�ڹ� �ʹ��ʹ��ʹ��ʹ� ����"); add(lb);
	}
	void display()
	{
		setLayout(new FlowLayout());
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}