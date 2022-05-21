package aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import combate.Tipo;
import movimientos.MovAtaqueEspecial;
import movimientos.MovAtaqueFisico;
import movimientos.Movimiento;
import pokemon.Entrenador;
import pokemon.Pokemon;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */



	public static Tipo tipoAEnum(int tip) {

		switch(tip) {
		case 0:
			return Tipo.NORMAL;
		case 1:
			return Tipo.DENDRO;
		case 2:
			return Tipo.PYRO;
		case 3:
			return Tipo.CRYO;
		case 4:
			return Tipo.HYDRO;
		case 5:
			return Tipo.ANEMO;
		case 6:
			return Tipo.ELECTRO;
		case 7:
			return Tipo.SECTO;
		case 8:
			return Tipo.GEO;
		default:
			return null;
		}

	}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("MySQL Connect Example.");
					Connection conn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName = "pokemon";
					String driver = "com.mysql.jdbc.Driver";
					String userName = "root";
					String password = "";

					// Las variables donde vamos a cargar los datos de mysql

					int idMovimiento, idEspecie, idEntrenador, tipo, parametroEspecifico, dinero, nMov=0, nPok=0;
					String nombreHabilidad, nombreEspecie, nombreEntrenador;


					List<MovAtaqueEspecial> mov_esp = new ArrayList<>();
					List<MovAtaqueFisico> mov_fis = new ArrayList<>();
					List<Pokemon> pokedex = new ArrayList<>();
					List<Entrenador> jugadores = new ArrayList<>();
					Random rn = new Random();

					// ////////////////////////////////////////////////////////////


					try {
						Class.forName(driver).getDeclaredConstructor().newInstance();
						conn = DriverManager.getConnection(url+dbName,userName,password);

						/*
						 * Movimientos
						 */

						String query = "Select * FROM movimientos";
						System.out.println("\nConnected to the database");
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while (rs.next())
						{

							idMovimiento = rs.getInt(1);
							nombreHabilidad = rs.getString(2);
							tipo = rs.getInt(3);
							parametroEspecifico = rs.getInt(4);
							System.out.println(idMovimiento+" "+nombreHabilidad+" "+tipo+" "+parametroEspecifico);
							if (idMovimiento<=20)
								mov_esp.add(new MovAtaqueEspecial(tipoAEnum(tipo), nombreHabilidad, idMovimiento, parametroEspecifico));
							else if (idMovimiento>20 && idMovimiento<=30)
								mov_fis.add(new MovAtaqueFisico(tipoAEnum(tipo), nombreHabilidad, idMovimiento, parametroEspecifico));
							nMov++;
						} //end while


						System.out.println("");

						/*
						 * Pokemons				random.nextInt(max - min + 1) + min
						 */

						query = "Select * FROM pokedex";
						stmt = conn.createStatement();
						rs = stmt.executeQuery(query);
						while (rs.next())
						{
							idEspecie = rs.getInt(1);
							nombreEspecie = rs.getString(2);
							tipo = rs.getInt(3);
							System.out.println(idEspecie+" "+nombreEspecie+" "+tipo);
							pokedex.add(new Pokemon(idEspecie, nombreEspecie, tipoAEnum(tipo), 
									(Movimiento)mov_esp.get(rn.nextInt(nMov)), (Movimiento)mov_esp.get(rn.nextInt(nMov)), 
									(Movimiento)mov_fis.get(rn.nextInt(nMov)), (Movimiento)mov_fis.get(rn.nextInt(nMov))));
							nPok++;
						} //end while


						System.out.println("");

						/*
						 * Entrenadores
						 */

						query = "Select * FROM entrenadores";
						stmt = conn.createStatement();
						rs = stmt.executeQuery(query);
						while (rs.next())
						{
							idEntrenador = rs.getInt(1);
							nombreEntrenador = rs.getString(2);
							dinero = rs.getInt(3);
							System.out.println(idEntrenador+" "+nombreEntrenador+" "+dinero);
							jugadores.add(new Entrenador(nombreEntrenador, dinero, 
									pokedex.get(rn.nextInt(nPok)), pokedex.get(rn.nextInt(nPok)), pokedex.get(rn.nextInt(nPok)), pokedex.get(rn.nextInt(nPok))));
						} //end while


						conn.close();
						System.out.println("Disconnected from database");
						System.out.println(nMov+" "+nPok+"\n");
					} //end try
					catch(ClassNotFoundException e) {
						e.printStackTrace();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					catch (Exception e) {
						e.printStackTrace();
					}

					// Una vez cargado los datos de mysql aqui empieza nuestro main


					MovAtaqueEspecial mv_01 = mov_esp.get(1);
					Pokemon p1 = pokedex.get(1);
					Pokemon p2 = pokedex.get(2);
					System.out.println(p1.getNombreEspecie());
					System.out.println(p2.getNombreEspecie());
					System.out.println(mv_01.getNombreHabilidad());




					// ////////////////////////////////////////////////////////////

					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/recursos/EvUOT3_UUAIw-aA.png")));
		setTitle("Cesurmon Impact: Revengence");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1401, 816);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Combatir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combate newWindow = new Combate();
				setVisible(false);
				newWindow.setVisible(true);
			}
		});

		JButton btnNewButton_1_1_2 = new JButton("Hola Mundo");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola mundo");
			}
		});
		btnNewButton_1_1_2.setBounds(1021, 441, 231, 68);
		contentPane.add(btnNewButton_1_1_2);

		JButton btnNewButton_1_1_1 = new JButton("Criar");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(1021, 322, 231, 68);
		contentPane.add(btnNewButton_1_1_1);

		JButton btnNewButton_1_1 = new JButton("Entrenar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(720, 322, 231, 68);
		contentPane.add(btnNewButton_1_1);

		JButton btnCapturar = new JButton("Capturar");
		btnCapturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Captura newWindow = new Captura();
				setVisible(false);
				newWindow.setVisible(true);
			}
		});
		btnCapturar.setBounds(1021, 206, 231, 68);
		contentPane.add(btnCapturar);
		btnNewButton.setBounds(720, 206, 231, 68);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/recursos/Captura-removebg-preview.png")));
		lblNewLabel_1.setBounds(271, 31, 823, 106);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/recursos/FE37LWYaAAA_NQe.JPG")));
		lblNewLabel.setBounds(10, 10, 1366, 763);
		contentPane.add(lblNewLabel);
	}
}
