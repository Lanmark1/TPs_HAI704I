package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FollowUpFile extends Remote {
	
	void modifyFileReport(String reportFile) throws RemoteException;
	String getFileReport() throws RemoteException;
	
		
}
