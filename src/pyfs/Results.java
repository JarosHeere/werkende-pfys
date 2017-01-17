package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
<<<<<<< HEAD
                String SQL = "SELECT * FROM luggage where Luggagetype LIKE" + "'%" + info[0] + "%'" + " and Luggagebrand LIKE " + "'%" + info[1] + "%'" + " and Luggagecol LIKE " + "'%"
                    + info[2] + "%'" + " and Luggageweight LIKE " + "'%" + info[3] + "%'" + " or Luggagespef LIKE " + "'%" + info[4] + "%'" + "and LFDM = 'Found'";
=======
                String SQL = "SELECT * FROM luggage where Luggagetype LIKE" + "'%" + info[0] + "%'" + " or Luggagebrand LIKE " + "'%" + info[1] + "%'" + " or Luggagecol LIKE " + "'%"
                        + info[2] + "%'" + " or Luggageweight LIKE " + "'%" + info[3] + "%'" + " or Luggagespef LIKE " + "'%" + info[4] + "%'" + "and LFDM = 'Found'";
>>>>>>> origin/master

                //ResultSet
                ResultSet rs = c.createStatement().executeQuery(SQL);
  ResultSet rs2 = c.createStatement().executeQuery(SQL);

            while (rs2.next()) {
                Unr = rs2.getInt("Unr");
            }
                
                
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
<<<<<<< HEAD
            
=======

        } else {

            try {
                a = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

                String SQL2 = "SELECT * FROM luggage WHERE Unr = " + "'" + Unr + "'";

                //ResultSet
                ResultSet rs2 = a.createStatement().executeQuery(SQL2);

                /**
                 * ********************************
                 * TABLE COLUMN ADDED DYNAMICALLY *
                 * ********************************
                 */
                for (int i = 0; i < rs2.getMetaData().getColumnCount(); i++) {
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn(rs2.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });
                    System.out.println("Column [" + i + "] ");
                    tableview.getColumns().addAll(col);
                    while (rs2.next()) {
                        //Iterate Row
                        ObservableList<String> row = FXCollections.observableArrayList();
                        for (int l = 1; l <= rs2.getMetaData().getColumnCount(); l++) {
                            //Iterate Column
                            row.add(rs2.getString(l));
                        }
                        System.out.println("Row [1] added " + row);
                        data.add(row);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }

            tableview.setItems(data);

        }
>>>>>>> origin/master
    }

         

          

    TableView ShowTableLuggage() {

        tableview = new TableView();
        showLuggageL();

        return this.tableview;
    }

    /* public void showDate() {
        Connection c;

        date = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
             String SQL2 = "SELECT * FROM luggage where LFDM = 'Found' and Luggagetype =" + "'" + info[0] + "'" + " and Luggagebrand = " + "'" + info[1] + "'" + " and Luggagecol = " + "'" 
                    + info[2] + "'" + " and Luggageweight = " + "'" + info[3] +"'";
           
            //ResultSet
            
            ResultSet rs2 = c.createStatement().executeQuery(SQL2); 
            while(rs2.next()) {
                
                this.Date[0] = rs2.getInt("Unr");
                
            }
            
            
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM flight WHERE";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);
            
          

            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             *********************************
     */
 /*       for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                dateTable.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            /**
             * ******************************
             * Data added to ObservableList *
             *******************************
     */
 /*     while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                date.add(row);

            }

            //FINALLY ADDED TO TableView
            dateTable.setItems(date);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

    }

    TableView ShowTableDate() {

        dateTable = new TableView();
        showDate();

        return this.dateTable;
    } */
}
