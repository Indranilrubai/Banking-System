package bank.view;

import javax.swing.JOptionPane;

public class InfMsg {
	private String a;

	public InfMsg(String a) {
		super();
		this.a = a;
		JOptionPane.showMessageDialog(null, this.a, "Information",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
