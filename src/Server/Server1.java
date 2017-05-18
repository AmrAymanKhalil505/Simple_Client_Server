package Server;

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

public class Server1 {
	private ServerSocket serverSocket;
	private Socket acceptSocket;
	private PrintStream output;
	private BufferedReader input;
	private ArrayList<ClientThread> threads;
	private ArrayList<String> Names;
	public static void main(String[] args) {
		try{Server1 s = new Server1();
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
			if(!Already)
			{	s.output.println("*****Conf*****");
				s.Names.add(name);
				break;
			}
			else 
			{
				s.output.println("0");
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

	public void run() {
		try {
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
				new Serverthread(acceptSocket).start();
				String messege =input.readLine();
				System.out.println("Client :"+messege);

				String reply =sc.nextLine();
				System.out.println("**Server :"+reply);
				output.println(reply);
				this.receive();
				if(f)
				this.send();
				 

			}
			System.out.println("The Client is Disconnected");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
