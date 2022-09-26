package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote{
	
	
	String getnom() throws RemoteException;
	String getSuiviAn() throws RemoteException;
	void affichernomComplet() throws RemoteException;
	
	
	
	
}
