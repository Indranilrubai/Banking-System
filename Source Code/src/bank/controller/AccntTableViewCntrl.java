package bank.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;

import prj.AccountReaderWritter;
import bank.model.Savings_Account;
import bank.view.*;

public class AccntTableViewCntrl
{
	private AccntTableVew actb;
	private JTable jtbl;
	private String [] head2={"AccountNo","AccountHolder's UID","AccountHolder's Name","Account Type","Balance"};
	private String [][] data2;
	private int sha,ka;
	private AccntDetails ad;
	private ArrayList<Savings_Account> dat;
	public AccntTableViewCntrl(AccntTableVew actb) {
		
		this.actb = actb;
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
		actb.getB1().addActionListener((a)->{
			CreatAccnt cracc=new CreatAccnt("iBanking");
			new AccntCreatCntrl(cracc).control();
			actb.dispose();
		});
		actb.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccntDetails ad=new AccntDetails("iBanking");
				new AccntDetailsContrl(ad).control();
				actb.dispose();
				//account details
			}
		});
		actb.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//deposite money
				AccountDeposite acdep=new AccountDeposite("iBanking");
				new AccntDepositeCntrl(acdep, acdep).control();
				actb.dispose();
			}
		});
		actb.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//withdraw money
				AccountWithdraw acwt=new AccountWithdraw("iBanking");
				new AccntWithdrawCntrl(acwt,acwt).control();
				actb.dispose();
			}
		});
		actb.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//transfer money
				AccTransferMoney actfm=new AccTransferMoney("iBanking");
				new AccntTransferCntrl(actfm).control();
				actb.dispose();
			}
		});
		actb.getL5().addMouseListener(new MouseAdapter() {
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
					actb.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in This Bank");
				}
			}
		});
		actb.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//log out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				actb.dispose();
			}
		});
		actb.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
								//transction details
				AccntTrans act=new AccntTrans("iBanking");
				new AccTransCntrl(act).control();
				actb.dispose();
			}
		});
		actb.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//edit account
				AccntEdit aced=new AccntEdit("iBanking");
				new AccntEditCntrl(aced).control();
				actb.dispose();
			}
		});
		actb.getL10().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//delete account
				DeleteAccount del=new DeleteAccount("iBanking");
				new DelAccntCntrl(del, del).control();
				actb.dispose();
			}
		});

	}
}
