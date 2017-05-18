package Model;


/*
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Exceptions.DuplicteNameException;
import Exceptions.MessegeNotSentException;

public class Client implements Runnable {
	private Socket clientSocket;
	private DataInputStream input ;
	private PrintStream output;
	private Scanner sc = new Scanner(System.in);
	private boolean f =true;
	private String  IP;
	private  String Name;
	private ClientListener listener ;
	Thread MyThread ;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public Socket getClientSocket() {
		return clientSocket;
	}
	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	public DataInputStream getInput() {
		return input;
	}
	public void setInput(DataInputStream input) {
		this.input = input;
	}
	public PrintStream getOutput() {
		return output;
	}
	public void setOutput(PrintStream output) {
		this.output = output;
	}
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	public boolean isF() {
		return f;
	}
	public void setF(boolean f) {
		this.f = f;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public static void main(String[] args) {
		Client c= new Client();
		
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void send(String from,String text, String to) throws MessegeNotSentException {
		// TODO Auto-generated method stub
		
	}
	public void joinIP(String IP,String port) throws NumberFormatException, UnknownHostException, IOException {
		clientSocket=new  Socket(IP,Integer.parseInt(port));
		input =  new DataInputStream(clientSocket.getInputStream());
		output= new PrintStream(clientSocket.getOutputStream());
		
		System.out.println("here113");
	}
	public void joinResponse(String name2) throws DuplicteNameException{
		output.println(name2.trim());
		
		System.out.println("here117");
		String line = Readyay(input);
		if(!(line.endsWith("Y")))
			{System.out.println("here120");
			JOptionPane.showMessageDialog(new JFrame(), "this name is already taken", "DuplicteNameException",
	    	        JOptionPane.ERROR_MESSAGE);
			
			}
		else
		{System.out.println("here124");
			if (listener!=null)
			{System.out.println("here126");
				listener.GoToChat(name2);
				MyThread = new Thread(this);
				MyThread.start();
			}
		}
			
		/*	if(listener!=null&&f)
		{
			listener.AddME(name2);
		}
		*/
	/*	
	}
	public ClientListener getListener() {
		return listener;
	}
	public void setListener(ClientListener listener) {

		this.listener = listener;
	}
	public void close() {
		// TODO Auto-generated method stub
		try {
			this.clientSocket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.output.close();
		this.MyThread.stop();
		this.MyThread=null;
		
	}

	public void updateMemberList()
	{
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String messege;
		while(f)
		{	messege =Readyay(input);
			int tindex =messege.indexOf("!@#$%^&*()");
		String Mess=messege.substring(0,tindex-1);
		String from=messege.substring(tindex+"!@#$%^&*()".length());
			 if(listener!=null)
			 {
				 listener.RecivedMessege(Mess,from);
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











import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Exceptions.DuplicteNameException;
import Exceptions.MessegeNotSentException;

public class Client implements Runnable {
	private Socket clientSocket;
	private BufferedReader input ;
	private PrintStream output;
	private Scanner sc = new Scanner(System.in);
	private boolean f =true;
	private String  IP;
	private  String Name;
	private ClientListener listener ;
	Thread MyThread ;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public Socket getClientSocket() {
		return clientSocket;
	}
	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	public BufferedReader getInput() {
		return input;
	}
	public void setInput(BufferedReader input) {
		this.input = input;
	}
	public PrintStream getOutput() {
		return output;
	}
	public void setOutput(PrintStream output) {
		this.output = output;
	}
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	public boolean isF() {
		return f;
	}
	public void setF(boolean f) {
		this.f = f;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public static void main(String[] args) {
		Client c= new Client();
		
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void send(String from,String text, String to) throws MessegeNotSentException {
			output.println(to+"!@#$%^&*()"+text+"!@#$%^&*()"+from);
			System.out.println("332");
	}
	public void joinIP(String IP,String port) throws NumberFormatException, UnknownHostException, IOException {
		clientSocket=new  Socket(IP,Integer.parseInt(port));
		input =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		output= new PrintStream(clientSocket.getOutputStream());
		
		System.out.println("here113");
	}
	public void joinResponse(String name2) throws DuplicteNameException{
		try {output.println(name2.trim());
		
		System.out.println("here117");
		String line;
		
			line = input.readLine();
		
		if(!(line.equals("YES")))
			{System.out.println("here120");
			JOptionPane.showMessageDialog(new JFrame(), "this name is already taken", "DuplicteNameException",
	    	        JOptionPane.ERROR_MESSAGE);
			
			}
		else
		{System.out.println("here124");
			if (listener!=null)
			{System.out.println("here126");
				listener.GoToChat(name2);
				//MyThread = new Thread(this);
				(MyThread=new Thread(this)).start();
			
				//MyThread.start();
			}
		}
			
		/*	if(listener!=null&&f)
		{
			listener.AddME(name2);
		}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ClientListener getListener() {
		return listener;
	}
	public void setListener(ClientListener listener) {

		this.listener = listener;
	}
	public void close() {
		// TODO Auto-generated method stub
		try {
			this.clientSocket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.output.close();
		this.MyThread.stop();
		this.MyThread=null;
		
	}

	public void updateMemberList()
	{
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String messege;
		try {
			while(((messege =input.readLine())!=null)&&f)
			{	if(messege.startsWith("XXX"))
				{
					if(listener!=null)
					{
						listener.AddME(messege.substring(3).replace("!@#$%^&*()", "\n"));
					}
				}
			else if(messege.startsWith("asfawer12323415!#@$%#@%@^#^&$#&#%$#%"))
			{	if(listener!=null)
				listener.RecivedMessege("The last messege was not sent due to problems with the network or missing clients ","IT");
				JOptionPane.showMessageDialog(new JFrame(), "this Messege is not sent maybe the other client is closed or there didn't exist that one", "MessegeNotSentException()",
		    	        JOptionPane.ERROR_MESSAGE);
			}else if(messege.startsWith("asfawer12323415!#@$%#@%@^#^&$#&#%$#%2"))
			{	if(listener!=null)
				listener.RecivedMessege("Your Messege:","::>>");
				
			}
			else{
				int tindex =messege.indexOf("!@#$%^&*()");
			String name = messege.substring(0,tindex);
			String Subs=messege.substring(tindex+"!@#$%^&*()".length());
				 tindex =Subs.indexOf("!@#$%^&*()");
			String Mess=Subs.substring(0,tindex);
			String from=Subs.substring(tindex+"!@#$%^&*()".length());
				 if(listener!=null)
				 {
					 listener.RecivedMessege(Mess,from);
				 }
					
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
}
