package bank.view;

import javax.swing.*;

import java.awt.*;
public class AccntantLogIn extends JFrame{
	private JTextField tfID;
	private JLabel lblID,lblPass,lblHead,lblpic;
	private JPasswordField ps;
	private JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5;
	private JButton btnlogin,btncncl;
	public AccntantLogIn(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		Bckgrndtrnslogin con=new Bckgrndtrnslogin();
		Container con2=getContentPane();
		pnl=new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		pnl1=new JPanel();
		pnl1.setBackground(new Color(140, 175, 222));
		ImageIcon ic=new ImageIcon("image\\aud.png");
		lblpic=new JLabel(ic);
		pnl1.add(lblpic);
		pnl2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblID=new JLabel("Enter Your ID:-             ");
		lblID.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tfID=new JTextField(15);
		tfID.setFont(new Font("Century Gothic", Font.BOLD, 15));
		pnl2.setBackground(new Color(140, 175, 222));
		pnl2.add(lblID);
		pnl2.add(tfID);
		pnl3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblPass=new JLabel("Enter Your Password:-");
		lblPass.setFont(new Font("Century Gothic", Font.BOLD, 15));
		ps=new JPasswordField(15);
		ps.setFont(new Font("Century Gothic", Font.BOLD, 15));
		pnl3.setBackground(new Color(140, 175, 222));
		pnl3.add(lblPass);
		pnl3.add(ps);
		pnl4=new JPanel();
		ImageIcon ic1=new ImageIcon("image\\aclgin.png");
		btnlogin=new JButton("Log In",ic1);
		ImageIcon ic2=new ImageIcon("image\\cncl.png");
		btncncl=new JButton("Cancel",ic2);
		pnl4.add(btnlogin);
		pnl4.add(btncncl);		
		pnl5=new JPanel();
		pnl5.setBackground(new Color(140, 175, 222));
		lblHead=new JLabel("------Accountant Log In-------");
		lblHead.setFont(new Font("Century Gothic", Font.BOLD, 24));
		pnl5.add(lblHead);
		pnl.add(pnl5);
		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(pnl3);
		pnl.add(pnl4);
		pnl.setOpaque(false);
		pnl1.setOpaque(false);
		pnl2.setOpaque(false);
		pnl3.setOpaque(false);
		pnl4.setOpaque(false);
		pnl5.setOpaque(false);
		con.add(pnl);
		con2.add(con);
		setVisible(true);
		setSize(400, 440);
		setResizable(false);
	}
	public JTextField getTfID() {
		return tfID;
	}
	public JPasswordField getPs() {
		return ps;
	}
	public JButton getBtnlogin() {
		return btnlogin;
	}
	public JButton getBtncncl() {
		return btncncl;
	}
}
class Bckgrndtrnslogin extends JPanel
{
	public Bckgrndtrnslogin() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\dwn.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}
