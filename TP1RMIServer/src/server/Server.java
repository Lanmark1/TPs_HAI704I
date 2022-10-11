package server;


import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commons.CabinetVeterinaire;
import commons.Espece;
import commons.SuiviAnimal;

public class Server {
	

	public static void main(String[] args) {
		
		
		
		try {
			
			System.setProperty("java.security.policy", "file:/home/reyne/Bureau/TPs_HAI704I/TP1RMIServer/src/security.policy");
			System.setProperty("java.rmi.server.codebase", "file:/home/reyne/Bureau/TPs_HAI704I/TP1RMIClient/codebase/");
//			System.out.println(new File("").getAbsolutePath());
			System.setSecurityManager(new SecurityManager());
			
			Registry registry = LocateRegistry.createRegistry(1099);
			
			CabinetVeterinaire cabinet = new CabinetVeterinaireImpl();
			if (registry == null)
				System.err.println("Registry not found on port 1099");
			else {
				registry.rebind("Cabinet", cabinet);
				System.err.println("Server ready");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

