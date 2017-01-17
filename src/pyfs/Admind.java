package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author merij
 */
public class Admind {

    Admin admin1 = new Admin();
    mysql Mysql = new mysql();

    public Admind() {
    }

    public void Add(String[] Add) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        if (!Add[1].equals(Add[0])) {
            try {

                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                String query = "INSERT INTO login (username, password, permission) VALUES (" + '"' + Add[0] + '"' + "," + '"' + Add[1] + '"' + "," + '"' + Add[2] + '"' + " )";
                Statement st = conn.createStatement();
                st.executeUpdate(query);
            } catch (SQLException ed) {

                System.err.println(ed);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("warning");
            alert.setHeaderText("username and password can not be the same \nthe account has not been created");
            alert.showAndWait();

        }
    }

    public void Delete(String[] delete) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String query = "DELETE FROM login WHERE username =" + '"' + delete[0] + '"' + "AND password = " + '"' + delete[1] + '"' + "";
            Statement st = conn.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public void Update(String[] updateInfo) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        if (!updateInfo[0].equals(updateInfo[1])) {
            try {

                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                String query = "UPDATE login SET username =" + '"' + updateInfo[0] + '"' + ", password = " + '"' + updateInfo[1] + '"' + ", permission = " + '"' + updateInfo[2] + '"' + "WHERE username =" + '"' + updateInfo[3] + '"';
                Statement st = conn.createStatement();
                st.executeUpdate(query);

            } catch (SQLException ed) {

                System.err.println(ed);

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("warning");
            alert.setHeaderText("username and password can not be the same \nthe account has not been created");
            alert.showAndWait();

        }
    }

    public void luggageRemove(String[] remove) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String query = "DELETE FROM luggage WHERE Unr = " + "'" + remove[0] + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

    public void luggageUpdate(String[] Update) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String query = "UPDATE luggage SET Luggagetype =" + '"' + Update[1] + '"' + ",Luggagebrand = " + '"' + Update[2] + '"' + ", Luggagecol = " + '"' + Update[3] + '"' + ", Luggageweight = " + '"' + Update[4] + '"'
                    + ", Luggagespef = " + '"' + Update[5] + '"' + ", LFDM = " + '"' + Update[6] + '"' + " WHERE Unr = " + '"' + Update[0] + '"';
            Statement st = conn.createStatement();
            st.executeUpdate(query);

        } catch (SQLException ed) {

            System.err.println(ed);

        }

    }

}
