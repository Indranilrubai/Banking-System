package bank.view;
import java.awt.*;
import javax.swing.*;
public class AccountDeposite extends AccntDetails
{
	private JPanel pnl7,pnl8;
	private JTextField tfDepAmt;
	private JLabel l11;
	private JButton btnDeps;
	public AccountDeposite(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		pnl7=new JPanel();
		pnl8=new JPanel();
		tfDepAmt=new JTextField(10);
		tfDepAmt.setFont(new Font("Century Gothic", Font.BOLD, 16));
		tfDepAmt.setToolTipText("Enter The Deposit Amount Here");
		l11=new JLabel("Enter the Amount To Be Deposited:-");
		l11.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl7.add(l11);
		pnl7.add(tfDepAmt);
		pnl8=new JPanel();
		ImageIcon pic1=new ImageIcon("image\\dep.png");
		btnDeps=new JButton("Deposit",pic1);
		btnDeps.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl8.add(btnDeps);
		pnl7.setOpaque(false);
		pnl8.setOpaque(false);
		super.getPnl().add(pnl7);
		super.getPnl().add(pnl8);
	}
	public JTextField getTfDepAmt() {
		return tfDepAmt;
	}
	public JButton getBtnDeps() {
		return btnDeps;
	}
}
