package bank.view;
import java.awt.*;

import javax.swing.*;
public class AccountWithdraw extends AccntDetails
{
	private JPanel pnl7,pnl8;
	private JTextField tfWithdAmt;
	private JLabel l11;
	private JButton btnWithdraw;
	public AccountWithdraw(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		pnl7=new JPanel();
		pnl8=new JPanel();
		tfWithdAmt=new JTextField(10);
		tfWithdAmt.setFont(new Font("Century Gothic", Font.BOLD, 16));
		tfWithdAmt.setToolTipText("Enter The Amount Here");
		l11=new JLabel("Enter the Amount to be Withdrawn:-");
		l11.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl7.add(l11);
		pnl7.add(tfWithdAmt);
		pnl8=new JPanel();
		ImageIcon pic1=new ImageIcon("image\\wtdr.png");
		btnWithdraw=new JButton("Withdraw",pic1);
		btnWithdraw.setFont(new Font("Century Gothic", Font.BOLD, 16));
		pnl8.add(btnWithdraw);
		pnl7.setOpaque(false);
		pnl8.setOpaque(false);
		super.getPnl().add(pnl7);
		super.getPnl().add(pnl8);
	}
	public JTextField getTfWithdAmt() {
		return tfWithdAmt;
	}
	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}
}
