package bank.controller;

import bank.view.*;
public class SndPgController 
{
	private SecndPage sndpg;

	public SndPgController(SecndPage sndpg) {
		this.sndpg = sndpg;
	}
	public void control()
	{
		sndpg.getbAdmin().addActionListener((a)->{
			AccntantLogIn alc=new AccntantLogIn("iBanking");
			new AccntLoginCntrl(alc).control();
			sndpg.dispose();
		});
		sndpg.getbUser().addActionListener((a)->{
			UserLogin ul=new UserLogin("iBanking");
			new UserLoginControl(ul).control();
			sndpg.dispose();
		});
		sndpg.getBtnHelp().addActionListener((a)->{
			Help hp=new Help("iBanking");
			new HelpController(hp).control();
			sndpg.dispose();
		});
	}
}
