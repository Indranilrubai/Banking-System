package bank.controller;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import bank.view.*;
import bank.model.*;
import prj.*;
public class AccountantHomeContrl {
	private AccountantHome acthm;
	private JTable jtbl;
	private String [] head2={"AccountNo","AccountHolder's UID","AccountHolder's Name","Account Type","Balance"};
	private String [][] data2;
	private int sha,ka;
	private AccntDetails ad;
	private ArrayList<Savings_Account> dat;
	public AccountantHomeContrl(AccountantHome acthm) {
		this.acthm = acthm;
		try {
			dat=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("File Not Found in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Error Occured While Reading Account Details");
		}
		sha=dat.size();
		data2=new String [sha][5];
	}
	public void control()
	{
		acthm.getB1().addActionListener((a)->{
			CreatAccnt cracc=new CreatAccnt("iBanking");
			new AccntCreatCntrl(cracc).control();
			acthm.dispose();
		});
		acthm.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccntDetails ad=new AccntDetails("iBanking");
				new AccntDetailsContrl(ad).control();
				acthm.dispose();
				//account details
			}
		});
		acthm.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//deposite money
				AccountDeposite acdep=new AccountDeposite("iBanking");
				new AccntDepositeCntrl(acdep, acdep).control();
				acthm.dispose();
			}
		});
		acthm.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//withdraw money
				AccountWithdraw acwt=new AccountWithdraw("iBanking");
				new AccntWithdrawCntrl(acwt,acwt).control();
				acthm.dispose();
			}
		});
		acthm.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//transfer money
				AccTransferMoney actfm=new AccTransferMoney("iBanking");
				new AccntTransferCntrl(actfm).control();
				acthm.dispose();
			}
		});
		acthm.getL5().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//see all account
				if(sha>0)
				{
					for(ka=0;ka<sha;ka++)
					{
						data2[ka][0]=Long.toString(dat.get(ka).getAccountid());
						data2[ka][1]=dat.get(ka).getUid();
						data2[ka][2]=dat.get(ka).getHoldername();
						data2[ka][3]=dat.get(ka).getType();
						data2[ka][4]=Double.toString(dat.get(ka).getBalance());
					}
					jtbl=new JTable(data2,head2);
					AccntTableVew atbv=new AccntTableVew("iBanking", jtbl);
					new AccntTableViewCntrl(atbv).control();
					atbv.getLbl().setText("Showing All The Accounts of This Bank");
					acthm.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in This Bank");
				}
			}
		});
		acthm.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//log out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				acthm.dispose();
			}
		});
		acthm.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
								//transction details
				AccntTrans act=new AccntTrans("iBanking");
				new AccTransCntrl(act).control();
				acthm.dispose();
			}
		});
		acthm.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//edit account
				AccntEdit aced=new AccntEdit("iBanking");
				new AccntEditCntrl(aced).control();
				acthm.dispose();
			}
		});
		acthm.getL10().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//delete account
				DeleteAccount del=new DeleteAccount("iBanking");
				new DelAccntCntrl(del, del).control();
				acthm.dispose();
			}
		});
	}
}
