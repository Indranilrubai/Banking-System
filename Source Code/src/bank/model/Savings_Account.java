package bank.model;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import bank.controller.InsufficientBalanceException;
public class Savings_Account implements Serializable,Bank
{
	private long accountid;
	private String holdername;
	private String uid;
	private double balance;
	private String type;
	ArrayList<Trans> trn=new ArrayList<Trans>();
	private double minimum_amount;
	Date dt=new Date();
	public Savings_Account(long accountid, String holdername, String uid,double balance, String type, double minimum_amount) {
		this.accountid = accountid;
		this.holdername = holdername;
		this.uid = uid;
		this.balance = balance;
		this.type = type;
		this.minimum_amount = minimum_amount;
		DateFormat sh=DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat ti=DateFormat.getTimeInstance(DateFormat.MEDIUM);
		trn.add(new Trans("iBanking Welcomes You",0.0,balance,sh.format(dt),ti.format(dt)));
	}
	public void withdraw(double amt) throws Exception {
		// TODO Auto-generated method stub
		if(this.getBalance()-amt>=minimum_amount)
		{
			this.setBalance(this.getBalance()-amt);
			DateFormat sh=DateFormat.getDateInstance(DateFormat.MEDIUM);
			DateFormat ti=DateFormat.getTimeInstance(DateFormat.MEDIUM);
			this.trn.add(new Trans("Cash Withdraw",amt,this.getBalance(),sh.format(dt),ti.format(dt)));
		}
		else
		{
			throw new InsufficientBalanceException("Sorry Insufficient Balance");
		}
	}
	public void deposite(double amt) {
		this.setBalance(this.getBalance()+amt);
		DateFormat sh=DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat ti=DateFormat.getTimeInstance(DateFormat.MEDIUM);
		this.trn.add(new Trans("Cash Deposit",amt,this.getBalance(),sh.format(dt),ti.format(dt)));
	}
	 public void acctrnsfer(Savings_Account acc, double amt) throws Exception 
	{
		if(this.getBalance()-amt>=minimum_amount)
		{
			this.setBalance(this.getBalance()-amt);
			acc.setBalance(acc.getBalance()+amt);
			DateFormat sh=DateFormat.getDateInstance(DateFormat.MEDIUM);
			DateFormat ti=DateFormat.getTimeInstance(DateFormat.MEDIUM);
			this.trn.add(new Trans("Money Transfer to-->"+acc.getAccountid(),amt,this.getBalance(),sh.format(dt),ti.format(dt)));
			acc.trn.add(new Trans("Money Transfer form-->"+this.getAccountid(),amt,acc.getBalance(),sh.format(dt),ti.format(dt)));
		}
		else
		{
			throw new InsufficientBalanceException("Sorry Insufficient Balance");
		}
	}
	public double getMinimum_amount() 
	{
		return minimum_amount;
	}
	public void curWithdraw(double amt) throws Exception {
		// TODO Auto-generated method stub
		if(minimum_amount>=amt-this.getBalance())
		{
			this.setBalance(this.getBalance()-amt);
			DateFormat sh=DateFormat.getDateInstance(DateFormat.MEDIUM);
			DateFormat ti=DateFormat.getTimeInstance(DateFormat.MEDIUM);
			this.trn.add(new Trans("Cash Withdraw",amt,this.getBalance(),sh.format(dt),ti.format(dt)));
		}
		else
		{
			throw new InsufficientBalanceException("Sorry Insufficient Balance");
		}
	}
	public void curAcctrnsfer(Savings_Account acc, double amt) throws Exception {
		// TODO Auto-generated method stub
		if(minimum_amount>=amt-this.getBalance())
		{
			this.setBalance(this.getBalance()-amt);
			acc.setBalance(acc.getBalance()+amt);
			DateFormat sh=DateFormat.getDateInstance(DateFormat.MEDIUM);
			DateFormat ti=DateFormat.getTimeInstance(DateFormat.MEDIUM);
			this.trn.add(new Trans("Money Transfer to-->"+acc.getAccountid(),amt,this.getBalance(),sh.format(dt),ti.format(dt)));
			acc.trn.add(new Trans("Money Transfer form-->"+this.getAccountid(),amt,acc.getBalance(),sh.format(dt),ti.format(dt)));
		}
		else
		{
			throw new InsufficientBalanceException("Sorry Insufficient Balance");
		}
	}
	public void setMinimum_amount(double minimum_amount) {
		this.minimum_amount = minimum_amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccountid() {
		return accountid;
	}
	public String getHoldername() {
		return holdername;
	}
	public String getUid() {
		return uid;
	}
	public ArrayList<Trans> getTrn() {
		return trn;
	}
}