package bank.controller;

public class InsufficientBalanceException extends Exception
{
	private static final long serialVersionUID = 1L;//Not mandatory

	public InsufficientBalanceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
