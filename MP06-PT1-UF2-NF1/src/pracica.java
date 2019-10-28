import java.sql.*;
import java.util.Scanner;

public class pracica {
	public static void main(String[] args) {

		try {
			String INSERT_Faccion = "INSERT INTO Faccion(faccion_id , nombre_faccion) VALUES(?, ?)";
			String INSERT_Personaje = "INSERT INTO Personaje(personaje_id  , nombre_personaje, ataque, defensa, faccion_id    ) VALUES(?, ?, ?, ?, ?)";
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:ForHonor.db");
			Statement st = conexion.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS Faccion");
			st.executeUpdate("DROP TABLE IF EXISTS Personaje");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Faccion (" + "faccion_id INT(64) PRIMARY KEY,"
					+ "nombre_faccion VARCHAR(15)," + "lore VARCHAR(200))");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Personaje (" + "personaje_id INT(64) PRIMARY KEY,"
					+ "nombre_personaje VARCHAR(15),"
					+ "ataque INT(64), defensa INT(64),faccion_id INT(64), FOREIGN KEY (faccion_id) REFERENCES Faccion (faccion_id))");
			// insert Caballero
			int numRowsInserted = 0;
			PreparedStatement ps = null;
			ps = conexion.prepareStatement(INSERT_Faccion);
			ps.setString(1, "1");
			ps.setString(2, "Caballeros");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Faccion: " + numRowsInserted);
			// insert Vikingo
			ps = conexion.prepareStatement(INSERT_Faccion);
			ps.setString(1, "2");
			ps.setString(2, "Vikingo");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Faccion: " + numRowsInserted);
			// insert Samurais
			ps = conexion.prepareStatement(INSERT_Faccion);
			ps.setString(1, "3");
			ps.setString(2, "Samurais");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Faccion: " + numRowsInserted);
			// insert personaje Caballero
			ps = conexion.prepareStatement(INSERT_Personaje);
			ps.setString(1, "1");
			ps.setString(2, "Daniel");
			ps.setString(3, "30");
			ps.setString(4, "30");
			ps.setString(5, "1");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Personaje Caballero: " + numRowsInserted);
			// insert personaje Caballero
			ps = conexion.prepareStatement(INSERT_Personaje);
			ps.setString(1, "2");
			ps.setString(2, "Josu");
			ps.setString(3, "30");
			ps.setString(4, "30");
			ps.setString(5, "1");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Personaje Caballero: " + numRowsInserted);
			// insert personaje Caballero
			ps = conexion.prepareStatement(INSERT_Personaje);
			ps.setString(1, "3");
			ps.setString(2, "David");
			ps.setString(3, "30");
			ps.setString(4, "30");
			ps.setString(5, "1");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Personaje Caballero: " + numRowsInserted);
			// insert personaje Vikingo
			ps = conexion.prepareStatement(INSERT_Personaje);
			ps.setString(1, "4");
			ps.setString(2, "Manolo");
			ps.setString(3, "30");
			ps.setString(4, "30");
			ps.setString(5, "2");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Personaje Vikingo: " + numRowsInserted);
			// insert personaje Vikingo
			ps = conexion.prepareStatement(INSERT_Personaje);
			ps.setString(1, "5");
			ps.setString(2, "Paco");
			ps.setString(3, "30");
			ps.setString(4, "30");
			ps.setString(5, "2");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Personaje Vikingo: " + numRowsInserted);
			// insert personaje Samurais
			ps = conexion.prepareStatement(INSERT_Personaje);
			ps.setString(1, "6");
			ps.setString(2, "Andres");
			ps.setString(3, "30");
			ps.setString(4, "30");
			ps.setString(5, "3");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Personaje Samurais: " + numRowsInserted);
			// insert personaje Samurais
			ps = conexion.prepareStatement(INSERT_Personaje);
			ps.setString(1, "7");
			ps.setString(2, "Uriol");
			ps.setString(3, "30");
			ps.setString(4, "30");
			ps.setString(5, "3");
			numRowsInserted = ps.executeUpdate();
			System.out.println("s'afegit INSERT_Personaje Samurais: " + numRowsInserted);
			int o = menuPrincipal();
			ResultSet rs = null;
			switch (o) {
			case 1:
				rs = st.executeQuery("SELECT * FROM Personaje");
				while (rs.next()) {
					System.out.println("personaje_id=" + rs.getObject("personaje_id") + ", nombre_personaje="
							+ rs.getObject("nombre_personaje") + ", ataque=" + rs.getObject("ataque") + ", defensa="
							+ rs.getObject("defensa") + ", faccion_id=" + rs.getObject("faccion_id"));
				}
				rs.close();
				break;
			case 2:
				rs = st.executeQuery("SELECT * FROM Personaje WHERE faccion_id = 2");
				while (rs.next()) {
					System.out.println("personaje_id=" + rs.getObject("personaje_id") + ", nombre_personaje="
							+ rs.getObject("nombre_personaje") + ", ataque=" + rs.getObject("ataque") + ", defensa="
							+ rs.getObject("defensa") + ", faccion_id=" + rs.getObject("faccion_id"));
				}
				rs.close();
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + o);
			}

			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int menuPrincipal() {
		Scanner teclat = new Scanner(System.in);
		int opcio = 0;
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("1. MOSTAR TAULA PERSONATJE");
		System.out.println("2. MOSTAR FACIO CABALLEROS");
		System.out.println("3. MOSTAR EL PERSONATJE SAMURAI AMB MES ATAC");
		System.out.println("4. SORTIR");
		System.out.print("Escull una opcio:");
		while (!teclat.hasNextInt()) {
			System.out.println("");
			System.out.println("==============================================");
			System.out.println("1. MOSTAR TAULA PERSONATJE");
			System.out.println("2. MOSTAR FACIO CABALLEROS");
			System.out.println("3. MOSTAR EL PERSONATJE SAMURAI AMB MES ATAC");
			System.out.println("4. SORTIR");
			System.out.print("Escull una opcio:");
			teclat.nextLine();
		}
		opcio = teclat.nextInt();
		return opcio;
	}
}
