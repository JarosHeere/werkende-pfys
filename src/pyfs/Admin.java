package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
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

    public mysql Mysql = new mysql();
    TextField username, usernameRemove, usernameUpdate, usernameCurrentUpdate, password, passwordRemove, passwordUpdate, toegang, toegangUpdate;
    TextField luggagenr, luggageType, luggageBrand, luggageCol, luggageWeight, luggageSpef, luggageUnr, luggageLFDM;

    final String USERNAME = Mysql.username();
    final String PASSWORD = Mysql.password();
    final String CONN_STRING = Mysql.urlmysql();

    private ObservableList<ObservableList> data, luggagedata;
    private TableView tableview, luggage;

    public Admin() {
    }

    public  void buildDataLogin() {
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
             * TABLE COLUMN ADDED DYNAMICALLY * ********************************
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

    public void buildDataLuggage() {
        Connection c;

        luggagedata = FXCollections.observableArrayList();
        try {
            c = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM luggage";
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
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                luggage.getColumns().addAll(col);
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
                luggagedata.add(row);

            }

            //FINALLY ADDED TO TableView
            luggage.setItems(luggagedata);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

    }

    TableView adminTableLuggage() {

        luggage = new TableView();
        buildDataLuggage();

        return this.luggage;
    }

    public TextField luggageNr() {

        luggagenr = new TextField();                 //text voor tijd invullen
        luggagenr.setPromptText("UNr");
        luggagenr.setFont(Font.font("Verdana", 20));
        luggagenr.setMaxWidth(220);
        luggagenr.setTranslateX(-110);

        return luggagenr;

    }

    public String getLuggageNr() {
        return luggagenr.getText();
    }

    public TextField luggageType() {

        luggageType = new TextField();                 //text voor tijd invullen
        luggageType.setPromptText("Type");
        luggageType.setFont(Font.font("Verdana", 20));
        luggageType.setMaxWidth(220);
        luggageType.setTranslateX(-250);
        luggageType.setTranslateY(-20);

        return luggageType;

    }

    public TextField luggageBrand() {

        luggageBrand = new TextField();                 //text voor tijd invullen
        luggageBrand.setPromptText("Brand");
        luggageBrand.setFont(Font.font("Verdana", 20));
        luggageBrand.setMaxWidth(220);
        luggageBrand.setTranslateX(-250);
        luggageBrand.setTranslateY(20);

        return luggageBrand;

    }

    public TextField luggageCol() {

        luggageCol = new TextField();                 //text voor tijd invullen
        luggageCol.setPromptText("Colour");
        luggageCol.setFont(Font.font("Verdana", 20));
        luggageCol.setMaxWidth(220);
        luggageCol.setTranslateX(0);
        luggageCol.setTranslateY(20);

        return luggageCol;

    }

    public TextField luggageWeight() {

        luggageWeight = new TextField();                 //text voor tijd invullen
        luggageWeight.setPromptText("Weight (.. KG)");
        luggageWeight.setFont(Font.font("Verdana", 20));
        luggageWeight.setMaxWidth(220);
        luggageWeight.setTranslateX(0);
        luggageWeight.setTranslateY(-20);

        return luggageWeight;

    }

    public TextField luggageSpef() {

        luggageSpef = new TextField();                 //text voor tijd invullen
        luggageSpef.setPromptText("Specifications");
        luggageSpef.setFont(Font.font("Verdana", 20));
        luggageSpef.setMaxWidth(220);
        luggageSpef.setTranslateX(250);
        luggageSpef.setTranslateY(-20);

        return luggageSpef;

    }

    public TextField luggageUnr() {

        luggageUnr = new TextField();                 //text voor tijd invullen
        luggageUnr.setPromptText("Unr");
        luggageUnr.setFont(Font.font("Verdana", 20));
        luggageUnr.setMaxWidth(220);
        luggageUnr.setTranslateX(-600);

        return luggageUnr;

    }

    public TextField luggageLFDM() {

        luggageLFDM = new TextField();                 //text voor tijd invullen
        luggageLFDM.setPromptText("Status");
        luggageLFDM.setFont(Font.font("Verdana", 20));
        luggageLFDM.setMaxWidth(220);
        luggageLFDM.setTranslateX(250);
        luggageLFDM.setTranslateY(20);

        return luggageLFDM;

    }

    public String getLuggageType() {
        return luggageType.getText();
    }

    public String getLuggageBrand() {
        return luggageBrand.getText();
    }

    public String getLuggageCol() {
        return luggageCol.getText();
    }

    public String getLuggageWeight() {
        return luggageWeight.getText();
    }

    public String getLuggageSpef() {
        return luggageSpef.getText();
    }

    public String getLuggageUnr() {
        return luggageUnr.getText();
    }

    public String getLuggageLFDM() {
        return luggageLFDM.getText();
    }

    public void ClearUser() {
        username.setText("");
        password.setText("");
        toegang.setText("");
    }

    public void ClearRemoveUser() {
        usernameRemove.setText("");
        passwordRemove.setText("");
    }

    public void ClearUpdateUser() {
        usernameUpdate.setText("");
        usernameCurrentUpdate.setText("");
        passwordUpdate.setText("");
        toegangUpdate.setText("");
    }

    public void ClearRemoveLuggage() {
        luggagenr.setText("");
    }

    public void ClearUpdateLuggage() {
        luggageType.setText("");
        luggageBrand.setText("");
        luggageCol.setText("");
        luggageWeight.setText("");
        luggageSpef.setText("");
        luggageUnr.setText("");
        luggageLFDM.setText("");
    }

    public void Check(String username) {

        Connection conn;                                                            //making connection to database

        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String query = ("SELECT * from login WHERE username  = " + '"' + username + '"');
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.absolute(1)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("warning");
                alert.setHeaderText("username already exists. Please choose another username");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
