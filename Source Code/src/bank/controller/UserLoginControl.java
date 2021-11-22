package bank.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;








import prj.CustomerReaderWritter;
import prj.TempReaderWriter;
import bank.model.*;
import bank.view.*;
public class UserLoginControl 
{
	private UserLogin usl;
	private ArrayList<Customer> cus=new ArrayList<Customer>();
	private int cnt=0,k;
	public UserLoginControl(UserLogin usl) {
		super();
		this.usl = usl;
		try {
			cus=CustomerReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Can't Find The File in Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("There is some Error Occured While Reading From File");
		}
		k=cus.size();
	}
	public void control()
	{
		usl.getBtnCreate().addActionListener((a)->{
			UserReg ur=new UserReg("indranil");
			new UserRegCntrl(ur).control();
			usl.dispose();
		});
		usl.getBtnLogin().addActionListener((a)->{
			
			if(usl.getTf1().getText().trim().length()==0)
			{
				new WarMsg("You Can Not Log In without Entering User ID");
			}
			else if(new String(usl.getPs().getPassword()).length()==0)
			{
				new WarMsg("You Can Not Log In without Entering Password");
			}
			else
			{
				String uid=usl.getTf1().getText().trim();
				String pass=new String(usl.getPs().getPassword());
				for(int i=0;i<k;i++)
				{
					if(cus.get(i).getUid().equals(uid) && cus.get(i).getPassword().equals(pass))
					{
						String ab=cus.get(i).getUid();
						try {
							TempReaderWriter.write(ab);
							UserHome uhm=new UserHome("iBanking");
							new UserHomeCntrl(uhm).control();
							usl.dispose();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							new ErrMsg("Some Error Occured While Loging In");
						}
						cnt++;
					}
				}
				if(cnt==0)
				{
					new ErrMsg("You Have Entered Wrong User Id or Password");
				}
			}
		});
	}
}
