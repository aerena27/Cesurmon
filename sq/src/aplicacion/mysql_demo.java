package aplicacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import combate.Estado;
import combate.Tipo;
import movimientos.MovAtaqueEspecial;
import movimientos.Movimiento;
import pokemon.Entrenador;
import pokemon.Pokemon;

public class mysql_demo{


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
				mov_esp.add(new MovAtaqueEspecial(tipoAEnum(tipo), nombreHabilidad, idMovimiento, parametroEspecifico));
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
				pokedex.add(new Pokemon(idEspecie, nombreEspecie, rn.nextInt(1500)+1000, rn.nextInt(60)+20, rn.nextInt(60)+20, rn.nextInt(60)+20, rn.nextInt(60)+20, rn.nextInt(60)+20, 10, 0, Estado.SIN_ESTADO, tipoAEnum(tipo), 
						(Movimiento)mov_esp.get(rn.nextInt(nMov)), (Movimiento)mov_esp.get(rn.nextInt(nMov)), 
						(Movimiento)mov_esp.get(rn.nextInt(nMov)), (Movimiento)mov_esp.get(rn.nextInt(nMov))));
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
		
		
		MovAtaqueEspecial mv_01 = mov_esp.get(1);

        Pokemon p1 = pokedex.get(1);
        Pokemon p2 = pokedex.get(2);

        mv_01.usarMovimiento(p1, p2);
        System.out.println(p2.getPuntosSaludCombate());
		
		
        
		// ////////////////////////////////////////////////////////////
	}


}