package bank.controller;

import bank.view.*;

public class HelpController {
	private Help hp;

	public HelpController(Help hp) {
		
		this.hp = hp;
	}
	public void control()
	{
		hp.getBtnBack().addActionListener((a)->{
			SecndPage sp=new SecndPage("iBanking");
			new SndPgController(sp).control();
			hp.dispose();
		});
	}
}
