package Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Client;

public class MasterServer 
{
	
	 static	ArrayList<String> Names ;
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 static int numberOfServer ;
	 static ServerSocket serversocket;
	 static Socket Servers[] ;
	 static  DataInputStream[] input;
	 static PrintWriter output[];
	 static boolean Closed [];
	 static Thread MT [];
	public static void main(String[] args) {
	System.out.println("Choose the number of servers we will have");
	MasterServer ms = new MasterServer();
	try {
		
		Names=new ArrayList<String>();
			numberOfServer = Integer.parseInt(br.readLine());
		Servers= new Socket [numberOfServer];
		MT=new Thread[numberOfServer];
			serversocket=new ServerSocket(9000);
		input =new DataInputStream[numberOfServer];
		output=new PrintWriter[numberOfServer];
		Closed=new boolean [numberOfServer];
		for(int i=0;i<numberOfServer;i++)
		{
			Servers[i]=serversocket.accept();
			input[i]=new DataInputStream(Servers[i].getInputStream());
			output[i]=new PrintWriter(Servers[i].getOutputStream());
			Closed[i]=false;
			
			
		}
		
		
		
		

	
	
	

	
	
	
	} 
	catch (NumberFormatException | IOException e) {
		e.printStackTrace();
	}
	
	 
	 
	 
	 
	}
}
 class ReadInputs implements Runnable
 {	static MasterServer MS;
 	static int SNM;
 	PrintWriter[] output;
 	DataInputStream[] input;
	 public ReadInputs(MasterServer ms ,int snm)
	 {
		 MS=ms;
		 SNM=snm;
		 this.input=MasterServer.input;
		 this.output=MasterServer.output;
		 System.out.println("i am 82");
	 }
	 
	@Override
	public void run() {
		while(!MasterServer.Closed[SNM])
		{String line = Readyay(MasterServer.input[SNM]);
		
		if(line.startsWith("***SearchName"))
			{	String Responce;
				boolean Dup=false;
				for(int i=0;i<MasterServer.numberOfServer;i++)
				{	if(i!=SNM)
						{
						MasterServer.output[i].println(line);
						Responce=Readyay(MasterServer.input[SNM]);
						if(Responce.equalsIgnoreCase("N"))
							{
							Dup=true;
							break;
							}
						}
				}
				if(Dup)
				{	System.out.println("i am 101");
					MasterServer.output[SNM].println("N");
					output[SNM].flush();
				}
				else 
				{System.out.println("i am 105");
					MasterServer.output[SNM].println("Y");
					output[SNM].flush();
				}
			}
			
			
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
 }