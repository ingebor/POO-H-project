import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Grupo 6 POO Seccion 21
 * Permite conectar el programa a una base de datos en sql
 */
public class ConeccionBD{
    private Connection currentConnection = null;
    public Statement stQuery = null;
    public ResultSet rsRecords = null;
    private String DB_URL = "";
    private String DB_USERNAME = "";
    private String DB_PASSWORD = "";

    /**
     * Constructor con parametros de ConeccionBD
     * @param URL el URL para hacer la conexion
     * @param USER el nombre de usuario para hacer la conexion
     * @param PASSWORD la contrasenia para hacer la conexion a sql
     */
    public ConeccionBD(String URL, String USER, String PASSWORD){
        this.DB_URL = URL;
        this.DB_USERNAME = USER;
        this.DB_PASSWORD = PASSWORD;
    }

	/**
	 * El metodo establece una nueva conexion con la base de datos, utilizando los atributos que se llenaron con el constructor
	 */
    public Connection getNewConnection(){
        try{
            currentConnection = null;

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            currentConnection = DriverManager.getConnection(
                    DB_URL,
                    DB_USERNAME,
                    DB_PASSWORD);

        }
        catch (Exception ex){
            System.out.println ("ConnectionBD->getConnection()..Error..: " + ex.getMessage());
            ex.printStackTrace();
        }
        return currentConnection;
    }

    /**
     * Acceso a currentConnection
     * @return Connection la conexion actual a sql
     */
    public Connection getCurrentConnection(){
        return currentConnection;
    }
    
    /**
     * Cierra la conexion actual con sql
     */
    public void closeConnection (){
        try{
            currentConnection.close();
        }
        catch (Exception ex){
            System.out.println ("ConnectionBD->getConnection()..Error..: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
