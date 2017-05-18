package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MultiServer implements Runnable {
	 ServerSocket serverSocket;
	 Socket acceptSocket;
	static final int NumberOfserves =3;
	 Socket Servers[]= new Socket[NumberOfserves];
	 PrintStream output[]=new PrintStream[NumberOfserves];
	 BufferedReader input []=new BufferedReader[NumberOfserves];
	 PrintStream outputAccept ;
	 BufferedReader inputAccept;
	
	 ArrayList<ClientThread> threads=new ArrayList<ClientThread>();
	 ArrayList<String> Names=new ArrayList<String>(); 
	  Scanner sc =new Scanner(System.in);
	  
	public static void main(String[] args) {
		MultiServer multiserver= new MultiServer();
				System.out.println("this is the server");
		System.out.println("please enter your port");
		int port =Integer.parseInt(multiserver.sc.nextLine().trim());
		
		try {
			multiserver.serverSocket= new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<NumberOfserves;i++)
		{
		System.out.println("please enter the another server IP if you don't want to enter anymore servers write NULL");
		
		String IP1 =multiserver.sc.nextLine();
		
		
		if(!IP1.equalsIgnoreCase("NULL"))
		{
			
			
			System.out.println("please enter the second server Port");
			int port1=Integer.parseInt(multiserver.sc.nextLine().trim());;
		try {
			multiserver.Servers[i]=new Socket(IP1, port1);
			multiserver.output[i]=new PrintStream(multiserver.Servers[i].getOutputStream());
			multiserver.input[i]=new BufferedReader(new InputStreamReader(multiserver.Servers[i].getInputStream()));
			multiserver.output[i].println("!@#$%^&*()");
			new Thread(new InputRunnable(multiserver, i)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			break;
		}
		
		}
		new Thread(multiserver).start();

	}
	@Override
	public void run() {
		while(true)
		{Socket x=null;
		try {
			x=	serverSocket.accept();
			outputAccept =new PrintStream(x.getOutputStream());
			inputAccept=new BufferedReader(new InputStreamReader(x.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}String line=null;
			try {System.out.println("Here79");
				line= inputAccept.readLine();
				System.out.println("Here81");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(line.equalsIgnoreCase("!@#$%^&*()"))
			{
				for(int j=0;j<NumberOfserves;j++)
				{
					if(Servers[j]==null)
					{
						Servers[j]=x;
						try {
							input[j]=new BufferedReader(new InputStreamReader(x.getInputStream()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							output[j]=new PrintStream(x.getOutputStream());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						new Thread(new InputRunnable(this, j)).start();
						break;
						//TODO the Thread Array
						
					}
				}
			}
			
			else if(line.startsWith("***SearchName"))
			{	boolean NotDone =true;
				while(NotDone){
				System.out.println("Here102");
				boolean dup=false;
				String name =line.substring("***SearchName".length()); 
				if(!search(name))
				{
					outputAccept.println("***NO***");try {
						line=inputAccept.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{System.out.println("Here109");
				for(int i=0;i<NumberOfserves;i++)
				{  if(output[i]==null)
					{
					break;
					}
					output[i].println("***SearchName"+name);
					System.out.println("Here125");
					try {
						if(input[i].readLine().equals("***NO***"))
						{System.out.println("Here128");
							dup=true;
							break;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
					if(dup)
					{System.out.println("Here136");
						outputAccept.println("***NO***");
						try {
							line=inputAccept.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else 
					{ NotDone=false;
						System.out.println("Here131");
						outputAccept.println("***YES***");
						System.out.println("Here133");
						Names.add(name);
						threads.add(new ClientThread(x, inputAccept, outputAccept, name, threads, Names));
						//TODO create new Client Thread
						
					}
				}
				}
				
				//threads.add(new ClientThread(x, inputAccept, outputAccept, name, threads, Names));
			}
			else if (line.startsWith("***DeleteName"))
			{	String Name = line.substring("***DeleteName".length());
				for(int i=0;i<Names.size();i++)
				{
					if(Name.equalsIgnoreCase(Names.get(i)))
					{
						Names.remove(i);
						threads.remove(i);
						break;
					}
				}
			}
			else if(line.startsWith("***Messege"))
			{	for(int j=0;j<NumberOfserves;j++)
			{
				output[j].println(line);
			}
				
				
			}
			
		}
		
	}
	public boolean search(String name)
	{System.out.println("Here169");
		
		for(int i=0;i<Names.size();i++)
		{
			if (Names.get(i).equalsIgnoreCase(name))
			{
				return false;
			}
		}
		return true;
	}
	
}


class InputRunnable implements Runnable
{	MultiServer ms;
	int SocketNumber;
	public InputRunnable( MultiServer ms,int SocketNumber)
	{
		this.ms=ms;this.SocketNumber=SocketNumber;
		
	}

	@Override
	public void run()  {
		while (true) {try {
			ms.input[SocketNumber]=new BufferedReader(new InputStreamReader( ms.Servers[SocketNumber].getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ms.output[SocketNumber]=new PrintStream(ms.Servers[SocketNumber].getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line=null;
		try {
		 line =ms.input[SocketNumber].readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newName=null;
		if(line.startsWith("***SearchName"))
		{boolean Duplicate = false;
		newName=line.substring("***SearchName".length());
		
			
			for(int i=0;i<ms.Names.size();i++)
			{
				if(ms.Names.get(i).equalsIgnoreCase(newName))
				{
					Duplicate=true;break;
				}
			}
			
			
			if(!Duplicate)
			{	
				ms.output[SocketNumber].println("***YES***");
				ms.output[SocketNumber].flush();
				System.out.println("234");
			}
			else
			{	
				ms.output[SocketNumber].println("***NO***");
				ms.output[SocketNumber].flush();
				System.out.println("238");
			}
		}
		
		else if (line.startsWith("***Messege"))
		{
			int tindex =line.indexOf("!@#$%^&*()");
			String name = line.substring("***Messege".length(),tindex);
			String Subs=line.substring(tindex+"!@#$%^&*()".length());
			tindex =Subs.indexOf("!@#$%^&*()");
			String Mess=Subs.substring(0,tindex-1);
			String from=Subs.substring(tindex+"!@#$%^&*()".length());
			
			for(int i=0;i<ms.Names.size();i++)
			{
				if(name.equalsIgnoreCase(ms.Names.get(i)))
				{
				ms.threads.get(i).output.println(Subs);
				}
			}
		}
	
		
	}
	
}
}

class ClientThread extends Thread{
	  BufferedReader input ;
	   PrintStream output ;
	  Socket acceptSocket ;
	  ArrayList<ClientThread> threads;
	ArrayList<String>Names;
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

	public void run()
	{
		while(this.notClosed)
		{	
			try {
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
				for (int i = 0 ; i<this.threads.size();i++)
					this.threads.get(i).output.println(myname +" Said :"+messege); 
				
			} catch (IOException e) {
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

	
	/*void SendMessege()
	{	String messege;
	
	try {
		messege = this.input.readLine();
		if (messege.equals("BYE")||messege.equals("QUIT"))
		{
			notClosed=false;
		}
		for (int i = 0 ; i<this.threads.size();i++)
		this.threads.get(i).output.println(messege); }
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
}

