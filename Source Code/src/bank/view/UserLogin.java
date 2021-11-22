package bank.view;



import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
public class UserLogin extends JFrame
{
	private JButton btnLogin,btnCreate;
	private JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5,pnl6,pnl7,pnl8,pnl9,pnl10,pnlbg;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	private JTextField tf1;
	private JPasswordField ps;
	public UserLogin(String arg0) throws HeadlessException {
		super(arg0);
		UlogBckgrnd con=new UlogBckgrnd();
		// TODO Auto-generated constructor stub
		Container con2=getContentPane();
		pnl=new JPanel();
		pnl.setBorder(new BevelBorder(BevelBorder.RAISED));
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		pnl1=new JPanel();
		lbl1=new JLabel("Enter the User ID and Password to Login");
		lbl1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		pnl1.add(lbl1);
		pnl2=new JPanel();
		lbl2=new JLabel("Uid:-              ");
		lbl2.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tf1=new JTextField(15);
		tf1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		pnl2.add(lbl2);
		pnl2.add(tf1);
		pnl3=new JPanel();
		lbl3=new JLabel("Password:-  ");
		lbl3.setFont(new Font("Century Gothic", Font.BOLD, 12));
		ps=new JPasswordField(15);
		ps.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		pnl3.add(lbl3);
		pnl3.add(ps);
		pnl4=new JPanel();
		pnl4.setAlignmentY(200);
		ImageIcon ic1=new ImageIcon("image\\cuslogn.png");
		btnLogin=new JButton("Log In",ic1);
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 12));
		pnl4.add(btnLogin);
		pnl5=new JPanel();
		pnl5.setLayout(new BorderLayout());
		pnl6=new JPanel();
		ImageIcon icm=new ImageIcon("image\\logo.jpg");
		lbl4=new JLabel(icm);
		pnl6.add(lbl4);
		pnl5.add(pnl6,BorderLayout.WEST);
		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(pnl3);
		pnl.add(pnl4);
		pnl7=new JPanel();
		pnl7.setLayout(new BoxLayout(pnl7, BoxLayout.Y_AXIS));
		lbl5=new JLabel("Still Not Have Any Account ??");
		lbl5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		pnl8=new JPanel();
		pnl8.add(lbl5);
		pnl9=new JPanel();
		pnl9.setLayout(new BorderLayout());
		ImageIcon nc=new ImageIcon("image\\newreg.png");
		btnCreate=new JButton("Create",nc);
		pnl10=new JPanel();
		pnl10.add(btnCreate);
		pnl9.add(pnl10,BorderLayout.CENTER);
		pnl7.add(pnl8);
		pnl7.add(pnl9);
		pnlbg=new JPanel();
		pnlbg.setLayout(new BorderLayout());
		pnlbg.add(pnl,BorderLayout.WEST);
		pnlbg.add(pnl5,BorderLayout.NORTH);
		pnlbg.add(pnl7,BorderLayout.CENTER);
		lbl1.setForeground(new Color(153, 125, 14));
		lbl2.setForeground(new Color(153, 125, 14));
		lbl3.setForeground(new Color(153, 125, 14));
		lbl5.setForeground(new Color(153, 125, 14));
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
		pnlbg.setOpaque(false);
		
		con.add(pnlbg);
		con2.add(con);
		setVisible(true);
		setBackground(Color.BLACK);
		setSize(600,300);
		setResizable(false);
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public JButton getBtnCreate() {
		return btnCreate;
	}
	public JTextField getTf1() {
		return tf1;
	}
	public JPasswordField getPs() {
		return ps;
	}
}
class UlogBckgrnd extends JPanel
{

	public UlogBckgrnd() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\ulog.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}