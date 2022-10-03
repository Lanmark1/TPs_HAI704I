package tp1rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public Server() {}
	
	public static void main(String[] args) {
		
		try {
//			AnimalImpl objA = new AnimalImpl("René","asiatique","taupe","Henry","Taupe en très bonne santé");
			CabinetVeterinaireImpl objCab = new CabinetVeterinaireImpl();
//			SecurityManager sManager = new SecurityManager();
//			System.setSecurityManager(sManager);
			System.setProperty("java.security.policy","file:./security.policy");
			System.setProperty("java.rmi.server.codebase", "file:./codebase");
			Registry registry = LocateRegistry.createRegistry(1099);
//			 Registry registry = LocateRegistry.getRegistry();
			if (registry == null) {
				System.err.println("RMI registry not found");
			}
			else {
//				registry.rebind("Animal", objA);
				registry.rebind("Cabinet", objCab);
				System.err.println("Server ready");
			}
		}
		catch (Exception e){
			System.out.println("Server exception: "+e.toString());
			e.printStackTrace();
		}

	}

}
