package bank.view;
import java.awt.*;

import javax.swing.*;

public class Help extends JFrame{
	private JButton btnBack;
	private JPanel pnl;
	public Help(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		bpk con=new bpk();
		btnBack=new JButton("Back");
		btnBack.setFont(new Font("", Font.BOLD, 30));
		pnl=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnl.add(btnBack);
		pnl.setOpaque(false);
		con.add(pnl,BorderLayout.SOUTH);
		Container con2=getContentPane();
		con2.add(con);
		setVisible(true);
		setSize(1200, 600);
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	
}
class bpk extends JPanel
{
	public bpk() {
		setOpaque(false);
		setLayout(new BorderLayout());
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\Contacts.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}