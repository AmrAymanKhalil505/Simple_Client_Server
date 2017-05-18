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

public class MasterServer2 
{
	
	 static	ArrayList<String> Names ;
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 static int numberOfServer ;
	 static ServerSocket serversocket;
	 static Socket Servers[] ;
	 static  BufferedReader input[];
	 static PrintWriter output[];
	 static boolean Closed [];
	 static Thread MT [];
	 static int numberOfClients; 
	public static void main(String[] args) {
	System.out.println("Choose the number of servers we will have");
	MasterServer2 ms = new MasterServer2();
	try {
		
		Names=new ArrayList<String>();
			numberOfServer = Integer.parseInt(br.readLine());
			
		Servers= new Socket [numberOfServer];
		MT=new Thread[numberOfServer];
			serversocket=new ServerSocket(9000);
		input =new  BufferedReader[numberOfServer];
		output=new PrintWriter[numberOfServer];
		Closed=new boolean [numberOfServer];
		for(int i=0;i<numberOfServer;i++)
		{
			Servers[i]=serversocket.accept();
			input[i]=new  BufferedReader(new InputStreamReader(Servers[i].getInputStream()));
			output[i]=new PrintWriter(Servers[i].getOutputStream());
			Closed[i]=false;
			
			
		}
		
		for(int j=0;j<numberOfServer;j++)
		{System.out.println("Choose the number of Clients this will Server have");
			numberOfClients = Integer.parseInt(br.readLine());
			System.out.println("55");
			for(int i=0;i<numberOfClients;i++)
			{	output[j].println("YourTurn");
			System.out.println("57");
					boolean dup = false ;
					boolean notEnd =true;
					while(notEnd){
							String Name =input[j].readLine();
							for(int k=0;k<output.length;k++)
								{if(k!=j){System.out.println("63");
									output[k].println("Search"+Name);
									if(!input[k].readLine().equalsIgnoreCase("YES"))
									{ dup= true;
					
									break;
									}
					
					
								}
							if(dup)
									{System.out.println("74");
								output[j].println("NO");
									}
								else
								{System.out.println("78");
								output[j].println("YES");
								notEnd=false;

								}
			
								}
	}
			}
}

	
	
	

	
	
	
	} 
	catch (NumberFormatException | IOException e) {
		e.printStackTrace();
	}
	
	 
	 
	 
	 
	}
}
/* class ReadInputs implements Runnable
 {	static MasterServer2 MS;
 	static int SNM;
 	PrintWriter[] output;
 	BufferedReader[] input;
	 public ReadInputs(MasterServer2 ms ,int snm)
	 {
		 MS=ms;
		 SNM=snm;
		 this.input=MasterServer2.input;
		 this.output=MasterServer2.output;
		 System.out.println("i am 82");
	 }
	 
	@Override
	public void run() {
		while(!MasterServer2.Closed[SNM])
		{String line = Readyay(MasterServer2.input[SNM]);
		
		if(line.startsWith("***SearchName"))
			{	String Responce;
				boolean Dup=false;
				for(int i=0;i<MasterServer2.numberOfServer;i++)
				{	if(i!=SNM)
						{
						MasterServer2.output[i].println(line);
						Responce=Readyay(MasterServer2.input[SNM]);
						if(Responce.equalsIgnoreCase("N"))
							{
							Dup=true;
							break;
							}
						}
				}
				if(Dup)
				{	System.out.println("i am 101");
					MasterServer2.output[SNM].println("N");
					output[SNM].flush();
				}
				else 
				{System.out.println("i am 105");
					MasterServer2.output[SNM].println("Y");
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
 }*/