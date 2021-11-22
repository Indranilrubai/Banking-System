package bank.controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import prj.CustomerReaderWritter;
import bank.model.Customer;
import bank.view.*;

public class UserRegCntrl{
	private UserReg ur;
	private ArrayList<Customer> cus;
	public UserRegCntrl(UserReg ur) {
		this.ur = ur;
		try {
			cus=CustomerReaderWritter.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("File Not Found In Location");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Some Error Occured While Reading From File");
		}
	}
	public void control()
	{
		ur.getBtnBack().addActionListener((a)->{
			SecndPage scn=new SecndPage("iBanking");
			new SndPgController(scn).control();
			ur.dispose();
		});
		ur.getBtnBack2().addActionListener((a)->{
			SecndPage scn=new SecndPage("iBanking");
			new SndPgController(scn).control();
			ur.dispose();
		});
		ur.getBtnRefrs().addActionListener((a)->{
			clear();
		});
		ur.getBtnPrs().addActionListener((a)->{
			if(ur.getTf1().getText().trim().length()<3)
			{
				new WarMsg("Please Enter Your Name");
			}
			else if(ur.getTa1().getText().trim().length()<5)
			{
				new WarMsg("Please Enter Your Address");
			}
			else if(ur.getTf2().getText().trim().length()<6)
			{
				new WarMsg("Please Enter Your Valid Pin No");
			}
			else if(ur.getTf3().getText().trim().length()<3)
			{
				new WarMsg("Please Enter Your Email Address");
			}
			else if(ur.getTf4().getText().trim().length()<8)
			{
				new WarMsg("Please Enter Your Phone No.");
			}
			
			else if(ur.getTf3().getText().trim().matches("[a-zA-Z0-9][\\w.]*@\\w+\\.[a-z]+\\.?[a-z]{2,}?"))
			{
				ur.getBtnRegister().setEnabled(true);
				ur.getBtnBack2().setEnabled(true);
				ur.getPswrd().setEditable(true);
				ur.getCnfpswrd().setEditable(true);
				ur.getTa1().setEditable(false);
				ur.getTf1().setEditable(false);
				ur.getTf2().setEditable(false);
				ur.getTf3().setEditable(false);
				ur.getTf4().setEditable(false);
				ur.getBtnBack().setEnabled(false);
				ur.getBtnPrs().setEnabled(false);
				ur.getBtnRefrs().setEnabled(false);
				String name=ur.getTf1().getText().trim();
				String phno=ur.getTf4().getText().trim();
				String email=ur.getTf3().getText().trim();
				String pin=ur.getTf2().getText().trim();
				int r=phno.length();
				String UID=name.substring(0, 2)+phno.substring(r-2,r)+email.substring(0,2)+pin.substring(0, 2);
				ur.getLbluid().setText(UID);
			}
			else
			{
				new ErrMsg("Your Email Id Is Not Valid");
			}
		});
		ur.getBtnRegister().addActionListener((a)->{
			
			
			if(new String(ur.getPswrd().getPassword()).trim().length()==0)
			{
				new WarMsg("Please Enter PassWord");
			}
			else if(new String(ur.getCnfpswrd().getPassword()).trim().length()==0)
			{
				new WarMsg("Please Confirm Your Password");
			}
			else if(new String(ur.getPswrd().getPassword()).trim().equals(new String(ur.getCnfpswrd().getPassword()).trim())==false)
			{
				new WarMsg("Please Make Sure Both Passwords are Same");
			}
			else if(new String(ur.getPswrd().getPassword()).trim().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!&]).{6,20})")==true)
			{
				String name=ur.getTf1().getText().trim();
				String address=ur.getTa1().getText().trim();
				String pin=ur.getTf2().getText().trim();
				String email=ur.getTf3().getText().trim();
				String phno=ur.getTf4().getText().trim();
				String dob=ur.getJdt().getSelectedItem().toString()+"-"+ur.getJmn().getSelectedItem().toString()+"-"+ur.getJyr().getSelectedItem().toString();
				String gen=ur.getBgrp().getSelection().getActionCommand();
				String UID=ur.getLbluid().getText().trim();
				String Pass=new String(ur.getPswrd().getPassword()).trim();
				cus.add(new Customer(UID, name, email, Pass, dob, phno, address, gen, pin));
				try {
					CustomerReaderWritter.write(cus);
					UserLogin ul=new UserLogin("iBanking");
					new UserLoginControl(ul).control();
					ur.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					new ErrMsg("Unable to Create The User Account");
				}
			}
			else
			{
				new ErrMsg("You Have Enter Password in Wrong Format");
			}
		});
		ur.getTf2().addKeyListener(new KeyAdapter() {
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
		ur.getTf4().addKeyListener(new KeyAdapter() {
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
	public void clear()
	{
		ur.getTa1().setText("");
		ur.getTf1().setText("");
		ur.getTf2().setText("");
		ur.getTf3().setText("");
		ur.getTf4().setText("");
	}
}