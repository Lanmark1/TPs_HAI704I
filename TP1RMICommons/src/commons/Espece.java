package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Espece extends Remote {
	
	public String getNomEspece() throws RemoteException;
}
