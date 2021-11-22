package bank.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class CreatAccnt extends JFrame
{
	private JPanel spn,p1,p2,p3,p4;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,bl1,bl2,bl3,l9,l10;
	private JButton b1;
	private JPanel pnl,pnl1,pnl2;
	private JButton btnSaving,btnCurrent;
	public CreatAccnt(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		spn=new JPanel();
		spn.setLayout(new BoxLayout(spn,BoxLayout.Y_AXIS));
		Bckgrndcr con=new Bckgrndcr();
		Container con2=getContentPane();
		bl3=new JLabel("  ");
		spn.add(bl3);
		ImageIcon ic1=new ImageIcon("image\\Untitled-1.jpg");
		l1=new JLabel("Account Details            ", ic1, JLabel.LEFT);
		l1.setBorder(new LineBorder(new Color(103, 165, 152)));
		l1.setSize(50,10);
		spn.add(l1);
		l1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l1.setToolTipText("Click Here To View Account Details Of Any Account");
		ImageIcon ic2=new ImageIcon("image\\2.jpg");
		l2=new JLabel("Deposit Money              ", ic2, JLabel.LEFT);
		l2.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l2);
		l2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l2.setToolTipText("Click Here To Deposit Money To Any Account");
		ImageIcon ic3=new ImageIcon("image\\3.jpg");
		l3=new JLabel("Withdraw Money          ", ic3, JLabel.LEFT);
		l3.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l3);
		l3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l3.setToolTipText("Click Here To Withdraw Money From Any Account");
		ImageIcon ic4=new ImageIcon("image\\4.jpg");
		l4=new JLabel("Transfer Money            ", ic4, JLabel.LEFT);
		l4.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l4);
		l4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l4.setToolTipText("Click Here To Transfer Money From An Account To Another Account");
		ImageIcon ic7=new ImageIcon("image\\5.jpg");
		l7=new JLabel("Transaction Details     ", ic7, JLabel.LEFT);
		l7.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l7);
		l7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l7.setToolTipText("Click Here To View The Transaction Details");
		ImageIcon ic9=new ImageIcon("image\\e1.jpg");
		l9=new JLabel("Edit Existing Account  ", ic9, JLabel.LEFT);
		l9.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l9);
		l9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l9.setToolTipText("Click Here To Edit Existing Account Details");
		ImageIcon ic10=new ImageIcon("image\\d1.jpg");
		l10=new JLabel("Delete an Account       ", ic10, JLabel.LEFT);
		l10.setBorder(new LineBorder(new Color(103, 165, 152)));
		spn.add(l10);
		l10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l10.setToolTipText("Click Here to Delete An Existing Account");
		spn.setSize(400,50);
		spn.setVisible(true);
		p1=new JPanel();
		ImageIcon ic5=new ImageIcon("image\\6.jpg");
		l5=new JLabel("See All Accounts", ic5, JLabel.LEFT);
		l5.setToolTipText("Click Here To See All The Accounts");
		l5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon ic6=new ImageIcon("image\\7.jpg");
		l6=new JLabel("Log Out. ", ic6, JLabel.LEFT);
		l6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l6.setToolTipText("Click Here To LogOut");
		p1.setLayout(new BorderLayout());
		p2=new JPanel();
		p2.add(l5);
		p2.add(l6);
		p3=new JPanel();
		ImageIcon ic11=new ImageIcon("image\\ca.png");
		b1=new JButton("Create Account", ic11);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.setToolTipText("Click Here To Create A New Account");
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
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
		pnl1=new JPanel();
		ImageIcon pc1=new ImageIcon("image\\sa.png");
		btnSaving=new JButton("\nSavings Account",pc1);
		btnSaving.setToolTipText("Click Here to Create an Savings Bank Account");
		btnSaving.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		pnl1.add(btnSaving);
		pnl.add(pnl1);
		pnl2=new JPanel();
		ImageIcon pc2=new ImageIcon("image\\caa.png");
		btnCurrent=new JButton("\nCurrent Account",pc2);
		btnCurrent.setToolTipText("Click Here to Create an Current Bank Account");
		btnCurrent.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		pnl2.add(btnCurrent);
		pnl.add(pnl2);
		pnl.setOpaque(false);
		pnl1.setOpaque(false);
		pnl2.setOpaque(false);
		con.add(pnl,BorderLayout.CENTER);
		con2.add(con);
		setVisible(true);
		setSize(1000, 550);
		setResizable(false);
	}
	public JLabel getL1() {
		return l1;
	}
	public JLabel getL2() {
		return l2;
	}
	public JLabel getL3() {
		return l3;
	}
	public JLabel getL4() {
		return l4;
	}
	public JLabel getL5() {
		return l5;
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
	public JLabel getL10() {
		return l10;
	}
	public JButton getB1() {
		return b1;
	}
	public JButton getBtnSaving() {
		return btnSaving;
	}
	public JButton getBtnCurrent() {
		return btnCurrent;
	}
}
class Bckgrndcr extends JPanel
{

	public Bckgrndcr() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\cra.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}