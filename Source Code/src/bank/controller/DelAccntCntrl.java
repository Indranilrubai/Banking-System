package bank.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;








import prj.*;
import bank.model.*;
import bank.view.*;

public class DelAccntCntrl extends AccntDetailsContrl
{
	private DeleteAccount da;
	private ArrayList<Savings_Account> svacc=new ArrayList<Savings_Account>();
	private int Count=0;
	public DelAccntCntrl(AccntDetails acdt,
			DeleteAccount da) {
		super(acdt);
		this.da = da;
		try {
	svacc=AccountReaderWritter.read();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	new ErrMsg("File Not Found in Location");
} catch (IOException e) {
	// TODO Auto-generated catch block
	new ErrMsg("There is some error occured while reading from ");
}
	}
	public void control()
	{
		super.control();
		da.getBtnDelete().addActionListener((a)->{
			if(da.getTfAccId().getText().trim().length()==0)
			{
				new WarMsg("Please Enter ");
			}
			else
			{
				long accntno=Long.parseLong(da.getTfAccId().getText());
				for(int i=0;i<svacc.size();i++)
				{
					if(svacc.get(i).getAccountid()==accntno)
					{
						svacc.remove(i);
						Count++;
					}
				}
				if(Count==0)
				{
					new ErrMsg("Sorry There is No Such Account No");
				}
				try {
					AccountReaderWritter.writter(svacc);
					new InfMsg("Account Successfully Deleted");
					AccountantHome ahm=new AccountantHome("iBanking");
					new AccountantHomeContrl(ahm).control();
					da.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					new ErrMsg("Unable Delete The Account");
					da.dispose();
				}
			}
		});
	}
}
