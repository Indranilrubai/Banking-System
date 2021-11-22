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
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

public class UserEditDetails extends JFrame
{
	private JPanel spn,p1,p2,p3,p4;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,bl1,bl2,bl3,l9,l10;
	private JButton b1;
	private JLabel lblUid,lblUid2,lblName,lblPhno,lblEmail,lblAddrs,lblPin,lblDob,lblGender,lblGender2;
	private JTextField tfName,tfPhno,tfEmail,tfAddres,tfPin,tfDob;
	private JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5,pnl6,pnl7,pnl8,pnl9,pnl10;
	private JButton btnDone;
	public UserEditDetails(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		spn=new JPanel();
		spn.setLayout(new BoxLayout(spn,BoxLayout.Y_AXIS));
		UBckgrnded con=new UBckgrnded();
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
		pnl1=new JPanel();
		lblUid2=new JLabel("Uid:-   ");
		lblUid=new JLabel();
		pnl1.add(lblUid2);
		pnl1.add(lblUid);
		pnl2=new JPanel();
		lblName=new JLabel("Edit Your Name:-");
		tfName=new JTextField(15);
		pnl2.add(lblName);
		pnl2.add(tfName);
		pnl3=new JPanel();
		lblAddrs=new JLabel("Edit Your Address:-");
		tfAddres=new JTextField(40);
		pnl3.add(lblAddrs);
		pnl3.add(tfAddres);
		pnl4=new JPanel();
		lblEmail=new JLabel("Edit Your Email:-");
		tfEmail=new JTextField(25);
		pnl4.add(lblEmail);
		pnl4.add(tfEmail);
		pnl5=new JPanel();
		lblDob=new JLabel("Edit your Date of Birth:-");
		tfDob=new JTextField(10);
		pnl5.add(lblDob);
		pnl5.add(tfDob);
		pnl6=new JPanel();
		lblGender2=new JLabel("Your Gender:-");
		lblGender=new JLabel();
		pnl6.add(lblGender2);
		pnl6.add(lblGender);
		pnl7=new JPanel();
		lblPhno=new JLabel("Edit Your Ph No:-");
		tfPhno=new JTextField(15);
		pnl7.add(lblPhno);
		pnl7.add(tfPhno);
		pnl8=new JPanel();
		lblPin=new JLabel("Edit Your Pin Code");
		tfPin=new JTextField(10);
		pnl8.add(lblPin);
		pnl8.add(tfPin);
		pnl9=new JPanel();
		ImageIcon ic=new ImageIcon("image\\dn.png");
		btnDone=new JButton("Done",ic);
		pnl9.add(btnDone);
		//pnl10=new JPanel();
		//pnl10.setLayout(new BorderLayout());
		pnl.setOpaque(false);
		pnl1.setOpaque(false);
		pnl2.setOpaque(false);
		pnl3.setOpaque(false);
		pnl4.setOpaque(false);
		pnl5.setOpaque(false);
		pnl6.setOpaque(false);
		pnl7.setOpaque(false);
		pnl8.setOpaque(false);
		pnl9.setOpaque(false);
		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(pnl3);
		pnl.add(pnl8);
		pnl.add(pnl4);
		pnl.add(pnl5);
		pnl.add(pnl6);
		pnl.add(pnl7);
		pnl.add(pnl9);
		//pnl10.add(pnl,BorderLayout.WEST);
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
	public JLabel getL3() {
		return l3;
	}
	public JLabel getLblUid() {
		return lblUid;
	}
	public JLabel getLblGender() {
		return lblGender;
	}
	public JTextField getTfName() {
		return tfName;
	}
	public JTextField getTfPhno() {
		return tfPhno;
	}
	public JTextField getTfEmail() {
		return tfEmail;
	}
	public JTextField getTfAddres() {
		return tfAddres;
	}
	public JTextField getTfPin() {
		return tfPin;
	}
	public JTextField getTfDob() {
		return tfDob;
	}
	public JButton getBtnDone() {
		return btnDone;
	}
}
class UBckgrnded extends JPanel
{
	public UBckgrnded() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\u4.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}