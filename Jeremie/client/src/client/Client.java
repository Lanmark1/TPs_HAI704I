package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commons.Animal;
import commons.CabinetVeterinaire;
import commons.FollowUpFile;
import commons.Species;

public class Client {
	
	private Client() {}
	
	public static void main(String[] args) {
		
		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			CabinetVeterinaire stubCab = (CabinetVeterinaire) registry.lookup("Cabinet");
			
			stubCab.addAnimal("René","asiatique","taupe", 10 ,"Henry","Taupe en très bonne santé");
			Animal rene = stubCab.searchAnimal("René");
//			ISpecies taupe = new Species("Tope");
//			System.out.println(taupe.getSpeciesName());
			rene.printFullName();
			String responseRene = rene.getFullName();
			System.out.println("response : "+responseRene);
			
			Species medorSpecies = new Dog();
			Species esp = new Species();
			stubCab.addAnimal("Medor", "berger-allemand", esp, "Henry", "very good boy");
			
			
			Animal medor = stubCab.searchAnimal("Medor");
			medor.printFullName();
			String responseMedor = medor.getFullName();
			System.out.println("response : "+responseMedor);
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
