package CSDataAccess.CSDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract  class CSDataHelper {
    private static String csPathConnection = "jdbc:sqlite:DataBase//CSDataBase.sqlite"  ; 
    private  static Connection csConn  = null ;

     protected static synchronized Connection CSopenConnection() throws Exception{
        try {
            if(csConn == null)
                csConn = DriverManager.getConnection(csPathConnection);
                System.out.println("conecto");


        } catch (SQLException e) {
                System.out.println("no conecto");
             throw e;   //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return csConn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (csConn != null)
            csConn.close();
        } catch (Exception e) {
            throw e;    //new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
    


}
