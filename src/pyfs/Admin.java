package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 *
 * @author IS109-Groep 5
 */
public class Admin {

    mysql Mysql = new mysql();
    TextField username, usernameRemove, usernameUpdate, usernameCurrentUpdate, password, passwordRemove, passwordUpdate, toegang, toegangRemove, toegangUpdate;
    TextField lugagenr;

    final String USERNAME = Mysql.username();
    final String PASSWORD = Mysql.password();
    final String CONN_STRING = Mysql.urlmysql();

    private ObservableList<ObservableList> data, lugagedata;
    private TableView tableview, lugage;

    public Admin() {
    }

    public void buildDataLogin() {
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
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
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

    TableView adminTable() {

        tableview = new TableView();
        buildDataLogin();

        return this.tableview;
    }

    public TextField addUsername() {

        username = new TextField();                 //text voor tijd invullen
        username.setPromptText("Username");
        username.setFont(Font.font("Verdana", 20));
        username.setMaxWidth(220);
        username.setTranslateX(-350);

        return username;

    }

    public TextField addPassword() {

        password = new TextField();                 //text voor tijd invullen
        password.setPromptText("Password");
        password.setFont(Font.font("Verdana", 20));
        password.setMaxWidth(220);
        password.setTranslateX(-100);

        return password;

    }

    public TextField Toegang() {

        toegang = new TextField();                 //text voor tijd invullen
        toegang.setPromptText("Acces");
        toegang.setFont(Font.font("Verdana", 20));
        toegang.setMaxWidth(220);
        toegang.setTranslateX(150);

        return toegang;

    }

    public String getTextAddusername() {
        return username.getText();
    }

    public String getTextAddpassword() {
        return password.getText();
    }

    public String getTextAddtoegang() {
        return toegang.getText();
    }

     public TextField removeUsername() {

        usernameRemove = new TextField();                 //text voor tijd invullen
        usernameRemove.setPromptText("Username");
        usernameRemove.setFont(Font.font("Verdana", 20));
        usernameRemove.setMaxWidth(220);
        usernameRemove.setTranslateX(-350);

        return usernameRemove;

    }

    public TextField removePassword() {

        passwordRemove = new TextField();                 //text voor tijd invullen
        passwordRemove.setPromptText("Password");
        passwordRemove.setFont(Font.font("Verdana", 20));
        passwordRemove.setMaxWidth(220);
        passwordRemove.setTranslateX(-100);

        return passwordRemove;

    }

    

    public String getTextRemoveusername() {
        return usernameRemove.getText();
    }

    public String getTextRemovepassword() {
        return passwordRemove.getText();
    }
    
    public TextField updateCurrentUsername() {

        usernameCurrentUpdate = new TextField();                 //text voor tijd invullen
        usernameCurrentUpdate.setPromptText("Current Username");
        usernameCurrentUpdate.setFont(Font.font("Verdana", 20));
        usernameCurrentUpdate.setMaxWidth(220);
        usernameCurrentUpdate.setTranslateX(-400);

        return usernameCurrentUpdate;

    }
    
     public TextField updateUsername() {

        usernameUpdate = new TextField();                 //text voor tijd invullen
        usernameUpdate.setPromptText("Username");
        usernameUpdate.setFont(Font.font("Verdana", 20));
        usernameUpdate.setMaxWidth(220);
        usernameUpdate.setTranslateX(-150);

        return usernameUpdate;

    }

    public TextField updatePassword() {

        passwordUpdate = new TextField();                 //text voor tijd invullen
        passwordUpdate.setPromptText("Password");
        passwordUpdate.setFont(Font.font("Verdana", 20));
        passwordUpdate.setMaxWidth(220);
        passwordUpdate.setTranslateX(100);

        return passwordUpdate;

    }

    public TextField updateToegang() {

        toegangUpdate = new TextField();                 //text voor tijd invullen
        toegangUpdate.setPromptText("Acces");
        toegangUpdate.setFont(Font.font("Verdana", 20));
        toegangUpdate.setMaxWidth(220);
        toegangUpdate.setTranslateX(350);

        return toegangUpdate;

    }

    public String getTextUpdateusername() {
        return usernameUpdate.getText();
    }

    public String getTextUpdatepassword() {
        return passwordUpdate.getText();
    }

    public String getTextUpdatetoegang() {
        return toegangUpdate.getText();
    }
    public String getTextUpdateCurrent() {
        return usernameCurrentUpdate.getText();
    }
    
     public void buildDataLugage() {
        Connection c;

        lugagedata = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM lugage";
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
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                lugage.getColumns().addAll(col);
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
                lugagedata.add(row);

            }

            //FINALLY ADDED TO TableView
            lugage.setItems(lugagedata);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

    }
     
      TableView adminTableLugage() {

        lugage = new TableView();
        buildDataLugage();

        return this.lugage;
    }
      
       public TextField lugageNr() {

        lugagenr = new TextField();                 //text voor tijd invullen
        lugagenr.setPromptText("Lugage Nr");
        lugagenr.setFont(Font.font("Verdana", 20));
        lugagenr.setMaxWidth(220);
        lugagenr.setTranslateX(-110);

        return lugagenr;

    }

    public String getLugageNr() {
        return lugagenr.getText();
    }

}
