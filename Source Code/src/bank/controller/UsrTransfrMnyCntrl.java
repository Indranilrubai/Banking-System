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
import prj.CustomerReaderWritter;
import prj.TempReaderWriter;
import bank.model.Customer;
import bank.model.Savings_Account;
import bank.view.*;

public class UsrTransfrMnyCntrl {
	private UserTransferMn utfm;
	
	private JTable jtb;
	private String matchUid;
	private String [] head2={"AccountNo","Account Holder's UID","Account Holder's Name","Account Type","Balance"};
	private String [][] data2;
	private String [] data;
	private int sha=0,ka,cntfr1=0,cntfr2=0;
	private ArrayList<Savings_Account> dat;
	private ArrayList<Customer> cus;
	
	private ArrayList<Savings_Account> accs=new ArrayList<Savings_Account>();
	private int cnt=0,cnt1=0;
	public UsrTransfrMnyCntrl(UserTransferMn utfm) {
		this.utfm = utfm;
		
		try {
			dat=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("File Not Found in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Error Occured While Reading Account Details");
		}
		try {
			matchUid=TempReaderWriter.read();
			matchUid=matchUid.trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new ErrMsg("Error Occured While Reading Customer Details");
		}
		for(int h=0;h<dat.size();h++)
		{
			if(dat.get(h).getUid().equals(matchUid))
			{
				sha++;
			}
		}
		data=new String[sha];
		for(int h=0;h<dat.size();h++)
		{
			if(dat.get(h).getUid().equals(matchUid))
			{
				data[cntfr1]=Long.toString(dat.get(h).getAccountid());
				cntfr1++;
			}
		}
		data2=new String[sha][5];
		try {
			cus=CustomerReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("File Not Found in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Error Occured While Reading Customer Details");
		}
	
		
		try {
			accs=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("The File not Found in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("There are some problem with the Reading of the File");
		}
	}
	public void control()
	{
		
utfm.getB1().addActionListener((a)->{
			
		});
		utfm.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Account Data
				if(sha>0)
				{
					UsrAccntData uad=new UsrAccntData("iBanking", data);
					new UsrAccntDataCntrl(uad).control();
					utfm.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		utfm.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				UserChangePasswrd ucp=new UserChangePasswrd("iBanking");
				new UserChangePassCntrl(ucp).control();
				utfm.dispose();
			}
		});
		utfm.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//See All Account
				if(sha>0)
				{
					for(ka=0;ka<dat.size();ka++)
					{
						if(dat.get(ka).getUid().equals(matchUid))
						{
							data2[cntfr2][0]=Long.toString(dat.get(ka).getAccountid());
							data2[cntfr2][1]=dat.get(ka).getUid();
							data2[cntfr2][2]=dat.get(ka).getHoldername();
							data2[cntfr2][3]=dat.get(ka).getType();
							data2[cntfr2][4]=Double.toString(dat.get(ka).getBalance());
							cntfr2++;
						}
					}
					jtb=new JTable(data2,head2);
					UserTabl atbv=new UserTabl("iBanking", jtb);
					new UserTableCntrl(atbv).control();
					atbv.getLbl().setText("Showing All The Accounts of This User");
					utfm.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		utfm.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transfer Money
				if(sha>0)
				{
					UserTransferMn utfm=new UserTransferMn("iBanking", data);
					new UsrTransfrMnyCntrl(utfm).control();
					utfm.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		utfm.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transaction Details
				if(sha>0)
				{
					UsrTransctnDetls utsd=new UsrTransctnDetls("iBanking", data);
					new UsrTransctnCntrl(utsd).control();
					utfm.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		utfm.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Edit Your Details
				UserEditDetails usedd=new UserEditDetails("iBanking");
				new UsrEditCntrl(usedd).control();
				for(int u=0;u<cus.size();u++)
				{
					if(cus.get(u).getUid().equals(matchUid))
					{
						usedd.getLblUid().setText(cus.get(u).getUid());
						usedd.getLblGender().setText(cus.get(u).getGender());
						usedd.getTfAddres().setText(cus.get(u).getAddress());
						usedd.getTfDob().setText(cus.get(u).getDob());
						usedd.getTfEmail().setText(cus.get(u).getEmailid());
						usedd.getTfName().setText(cus.get(u).getName());
						usedd.getTfPhno().setText(cus.get(u).getPhno());
						usedd.getTfPin().setText(cus.get(u).getPinno());
					}
				}
				utfm.dispose();
			}
		});
		utfm.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Log Out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				utfm.dispose();
				new InfMsg("ThankYou For Banking With Us");
			}
		});

		
		utfm.getTf1().addKeyListener(new KeyAdapter() {
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
		utfm.getBtnTransf().addActionListener((a)->{
			if(utfm.getTf1().getText().trim().length()==0)
			{
				new WarMsg("Please Enter The Reciever's Account No:-");
			}
			else
			{
				long ano1=Long.parseLong(utfm.getTf1().getText().trim());
				for(int i=0;i<accs.size();i++)
				{
					if(accs.get(i).getAccountid()==ano1)
					{
						cnt1++;
						long ano=Long.parseLong(utfm.getJcb().getSelectedItem().toString().trim());
						for(int j=0;j<accs.size();j++)
						{
							if(accs.get(j).getAccountid()==ano)
							{
								double amt=Double.parseDouble(utfm.getTf3().getText().trim());
								if(accs.get(j).getType().equals("Savings Account"))
								{
									try {
										accs.get(j).acctrnsfer(accs.get(i), amt);
										JOptionPane.showMessageDialog(null, "The Balance Successfully Transfered", "Information",JOptionPane.INFORMATION_MESSAGE);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										new ErrMsg("Insufficient Balance in Your's Account");
									}
								}
								else if(accs.get(j).getType().equals("Current Account"))
								{
									try {
										accs.get(j).curAcctrnsfer(accs.get(i), amt);
										JOptionPane.showMessageDialog(null, "The Balance Successfully Transfered", "Information",JOptionPane.INFORMATION_MESSAGE);
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
							new ErrMsg("The Sender's Account No is not Valid");
						}
					}
				}
				if(cnt1==0)
				{
					new ErrMsg("The Reciever's Account No is not Valid");
				}
				try {
					AccountReaderWritter.writter(accs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					new ErrMsg("Can't Transfer The Amount");
				}
			}
		});

	}
}
