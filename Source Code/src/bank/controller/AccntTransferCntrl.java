package bank.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
















import javax.swing.JOptionPane;




import javax.swing.JTable;

import prj.AccountReaderWritter;
import bank.model.*;
import bank.view.*;

public class AccntTransferCntrl
{
	private AccTransferMoney actnfm;
	
	private JTable jtbl;
	private String [] head2={"AccountNo","AccountHolder's UID","AccountHolder's Name","Account Type","Balance"};
	private String [][] data2;
	private int sha,ka;
	private AccntDetails ad;
	private ArrayList<Savings_Account> dat;
	
	private ArrayList<Savings_Account> accs;
	private int cnt=0,cnt1=0;
	public AccntTransferCntrl(AccTransferMoney actnfm) {
		this.actnfm = actnfm;
		try {
			accs=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("The File not Found in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("There are some problem with the Reading of the File");
		}
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
		actnfm.getB1().addActionListener((a)->{
			CreatAccnt cracc=new CreatAccnt("iBanking");
			new AccntCreatCntrl(cracc).control();
			actnfm.dispose();
		});
		actnfm.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccntDetails ad=new AccntDetails("iBanking");
				new AccntDetailsContrl(ad).control();
				actnfm.dispose();
				//account details
			}
		});
		actnfm.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//deposite money
				AccountDeposite acdep=new AccountDeposite("iBanking");
				new AccntDepositeCntrl(acdep, acdep).control();
				actnfm.dispose();
			}
		});
		actnfm.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//withdraw money
				AccountWithdraw acwt=new AccountWithdraw("iBanking");
				new AccntWithdrawCntrl(acwt,acwt).control();
				actnfm.dispose();
			}
		});
		actnfm.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//transfer money
				AccTransferMoney actfm=new AccTransferMoney("iBanking");
				new AccntTransferCntrl(actfm).control();
				actnfm.dispose();
			}
		});
		actnfm.getL5().addMouseListener(new MouseAdapter() {
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
					actnfm.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in This Bank");
				}
			}
		});
		actnfm.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//log out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				actnfm.dispose();
			}
		});
		actnfm.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
								//transction details
				AccntTrans act=new AccntTrans("iBanking");
				new AccTransCntrl(act).control();
				actnfm.dispose();
			}
		});
		actnfm.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//edit account
				AccntEdit aced=new AccntEdit("iBanking");
				new AccntEditCntrl(aced).control();
				actnfm.dispose();
			}
		});
		actnfm.getL10().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//delete account
				DeleteAccount del=new DeleteAccount("iBanking");
				new DelAccntCntrl(del, del).control();
				actnfm.dispose();
			}
		});
		
		
		
		
		
		actnfm.getTf1().addKeyListener(new KeyAdapter() {
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
		actnfm.getTf2().addKeyListener(new KeyAdapter() {
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
		actnfm.getBtnTrans().addActionListener((a)->{
			if(actnfm.getTf1().getText().trim().length()==0)
			{
				new WarMsg("Please Enter The Sender's Account No:-");
			}
			else if(actnfm.getTf2().getText().trim().length()==0)
			{
				new WarMsg("Please Enter The Receiver's Account No:-");
			}
			else if(actnfm.getTf3().getText().trim().length()==0)
			{
				new WarMsg("Please Enter The Amount");
			}
			else
			{
				long ano1=Long.parseLong(actnfm.getTf2().getText().trim());
				for(int i=0;i<accs.size();i++)
				{
					if(accs.get(i).getAccountid()==ano1)
					{
						cnt1++;
						long ano=Long.parseLong(actnfm.getTf1().getText().trim());
						for(int j=0;j<accs.size();j++)
						{
							if(accs.get(j).getAccountid()==ano)
							{
								double amt=Double.parseDouble(actnfm.getTf3().getText().trim());
								if(accs.get(j).getType().equals("Savings Account"))
								{
									try {
										accs.get(j).acctrnsfer(accs.get(i), amt);
										JOptionPane.showMessageDialog(null, "Balance Successfully Transferred", "Information",JOptionPane.INFORMATION_MESSAGE);
										new InfMsg("Sender's New Balance :-"+Double.toString(accs.get(j).getBalance()));
										clear();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										new ErrMsg("Insufficient Balance in Sender's Account");
									}
								}
								else if(accs.get(j).getType().equals("Current Account"))
								{
									try {
										accs.get(j).curAcctrnsfer(accs.get(i), amt);
										JOptionPane.showMessageDialog(null, "The Balance Successfully Transfered", "Information",JOptionPane.INFORMATION_MESSAGE);
										new InfMsg("Sender's New Balance :-"+Double.toString(accs.get(j).getBalance()));
										clear();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										new ErrMsg("Insufficient Balance in Sender's Account");
									}
								}
								cnt++;
							}
						}
						if(cnt==0)
						{
							new ErrMsg("The Sender's Account No. Is Not Valid");
						}
						
					}
				}
				if(cnt1==0)
				{
					new ErrMsg("The Receiver's Account No. Is Not Valid");
				}
				try {
					AccountReaderWritter.writter(accs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					new ErrMsg("Can't Transfer The Money");
				}
			}
		});
	}
	public void clear()
	{
		actnfm.getTf1().setText("");
		actnfm.getTf2().setText("");
		actnfm.getTf3().setText("");
	}
}
