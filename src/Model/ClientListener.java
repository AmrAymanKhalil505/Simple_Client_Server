package Model;

import java.util.EventListener;

public interface ClientListener extends EventListener {

	void AddME(String name2);

	void RecivedMessege(String mess, String from);

	void GoToChat(String name);
}
