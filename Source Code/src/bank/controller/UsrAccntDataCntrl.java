package bank.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;







import javax.swing.JTable;

import prj.*;
import bank.model.*;
import bank.view.*;

public class UsrAccntDataCntrl
{
	private UsrAccntData uad;
	
	private JTable jtb;
	private String matchUid;
	private String [] head2={"AccountNo","Account Holder's UID","Account Holder's Name","Account Type","Balance"};
	private String [][] data2;
	private String [] data;
	private int sha=0,ka,cntfr1=0,cntfr2=0;
	private ArrayList<Savings_Account> dat;
	private ArrayList<Customer> cus;
	
	private ArrayList<Savings_Account> sav=new ArrayList<Savings_Account>();
	private long ac;
	private int cnt=0;
	public UsrAccntDataCntrl(UsrAccntData uad) {
		this.uad = uad;
		
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
			sav=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("The File is Not Present in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("There is some Problem Occured while Reading data from File");
		}
	}
	public void control()
	{
		
uad.getB1().addActionListener((a)->{
			
		});
uad.getL3().addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		UserChangePasswrd ucp=new UserChangePasswrd("iBanking");
		new UserChangePassCntrl(ucp).control();
		uad.dispose();
	}
});
		uad.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Account Data
				if(sha>0)
				{
					UsrAccntData uad=new UsrAccntData("iBanking", data);
					new UsrAccntDataCntrl(uad).control();
					uad.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		uad.getL2().addMouseListener(new MouseAdapter() {
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
					uad.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		uad.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transfer Money
				if(sha>0)
				{
					UserTransferMn utfm=new UserTransferMn("iBanking", data);
					new UsrTransfrMnyCntrl(utfm).control();
					uad.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		uad.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transaction Details
				if(sha>0)
				{
					UsrTransctnDetls utsd=new UsrTransctnDetls("iBanking", data);
					new UsrTransctnCntrl(utsd).control();
					uad.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		uad.getL9().addMouseListener(new MouseAdapter() {
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
				uad.dispose();
			}
		});
		uad.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Log Out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				uad.dispose();
				new InfMsg("ThankYou For Banking With Us");
			}
		});

		
		uad.getJcmb().addActionListener((a)->{
			ac=Long.parseLong(uad.getJcmb().getSelectedItem().toString());
			for(int i=0;i<sav.size();i++)
			{
				if(sav.get(i).getAccountid()==ac)
				{
					uad.getLblHolUid().setText(sav.get(i).getUid());
					uad.getLblHolderNm().setText(sav.get(i).getHoldername());
					uad.getLblType().setText(sav.get(i).getType());
					uad.getLblBal().setText(Double.toString(sav.get(i).getBalance()));
					uad.getLblMinBal().setText(Double.toString(sav.get(i).getMinimum_amount()));
					cnt++;
				}
			}
			if(cnt==0)
			{
				new ErrMsg("There is No Such Account");
			}
		});
	}
}
