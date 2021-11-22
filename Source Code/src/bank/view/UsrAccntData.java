package bank.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class UsrAccntData extends JFrame{
	private JPanel spn,p1,p2,p3,p4;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,bl1,bl2,bl3,l9,l10;
	private JButton b1;
	private String [] data;
	private JComboBox<String> jcmb;
	private JLabel lblAcNo2,lblHolderNm,lblHolderNm2,lblHolUid,lblHolUid2,lblBal,lblBal2,lblType,lblType2,lblMinBal,lblMinBal2;
	private JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5,pnl6;
	public UsrAccntData(String arg0, String[] data) throws HeadlessException {
		super(arg0);
		this.data = data;
		spn=new JPanel();
		spn.setLayout(new BoxLayout(spn,BoxLayout.Y_AXIS));
		UBckgrndad con=new UBckgrndad();
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
		jcmb=new JComboBox<String>(data);
		jcmb.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblAcNo2=new JLabel("Select The Account No:-");
		lblAcNo2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		pnl1=new JPanel();
		pnl1.add(lblAcNo2);
		pnl1.add(jcmb);
		pnl2=new JPanel();
		lblHolUid2=new JLabel("The Account Holder's Uid is:-");
		lblHolUid2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblHolUid=new JLabel();
		lblHolUid.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl2.add(lblHolUid2);
		pnl2.add(lblHolUid);
		pnl3=new JPanel();
		lblHolderNm2=new JLabel("The Account Holder's Name is:-");
		lblHolderNm2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblHolderNm=new JLabel();
		lblHolderNm.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl3.add(lblHolderNm2);
		pnl3.add(lblHolderNm);
		pnl4=new JPanel();
		lblType2=new JLabel("The Account Type is:-");
		lblType2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblType=new JLabel();
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl4.add(lblType2);
		pnl4.add(lblType);
		pnl5=new JPanel();
		lblBal2=new JLabel("The Account's Available Balance is:-");
		lblBal2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblBal=new JLabel();
		lblBal.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl5.add(lblBal2);
		pnl5.add(lblBal);
		pnl6=new JPanel();
		lblMinBal2=new JLabel("The Account's Minimum Balance is:-");
		lblMinBal2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblMinBal=new JLabel();
		lblMinBal.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl6.add(lblMinBal2);
		pnl6.add(lblMinBal);
		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(pnl3);
		pnl.add(pnl4);
		pnl.add(pnl5);
		pnl.add(pnl6);
		lblAcNo2.setForeground(Color.RED);
		lblHolderNm.setForeground(Color.RED);
		lblHolderNm2.setForeground(Color.RED);
		lblHolUid.setForeground(Color.RED);
		lblHolUid2.setForeground(Color.RED);
		lblBal.setForeground(Color.RED);
		lblBal2.setForeground(Color.RED);
		lblType.setForeground(Color.RED);
		lblType2.setForeground(Color.RED);
		lblMinBal.setForeground(Color.RED);
		lblMinBal2.setForeground(Color.RED);
		pnl.setOpaque(false);
		pnl1.setOpaque(false);
		pnl2.setOpaque(false);
		pnl3.setOpaque(false);
		pnl4.setOpaque(false);
		pnl5.setOpaque(false);
		pnl6.setOpaque(false);
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
	public JComboBox<String> getJcmb() {
		return jcmb;
	}
	public JLabel getLblHolderNm() {
		return lblHolderNm;
	}
	public JLabel getLblHolUid() {
		return lblHolUid;
	}
	public JLabel getLblBal() {
		return lblBal;
	}
	public JLabel getLblType() {
		return lblType;
	}
	public JLabel getLblMinBal() {
		return lblMinBal;
	}
}
class UBckgrndad extends JPanel
{
	public UBckgrndad() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\u6.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}