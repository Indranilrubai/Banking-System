package prj;

import java.io.*;

public class TempReaderWriter  
{
	public static void write(String a) throws IOException
	{
		BufferedWriter indranil=new BufferedWriter(new FileWriter("Indranil.dat"));
		indranil.write(a);
		indranil.close();
	}
	public static String read() throws Exception
	{
		BufferedReader indranil=new BufferedReader(new FileReader("Indranil.dat"));
		String a;
		a=indranil.readLine();
		indranil.close();
		return a;
	}
}
