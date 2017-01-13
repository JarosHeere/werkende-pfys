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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author merij
 */
public class Results {
    
    mysql Mysql = new mysql();
    
      final String USERNAME = Mysql.username();
    final String PASSWORD = Mysql.password();
    final String CONN_STRING = Mysql.urlmysql();
    
     private ObservableList<ObservableList> data, lugagedata;
    private TableView tableview, lugage;
    
     public void show() {
        Connection c;

        data = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM login";
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

    TableView ShowTable() {

        tableview = new TableView();
        show();

        return this.tableview;
    }
    
}
