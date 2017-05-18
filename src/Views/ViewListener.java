package Views;

import java.util.EventListener;

public interface ViewListener extends EventListener {

	void join(String text);

	void send(String from,String text, String To);

	void EnterIP(String ip , String port);

	void closeClient();

	

}
