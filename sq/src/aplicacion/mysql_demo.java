package aplicacion;
import java.sql.*;

import combate.Estado;
import combate.Tipo;
import movimientos.MovAtaqueFisico;
import pokemon.Pokemon;

public class mysql_demo{


	public Tipo tipoAEnum(int tip) {

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
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "pokemon";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		
		// Las variables donde vamos a cargar los datos de mysql
		
		int idMovimiento, idEspecie, idEntrenador, tipo, dinero;
		String nombreHabilidad, nombreEspecie, nombreEntrenador;
		
		
		
		
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
				System.out.println(idMovimiento+" "+nombreHabilidad+" "+tipo);
			} //end while
			
			
			System.out.println("");

			/*
			 * Pokemons
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
			} //end while
			
			
			conn.close();
			System.out.println("Disconnected from database\n");
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
		
		
        MovAtaqueFisico mv_01 = new MovAtaqueFisico(Tipo.PYRO, "Placaje", 1, 50);

        Pokemon p1 = new Pokemon(01, "Malenia", 1000, 80, 20, 40, 10, 30, 10, 0, Estado.SIN_ESTADO, Tipo.HYDRO, mv_01,
                mv_01, null, null);
        Pokemon p2 = new Pokemon(02, "Radhan", 1000, 50, 30, 80, 40, 10, 10, 0, Estado.SIN_ESTADO, Tipo.PYRO, mv_01,
                null, null, null);

        mv_01.usarMovimiento(p1, p2);
        System.out.println(p2.getPuntosSaludCombate());
		
		
        
		// ////////////////////////////////////////////////////////////
	}
}