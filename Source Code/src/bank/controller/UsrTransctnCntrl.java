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
import bank.model.Trans;
import bank.view.AccntTableVew;
import bank.view.ErrMsg;
import bank.view.InfMsg;
import bank.view.SecndPage;
import bank.view.UserChangePasswrd;
import bank.view.UserEditDetails;
import bank.view.UserHome;
import bank.view.UserTabl;
import bank.view.UserTransferMn;
import bank.view.UsrAccntData;
import bank.view.UsrTransctnDetls;

public class UsrTransctnCntrl{
	private UsrTransctnDetls ustsd;
	
	private JTable jtb;
	private String matchUid;
	private String [] head2={"AccountNo","Account Holder's UID","Account Holder's Name","Account Type","Balance"};
	private String [][] data2;
	private String [] data;
	private int sha=0,ka,cntfr1=0,cntfr2=0;
	private ArrayList<Savings_Account> dat;
	private ArrayList<Customer> cus;
	
	private int sh=0;
	public UsrTransctnCntrl(UsrTransctnDetls ustsd) {
		
		this.ustsd = ustsd;
		
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
		
		
ustsd.getB1().addActionListener((a)->{
			
		});
		ustsd.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Account Data
				if(sha>0)
				{
					UsrAccntData uad=new UsrAccntData("iBanking", data);
					new UsrAccntDataCntrl(uad).control();
					ustsd.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ustsd.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				UserChangePasswrd ucp=new UserChangePasswrd("iBanking");
				new UserChangePassCntrl(ucp).control();
				ustsd.dispose();
			}
		});
		ustsd.getL2().addMouseListener(new MouseAdapter() {
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
					ustsd.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ustsd.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transfer Money
				if(sha>0)
				{
					UserTransferMn utfm=new UserTransferMn("iBanking", data);
					new UsrTransfrMnyCntrl(utfm).control();
					ustsd.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ustsd.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Transaction Details
				if(sha>0)
				{
					UsrTransctnDetls utsd=new UsrTransctnDetls("iBanking", data);
					new UsrTransctnCntrl(utsd).control();
					ustsd.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in Opened for this User");
				}
			}
		});
		ustsd.getL9().addMouseListener(new MouseAdapter() {
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
				ustsd.dispose();
			}
		});
		ustsd.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Log Out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				ustsd.dispose();
				new InfMsg("ThankYou For Banking With Us");
			}
		});

		
		ustsd.getBtnTransctn().addActionListener((a)->{
			if(ustsd.getJcmacc().getSelectedItem().toString().trim().length()==0)
			{
				new ErrMsg("Please Enter Account No");
			}
			else
			{
				long accno=Long.parseLong(ustsd.getJcmacc().getSelectedItem().toString().trim());
				ArrayList<Savings_Account> acc=new ArrayList<Savings_Account>();
				try {
					acc=(ArrayList<Savings_Account>)AccountReaderWritter.read();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					new ErrMsg("There is a Problem While Reading from File");
				}
				for(int i=0;i<acc.size();i++)
				{
					if(acc.get(i).getAccountid()==accno)
					{
						ArrayList<Trans> trns=new ArrayList<Trans>();
						trns=acc.get(i).getTrn();
						int j=trns.size();
						String [][] data=new String[j][5];
						String [] head={"Type of Transactions","Date","Time","Amount Dep./WtDrw.","Available Balance"};
						for(int k=0;k<j;k++)
						{
							data[k][0]=trns.get(k).getType();
							data[k][1]=trns.get(k).getDt();
							data[k][2]=trns.get(k).getTi();
							data[k][3]=Double.toString(trns.get(k).getAmt());
							data[k][4]=Double.toString(trns.get(k).getBal());
						}
						JTable jt=new JTable(data,head);
						jt.getColumnModel().getColumn(0).setPreferredWidth(200);
						UserTabl atv=new UserTabl("iBanking", jt);
						new UserTableCntrl(atv).control();
						ustsd.dispose();
						atv.setVisible(true);
						if(acc.get(i).getType().equals("Savings Account"))
						{
							atv.getLbl().setText("Showing Transaction Details of Savings Account:-"+acc.get(i).getAccountid());
						}
						else
						{
							atv.getLbl().setText("Showing Transaction Details of Current Account:-"+acc.get(i).getAccountid());
							if(acc.get(i).getBalance()<0)
							{
								JOptionPane.showMessageDialog(null, "The Balance Shows in Negetive Fig. that amount is already OverDrafted", "Information",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						sh++;
						break;
					}
				}
				if(sh==0)
				{
					new ErrMsg("No Such Record Found");
				}
			}
		});
	}
}
