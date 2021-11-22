package bank.view;

import javax.swing.JOptionPane;

public class ErrMsg {
	public ErrMsg(String ab) {
		JOptionPane.showMessageDialog(null, ab, "Error Message", JOptionPane.ERROR_MESSAGE);
		
	}
}
