package prj;
import java.io.*;
import java.util.ArrayList;

import bank.model.*;
import bank.view.*;
public class AccountReaderWritter {
	public static void writter(ArrayList<Savings_Account> accd) throws FileNotFoundException, IOException
	{
		ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("Account.dat"));
		obj.writeObject(accd);
		obj.close();
	}
	@SuppressWarnings({ "unchecked", "finally" })
	public static ArrayList<Savings_Account> read() throws FileNotFoundException, IOException
	{
		ObjectInputStream objinp=new ObjectInputStream(new FileInputStream("Account.dat"));
		ArrayList<Savings_Account> acc=new ArrayList<Savings_Account>();
		try {
			acc=(ArrayList<Savings_Account>)objinp.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			new ErrMsg("Class Not Found");
		}
		finally
		{
			objinp.close();
			return acc;
		}
	}
}
