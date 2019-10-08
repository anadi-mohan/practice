import java.io.*;
import java.util.*;
import java.net.*;
class Server
{
	public static void main(String args[])throws IOException
	{
		ServerSocket ss = new ServerSocket(8080);
		String msg="";
		Scanner sc =new Scanner(System.in);
		Socket s=ss.accept();
		DataInputStream din= new DataInputStream(s.getInputStream());
		DataOutputStream dos= new DataOutputStream(s.getOutputStream());
		while(!msg.equalsIgnoreCase("over"))
		{
			String str =(String) din.readUTF();
			System.out.println("->"+str);
			System.out.print("<-");
			msg=sc.nextLine();
			dos.writeUTF(msg);
			dos.flush();
		}
		dos.close();
		din.close();
		ss.close();
	}
}	