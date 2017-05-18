package Controller;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Exceptions.DuplicteNameException;
import Exceptions.MessegeNotSentException;
import Model.Client;
import Model.ClientListener;
import Views.View;
import Views.ViewListener;

public class Chat implements ViewListener,ClientListener{
	View v;
	Client c;
	
	public static void main(String[] args) {
		Chat chat = new Chat();
		
	}
	public Chat() {
		
		v=new View();
		c=new Client();
		v.setVisible(true);
	    v.enterIPPanel();
		v.setListener(this);
		c.setListener(this);
	} 
	

	@Override
	public void send(String from,String text, String To) {
		
		
	
		try{
			c.send(from,text,To);
		}
		catch (MessegeNotSentException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "MessegeNotSentException",
	    	        JOptionPane.ERROR_MESSAGE);
		}
		return;
		}
	

	private void help() {
		
	}

	@Override
	public void join(String name) {
		
	try{
	c.joinResponse(name);
	}
	
	catch(DuplicteNameException e)
	{
		JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "DuplicteNameException",
    	        JOptionPane.ERROR_MESSAGE);
		
	}
	
	}

	
	@Override
	public void EnterIP(String text,String port ) {
		
		
		try {
			c.joinIP(text,port);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "NumberFormatException",
		    	        JOptionPane.ERROR_MESSAGE);
					return;
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "UnknownHostException",
		    	        JOptionPane.ERROR_MESSAGE);
				return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "IOExceptiont",
	    	        JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		v.enterNamePanel();
	}

	@Override
	public void AddME(String name) {
		// TODO Auto-generated method stub
	
		v.getTextOnlineMemebers().setText(name);
		v.ChatPanel();
		
	}
	
	@Override
	public void closeClient() {
		// TODO Auto-generated method stub
		c.close();
	}
	@Override
	public void RecivedMessege(String mess, String from) {
		if(from.equalsIgnoreCase("::>>"))
		{
			v.getTextChat().setText(v.getTextChat().getText()+"\n"+from +" Said:"+mess+v.getTextSend().getText());
		}
		else{
		v.getTextChat().setText(v.getTextChat().getText()+"\n"+from +" Said:"+mess);
		}
	}
	@Override
	public void GoToChat(String name) {
		// TODO Auto-generated method stub
		System.out.println("What on earth");
		v.getLblMyName().setText("Your name is "+name);
		v.getLblMyName().setName(name);
		v.ChatPanel();
	}

	
	

	
	
}
