import java.io.*;
import java.util.*;
import java.net.*;  
public class Client 
{  
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String msg="";
		System.out.println("Enter the server u want to send to");
		String ser=sc.nextLine();
		Socket s=new Socket(ser,8080);  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		DataInputStream din = new DataInputStream(s.getInputStream());
		while(!msg.equalsIgnoreCase("over"))
		{
			System.out.print("<-");
			msg=sc.nextLine();
			if(msg.equalsIgnoreCase("over"))break;
			dout.writeUTF(msg);  
			System.out.println("->"+(String)din.readUTF());
			dout.flush();
		}  
		dout.close();
		din.close();  
		s.close();  
	} 
}  
  