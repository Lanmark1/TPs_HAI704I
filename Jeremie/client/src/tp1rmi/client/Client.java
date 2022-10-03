package tp1rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import tp1rmi.commons.Animal;
import tp1rmi.commons.CabinetVeterinaire;
import tp1rmi.commons.FollowUpFile;
import tp1rmi.commons.Species;

public class Client {
	
	private Client() {}
	
	public static void main(String[] args) {
		
		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			CabinetVeterinaire stubCab = (CabinetVeterinaire) registry.lookup("Cabinet");
			
			stubCab.addAnimal("René","asiatique","taupe","Henry","Taupe en très bonne santé");
			
			Animal Rene = stubCab.searchAnimal("René");
			Species taupe = new Species("Tope");
			System.out.println(taupe.getSpeciesName());
			Rene.printFullName();
			String responseRene = Rene.getFullName();
			System.out.println("response : "+responseRene);
			
			
//			Animal stubA = (Animal) registry.lookup("Animal");
//			String response = stubA.getFullName();
//			System.out.println("response : "+response);
//			
//			Species test = new Species("chat");//stubA.getSpecies();
//			
//			String speciesName = stubA.getSpeciesName();
//			System.out.println("species response : "+speciesName);
//			stubA.printSpeciesName();
//			
//			String fileResponse = ((FollowUpFile) stubA.getFile()).getFileReport();
//			System.out.println("file response : "+fileResponse);
//			stubA.printFile();
//			
//			((FollowUpFile) stubA.getFile()).modifyFileReport("Taupe en mauvaise santé");
//			
//			stubA.printFile();
//			fileResponse = ((FollowUpFile) stubA.getFile()).getFileReport();
//			
//			System.out.println("file response after modification: "+fileResponse);
			
		}
		catch(Exception e) {
			System.err.println("Server Exception"+e.toString());
			e.printStackTrace();
		}

	}

}
