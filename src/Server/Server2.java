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

public class Server2 implements Runnable {
	  ServerSocket serverSocket;
	  Socket acceptSocket;
	  PrintStream acceptOutput;
	  DataInputStream acceptInput;
	
	ArrayList<ClientThread> threads;
	ArrayList<String> Names;
	 
	Socket MasterServerSocket;
	 PrintStream MSOutpPrintStream;
	 DataInputStream MSinpReader;
	Scanner sc =new Scanner(System.in);
	 public static void main(String[] args) {
		 Server2 s2=new Server2();
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
			 s2.MSinpReader=new DataInputStream(s2.MasterServerSocket.getInputStream());
			 s2.Names=new ArrayList<String>();
			 
			// new Thread(new Server2()).start();
			
			 
			 while (true)
				 
			 {
				 s2.acceptSocket=s2.serverSocket.accept();
				 s2.acceptInput=new DataInputStream(s2.acceptSocket.getInputStream());
				 s2.acceptOutput = new PrintStream(s2.acceptSocket.getOutputStream());
				 
				String line2 = Readyay(s2.acceptInput);
				
				System.out.println("50");
				if(!s2.search(line2))
				{
					s2.MSOutpPrintStream.println("***SearchName"+line2);
					String line3=Readyay(s2.MSinpReader);
					if(line3.endsWith("Y"))
					{
						s2.acceptOutput.println("Y");
						
						//TODO new client Thread
						s2.Names.add(line2);
					}
					else 
					{
						s2.acceptOutput.println("N");
						
					}
				}
				
			 }
			 
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	 
	 }
	 public static String Readyay(DataInputStream in)
	 {String messageString="";
		byte[] messageByte = new byte[1000];int bytesRead=0;
		try {
			messageByte[0] = in.readByte();
		
	    messageByte[1] = in.readByte();
	    boolean end = false;
	    int bytesToRead = messageByte[1];
	    while(!end)
	    {
	        bytesRead = in.read(messageByte);
	        messageString += new String(messageByte, 0, bytesRead);
	        if (messageString.length() == bytesToRead )
	        {
	            end = true;
	        }
	    }
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return messageString;
	}
	@Override
	public void run() {
			while (true)
			{
				try 
				{
					String line =	MSinpReader.readLine();
					if(line.startsWith("***SearchName"))
					{
						if (search(line.substring("***SearchName".length())))//search for the name
						{
							MSOutpPrintStream.println("N");
							MSOutpPrintStream.flush();
						}
						else
						{
							MSOutpPrintStream.println("Y");
							MSOutpPrintStream.flush();
						}
					}
					
					
					
					
					
					
					
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
	}
	private  boolean search(String substring) {
		for(int i=0;i<Names.size();i++)
		{
			if (substring.equalsIgnoreCase(Names.get(i)))
			{
				return true;
			}
		}
		return false;
	}
	
}

	

