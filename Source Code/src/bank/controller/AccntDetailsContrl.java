package bank.controller;
import bank.view.*;
import bank.model.*;
import prj.*;

import javax.swing.*;

import java.awt.event.KeyEvent;









import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class AccntDetailsContrl
{
	private AccntDetails acdt;
	private int sh=0,i;
	private JTable jtbl;
	private String [] head2={"AccountNo","AccountHolder's UID","AccountHolder's Name","Account Type","Balance"};
	private String [][] data2;
	private int sha,ka;
	private ArrayList<Savings_Account> dat;
	private ArrayList<Savings_Account> acc;
	public AccntDetailsContrl(AccntDetails acdt) {
		this.acdt = acdt;
		try {
			dat=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			new ErrMsg("File Not Found in Location");
		} catch (IOException e) {
			new ErrMsg("Error Occured While Reading Account Details");
		}
		sha=dat.size();
		data2=new String [sha][5];
	}
	public void control()
	{
		acdt.getB1().addActionListener((a)->{
			CreatAccnt cracc=new CreatAccnt("iBanking");
			new AccntCreatCntrl(cracc).control();
			acdt.dispose();
		});
		acdt.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccntDetails ad=new AccntDetails("iBanking");
				new AccntDetailsContrl(ad).control();
				acdt.dispose();
				//account details
			}
		});
		acdt.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//Deposit money
				AccountDeposite acdep=new AccountDeposite("iBanking");
				new AccntDepositeCntrl(acdep, acdep).control();
				acdt.dispose();
			}
		});
		acdt.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//withdraw money
				AccountWithdraw acwt=new AccountWithdraw("iBanking");
				new AccntWithdrawCntrl(acwt,acwt).control();
				acdt.dispose();
			}
		});
		acdt.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//transfer money
				AccTransferMoney actfm=new AccTransferMoney("iBanking");
				new AccntTransferCntrl(actfm).control();
				acdt.dispose();
			}
		});
		acdt.getL5().addMouseListener(new MouseAdapter() {
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
					acdt.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in This Bank");
				}
			}
		});
		acdt.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//log out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				acdt.dispose();
			}
		});
		acdt.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
								//Transaction details
				AccntTrans act=new AccntTrans("iBanking");
				new AccTransCntrl(act).control();
				acdt.dispose();
			}
		});
		acdt.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//edit account
				AccntEdit aced=new AccntEdit("iBanking");
				new AccntEditCntrl(aced).control();
				acdt.dispose();
			}
		});
		acdt.getL10().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//delete account
				DeleteAccount del=new DeleteAccount("iBanking");
				new DelAccntCntrl(del, del).control();
				acdt.dispose();
			}
		});

		
		
		
		
		
		acdt.getBtnSrch().addActionListener((a)->{
			if(acdt.getTfAccId().getText().trim().length()==0)
			{
				new ErrMsg("Please Enter The Account No");
			}
			else
			{
			long accno=Long.parseLong(acdt.getTfAccId().getText().trim());
			
			try {
				acc=(ArrayList<Savings_Account>)AccountReaderWritter.read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				new ErrMsg("There is a Problem While Reading from File");
			}
			for(i=0;i<acc.size();i++)
			{
				if(acc.get(i).getAccountid()==accno)
				{
					view();
					acdt.getLblUid().setText(acc.get(i).getUid());
					acdt.getLblHldrNm().setText(acc.get(i).getHoldername());
					acdt.getLbltype().setText(acc.get(i).getType());
					acdt.getLblBal().setText(Double.toString(acc.get(i).getBalance()));
					if(acc.get(i).getType().equals("Current Account"))
					{
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
				new ErrMsg("There is No Such Account");
			}
		}});
		acdt.getTfAccId().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent a) {
				// TODO Auto-generated method stub
				char key=a.getKeyChar();
				if(!(Character.isDigit(key))||(key==KeyEvent.VK_BACK_SPACE)||(key==KeyEvent.VK_DELETE))
				{
					a.consume();
				}
			}
		});
	}
	public int getI() {
		return i;
	}
	public Savings_Account getAcc()
	{
		return acc.get(i);
	}
	public void view()
	{
		acdt.getLblBal2().setText("Available Balance:-");
		acdt.getLblHldrNm2().setText("Account Holder's Name:-");
		acdt.getLbltype2().setText("Account Type:-");
		acdt.getLblUid2().setText("Account Holder's UID:-");
	}
	public void clear()
	{
		acdt.getTfAccId().setText("");
		acdt.getLblBal().setText("");
		acdt.getLblBal2().setText("");
		acdt.getLblHldrNm().setText("");
		acdt.getLblHldrNm2().setText("");
		acdt.getLblMinBl().setText("");
		acdt.getLblMinBl2().setText("");
		acdt.getLbltype().setText("");
		acdt.getLbltype2().setText("");
	}
}
