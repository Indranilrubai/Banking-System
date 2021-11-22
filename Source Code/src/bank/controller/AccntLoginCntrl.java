package bank.controller;

import bank.view.*;

public class AccntLoginCntrl {
	private AccntantLogIn acli;

	public AccntLoginCntrl(AccntantLogIn acli) {
		super();
		this.acli = acli;
	}
	public void control()
	{
		acli.getBtncncl().addActionListener((a)->{
			SecndPage sp=new SecndPage("iBanking");
			new SndPgController(sp).control();
			acli.dispose();
		});
		acli.getBtnlogin().addActionListener((a)->{
			if(acli.getTfID().getText().trim().length()==0)
			{
				new WarMsg("Enter Your User ID");
			}
			else if(new String(acli.getPs().getPassword()).trim().length()==0)
			{
				new WarMsg("Enter Your Password");
			}
			else
			{
				String uid=acli.getTfID().getText().trim();
				String pass=new String(acli.getPs().getPassword()).trim();
				if(uid.equals("Indranil") && pass.equals("Mukherjee"))
				{
					AccountantHome achm=new AccountantHome("iBanking");
					new AccountantHomeContrl(achm).control();
					acli.dispose();
				}
				else
				{
					new ErrMsg("Sorry You Have Entered Wrong Id and Password");
				}
			}
		});
	}
}
