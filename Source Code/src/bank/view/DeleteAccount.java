package bank.view;
import java.awt.HeadlessException;
import javax.swing.*;
public class DeleteAccount extends AccntDetails
{
	private JPanel pnl7;
	private JButton btnDelete;
	public DeleteAccount(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		pnl7=new JPanel();
		ImageIcon ic=new ImageIcon("image\\d.png");
		btnDelete=new JButton("Delete",ic);
		pnl7.add(btnDelete);
		pnl7.setOpaque(false);
		super.getPnl().add(pnl7);		
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
}
