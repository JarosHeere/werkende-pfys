/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Merijn Molenaar
 */
public class ResultsFound {

    public ResultsFound() {
    }
    
      private String[] info;
    private String[] Label;

    public void setInfo(String[] info) {
        this.info = info;
    }
    
     public void Label(String [] Label) {
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
        Connection c;
  int Unr = 0;
        data = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
             String SQL2 = "SELECT * FROM flight WHERE labelnr = " + "'" + Label[0] + "' and " + "flightnr = " + "'" + Label[1] + "'";
           
            //ResultSet
            
            ResultSet rs2 = c.createStatement().executeQuery(SQL2);
            
           while (rs2.next()) { 
           Unr = rs2.getInt("Unr");
           }
            
            
            
            
            
            
            
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM luggage where LFDM = 'Lost' and Luggagetype =" + "'" + info[0] + "'" + " and Luggagebrand = " + "'" + info[1] + "'" + " and Luggagecol = " + "'" 
                    + info[2] + "'" + " and Luggageweight = " + "'" + info[3] +"'" + " or Unr = " + "'" + Unr + "'" + " or Luggagespef = " + "'" + info[4] + "'";
           
            //ResultSet
            
            ResultSet rs = c.createStatement().executeQuery(SQL);
            
            

            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             *********************************
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
             * Data added to ObservableList *
             *******************************
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

    }

    TableView ShowTableLuggage() {

        tableview = new TableView();
        showLuggageL();

        return this.tableview;
    }
    
     
    
     public void showPerson() {
        Connection c;
        int Unr = 0;
        
        int Pnr = 0;

        person = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
             String SQL3 = "SELECT * FROM flight WHERE labelnr = " + "'" + Label[0] + "' and " + "flightnr = " + "'" + Label[1] + "'";
           
            //ResultSet
            
            ResultSet rs3 = c.createStatement().executeQuery(SQL3);
            
           while (rs3.next()) { 
           Unr = rs3.getInt("Unr");
           }
            
             String SQL2 = "SELECT * FROM luggage where LFDM = 'Lost' and Luggagetype =" + "'" + info[0] + "'" + " and Luggagebrand = " + "'" + info[1] + "'" + " and Luggagecol = " + "'" 
                    + info[2] + "'" + " and Luggageweight = " + "'" + info[3] +"'" + " or Unr = " + "'" + Unr + "'";
           
            //ResultSet
            
            ResultSet rs2 = c.createStatement().executeQuery(SQL2);
            while (rs2.next()) {
                
               Pnr = rs2.getInt("Pnr");
               
                
            }
            
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM persoon WHERE Pnr = " + "'" + Pnr + "'";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);
            
          

            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             *********************************
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
             * Data added to ObservableList *
             *******************************
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

            //FINALLY ADDED TO TableView
            personTable.setItems(person);
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
    
  

    
}

    

