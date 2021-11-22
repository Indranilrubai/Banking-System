package bank.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


















import javax.swing.JTable;

import bank.model.*;
import bank.view.*;
import prj.*;
public class CreatAccntMnCntrl
{
	private CreatAccntM crm;
	
	private JTable jtbl;
	private String [] head2={"AccountNo","AccountHolder's UID","AccountHolder's Name","Account Type","Balance"};
	private String [][] data2;
	private int sha,ka;
	private AccntDetails ad;
	private ArrayList<Savings_Account> dat;
	
	private ArrayList<Savings_Account> cre;
	private ArrayList<Customer> cus;
	private int cnt1,cnt2;
	public CreatAccntMnCntrl(CreatAccntM crm) {
		this.crm = crm;
		try {
			cre=AccountReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Respective File Not Found in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("There is some Error Occurred while reading from file");
		}
		try {
			cus=CustomerReaderWritter.read();
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			new ErrMsg("Respective File Not Found in Location");
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			new ErrMsg("There is some Error Occurred while reading from file");
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
		
		crm.getB1().addActionListener((a)->{
			CreatAccnt cracc=new CreatAccnt("iBanking");
			new AccntCreatCntrl(cracc).control();
			crm.dispose();
		});
		crm.getL1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccntDetails ad=new AccntDetails("iBanking");
				new AccntDetailsContrl(ad).control();
				crm.dispose();
				//account details
			}
		});
		crm.getL2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//deposite money
				AccountDeposite acdep=new AccountDeposite("iBanking");
				new AccntDepositeCntrl(acdep, acdep).control();
				crm.dispose();
			}
		});
		crm.getL3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//withdraw money
				AccountWithdraw acwt=new AccountWithdraw("iBanking");
				new AccntWithdrawCntrl(acwt,acwt).control();
				crm.dispose();
			}
		});
		crm.getL4().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//transfer money
				AccTransferMoney actfm=new AccTransferMoney("iBanking");
				new AccntTransferCntrl(actfm).control();
				crm.dispose();
			}
		});
		crm.getL5().addMouseListener(new MouseAdapter() {
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
					crm.dispose();
				}
				else
				{
					new ErrMsg("Sorry There is No Account in This Bank");
				}
			}
		});
		crm.getL6().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//log out
				SecndPage snd=new SecndPage("iBanking");
				new SndPgController(snd).control();
				crm.dispose();
			}
		});
		crm.getL7().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
								//transction details
				AccntTrans act=new AccntTrans("iBanking");
				new AccTransCntrl(act).control();
				crm.dispose();
			}
		});
		crm.getL9().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//edit account
				AccntEdit aced=new AccntEdit("iBanking");
				new AccntEditCntrl(aced).control();
				crm.dispose();
			}
		});
		crm.getL10().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								//delete account
				DeleteAccount del=new DeleteAccount("iBanking");
				new DelAccntCntrl(del, del).control();
				crm.dispose();
			}
		});
		
		
		crm.getTfAmnt().addKeyListener(new KeyAdapter() {
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
		crm.getTfMinA().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent a) {
				// TODO Auto-generated method stub
				char key=a.getKeyChar();
				if(!(Character.isDigit(key))||(key==KeyEvent.VK_BACK_SPACE)||(key==KeyEvent.VK_DELETE))
				{
					a.consume();
				}
			}
		});
		crm.getUid().addActionListener((a)->{
			String uid=crm.getUid().getSelectedItem().toString();
			for(int h=0;h<cus.size();h++)
			{
				if(uid.equals(cus.get(h).getUid()))
				{
					crm.getLbHold().setText(cus.get(h).getName());
					cnt1++;
				}
			}
			if(cnt1==0)
			{
				new ErrMsg("User ID Not Found");
			}
		});
		crm.getJcb().addActionListener((a)->{
			crm.getTfAmnt().setText("");
			crm.getTfMinA().setText("");
		});
		crm.getJcb().addActionListener((a)->{
			String actype=crm.getJcb().getSelectedItem().toString();
			if(actype.equals("Savings Account"))
			{
				crm.getLbMin2().setText("Enter The Minimum Balance");
			}
			else if(actype.equals("Current Account"))
			{
				crm.getLbMin2().setText("Enter The Overdraft Limit of this Account");
			}
		});
		crm.getBtnCreate().addActionListener((a)->{
			
			if(crm.getTfAmnt().getText().trim().length()==0 || crm.getTfMinA().getText().trim().length()==0)
			{
				new WarMsg("Please Enter Amount And Minimum Balance");
			}
			else if(crm.getLbHold().getText().trim().length()==0)
			{
				new WarMsg("Please Select A UID");
			}
			else
			{
				long acid=Long.parseLong(crm.getLblAccn().getText());
				String hnm=crm.getLbHold().getText();
				double bal=Double.parseDouble(crm.getTfAmnt().getText().trim());
				String uid=crm.getUid().getSelectedItem().toString();
				String type=crm.getJcb().getSelectedItem().toString();
				double min=Double.parseDouble(crm.getTfMinA().getText().trim());
				cre.add(new Savings_Account(acid, hnm, uid, bal, type, min));
				try {					
					AccountReaderWritter.writter(cre);
					new InfMsg("Account Successfully Created");
					AccountantHome ahm=new AccountantHome("iBanking");
					new AccountantHomeContrl(ahm).control();
					crm.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					new ErrMsg("Can't Create the Account Some error Occured");
					AccountantHome ahm=new AccountantHome("iBanking");
					new AccountantHomeContrl(ahm).control();
					crm.dispose();
				}
			}
		});
	}
}
