package aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pokemon.Entrenador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class CombateFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CombateFrame() {		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CombateFrame.class.getResource("/recursos/EvUOT3_UUAIw-aA.png")));
		setTitle("Cesurmon Impact: Revengence");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1401, 816);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Volver al menu principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(30, 48, 176, 70);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnVictorias = new JTextPane();
		txtpnVictorias.setText("Victorias:");
		txtpnVictorias.setBounds(562, 112, 191, 54);
		contentPane.add(txtpnVictorias);
		
		JTextPane txtpnTurnos = new JTextPane();
		txtpnTurnos.setText("Turno: ");
		txtpnTurnos.setBounds(562, 48, 191, 54);
		contentPane.add(txtpnTurnos);
		
		JTextPane pokemonJugador = new JTextPane();
		pokemonJugador.setBounds(30, 168, 191, 54);
		contentPane.add(pokemonJugador);
		
		JTextPane pokemonRival = new JTextPane();
		pokemonRival.setBounds(966, 168, 191, 54);
		contentPane.add(pokemonRival);
		
		JTextPane psJugador = new JTextPane();
		psJugador.setText("PS:");
		psJugador.setBounds(30, 232, 191, 54);
		contentPane.add(psJugador);
		
		JTextPane psRival = new JTextPane();
		psRival.setText("PS:");
		psRival.setBounds(966, 232, 191, 54);
		contentPane.add(psRival);
		
		JTextPane stJugador = new JTextPane();
		stJugador.setText("ST:");
		stJugador.setBounds(231, 232, 90, 54);
		contentPane.add(stJugador);
		
		JTextPane stRival = new JTextPane();
		stRival.setText("ST:");
		stRival.setBounds(1167, 232, 90, 54);
		contentPane.add(stRival);
		
		JButton mov1 = new JButton("");
		mov1.setBounds(101, 333, 176, 70);
		contentPane.add(mov1);
		
		JButton mov2 = new JButton("");
		mov2.setBounds(376, 333, 176, 70);
		contentPane.add(mov2);
		
		JButton mov3 = new JButton("");
		mov3.setBounds(101, 435, 176, 70);
		contentPane.add(mov3);
		
		JButton mov4 = new JButton("");
		mov4.setBounds(376, 435, 176, 70);
		contentPane.add(mov4);
		
		JButton descansar = new JButton("Descansar");
		descansar.setBounds(613, 383, 176, 70);
		contentPane.add(descansar);
		
		JTextPane log = new JTextPane();
		log.setBounds(877, 333, 408, 170);
		contentPane.add(log);
		
		JButton iniciarCombate = new JButton("Iniciar combate");
		iniciarCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		iniciarCombate.setBounds(282, 48, 176, 70);
		contentPane.add(iniciarCombate);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CombateFrame.class.getResource("/recursos/b786c23aad9430eed946f3f85036bab9.jpg")));
		lblNewLabel.setBounds(10, 10, 1367, 759);
		contentPane.add(lblNewLabel);
	}
}
