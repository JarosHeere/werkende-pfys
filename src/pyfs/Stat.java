package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

/**
 *
 * @author merij
 */
public class Stat {

    private PieChart piechart;
    mysql Mysql = new mysql();

    public Stat() {

    }

    public PieChart OverYear() {
        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        Connection conn;
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) AS total FROM luggage where LFDM = 'Lost'");

            while (rs5.next()) {
                count = rs5.getInt("total");
            }
            ResultSet rs6 = stmt.executeQuery("SELECT COUNT(*) AS total FROM luggage where LFDM = 'Destroyed'");

            while (rs6.next()) {
                count1 = rs6.getInt("total");

            }
            ResultSet rs7 = stmt.executeQuery("SELECT COUNT(*) AS total FROM luggage where LFDM = 'Found'");

            while (rs7.next()) {
                count2 = rs7.getInt("total");
            }
            count1 = count1 + count2;
        } catch (SQLException ed) {

            System.err.println(ed);

        }

        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Found & destroyed", count1),
                        new PieChart.Data("Still lost", count));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Luggage past year");

        return chart;
    }

    public PieChart CurrentLuggage() {

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        Connection conn;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) AS total FROM luggage where LFDM = 'Lost'");

            while (rs5.next()) {
                count = rs5.getInt("total");
            }
            ResultSet rs6 = stmt.executeQuery("SELECT COUNT(*) AS total FROM luggage where LFDM = 'Managed'");

            while (rs6.next()) {
                count1 = rs6.getInt("total");
             
            }
            ResultSet rs7 = stmt.executeQuery("SELECT COUNT(*) AS total FROM luggage where LFDM = 'Found'");

            while (rs7.next()) {
                count2 = rs7.getInt("total");
            }

        } catch (SQLException ed) {

            System.err.println(ed);

        }

        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Lost", count),
                        new PieChart.Data("Back to owner's", count1),
                        new PieChart.Data("Found", count2));

        final PieChart chart2 = new PieChart(pieChartData);
        chart2.setTitle("Current luggage");

        return chart2;
    }

}
