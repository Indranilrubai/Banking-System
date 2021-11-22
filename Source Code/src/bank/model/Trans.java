package bank.model;

import java.io.Serializable;


public class Trans implements Serializable
{
	private String type;
	private double amt;
	private double bal;
	private String dt,ti;
	public Trans(String type, double amt2, double d, String dt, String ti) {
		super();
		this.type = type;
		this.amt = amt2;
		this.bal = d;
		this.dt = dt;
		this.ti = ti;
	}
	public String getType() {
		return type;
	}
	public double getAmt() {
		return amt;
	}
	public double getBal() {
		return bal;
	}
	public String getDt() {
		return dt;
	}
	public String getTi() {
		return ti;
	}
	public String Details()
	{
		return type+"\t"+amt+"\t"+bal+"\t"+dt+"\t"+ti;
	}
}
