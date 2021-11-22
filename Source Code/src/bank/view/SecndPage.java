package bank.view;

import java.awt.*;

import javax.swing.*;

public class SecndPage extends JFrame
{
	private JButton bAdmin,bUser,btnHelp;
	
	private JPanel pnl,pnl1;
	private JLabel l1,l2,l5;
	public SecndPage(String arg0) throws HeadlessException {
		super(arg0);
		ScBckgrnd con=new ScBckgrnd();
		// TODO Auto-generated constructor stub
		l1=new JLabel("   ");
		l2=new JLabel("   ");
		l5=new JLabel("Welcome and Please Choose A Option",JLabel.CENTER);
		l5.setFont(new Font("Century Gothic", Font.BOLD, 20));
		l5.setForeground(Color.cyan);
		ImageIcon ic1=new ImageIcon("image\\acc.png");
		bAdmin=new JButton("Accountant", ic1);
		ImageIcon ic2=new ImageIcon("image\\usr.png");
		bUser=new JButton("User          ",ic2);
		Container con2=getContentPane();
		pnl=new JPanel(new GridLayout(3, 4, 20, 20));
		pnl.setOpaque(false);
		pnl.add(l1);
		pnl.add(l2);
		//pnl.add(l3);
		//pnl.add(l4);
		//pnl.add(l5);
		pnl.add(bAdmin);
		pnl.add(bUser);
		ImageIcon ic3=new ImageIcon("image\\hlp.png");
		btnHelp=new JButton("Help",ic3);
		pnl1=new JPanel();
		pnl1.add(btnHelp);
		pnl1.setOpaque(false);
		con.add(l5,BorderLayout.NORTH);
		con.add(pnl,BorderLayout.CENTER);
		con.add(pnl1,BorderLayout.SOUTH);
		con2.add(con);
		setVisible(true);
		setSize(400, 350);
		setResizable(false);
	}
	public JButton getbAdmin() {
		return bAdmin;
	}
	public JButton getbUser() {
		return bUser;
	}
	public JButton getBtnHelp() {
		return btnHelp;
	}
}
class ScBckgrnd extends JPanel
{

	public ScBckgrnd() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\12.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}