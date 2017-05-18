package Server;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server3  {
	  ServerSocket serverSocket;
	  Socket acceptSocket;
	  PrintStream acceptOutput;
	 BufferedReader acceptInput;
	
	ArrayList<ClientThread> threads;
	ArrayList<String> Names;
	 
	Socket MasterServerSocket;
	 PrintStream MSOutpPrintStream;
	 BufferedReader MSinpReader;
	Scanner sc =new Scanner(System.in);
	 public static void main(String[] args) {
		 Server3 s2=new Server3();
		System.out.println("what is your port?");
		int port = Integer.parseInt(s2.sc.nextLine());
		try {
			s2.serverSocket = new ServerSocket(port);
			System.out.println("what is the master Server IP");
			String line =s2.sc.nextLine();
			System.out.println("what is the master Port number");
			 port = Integer.parseInt(s2.sc.nextLine());
			 s2.MasterServerSocket =new Socket(line,port);
			 s2.MSOutpPrintStream=new PrintStream(s2.MasterServerSocket.getOutputStream());
			 s2.MSinpReader=new BufferedReader(new InputStreamReader(s2.MasterServerSocket.getInputStream()));
			 s2.Names=new ArrayList<String>();
			 
			
			 System.out.println("what is the number of clients u will have?");
			 int NumberOfClients =Integer.parseInt(s2.sc.nextLine());
			 System.out.println("45");
			 if(s2.MSinpReader.readLine().equals("YourTurn"));
			 for(int i=0;i<NumberOfClients;i++)
			 { boolean notEnd= true;
			 s2.acceptSocket= s2.serverSocket.accept();
			 s2.acceptInput=new BufferedReader(new InputStreamReader(s2.acceptSocket.getInputStream()));
			 s2.acceptOutput=new PrintStream(s2.acceptSocket.getOutputStream());
			 System.out.println("51");
			 while(notEnd){
				
				 String name =s2.acceptInput.readLine();
				 System.out.println("54");
				
				
				 if(!s2.search(name))
				 {
					 System.out.println("59");
					 s2.acceptOutput.println("NO");
				 }
				 else 
				 {	System.out.println("63");
					 s2.MSOutpPrintStream.println(name);
					 System.out.println("65");
					 s2.MSinpReader.readLine();
					 if( s2.MSinpReader.readLine().equals("YES"))
					 {	System.out.println("68");
						 s2.acceptOutput.println("YES");notEnd=true;
					 }
					 else
					 {System.out.println("72");
						 s2.acceptOutput.println("NO");
					 }
					 
				 }
				 
			 }
			 }
		
			}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	 }
	private  boolean search(String name) {
			for (int i=0;i<Names.size();i++)
			{
				if (name.equalsIgnoreCase(Names.get(i)))
				{
					return true ;
				}
			}
		return false;
	}
}