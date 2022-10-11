package gui;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Fenetre() {
		super("Fenetre créee");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());
	}
	
    public static void main(String[] args) {	
    	
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Fenetre fenetre = new Fenetre();
    	
    	fenetre.add(new JCheckBox("Ajouter patient"));
    	fenetre.add(new JTextField("Rentrez le nom du patient"));
    	fenetre.setVisible(true);
   /*
	JFrame cadre = new javax.swing.JFrame("Premiere fenetre");
	
	JPanel panneau = new JPanel();
	
	panneau.setPreferredSize(new Dimension(250, 150));

	panneau.setBackground(Color.RED);
	cadre.setContentPane(panneau);
	cadre.setLocation(400, 300);
	cadre.pack();
	cadre.setVisible(true);
	cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    */
    }
}