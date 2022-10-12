package client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import commons.CabinetVeterinaire;
import commons.*;
import commons.Espece;

public class Interface extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField nomAnimal;
	private JTextField nomMaitre;
	private JTextField nomRace;
	private JTextField etatSante;
	private JLabel lblNomDesAnimaux;
	private JTable table;
	JComboBox<String> comboBox;
	Registry registry = LocateRegistry.getRegistry();
	CabinetVeterinaire cabinet = (CabinetVeterinaire) registry.lookup("Cabinet");
	String nomEspece;
	/**
	 * Launch the application.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {
	
		
		// On suppose le cabinet déjà créer
			// On demande d'ajouter un animal 
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public Interface() throws RemoteException, NotBoundException {
		
		
		
	
			
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,800,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNomAnimal = new JLabel("Nom animal : ");
		lblNomAnimal.setBounds(12, 28, 144, 15);
		contentPane.add(lblNomAnimal);
		
		JLabel lblNomAnimal_1 = new JLabel("Nom maître : ");
		lblNomAnimal_1.setBounds(391, 28, 144, 15);
		contentPane.add(lblNomAnimal_1);
		
		JLabel lblNomAnimal_1_1 = new JLabel("Espèce : ");
		lblNomAnimal_1_1.setBounds(12, 63, 144, 15);
		contentPane.add(lblNomAnimal_1_1);
		
		JLabel lblNomAnimal_1_1_1 = new JLabel("Race : ");
		lblNomAnimal_1_1_1.setBounds(391, 63, 144, 15);
		contentPane.add(lblNomAnimal_1_1_1);
		
		JLabel lblNomAnimal_1_1_1_1 = new JLabel("Etat de santé : ");
		lblNomAnimal_1_1_1_1.setBounds(391, 103, 144, 15);
		contentPane.add(lblNomAnimal_1_1_1_1);
		
		nomAnimal = new JTextField();
		nomAnimal.addActionListener(this);
		nomAnimal.setBounds(130, 26, 144, 19);
		contentPane.add(nomAnimal);
		nomAnimal.setColumns(10);
		
		nomMaitre = new JTextField();
		nomMaitre.addActionListener(this);
		nomMaitre.setColumns(10);
		nomMaitre.setBounds(523, 26, 144, 19);
		contentPane.add(nomMaitre);
		
		nomRace = new JTextField();
		nomRace.addActionListener(this);
		nomRace.setColumns(10);
		nomRace.setBounds(523, 61, 144, 19);
		contentPane.add(nomRace);
		
		etatSante = new JTextField();
		etatSante.addActionListener(this);
		etatSante.setColumns(10);
		etatSante.setBounds(523, 90, 206, 42);
		contentPane.add(etatSante);
		
		JToggleButton tglbtnSupprimer = new JToggleButton("Supprimez");
		tglbtnSupprimer.addActionListener(this);
		tglbtnSupprimer.setBounds(201, 135, 167, 25);
		contentPane.add(tglbtnSupprimer);
		
		
		lblNomDesAnimaux = new JLabel("Nom des animaux présents");
		lblNomDesAnimaux.setBounds(264, 172, 206, 31);
		contentPane.add(lblNomDesAnimaux);
	
		
		String[] options = { "", "Chien", "Chat"};
		comboBox = new JComboBox<String>(options);
		comboBox.setBounds(130, 58, 144, 24);
//		comboBox.addItemListener(this);
		contentPane.add(comboBox);
		
		JToggleButton tglbtnValidez_1 = new JToggleButton("Validez");
		tglbtnValidez_1.addActionListener(this);
		tglbtnValidez_1.setBounds(12, 135, 167, 25);
		contentPane.add(tglbtnValidez_1);
	
	}

	// Je récupère la valeur des buttons
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand(); 
		if(command.equals("Validez")) {
			
			try {
				String espece = (String) comboBox.getSelectedItem();
				cabinet.addAnimal(nomAnimal.getText(), nomMaitre.getText(), espece, nomRace.getText(), etatSante.getText());
				
				JOptionPane.showMessageDialog(null, "Vous venez d'ajouter un animal");
				if(cabinet.size() > 100) {
					JOptionPane.showMessageDialog(null, "Votre cabinet contient plus de 100 animaux");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(command.equals("Supprimez")) {
			
			try {
				System.out.println(cabinet.searchAnimal("Yoann"));
				cabinet.removeAnimal(nomAnimal.getText(),nomMaitre.getText());
				System.out.println(cabinet.searchAnimal("Yoann"));
				JOptionPane.showMessageDialog(null, "Vous venez de supprimer un animal");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

	// Je récupère le nom de l'espece
	
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		Object obj = e.getItem();
//		String selection = (String)obj;
//		System.out.println("Je suis " + selection);
//	}
	
	
}
