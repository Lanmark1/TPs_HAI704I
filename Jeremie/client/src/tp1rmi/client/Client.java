package tp1rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import tp1rmi.commons.Animal;
import tp1rmi.commons.FollowUpFile;

public class Client {
	
	private Client() {}
	
	public static void main(String[] args) {
		
		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			Animal stub = (Animal) registry.lookup("Animal");
			String response = stub.getFullName();
			System.out.println("response : "+response);
			String fileResponse = ((FollowUpFile) stub.getFile()).getFileReport();
			System.out.println("file response : "+fileResponse);
			stub.printFullName();
			stub.printFile();
			((FollowUpFile) stub.getFile()).modifyFileReport("Taupe en mauvaise santé");
			stub.printFile();
			fileResponse = ((FollowUpFile) stub.getFile()).getFileReport();
			System.out.println("file response after modification: "+fileResponse);
			
		}
		catch(Exception e) {
			System.err.println("Server Exception"+e.toString());
			e.printStackTrace();
		}

	}

}
