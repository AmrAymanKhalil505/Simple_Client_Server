package Exceptions;

public class MessegeNotSentException extends Exception {
	public MessegeNotSentException()
	{
		super();
	}
	public MessegeNotSentException(String messege)
	{
		super(messege);
	}
}
