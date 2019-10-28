package midtest;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import midtest.MycountDown01.TimerCount;

public class A1602100359  extends MyCalc {

	public static void main(String[] args) {
		Mymenu mm = new Mymenu();
		mm.display();
		mm.makeMenu();

	}

}

class Mymenu extends JFrame implements ActionListener{
	JLabel jb,count;
	JMenuBar mb;
	JMenu mFile,mEdit,mHelp;
	JMenu mOut,mIF;
	JMenuItem toDR,toVR,toPdf,toPrinter;
	JMenuItem miNew,miOpen,miSave,miQuit,miHelpme; 
	JMenuItem miCopy,miPaste,miCut; 
	JMenuItem miHelp,miCaic,miCanvas,miGame,miTime;
	JTextArea ta;
	FileDialog open,save;
	Mymenu()
	
	{

		count = new JLabel(""); 

		mb = new JMenuBar(); 
		mFile = new JMenu("����(F)");
		mFile.setMnemonic(KeyEvent.VK_F);

		mEdit = new JMenu("Add(A)");
		mEdit.setMnemonic(KeyEvent.VK_A);

		mHelp = new JMenu("Notice(N)");
		mHelp.setMnemonic(KeyEvent.VK_N);
		mOut = new JMenu("���");
		toPdf = new JMenu("PDF�� �����");
		toPrinter = new JMenu("������ ���"); 
		mIF = new JMenu("����");
		toDR = new JMenuItem("16-02100359");
		toVR = new JMenuItem("���ʼ�");

		miNew = new JMenuItem("����");
		miNew.addActionListener(this);
		miNew.setAccelerator(KeyStroke.getKeyStroke('N',ActionEvent.CTRL_MASK));

		miOpen = new JMenuItem("����");
		miOpen.addActionListener(this);
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O',ActionEvent.CTRL_MASK));
		open = new FileDialog(this, "����",FileDialog.LOAD);

		miSave = new JMenuItem("����");
		miSave.addActionListener(this);
		miSave.setAccelerator(KeyStroke.getKeyStroke('S',ActionEvent.CTRL_MASK));
		save = new FileDialog(this, "����",FileDialog.SAVE);

		miQuit = new JMenuItem("������");
		miQuit.addActionListener(this);
		miQuit.setAccelerator(KeyStroke.getKeyStroke('Q',ActionEvent.CTRL_MASK));

		miCopy = new JMenuItem("�����ϱ�");
		miPaste = new JMenuItem("���̱�");
		miPaste.setEnabled(false);

		miCut = new JMenuItem("�ڸ���");
		miHelpme = new JMenuItem("���ǻ���");
		miHelpme.addActionListener(this);


		ta = new JTextArea(10,50); add(ta);
		miCaic = new JMenuItem("����");
		miCaic.addActionListener(this);
		miCanvas = new JMenuItem("�׸���");
		miCanvas.addActionListener(this);
		miGame = new JMenuItem("�����ϱ�");
		miGame.addActionListener(this);
		miTime = new JMenuItem("����ð�");
		miTime.addActionListener(this);

		
	}
	
	
	class TimerCount extends Thread
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
				setTitle("�޴���"+""+gc.get(gc.HOUR)+"��"+gc.get(gc.MINUTE)+"��"+gc.get(gc.SECOND)+"��");
			}
		}
	}
		
	
	
	
	
	void makeMenu()
	{
		mb.add(mFile); 
		mb.add(mEdit);
		mb.add(mHelp); 
		//mb.add(mOut);

		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miQuit);
		mHelp.add(miHelpme);
		mHelp.add(mIF);
		mEdit.add(miCaic);
		mEdit.add(miCanvas);
		mEdit.add(miGame);
		mEdit.add(miTime);
		mOut.add(toPdf);
		mOut.add(toPrinter); 
		mIF.add(toVR);
		mIF.add(toDR);
		setJMenuBar(mb);
	
		
	}
	void display()
	{
		//setTitle("�ڹ� �����ϴ� �޴���");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t1 = new Thread(new TimerCount());
		t1.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==miQuit)
		{
			System.exit(0);
		}
		if(e.getSource()==miNew)
		{
			ta.setText("");
		}
		if(e.getSource()==miOpen)
		{
			open.setVisible(true);
			String fileName=open.getDirectory()+open.getFile();//���ϰ��
			try
			{
				FileReader fr = new FileReader(fileName);
				while(true)
				{
					int a =fr.read();
					if(a==-1)break;//�����ǳ��� -1�̴�
					ta.append(""+(char)a);
				}  
			}
			catch(IOException io)
			{

			}
		}
		   if(e.getSource()==miSave)
		   {
		      
		      save.setVisible(true);
		            String fileName1 = save.getDirectory() + save.getFile();
		            try {
		                FileOutputStream output = new FileOutputStream(fileName1);
		                byte[] by=ta.getText().getBytes();
		                output.write(by);
		                  
		            } catch (Exception ee) {
		                     ee.getStackTrace();
		            }
		      }
		if(e.getSource()==miHelp)
		{
			MyHelp dial = new MyHelp();
			dial.isShowing();
			//System.exit(0);
		}
		if(e.getSource() == miCanvas)
		{
			MyOvalFrame mof = new MyOvalFrame();
			mof.display();
		}
		if(e.getSource() == miCaic)
		{
			MyCalc mof = new MyCalc();
			mof.display();
		}
		if(e.getSource() == miGame)
		{
			MyPuzzle1 mof = new MyPuzzle1();
			mof.display();
		}
		if(e.getSource() == miHelpme)
		{
			MyTexttest01 mof = new MyTexttest01();
			mof.display();
		}
		if(e.getSource() == miTime)
		{
		MycountDown01 md1 = new MycountDown01();
		md1.display();
	
		}
	}

}
class MyHelp extends JDialog
{
	JButton btn;   

	MyHelp()
	{
		btn =new JButton("Close");
		btn.addActionListener(new ActionListener() {



			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.exit(0);
			}

		});
		add(btn);
		setTitle("�ڹ��ְ�");
		setSize(200,100);
		setVisible(true);
	}


}


