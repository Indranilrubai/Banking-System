package bank.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import prj.AccountReaderWritter;
import bank.model.*;
import bank.view.*;

public class AccntDepositeCntrl extends AccntDetailsContrl
{
	private AccountDeposite acdp;
	private int sh=0,i;
	private ArrayList<Savings_Account> acc;
	public AccntDepositeCntrl(AccntDetails acdt,
			AccountDeposite acdp) {
		super(acdt);
		this.acdp = acdp;
		try {
			acc=(ArrayList<Savings_Account>)AccountReaderWritter.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new ErrMsg("There is a Problem While Reading from File");
		}
	}
	public void control()
	{
		super.control();
		acdp.getBtnDeps().addActionListener((a)->{
			if(acdp.getTfAccId().getText().trim().length()==0)
			{
				new ErrMsg("Please Enter The Account No");
			}
			else if(acdp.getTfDepAmt().getText().trim().length()==0)
			{
				new ErrMsg("Please Enter The Amount");
			}
			else
			{
			long accno=Long.parseLong(acdp.getTfAccId().getText().trim());
			for(i=0;i<acc.size();i++)
			{
				if(acc.get(i).getAccountid()==accno)
				{
					if(acc.get(i).getType().equals("Savings Account"))
					{
						acc.get(i).deposite(Double.parseDouble(acdp.getTfDepAmt().getText().trim()));
						new InfMsg("Now Available Balance :-"+Double.toString(acc.get(i).getBalance()));
					}
					else if(acc.get(i).getType().equals("Current Account"))
					{
						acc.get(i).deposite(Double.parseDouble(acdp.getTfDepAmt().getText().trim()));
						new InfMsg("Now Available Balance :-"+Double.toString(acc.get(i).getBalance()));
					}
					super.clear();
					sh++;
				}
			}
			if(sh==0)
			{
				new ErrMsg("There is No Such Account");
			}
		}
			try {
				AccountReaderWritter.writter(acc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				new ErrMsg("There are Some error Occured While Depositing The Balance");
			}});
		acdp.getTfDepAmt().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent a) {
				// TODO Auto-generated method stub
				char key=a.getKeyChar();
				if(!(Character.isDigit(key))||(key==KeyEvent.VK_BACK_SPACE)||(key==KeyEvent.VK_DELETE))
				{
					a.consume();
				}
			}
		});
	}
}
