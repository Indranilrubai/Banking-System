package bank.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;







import javax.swing.*;



import prj.*;
import bank.model.*;
import bank.view.*;
public class AccTransCntrl
{
	private JTable jtbl;
	private String [] head2={"AccountNo","AccountHolder's UID","AccountHolder's Name","Account Type","Balance"};
	private String [][] data2;
	private int sha,ka;
	private AccntDetails ad;
	private ArrayList<Savings_Account> dat;
	
	private AccntTrans actrns;
	private int sh=0;
	public AccTransCntrl( AccntTrans actrns) {
		this.actrns = actrns;
		
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
		
		
		actrns.getB1().addActionListener((a)->{
			CreatAccnt cracc=new CreatAccnt("iBanking");
			new AccntCreatCntrl(cracc).control();
			actrns.dispose();
		});
		actrns.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccntDetails ad=new AccntDetails("iBanking");
				new AccntDetailsContrl(ad).control();
				actrns.dispose();
				//account details
			}
		});
		actrns.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//deposite money
				AccountDeposite acdep=new AccountDeposite("iBanking");
				new AccntDepositeCntrl(acdep, acdep).control();
				actrns.dispose();
			}
		});
		actrns.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//withdraw money
				AccountWithdraw acwt=new AccountWithdraw("iBanking");
				new AccntWithdrawCntrl(acwt,acwt).control();
				actrns.dispose();
			}
		});
		actrns.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//transfer money
				AccTransferMoney actfm=new AccTransferMoney("iBanking");
				new AccntTransferCntrl(actfm).control();
				actrns.dispose();
			}
		});
		actrns.getL5().addMouseListener(new MouseAdapter() {
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
					actrns.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in This Bank");
				}
			}
		});
		actrns.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//log out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				actrns.dispose();
			}
		});
		actrns.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
								//transction details
				AccntTrans act=new AccntTrans("iBanking");
				new AccTransCntrl(act).control();
				actrns.dispose();
			}
		});
		actrns.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//edit account
				AccntEdit aced=new AccntEdit("iBanking");
				new AccntEditCntrl(aced).control();
				actrns.dispose();
			}
		});
		actrns.getL10().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//delete account
				DeleteAccount del=new DeleteAccount("iBanking");
				new DelAccntCntrl(del, del).control();
				actrns.dispose();
			}
		});
		
		actrns.getBtnSrch().addActionListener((a)->{
			if(actrns.getTf().getText().trim().length()==0)
			{
				new ErrMsg("Please Enter Account No");
			}
			else
			{
				long accno=Long.parseLong(actrns.getTf().getText().trim());
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
						AccntTableVew atv=new AccntTableVew("iBanking", jt);
						new AccntTableViewCntrl(atv).control();
						actrns.dispose();
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
								JOptionPane.showMessageDialog(null, "The Balance Shows in Negative Fig. that amount is already OverDrafted", "Information",JOptionPane.INFORMATION_MESSAGE);
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
		actrns.getTf().addKeyListener(new KeyAdapter() {
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
		
	}
}
