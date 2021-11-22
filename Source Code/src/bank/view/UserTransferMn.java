package bank.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class UserTransferMn extends JFrame
{
	private JPanel spn,p1,p2,p3,p4;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,bl1,bl2,bl3,l9,l10;
	private JButton b1;
	private JComboBox<String> jcb;
	private JLabel lbl1,lbl2,lbl3,lb4;
	private JTextField tf1,tf3;
	private String [] a;
	private JButton btnTransf;
	private JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5;
	public UserTransferMn(String arg0,String [] a) throws HeadlessException {
		super(arg0);
		this.a=a;
		// TODO Auto-generated constructor stub
		spn=new JPanel();
		spn.setLayout(new BoxLayout(spn,BoxLayout.Y_AXIS));
		UBckgrndtm con=new UBckgrndtm();
		Container con2=getContentPane();
		bl3=new JLabel("  ");
		spn.add(bl3);
		ImageIcon ic1=new ImageIcon("image\\Untitled-1.jpg");
		l1=new JLabel("Account Details            ", ic1, JLabel.LEFT);
		l1.setBorder(new LineBorder(new Color(103, 165, 152)));
		l1.setSize(50,10);
		spn.add(l1);
		l1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l1.setToolTipText("Click Here to View Account Details of any Account");
		ImageIcon ic2=new ImageIcon("image\\6.jpg");
		l2=new JLabel("See All Account            ", ic2, JLabel.LEFT);
		l2.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l2);
		l2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l2.setToolTipText("Click Here to See All Your Account");
		ImageIcon ic4=new ImageIcon("image\\4.jpg");
		l4=new JLabel("Transfer Money            ", ic4, JLabel.LEFT);
		l4.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l4);
		l4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l4.setToolTipText("Click Here to Transfer Money from an Account to Another Account");
		ImageIcon ic7=new ImageIcon("image\\5.jpg");
		l7=new JLabel("Transaction Details     ", ic7, JLabel.LEFT);
		l7.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l7);
		l7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l7.setToolTipText("Click Here to view the Transaction Details");
		ImageIcon ic3=new ImageIcon("image\\cp.png");
		l3=new JLabel("Change Password       ", ic3, JLabel.LEFT);
		l3.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l3);
		l3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l3.setToolTipText("Click Here To Change Password");
		
		ImageIcon ic9=new ImageIcon("image\\e1.jpg");
		l9=new JLabel("Edit Your Details           ", ic9, JLabel.LEFT);
		l9.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l9);
		l9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l9.setToolTipText("Click Here to Edit Your Personal Details");
		spn.setSize(400,50);
		spn.setVisible(true);
		p1=new JPanel();
		ImageIcon ic6=new ImageIcon("image\\7.jpg");
		l6=new JLabel("Log Out. ", ic6, JLabel.LEFT);
		l6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l6.setToolTipText("Click Here to LogOut");
		p1.setLayout(new BorderLayout());
		p2=new JPanel();
		p2.add(l6);
		p3=new JPanel();
		ImageIcon ic11=new ImageIcon("image\\loan.png");
		b1=new JButton("Apply For Loan", ic11);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.setToolTipText("Click Here To Apply For Loan");
		b1.setPreferredSize(new Dimension(150,20));
		p3.setLayout(new GridLayout(2, 2));
		ImageIcon ic8=new ImageIcon("image\\8.jpg");
		l8=new JLabel(ic8);
		bl1=new JLabel("");
		bl2=new JLabel("");
		p4=new JPanel(new GridLayout(2, 2));
		p4.add(bl1);
		p4.add(bl2);
		p4.add(b1);
		p3.add(l8);
		p3.add(p4);
		spn.setOpaque(false);
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p4.setOpaque(false);
		p1.add(p3,BorderLayout.WEST);
		p1.add(p2,BorderLayout.EAST);
		con.add(p1,BorderLayout.NORTH);
		con.add(spn,BorderLayout.WEST);
	
		pnl=new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		pnl4=new JPanel();
		lbl3=new JLabel("Transfering Amount from one Account to Another");
		lbl3.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		pnl1=new JPanel();
		lbl1=new JLabel("Select The Sender's Account No.");
		lbl1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jcb=new JComboBox<String>(a);
		jcb.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		pnl1.add(lbl1);
		pnl1.add(jcb);
		pnl2=new JPanel();
		lbl2=new JLabel("Select The Reciever's Account No.");
		lbl2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		tf1=new JTextField(20);
		tf1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		pnl2.add(lbl2);
		pnl2.add(tf1);
		pnl3=new JPanel();
		ImageIcon ic=new ImageIcon("image\\mntrnsf.png");
		btnTransf=new JButton("Transfer",ic);
		btnTransf.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		pnl3.add(btnTransf);
		pnl5=new JPanel();
		lb4=new JLabel("Enter The Amount:-");
		lb4.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		tf3=new JTextField(10);
		tf3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		pnl5.add(lb4);
		pnl5.add(tf3);
		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(pnl5);
		pnl.add(pnl3);
		pnl.add(pnl4);
		pnl.setOpaque(false);
		pnl1.setOpaque(false);
		pnl2.setOpaque(false);
		pnl3.setOpaque(false);
		pnl4.setOpaque(false);
		pnl5.setOpaque(false);
		con.add(pnl,BorderLayout.CENTER);
		con2.add(con);
		setVisible(true);
		setSize(1000, 550);
		setResizable(false);
	
	}
	public JLabel getL3() {
		return l3;
	}
	public JLabel getL1() {
		return l1;
	}
	public JLabel getL2() {
		return l2;
	}
	public JLabel getL4() {
		return l4;
	}
	public JLabel getL6() {
		return l6;
	}
	public JLabel getL7() {
		return l7;
	}
	public JLabel getL9() {
		return l9;
	}
	public JButton getB1() {
		return b1;
	}
	public JComboBox<String> getJcb() {
		return jcb;
	}
	public JTextField getTf1() {
		return tf1;
	}
	public JButton getBtnTransf() {
		return btnTransf;
	}
	public JTextField getTf3() {
		return tf3;
	}
	
}
class UBckgrndtm extends JPanel
{
	public UBckgrndtm() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\u7.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}