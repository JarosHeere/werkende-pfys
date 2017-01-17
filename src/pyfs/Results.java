package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 *
 * @author merij
 */
public class Results {

    private String[] info;
    private String[] Label;
    private String fUnr;

    public void setInfo(String[] info) {
        this.info = info;
    }

    public void Label(String[] Label) {
        this.Label = Label;
    }

    public void fUnr(String fUnr) {
        this.fUnr = fUnr;
    }

    public GridPane ResultGrid() {

        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        grid.add(ShowTableLuggage(), 1, 0);

        return grid;
    }

    mysql Mysql = new mysql();

    final String USERNAME = Mysql.username();
    final String PASSWORD = Mysql.password();
    final String CONN_STRING = Mysql.urlmysql();

    private ObservableList<ObservableList> data, date, loc;
    private TableView tableview, dateTable, locTable;

    public void showLuggageL() {
        Connection c;
        Connection a;
        int Unr = 0;

        data = FXCollections.observableArrayList();

        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            //SQL FOR SELECTING ALL OF CUSTOMER

            ResultSet rs;

            if (Label[0].isEmpty()) {
                String SQL = "SELECT * FROM luggage where Luggagetype LIKE" + "'%" + info[0] + "%'" + " and Luggagebrand LIKE " + "'%" + info[1] + "%'" + " and Luggagecol LIKE " + "'%"
                        + info[2] + "%'" + " and Luggageweight LIKE " + "'%" + info[3] + "%'" + " and Luggagespef LIKE " + "'%" + info[4] + "%'" + "and LFDM = 'Found'";
                rs = c.createStatement().executeQuery(SQL);
            } else {

                String SQL = "SELECT * FROM luggage l, flight f WHERE f.Unr = l.Unr AND f.labelnr =" + "'" + Label[0] + "'" + " AND l.LFDM = 'Found'";
                 rs = c.createStatement().executeQuery(SQL);
                while (rs.next()) {
                    Unr = rs.getInt("Unr");
                }

                if (Unr != 0) {

                    String SQL3 = " SELECT * FROM luggage WHERE Unr =" + "'" + Unr + "'";
                    rs = c.createStatement().executeQuery(SQL3);

                }

            }

            //ResultSet
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableview.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");

            }

            /**
             * ******************************
             * Data added to ObservableList * ******************************
             */
            
            rs.beforeFirst();
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

    }

    TableView ShowTableLuggage() {

        tableview = new TableView();
        showLuggageL();

        return this.tableview;
    }

    public void setManaged(String fUnr) {

        Connection c;

        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            //SQL FOR SELECTING ALL OF CUSTOMER

            String SQL = "UPDATE luggage SET LFDM = 'Managed' WHERE Unr = " + "'" + fUnr + "'";

            //ResultSet
            Statement st = c.createStatement();
            st.executeUpdate(SQL);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

    }

}
