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
 * @author Merijn Molenaar
 */
public class ResultsFound {

    public ResultsFound() {
    }

    private String[] info;
    private String[] Label;
    private int Pnr;

    public void setInfo(String[] info) {
        this.info = info;
    }

    public void Label(String[] Label) {
        this.Label = Label;
    }

    public GridPane ResultGrid() {

        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        grid.add(ShowTableLuggage(), 1, 0);
        grid.add(ShowTablePerson(), 2, 0);

        return grid;
    }

    mysql Mysql = new mysql();

    final String USERNAME = Mysql.username();
    final String PASSWORD = Mysql.password();
    final String CONN_STRING = Mysql.urlmysql();

    private ObservableList<ObservableList> data, person, loc;
    private TableView tableview, personTable, locTable;

    public void showLuggageL() {
        
        Pnr = 0;
        Connection c;
        int Unr = 0;
        data = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

           ResultSet rs;
            if (Label[0].isEmpty()) {
                String SQL = "SELECT * FROM luggage where Luggagetype LIKE" + "'%" + info[0] + "%'" + " and Luggagebrand LIKE " + "'%" + info[1] + "%'" + " and Luggagecol LIKE " + "'%"
                        + info[2] + "%'" + " and Luggageweight LIKE " + "'%" + info[3] + "%'" + " and Luggagespef LIKE " + "'%" + info[4] + "%'" + "and LFDM = 'Lost'";
                rs = c.createStatement().executeQuery(SQL);
                
                while(rs.next()) {
                    
                    this.Pnr = rs.getInt("Pnr");
                    
                }
            } else {

                String SQL = "SELECT * FROM luggage l, flight f WHERE f.Unr = l.Unr AND f.labelnr =" + "'" + Label[0] + "'" + " AND l.LFDM = 'Lost'";
                 rs = c.createStatement().executeQuery(SQL);
                while (rs.next()) {
                    Unr = rs.getInt("Unr");
                    Pnr = rs.getInt("Pnr");
                }

                if (Unr != 0) {

                    String SQL3 = " SELECT * FROM luggage WHERE Unr =" + "'" + Unr + "'";
                    rs = c.createStatement().executeQuery(SQL3);
                    
                    

                }

            }
            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY * ********************************
             */
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

    public void showPerson() {
        Connection c;
  

    

        person = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

         
            //SQL FOR SELECTING ALL OF CUSTOMER
            if(this.Pnr != 0) {
                
            }
            String SQL = "SELECT * FROM persoon WHERE Pnr = " + "'" + this.Pnr + "'";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY * ********************************
             */
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                personTable.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            /**
             * ******************************
             * Data added to ObservableList * ******************************
             */
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                person.add(row);

            }
            personTable.setItems(person);
            //FINALLY ADDED TO TableView

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

    }

    TableView ShowTablePerson() {

        personTable = new TableView();
        showPerson();

        return this.personTable;
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
