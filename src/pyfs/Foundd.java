package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author merij
 */
public class Foundd {

    mysql Mysql = new mysql();
    Found found1 = new Found();
    
    String[] foundbagage;
   String[] foundDate;
   String[] foundLabel;

    public void setFoundbagage(String[] foundbagage) {
        this.foundbagage = foundbagage;
    }

    public void setFoundDate(String[] foundDate) {
        this.foundDate = foundDate;
    }

    public void setFoundLabel(String[] foundLabel) {
        this.foundLabel = foundLabel;
    }
   
   
    
    

    public Foundd() {
    }

    public void getLuggage(int Unr) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        
  
        int Lugagenr = 2;

       
        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            

            String query = "INSERT INTO lugage (Lugagelnr, Lugagetype, Lugagebrand, Lugagecol, Lugeweight, Lugagewespef, Unr,Pnr, LFDM) VALUES (" + '"' + Lugagenr + '"' + "," + '"' + foundbagage[0] + '"' + "," + '"' + foundbagage[1] + '"' + "," + '"'
                    + foundbagage[2] + '"' + "," + '"' + foundbagage[3] + '"' + "," + '"' + foundbagage[4]  +'"' + "," + '"' + Unr  + '"' +  "," + '"' + null  +'"' + ",'F'" + " )";

            st.executeUpdate(query);

        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public void getDate(int Unr) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();


        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            
            

            String query = ("INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + foundDate[0] + '"' + "," + '"' + foundDate[1] + '"' + "," + '"' + foundDate[2] + '"' + " ," + Unr + ")");

            //String query = "INSERT INTO dta (date, time, airport, Unr) VALUES (" + '"' + datex[0] + '"' + "," + '"' + datex[1] + '"' + "," + '"' + datex[2] + '"' + "," + '"' + 100 + '"' + " )";

            st.executeUpdate(query);
        }
        catch (SQLException ed) {

            System.err.println(ed);

        }

    }

 public void getLabel(int Unr) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();


        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            
            

            String query = ("INSERT INTO flight (Unr, labelnr, flightnr, destin) VALUES (" + '"' + Unr + '"' + "," + "'" + foundLabel[0] + "'" + "," + '"' + foundLabel[1] + '"' + "," + '"' +  null + '"' + ")");
            //String query2 = ("INSERT into persoon (Pnr, name, adress, city, zip, country, tel, mail) VALUES (25, " + '"' + info[2] + '"' + ", null, null, null, null, null, null)");

           

            st.executeUpdate(query);
         //  st.executeUpdate(query2);
        }
        catch (SQLException ed) {

            System.err.println(ed);

        }

    }






}
