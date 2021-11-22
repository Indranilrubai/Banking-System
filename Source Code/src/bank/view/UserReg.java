package bank.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class UserReg extends JFrame{
	private JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5,pnl6,pnl7,pnl8,pnl9,pnl10,pnl11,pnl12,pnl13,pnl14,pnl15;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,lblpas,lblrepas,lbluid,lbluid2,lblul;
	private JTextField tf1,tf2,tf3,tf4;
	private JTextArea ta1;
	private String [] dd=new String[31];
	private String [] mm=new String[12];
	private String [] yyyy=new String[115];
	private JComboBox<String> jdt;
	private JComboBox<String> jmn;
	private JComboBox<String> jyr;
	private JPasswordField pswrd,cnfpswrd;
	private JRadioButton male,female;
	private ButtonGroup bgrp;
	private JButton btnPrs,btnRefrs,btnBack,btnRegister,btnBack2;
	public UserReg(String arg0) throws HeadlessException {
		super(arg0);
		UrBckgrnd con=new UrBckgrnd();
		// TODO Auto-generated constructor stub
		for(int i=0;i<31;i++)
		{
			dd[i]=Integer.toString(i+1);
		}
		for(int i=0;i<12;i++)
		{
			mm[i]=Integer.toString(i+1);
		}
		for(int i=0;i<115;i++)
		{
			yyyy[i]=Integer.toString(i+1900);
		}
		pnl=new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		pnl1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		l1=new JLabel("Enter Your Name:-      ");
		l1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf1=new JTextField(30);
		tf1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf1.setBorder(new LineBorder(Color.black));
		pnl1.add(l1);
		pnl1.add(tf1);
		pnl2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		l2=new JLabel("Enter Your Address:-   ");
		l2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		ta1=new JTextArea(2,30);
		ta1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		ta1.setBorder(new LineBorder(Color.black));
		ta1.setPreferredSize(new Dimension(100, 35));
		pnl2.add(l2);
		pnl2.add(ta1);
		pnl3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		l3=new JLabel("Enter Your Pin No.:-     ");
		l3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf2=new JTextField(30);
		tf2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf2.setBorder(new LineBorder(Color.black));
		pnl3.add(l3);
		pnl3.add(tf2);
		pnl4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		l4=new JLabel("Enter Your Email ID:-   ");
		l4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf3=new JTextField(30);
		tf3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf3.setBorder(new LineBorder(Color.black));
		pnl4.add(l4);
		pnl4.add(tf3);
		pnl5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		l5=new JLabel("Enter Your Ph No.:-      ");
		l5.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf4=new JTextField(30);
		tf4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		tf4.setBorder(new LineBorder(Color.black));
		pnl5.add(l5);
		pnl5.add(tf4);
		pnl6=new JPanel(new FlowLayout(FlowLayout.LEFT));
		l6=new JLabel("Select Your Gender:-                          ",JLabel.LEFT);
		l6.setFont(new Font("Century Gothic", Font.BOLD, 13));
		male=new JRadioButton("Male      ");
		male.setActionCommand("Male");
		male.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		female=new JRadioButton("Female");
		female.setActionCommand("Female");
		female.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		pnl6.add(l6);
		bgrp=new ButtonGroup();
		bgrp.add(male);
		bgrp.add(female);
		pnl6.add(male);
		pnl6.add(female);
		pnl7=new JPanel(new FlowLayout(FlowLayout.LEFT));
		l7=new JLabel("Select Your Date Of Birth(dd-mm-yyyy):-       ");
		l7.setFont(new Font("Century Gothic", Font.BOLD, 13));
		jdt=new JComboBox<String>(dd);
		jdt.setFont(new Font("Century Gothic", Font.BOLD, 13));
		jmn=new JComboBox<String>(mm);
		jmn.setFont(new Font("Century Gothic", Font.BOLD, 13));
		jyr=new JComboBox<String>(yyyy);
		jyr.setFont(new Font("Century Gothic", Font.BOLD, 13));
		pnl7.add(l7);
		pnl7.add(jdt);
		pnl7.add(jmn);
		pnl7.add(jyr);
		pnl8=new JPanel();
		ImageIcon ic1=new ImageIcon("image\\dn.png");
		ImageIcon ic2=new ImageIcon("image\\left.png");
		ImageIcon ic3=new ImageIcon("image\\re.png");
		btnBack=new JButton("Back       ",ic2);
		btnPrs=new JButton("Proceed",ic1);
		btnPrs.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnRefrs=new JButton("Refresh",ic3);
		btnRefrs.setFont(new Font("Century Gothic", Font.BOLD, 13));
		pnl8.add(btnBack);
		pnl8.add(btnPrs);
		pnl8.add(btnRefrs);
		pnl9=new JPanel(new FlowLayout(FlowLayout.LEFT));
		ImageIcon ic=new ImageIcon("image\\logo.jpg");
		l8=new JLabel(ic);
		pnl9.add(l8);
		pnl10=new JPanel(new FlowLayout(FlowLayout.CENTER));
		l9=new JLabel("--------------Customer Registration Area--------------");
		l9.setFont(new Font("Century Gothic", Font.BOLD, 21));
		pnl10.add(l9);
		pnl11=new JPanel();
		lblul=new JLabel("___________________________________________");
		lblul.setFont(new Font("Century Gothic", Font.BOLD, 21));
		pnl11.add(lblul);
		pnl12=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lbluid2=new JLabel("Your User ID:-                                         ");
		lbluid2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lbluid=new JLabel();
		lbluid.setFont(new Font("Century Gothic", Font.BOLD, 13));
		pnl12.add(lbluid2);
		pnl12.add(lbluid);
		pnl13=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblpas=new JLabel("Enter The Password:-            ");
		lblpas.setFont(new Font("Century Gothic", Font.BOLD, 13));
		pswrd=new JPasswordField(20);
		pswrd.setFont(new Font("Century Gothic", Font.BOLD, 13));
		pswrd.setToolTipText("The Password Should Contains One Small And One Capital Letter And One Digit And A Special Charecter");
		pswrd.setEditable(false);
		pnl13.add(lblpas);
		pnl13.add(pswrd);
		pnl14=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblrepas=new JLabel("ReEnter The Password:-        ");
		lblrepas.setFont(new Font("Century Gothic", Font.BOLD, 13));
		cnfpswrd=new JPasswordField(20);
		cnfpswrd.setToolTipText("The Password Should Contains One Small And One Capital Letter And One Digit And A Special Charecter");
		cnfpswrd.setFont(new Font("Century Gothic", Font.BOLD, 13));
		cnfpswrd.setEditable(false);
		pnl14.add(lblrepas);
		pnl14.add(cnfpswrd);
		pnl15=new JPanel();
		ImageIcon pic=new ImageIcon("image\\regtr.png");
		btnRegister=new JButton("Register",pic);
		btnBack2=new JButton("Back       ",ic2);
		btnBack2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnRegister.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnRegister.setEnabled(false);
		btnBack2.setEnabled(false);
		pnl15.add(btnBack2);
		pnl15.add(btnRegister);
		l1.setForeground(new Color(14,72,91));
		l2.setForeground(new Color(14,72,91));
		l3.setForeground(new Color(14,72,91));
		l4.setForeground(new Color(14,72,91));
		l5.setForeground(new Color(14,72,91));
		l6.setForeground(new Color(14,72,91));
		l7.setForeground(new Color(14,72,91));
		l8.setForeground(new Color(14,72,91));
		l9.setForeground(new Color(14,72,91));
		lblpas.setForeground(new Color(14,72,91));
		lblrepas.setForeground(new Color(14,72,91));
		lbluid.setForeground(new Color(14,72,91));
		lbluid2.setForeground(new Color(14,72,91));
		lblul.setForeground(new Color(14,72,91));
		pnl.add(pnl9);
		pnl.add(pnl10);
		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(pnl3);
		pnl.add(pnl4);
		pnl.add(pnl6);
		pnl.add(pnl7);
		pnl.add(pnl5);
		pnl.add(pnl8);
		pnl.add(pnl11);
		pnl.add(pnl12);
		pnl.add(pnl13);
		pnl.add(pnl14);
		pnl.add(pnl15);
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
		pnl10.setOpaque(false);
		pnl11.setOpaque(false);
		pnl12.setOpaque(false);
		pnl13.setOpaque(false);
		pnl14.setOpaque(false);
		pnl15.setOpaque(false);
		male.setOpaque(false);
		female.setOpaque(false);
		Container con2=getContentPane();
		con.add(pnl,BorderLayout.WEST);
		con2.add(con);
		setSize(540, 620);
		setResizable(false);
		setVisible(true);
	}
	public JButton getBtnBack2() {
		return btnBack2;
	}
	public JTextField getTf1() {
		return tf1;
	}
	public JTextField getTf2() {
		return tf2;
	}
	public JTextField getTf3() {
		return tf3;
	}
	public JTextField getTf4() {
		return tf4;
	}
	public JTextArea getTa1() {
		return ta1;
	}
	public JPasswordField getPswrd() {
		return pswrd;
	}
	public JPasswordField getCnfpswrd() {
		return cnfpswrd;
	}
	public JRadioButton getMale() {
		return male;
	}
	public JRadioButton getFemale() {
		return female;
	}
	public ButtonGroup getBgrp() {
		return bgrp;
	}
	public JButton getBtnPrs() {
		return btnPrs;
	}
	public JButton getBtnRefrs() {
		return btnRefrs;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JLabel getLbluid() {
		return lbluid;
	}
	public JButton getBtnRegister() {
		return btnRegister;
	}
	public JComboBox<String> getJdt() {
		return jdt;
	}
	public JComboBox<String> getJmn() {
		return jmn;
	}
	public JComboBox<String> getJyr() {
		return jyr;
	}
	
}
class UrBckgrnd extends JPanel
{

	public UrBckgrnd() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\reg.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}