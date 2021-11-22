package bank.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;

import prj.AccountReaderWritter;
import prj.CustomerReaderWritter;
import prj.TempReaderWriter;
import bank.model.Customer;
import bank.model.Savings_Account;
import bank.view.*;

public class UserChangePassCntrl {
	private UserChangePasswrd ucp;
	private int jhcnt=0;
	private JTable jtb;
	private String matchUid;
	private String [] head2={"AccountNo","Account Holder's UID","Account Holder's Name","Account Type","Balance"};
	private String [][] data2;
	private String [] data;
	private int sha=0,ka,cntfr1=0,cntfr2=0;
	private ArrayList<Savings_Account> dat;
	private ArrayList<Customer> cus;
	public UserChangePassCntrl(UserChangePasswrd ucp) {
		
		this.ucp = ucp;
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
	}
	public void control()
	{
		ucp.getBtnOK().addActionListener((a)->{
			if(new String(ucp.getPsold().getPassword()).trim().length()==0)
			{
				new WarMsg("Please Enter The Old Password");
			}
			else if(new String(ucp.getPsnew().getPassword()).trim().length()==0)
			{
				new WarMsg("Please Enter Your New Password");
			}
			else if(new String(ucp.getPscfm().getPassword()).trim().length()==0)
			{
				new WarMsg("You Have To Confirm Your Password");
			}
			else if(new String(ucp.getPsnew().getPassword()).trim().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!&]).{6,20})")==true)
			{
				String uid=matchUid;
				String pass=new String(ucp.getPsold().getPassword()).trim();
				String newpass=new String(ucp.getPsnew().getPassword()).trim();
				for(int y=0;y<cus.size();y++)
				{
					if(cus.get(y).getUid().trim().equals(uid) && cus.get(y).getPassword().trim().equals(pass))
					{
						cus.get(y).setPassword(newpass);
						jhcnt++;
					}
				}
				if(jhcnt==0)
				{
					new ErrMsg("Sorry You Have Entered Your Previous Password Wrong");
				}
				try {
					CustomerReaderWritter.write(cus);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					new ErrMsg("Sorry Unable To Change The Password");
				}
			}
			else
			{
				new ErrMsg("Your New Password Is In Wrong Format Please Follow Previous Format");
			}
		});
ucp.getB1().addActionListener((a)->{
			
		});
		ucp.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Account Data
				if(sha>0)
				{
					UsrAccntData uad=new UsrAccntData("iBanking", data);
					new UsrAccntDataCntrl(uad).control();
					ucp.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ucp.getL2().addMouseListener(new MouseAdapter() {
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
					ucp.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ucp.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transfer Money
				if(sha>0)
				{
					UserTransferMn utfm=new UserTransferMn("iBanking", data);
					new UsrTransfrMnyCntrl(utfm).control();
					ucp.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ucp.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transaction Details
				if(sha>0)
				{
					UsrTransctnDetls utsd=new UsrTransctnDetls("iBanking", data);
					new UsrTransctnCntrl(utsd).control();
					ucp.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ucp.getL9().addMouseListener(new MouseAdapter() {
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
				ucp.dispose();
			}
		});
		ucp.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Log Out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				ucp.dispose();
				new InfMsg("ThankYou For Banking With Us");
			}
		});
		
		ucp.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				UserChangePasswrd ucp=new UserChangePasswrd("iBanking");
				new UserChangePassCntrl(ucp).control();
				ucp.dispose();
			}
		});
	}
}
