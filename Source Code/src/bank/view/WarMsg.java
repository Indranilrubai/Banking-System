package bank.view;

import javax.swing.JOptionPane;

public class WarMsg {
	private String a;

	public WarMsg(String a) {
		JOptionPane.showMessageDialog(null, a, "Warning Message", JOptionPane.WARNING_MESSAGE);
	}
}
