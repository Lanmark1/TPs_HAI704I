package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import commons.Animal;
import commons.Espece;
import commons.SuiviAnimal;

public class AnimalImpl extends UnicastRemoteObject implements Animal{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String nomMaitre;
	private Espece espece;
	private String race;
	private String suivi;
	

	
	public AnimalImpl()  throws RemoteException {
	}

	public AnimalImpl(String nomA, String nomMaitreA, String especeA, String raceA, String sa)  throws RemoteException {
		this.nom = nomA;
		this.nomMaitre= nomMaitreA;
		this.espece = new Espece(especeA);
		this.race = raceA;
		this.suivi = sa;
}
	
	
	public AnimalImpl(String nomA, String nomMaitreA, Espece especeA, String raceA, String sa)  throws RemoteException {
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
//		
//		@Override
//		public String getSuiviAn() throws RemoteException {
//			return suivi.getSuivi();
//		}
//		

		@Override
		public void affichernomComplet() throws RemoteException {
			// TODO document why this method is empty
		}

		@Override
		public String getNomEspece() throws RemoteException {
			return espece.getNomEspece();
		}

		@Override
		public Espece getEspece() throws RemoteException {
			return espece;
		}

}