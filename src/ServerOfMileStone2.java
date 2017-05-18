import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.stream.events.Namespace;

public class ServerOfMileStone2 {
	private ServerSocket serverSocket;
	private Socket acceptSocket;
	private PrintStream output;
	private BufferedReader input;
	private ArrayList<ClientThread> threads;
	private ArrayList<String> Names;
	public static void main(String[] args) {
		try{ServerOfMileStone2 s = new ServerOfMileStone2();
		System.out.println("Here is the Server");
		s.threads = new ArrayList<ClientThread> ();
		s.serverSocket = new ServerSocket(6000);// port,number of connection
		s.Names =new ArrayList<String>();
		while (true)
		{
			for (int i = 0 ; i<s.threads.size() ; i++ )
				if (s.threads.get(i).getAcceptSocket().isClosed())
				{	s.threads.remove(i);
					s.Names.remove(i);
				}
			s.acceptSocket = s.serverSocket.accept();
			//TODO name check
			
			
			s.input=new BufferedReader(new InputStreamReader(s.acceptSocket.getInputStream()));
			s.output= new PrintStream(s.acceptSocket.getOutputStream());String name;
			while(true)
			{for (int i = 0 ; i<s.threads.size() ; i++ )
				if (s.threads.get(i).getAcceptSocket().isClosed())
				{	s.threads.remove(i);
					s.Names.remove(i);
				}
				name = s.input.readLine();
			boolean Already =false;
			for(int i=0;i<s.Names.size();i++)
				if(s.Names.get(i).equals(name))
				{
					Already = true;
				}
			if(!Already&&!name.equalsIgnoreCase("All"))
			{	s.output.println("YES");
				s.Names.add(name);
				break;
			}
			else 
			{
				s.output.println("NO");
			}
			}
			s.threads.add(new ClientThread(s.acceptSocket,new BufferedReader(new InputStreamReader(s.acceptSocket.getInputStream())),new PrintStream(s.acceptSocket.getOutputStream()),name,s.threads,s.Names));
			s.threads.get(s.threads.size()-1).start();
		}
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	/*public void run() {
	/*	try {
			serverSocket = new ServerSocket(6000);// port,number of connection
			acceptSocket = serverSocket.accept();

			output = new PrintStream(acceptSocket.getOutputStream());
			input = new BufferedReader(new InputStreamReader(
					acceptSocket.getInputStream()));
			String messege;
			try {
				messege = input.readLine();
				output.println("Server Says:Connected");
			} catch (IOException e) {
				
				System.out.println(e.getMessage()) ; 
			}
			while(acceptSocket.isConnected()&&f)
			{
				/*new Serverthread(acceptSocket).start();*/
				/*String messege =input.readLine();
				System.out.println("Client :"+messege);

				/*String reply =sc.nextLine();
				System.out.println("**Server :"+reply);
				output.println(reply);*//*
				this.receive();
				if(f)
				this.send();
				 

			}
			System.out.println("The Client is Disconnected");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}*/

	}
/*	void receive ()
	{
		String messege;
		try {
			messege = input.readLine();
			if(messege.equals("BYE")||messege.equals("QUIT"))
				
			
			System.out.println("Client Says :" + messege);
		} catch (IOException e) {
			
		System.out.println(e.getMessage()); 
		}
		
	}
	*/
//}




////////////////////////////////////
class ClientThread extends Thread{
	 private BufferedReader input ;
	  private PrintStream output ;
	  private Socket acceptSocket ;
	  private ArrayList<ClientThread> threads;
	  private ArrayList<String>Names;
	  boolean notClosed = true;
	  String myname ;
	 
	public ClientThread(Socket acceptSocket,BufferedReader in,PrintStream ou,String n,ArrayList<ClientThread> threads, ArrayList<String> names) {
		// TODO Auto-generated constructor stub
		this.acceptSocket=acceptSocket ; 
		this.threads = threads;
		this.input = in;
		this.output = ou;
		myname = n;
		Names=names;
	}
	/*public void run()
	{ 
		String messege;
		try {
			messege = input.readLine();
			output.println("Server Says:Connected");
		} catch (IOException e) {
			
			System.out.println(e.getMessage()) ; 
		}
		while(acceptSocket.isConnected()&&f)
		{
			new Serverthread(acceptSocket).start();
		 messege =input.readLine();
			System.out.println("Client :"+messege);

			String reply =sc.nextLine();
			System.out.println("**Server :"+reply);
			output.println(reply);
			this.receive();
			if(f)
			this.send();
			 

		}
		System.out.println("The Client is Disconnected");
	}
	void receive ()
	{
		String messege;
		try {
			messege = input.readLine();
			if(messege.equals("BYE")||messege.equals("QUIT"))
	//			checkNull();
				
			System.out.println("Client Says :" + messege);
		} catch (IOException e) {
			
		System.out.println(e.getMessage()); 
		}
		
	}
	void send()
	{

		String reply =sc.nextLine();
		output.println(reply);
		
	}*/
	public void run()
	{
		while(this.notClosed)
		{	
			try {for (int i = 0 ; i<this.threads.size();i++)
				this.threads.get(i).output.println(("XXX"+GetOurNames(Names))); 
				String messege = this.input.readLine();
				if(messege.equals("BYE")||messege.equals("QUIT"))
				{	this.acceptSocket.close();
					for(int i=0;i<this.threads.size();i++)
					{
						if(this.threads.get(i).acceptSocket.isClosed())
						{
							this.threads.remove(i);
							this.Names.remove(i);
						}
					}
					this.notClosed=false;
				}
				
				int tindex =messege.indexOf("!@#$%^&*()");
				String name = messege.substring(0,tindex);
				String Subs=messege.substring(tindex+"!@#$%^&*()".length());
					 tindex =Subs.indexOf("!@#$%^&*()");
				String Mess=Subs.substring(0,tindex);
				String from=Subs.substring(tindex+"!@#$%^&*()".length());
				if(name.equals("All")){
				for (int i = 0 ; i<this.threads.size();i++){
					if(!this.Names.get(i).equalsIgnoreCase(from))
					this.threads.get(i).output.println(messege);}}
				else
				{boolean f=false;
					for (int i = 0 ; i<this.threads.size();i++)
						if(name.equalsIgnoreCase(this.Names.get(i))){
						this.threads.get(i).output.println(messege);
						f=true;
						}
						if(!f)
							for (int i = 0 ; i<this.threads.size();i++)
								if(from.equalsIgnoreCase(this.Names.get(i))){
								this.threads.get(i).output.println("asfawer12323415!#@$%#@%@^#^&$#&#%$#%");
								
								}
								else
								{
									for (int i1 = 0 ; i1<this.threads.size();i1++)
										if(from.equalsIgnoreCase(this.Names.get(i1))){
										this.threads.get(i1).output.println("asfawer12323415!#@$%#@%@^#^&$#&#%$#%2");
								}
				}
				
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			this.input.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     this.output.close();
	      try {
			this.acceptSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	Socket getAcceptSocket(){
		return this.acceptSocket;
	}
	String GetOurNames(ArrayList<String> x)
	{String r="";
		for(int i=0;i<x.size();i++)
		{
			r=r+x.get(i)+"!@#$%^&*()";
		}
		return r;
	}
	
	
}
