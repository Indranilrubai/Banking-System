package prj;

import java.util.ArrayList;
import java.io.*;

import bank.model.*;
import bank.view.*;
public class CustomerReaderWritter {
	public static void write(ArrayList<Customer> cst) throws FileNotFoundException, IOException
	{
		ObjectOutputStream objout=new ObjectOutputStream(new FileOutputStream("Bank.dat"));
		objout.writeObject(cst);
		objout.close();
	}
	@SuppressWarnings({ "unchecked", "finally" })
	public static ArrayList<Customer> read() throws FileNotFoundException, IOException
	{
		ObjectInputStream objinp=new ObjectInputStream(new FileInputStream("Bank.dat"));
		ArrayList<Customer> cus=new ArrayList<Customer>();
		try {
			cus=(ArrayList<Customer>)objinp.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Class Not Found");
		}
		finally
		{
			objinp.close();
			return cus;
		}
	}
}
