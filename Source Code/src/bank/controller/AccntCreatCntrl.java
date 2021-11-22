package bank.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

import prj.*;
import bank.model.*;
import bank.view.*;

public class AccntCreatCntrl
{
	private JTable jtbl;
	private String [] head2={"AccountNo","AccountHolder's UID","AccountHolder's Name","Account Type","Balance"};
	private String [][] data2;
	private int sha,ka;
	private AccntDetails ad;
	private ArrayList<Savings_Account> dat;
	
	private CreatAccnt cacc;
	private Date dt=new Date();
	private String abc,acno;
	private ArrayList<Savings_Account> sacc=new ArrayList<Savings_Account>();
	private ArrayList<Customer> cust=new ArrayList<Customer>();
	private int ht;
	private String [] uida;
	public AccntCreatCntrl( CreatAccnt cacc) {
		this.cacc = cacc;
		try {
			sacc=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("File Not Found in its Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Error occured while Reading The Account Details");
		}
		try {
			cust=CustomerReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("File Not Found in its Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Error occured while Reading The Customer Details");
		}
		int j=cust.size();
		uida=new String[j];
		for(int i=0;i<j;i++)
		{
			uida[i]=cust.get(i).getUid();
		}
		ht=sacc.size()+1;
		abc=new SimpleDateFormat("ddMMyy").format(dt);
		acno=abc+Integer.toString(ht);
		
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
		cacc.getB1().addActionListener((a)->{
			CreatAccnt cracc=new CreatAccnt("iBanking");
			new AccntCreatCntrl(cracc).control();
			cacc.dispose();
		});
		cacc.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccntDetails ad=new AccntDetails("iBanking");
				new AccntDetailsContrl(ad).control();
				cacc.dispose();
				//account details
			}
		});
		cacc.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//Deposit money
				AccountDeposite acdep=new AccountDeposite("iBanking");
				new AccntDepositeCntrl(acdep, acdep).control();
				cacc.dispose();
			}
		});
		cacc.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//withdraw money
				AccountWithdraw acwt=new AccountWithdraw("iBanking");
				new AccntWithdrawCntrl(acwt,acwt).control();
				cacc.dispose();
			}
		});
		cacc.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//transfer money
				AccTransferMoney actfm=new AccTransferMoney("iBanking");
				new AccntTransferCntrl(actfm).control();
				cacc.dispose();
			}
		});
		cacc.getL5().addMouseListener(new MouseAdapter() {
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
					cacc.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in This Bank");
				}
			}
		});
		cacc.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//log out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				cacc.dispose();
			}
		});
		cacc.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
								//Transaction details
				AccntTrans act=new AccntTrans("iBanking");
				new AccTransCntrl(act).control();
				cacc.dispose();
			}
		});
		cacc.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//edit account
				AccntEdit aced=new AccntEdit("iBanking");
				new AccntEditCntrl(aced).control();
				cacc.dispose();
			}
		});
		cacc.getL10().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//delete account
				DeleteAccount del=new DeleteAccount("iBanking");
				new DelAccntCntrl(del, del).control();
				cacc.dispose();
			}
		});

		
		
		
		
		
		cacc.getBtnSaving().addActionListener((a)->{
			CreatAccntM cam=new CreatAccntM("iBanking",uida);
			new CreatAccntMnCntrl(cam).control();
			cam.getJcb().setSelectedItem("Savings Account");
			cam.getLblAccn().setText(acno);
			cam.getLbMin2().setText("Enter The Minimum Balance");
			cacc.dispose();
		});
		cacc.getBtnCurrent().addActionListener((a)->{
			CreatAccntM cam=new CreatAccntM("iBanking",uida);
			new CreatAccntMnCntrl(cam).control();
			cam.getJcb().setSelectedItem("Current Account");
			cam.getLblAccn().setText(acno);
			cam.getLbMin2().setText("Enter The Overdraft Limit of this Account");
			cacc.dispose();
		});
	}
}
