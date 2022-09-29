package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Animal;
import common.SuiviAnimal;

public class AnimalImpl extends UnicastRemoteObject implements Animal{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nom;
	public String nomMaitre;
	public Espece espece = new Espece();
	public String race ;
	public SuiviAnimal suivi = new SuiviAnimalImpl("");

	
	public AnimalImpl()  throws RemoteException {
	}
	
	public AnimalImpl(String nomA, String nomMaitreA, Espece especeA, String raceA, SuiviAnimal sa)  throws RemoteException {
			this.nom = nomA;
			this.nomMaitre= nomMaitreA;
			this.espece = especeA;
			this.race = raceA;
			this.suivi = sa;
	}
		
		

		@Override
		public String getnom() throws RemoteException {
			return nom;
		}
		
		@Override
		public String getSuiviAn() throws RemoteException {
			return suivi.getSuivi();
		}
		

		@Override
		public void affichernomComplet() throws RemoteException {
			
		}

		@Override
		public String getNomEspece() throws RemoteException {
			return espece.getNomEspece();
		}

}