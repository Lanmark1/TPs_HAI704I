package tp1rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public Server() {}
	
	public static void main(String[] args) {
		
		try {
			AnimalImpl obj = new AnimalImpl("René","asiatique","taupe","Henry","Taupe en très bonne santé");
			
//			System.setSecurityManager(new SecurityManager());
			System.setProperty("java.security.policy","file:./security.policy");
			Registry registry = LocateRegistry.createRegistry(1099);
//			 Registry registry = LocateRegistry.getRegistry();
			if (registry == null) {
				System.err.println("RMI registry not found");
			}
			else {
				registry.rebind("Animal", obj);
				System.err.println("Server ready");
			}
		}
		catch (Exception e){
			System.out.println("Server exception: "+e.toString());
			e.printStackTrace();
		}

	}

}
