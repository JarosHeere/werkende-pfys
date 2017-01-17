package pyfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author IS109-Groep 5
 *
 */
public class pyfs extends Application {

    /* Code is ingedeeld per sectie (login, menu, lost, found en stat)
    Aan het begin worden alle controls aangeroepen, dit is zo ingedeeld dat je
    snel kan onderscheiden welke control op welke pagina zit. Verder in de code zijn
    alle secties onderscheidde doormiddel van comments. Door control f te doen kan je snel naar de juiste sectie
    springen. Alle eens sectie meerder paginas heeft wordt dit doormiddel van een numering gedaan bijv. lost (eerste pag) lost1, lost2, lost 3 & lostfinal (laatste pag)
     */
    Stage thestage;

    //login
    Scene loginscherm;
    Button loginbtn;
    StackPane inlogschermpane;

    //Menu
    Button statbtn, lostbtn, foundbtn, logoutbtn, adminbtn;
    StackPane menupane;
    Scene menu;

    //Lost
    Button lostterugmenu, lostnext, lostnext2, lostback, lostback2, search, lostterugfinal, lostnext3, lostback3;
    TextField username;
    PasswordField password;
    StackPane lostpane, lost2pane, lost3pane, lost4pane, lostfinalpane;
    Scene lost, lost2, lost3, lost4, lostfinal;

    //Found
    Button foundterugmenu, foundnext, foundnext2, foundnext3, find, foundback, foundback2, foundfinalButton;
    StackPane foundpane, found2pane, found3pane, foundfinalpane;
    Scene found, found2, found3, foundfinal;

    //Stat
    Button statterugmenu, yearbtn, currentbtn;
    StackPane statpane, yearpane, currentpane;
    Scene stat, year, current;
    Stage yearstage, currentstage;

    //Admin
    Button adminterugmenu, userTableBtn;
    StackPane adminpane, userTablePane, userRemovePane, userUpdatePane, luggageTablePane, luggageRemovePane, luggageUpdatePane;
    Scene admin, userTable, userCreate, userRemove, userUpdate, luggageTable, luggageRemove, luggageUpdate;
    Stage userTableStage, userCreateStage, userRemoveStage, userUpdateStage, luggageTableStage, luggageRemoveStage, luggageUpdateStage;

    @Override
    public void start(Stage primaryStage) {

        thestage = primaryStage;                                                 // declares the stage
        Found found1 = new Found();                                              //
        Lost lost1 = new Lost();                                                 //
        Stat stat1 = new Stat();                                                 //
        Login login = new Login();                                               //
        mysql Mysql = new mysql();                                               //
        Lostd lostd = new Lostd();                                               //  makes new objects of the classes and giving them a name.
        Admin admin1 = new Admin();                                              //
        Admind admind = new Admind();                                            //
        Foundd foundd = new Foundd();                                            //
        Results results = new Results();                                         //
        ResultsFound resultfound = new ResultsFound();//

        //BEGIN CONTROLS
        //Loginscherm
        Button loginbtn = new Button();
        loginbtn.setText("Login");                                               // login button & style
        loginbtn.setPrefSize(200, 50);
        loginbtn.setTranslateY(90);
        loginbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        loginbtn.setOnAction(new EventHandler<ActionEvent>() {                   // this will happen when you click the button

            @Override
            public void handle(ActionEvent event) {

                String UserName = login.getTextUsername();                       // getting username
                String Password = login.getTextPassword();                       // getting password

                Connection conn;                                                 // declares the connection name

                final String USERNAME = Mysql.username();                        // getting the username from the database
                final String PASSWORD = Mysql.password();                        // getting the password from the database
                final String CONN_STRING = Mysql.urlmysql();                     // getting the connection string to connect with the database

                try {

                    conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);     // making connection to the database
                    System.out.println("Connected login");
                    Statement stmt = (Statement) conn.createStatement();         // creates a statement
                    ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) AS total FROM login WHERE username= " + '"' + UserName + '"');   //check if there is a account with the same name
                    int count = 0;

                    while (rs1.next()) {                                         // getting total
                        count = rs1.getInt("total");
                    }

                    ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE username = " + "'" + UserName + "'");               //getting username from database

                    if (count > 0) {

                        while (rs.next()) {

                            String pass = rs.getString("password");
                            if (pass.equals(Password)) {                         // check if passwords are the same
                                toegang = rs.getInt("permission");               // gets the permissionlevel
                                thestage.setScene(menu);                         // go to the next stage
                                login.Clear();                                   // clears the fields

                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);   // get an alert popup
                                alert.setTitle("warning");
                                alert.setHeaderText("username and/or password are incorrect");
                                alert.showAndWait();
                                login.Clear();                                   // clears the fields
                            }

                        }

                    } else {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);    // get an alert popup
                        alert.setTitle("warning");
                        alert.setHeaderText("username and/or password are incorrect");
                        alert.showAndWait();
                        login.Clear();                                           // clears the fields

                    }

                } catch (SQLException ed) {

                    System.err.println(ed);                                      // print the warning message

                }

            }

        }
        );

        //verklaren alle toegevoegde controls
        //menu
        logoutbtn = new Button();
        logoutbtn.setText("Logout");                                             // logout button & style
        logoutbtn.setPrefSize(200, 50);
        logoutbtn.setTranslateY(-370);
        logoutbtn.setTranslateX(700);
        logoutbtn.setStyle(
                "-fx-base:darkcyan;-fx-border-color:black");
        logoutbtn.setOnAction(
                new EventHandler<ActionEvent>() {                                // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(loginscherm);                                  // go to the next scene

            }
        }
        );

        lostbtn = new Button();

        lostbtn.setText("Lost");                                                 // lost button & style
        lostbtn.setPrefSize(200, 50);
        lostbtn.setTranslateX(-500);
        lostbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostbtn.setOnAction(
                new EventHandler<ActionEvent>() {                                // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(lost);                                         // go to the next scene
            }
        }
        );

        foundbtn = new Button();
        foundbtn.setText("Found");                                               // found button & style
        foundbtn.setPrefSize(200, 50);
        foundbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundbtn.setOnAction(new EventHandler<ActionEvent>() {                   // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(found);                                        // go to the next scene

            }
        }
        );

        statbtn = new Button();
        statbtn.setText("Statistics");                                           // statistics button & style
        statbtn.setPrefSize(200, 50);
        statbtn.setTranslateX(500);
        statbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        statbtn.setOnAction(new EventHandler<ActionEvent>() {                    // this will happen when you click the button

            @Override
            public void handle(ActionEvent event) {

                if (toegang >= 2) {                                              // if the permissionlevel is 2 or higher you can go to this stage
                    thestage.setScene(stat);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);        // get an alert popup
                    alert.setTitle("Warning");
                    alert.setHeaderText("You do not have permission to this page"); // if the permissionlevel is lower then 2 print this errormessage
                    alert.showAndWait();

                }

            }
        });

        adminbtn = new Button();
        adminbtn.setText("Admin");                                               // admin button & style
        adminbtn.setPrefSize(200, 50);
        adminbtn.setTranslateY(-370);
        adminbtn.setTranslateX(-700);
        adminbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        adminbtn.setOnAction(new EventHandler<ActionEvent>() {                   // this will happen when you click the button

            @Override
            public void handle(ActionEvent eventF) {

                if (toegang == 3) {                                              // if the permissionlevel is exactly 3 you can go to this stage

                    thestage.setScene(admin);

                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);        // get an alert popup
                    alert.setTitle("Warning");
                    alert.setHeaderText("You do not have permission to this page"); // if the permissionlevel is lower then 3 print this errormessage
                    alert.showAndWait();
                }
            }
        }
        );

        //lost
        lostterugmenu = new Button();
        lostterugmenu.setText("Back");                                           // back button & style
        lostterugmenu.setPrefSize(200, 50);
        lostterugmenu.setTranslateY(-370);
        lostterugmenu.setTranslateX(700);
        lostterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostterugmenu.setOnAction(new EventHandler<ActionEvent>() {              // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(menu);                                         // go to the previous scene

            }
        }
        );

        lostnext = new Button();
        lostnext.setText("Next");                                                // next button & style
        lostnext.setPrefSize(120, 50);
        lostnext.setTranslateY(105);
        lostnext.setTranslateX(55);
        lostnext.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostnext.setOnAction(new EventHandler<ActionEvent>() {                   // this will happen when you click the button

            public void handle(ActionEvent event
            ) {
                String[] date = new String[4];                                   // make a new array called date from the type string
                date[0] = lost1.getDate();                                       //
                date[1] = lost1.getTime();                                       //
                date[2] = lost1.getAirport();                                    // save the data to the array
                System.out.println(date[0]);                                     //
                lostd.setLostdate(date);                                         // 
                thestage.setScene(lost2);                                        // go to the next scene
            }
        }
        );

        //lost 2
        lostback = new Button();
        lostback.setText("Back");                                                // back button & style
        lostback.setPrefSize(200, 50);
        lostback.setTranslateY(-370);
        lostback.setTranslateX(700);
        lostback.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostback.setOnAction(new EventHandler<ActionEvent>() {                   // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(lost);                                         // go to the previous scene 
            }
        }
        );

        lostnext2 = new Button();
        lostnext2.setText("Next");                                               // next button & style
        lostnext2.setPrefSize(120, 50);
        lostnext2.setTranslateY(105);
        lostnext2.setTranslateX(55);
        lostnext2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostnext2.setOnAction(new EventHandler<ActionEvent>() {                  // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                String[] persoon = new String[7];                                // make a new array from the type string called persoon
                persoon[0] = lost1.getTextNaam();                                //
                persoon[1] = lost1.getTextAdres();                               //
                persoon[2] = lost1.getCity();                                    //
                persoon[3] = lost1.getTextZip();                                 // save the data to the array
                persoon[4] = lost1.getTextCountry();                             //
                persoon[5] = lost1.getTextPhone();                               //
                persoon[6] = lost1.getTextMail();                                //

                lostd.setP(persoon);
                thestage.setScene(lost3);                                        // go to the next scene
            }
        }
        );

        lostback2 = new Button();
        lostback2.setText("Back");                                               // back button & style
        lostback2.setPrefSize(200, 50);
        lostback2.setTranslateY(-370);
        lostback2.setTranslateX(700);
        lostback2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostback2.setOnAction(new EventHandler<ActionEvent>() {                  // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(lost2);                                        // go to the previous scene
            }
        }
        );

        lostnext3 = new Button();
        lostnext3.setText("Next");                                               // next button & style
        lostnext3.setPrefSize(120, 50);
        lostnext3.setTranslateY(175);
        lostnext3.setTranslateX(92);
        lostnext3.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostnext3.setOnAction(new EventHandler<ActionEvent>() {                  // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(lost4);                                        // go to the next scene
            }
        }
        );

        search = new Button();
        search.setText("Search");                                                // search button & style
        search.setPrefSize(120, 50);
        search.setTranslateY(175);
        search.setTranslateX(92);
        search.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        search.setOnAction(new EventHandler<ActionEvent>() {                     // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                String[] label = new String[3];                                  // make a new array from the type string called label
                label[0] = lost1.getTextLabelnr();                               //
                label[1] = lost1.getTextFlightnr();                              // save the data to the array
                label[2] = lost1.getTextDestin();                                //
                lostd.setLabel(label);                                           //

                String[] lostbagage = new String[5];                             // make a new array from the type string called lostbagage
                lostbagage[0] = lost1.getTextLugype();                           //
                lostbagage[1] = lost1.getTextLygbrand();                         // save the data to the array
                lostbagage[2] = lost1.getTextLugcolor();                         //
                lostbagage[3] = lost1.getTextlugweight();                        //
                lostbagage[4] = lost1.getTextLugspef();                          //

                lostd.setLostbagage(lostbagage);

                int unr = lostd.Unr();                                           // get the unr from lostd
                int pnr = lostd.invullenP();                                     // get the pnr from lostd

                lostd.getLabel(unr);                                             //
                lostd.getLuggage(unr, pnr);                                      // assign the values of unr and pnr
                lostd.getDate(unr);                                              //

                results.setInfo(lostbagage);                                     // fills in the info
                results.Label(label);                                            // fills in the label
                lostfinalpane.getChildren().add(results.ResultGrid());           // show the results
                lostfinalpane.getChildren().add(lostterugfinal);                 // 
                lost1.Clear();                                                   // clears the fields
                //lostd.zoeken(labelnr);
                thestage.setScene(lostfinal);                                    // go to the next scene
                
            }

        }
        );

        lostback3 = new Button();
        lostback3.setText("Back");                                               // back button & style
        lostback3.setPrefSize(200, 50);
        lostback3.setTranslateY(-370);
        lostback3.setTranslateX(700);
        lostback3.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostback3.setOnAction(new EventHandler<ActionEvent>() {                  // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(lost3);                                        // go to the previous scene
            }
        }
        );

        //lost final
        lostterugfinal = new Button();
        lostterugfinal.setText("Menu");                                           //lost terug menu button
        lostterugfinal.setPrefSize(200, 50);
        lostterugfinal.setTranslateY(-370);
        lostterugfinal.setTranslateX(700);
        lostterugfinal.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        lostterugfinal.setOnAction(new EventHandler<ActionEvent>() {             // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(menu);                                         // go to the next scene
            }
        }
        );

        //found
        foundterugmenu = new Button();
        foundterugmenu.setText("Back");                                          // back button & style
        foundterugmenu.setPrefSize(200, 50);
        foundterugmenu.setTranslateY(-370);
        foundterugmenu.setTranslateX(700);
        foundterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundterugmenu.setOnAction(new EventHandler<ActionEvent>() {             // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(menu);                                         // go to the previous scene

            }
        }
        );

        foundnext = new Button();
        foundnext.setText("Next");                                               // next button & style
        foundnext.setPrefSize(120, 50);
        foundnext.setTranslateY(105);
        foundnext.setTranslateX(55);
        foundnext.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundnext.setOnAction(new EventHandler<ActionEvent>() {                  // this will happen when you click the button         

            @Override
            public void handle(ActionEvent event
            ) {
                String[] datex = new String[4];                                  // make a new array from the type string called datex
                datex[0] = found1.getDate().getText().toLowerCase();             //
                datex[1] = found1.getTime();                                     // fill in the array       
                datex[2] = found1.getAirport();                                  //
                System.out.println(datex[1]);                                    //
                foundd.setFoundDate(datex);                                      //
                thestage.setScene(found2);                                       // go to the next scene
            }
        }
        );

        foundback = new Button();
        foundback.setText("Back");                                               // back button & style
        foundback.setPrefSize(200, 50);
        foundback.setTranslateY(-370);
        foundback.setTranslateX(700);
        foundback.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundback.setOnAction(new EventHandler<ActionEvent>() {                  // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(found);                                        // go to the previous scene

            }
        }
        );

        foundnext2 = new Button();
        foundnext2.setText("Next");                                              // next button & style
        foundnext2.setPrefSize(120, 50);
        foundnext2.setTranslateY(105);
        foundnext2.setTranslateX(55);
        foundnext2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundnext2.setOnAction(new EventHandler<ActionEvent>() {                 // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(found3);                                       // go to the next scene
            }
        }
        );

        foundback2 = new Button();
        foundback2.setText("Back");                                              // back button & style
        foundback2.setPrefSize(200, 50);
        foundback2.setTranslateY(-370);
        foundback2.setTranslateX(700);
        foundback2.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundback2.setOnAction(new EventHandler<ActionEvent>() {                 // this will happen when you click the button
            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(found2);                                       // go to the previous scene
            }
        }
        );

        foundnext3 = new Button();
        foundnext3.setText("Place");                                             // place button & style
        foundnext3.setPrefSize(120, 50);
        foundnext3.setTranslateY(175);
        foundnext3.setTranslateX(92);
        foundnext3.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundnext3.setOnAction(new EventHandler<ActionEvent>() {                 // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {

                int unr = lostd.Unr();                                           //
                String[] foundbagage = new String[5];                            // create a new array from the type string called foundbagage
                foundbagage[0] = found1.getLugtype();                            //
                foundbagage[1] = found1.getLugbrand();                           //
                foundbagage[2] = found1.getLugcolor();                           // fill in the array
                foundbagage[3] = found1.getLugweight();                          //
                foundbagage[4] = found1.getLugspef();                            //
                foundd.setFoundbagage(foundbagage);                              //

                String[] vlucht = new String[4];                                 // create a new array from the type string called vlucht
                vlucht[0] = found1.getLabelnr();                                 //
                vlucht[1] = found1.getFlightnr();                                // fill in the array
                vlucht[2] = found1.getNametrav();                                //

                foundd.setFoundLabel(vlucht);                                    //
                foundd.getLuggage(unr);                                          //
                foundd.getLabel(unr);                                            // 
                foundd.getDate(unr);                                             //

                resultfound.setInfo(foundbagage);                                // show results
                resultfound.Label(vlucht);                                       //
                foundfinalpane.getChildren().add(resultfound.ResultGrid());      //
                found1.Clear();                                                  // clear the fields
                thestage.setScene(foundfinal);                                   // go to the next scene
            }
        }
        );

        //foundfinal
        foundfinalButton = new Button();
        foundfinalButton.setText("Menu");                                        // menu button & style
        foundfinalButton.setPrefSize(200, 50);
        foundfinalButton.setTranslateY(-370);
        foundfinalButton.setTranslateX(700);
        foundfinalButton.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        foundfinalButton.setOnAction(new EventHandler<ActionEvent>() {           // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(menu);                                         // go to the next scene
            }
        }
        );

        //stat
        statterugmenu = new Button();
        statterugmenu.setText("Back");                                           // back button & style
        statterugmenu.setPrefSize(200, 50);
        statterugmenu.setTranslateY(-370);
        statterugmenu.setTranslateX(700);
        statterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");

        statterugmenu.setOnAction(new EventHandler<ActionEvent>() {              // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(menu);                                         // go to the previous scene
            }
        }
        );

        //stat
        yearbtn = new Button();
        yearbtn.setText("Past year");                                            // past year button & style
        yearbtn.setPrefSize(200, 50);
        yearbtn.setTranslateX(300);
        yearbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        yearbtn.setOnAction(new EventHandler<ActionEvent>() {                    // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                yearstage = new Stage();                                         // make a new stage
                yearstage.setTitle("Past year");
                yearstage.setScene(year);
                yearstage.setResizable(false);                                   // make it so it isn't resizeable
                yearstage.show();                                                // show the stage
            }
        }
        );

        currentbtn = new Button();
        currentbtn.setText("Current luggage");                                   // current luggage button & style
        currentbtn.setPrefSize(200, 50);
        currentbtn.setTranslateX(-300);
        currentbtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        currentbtn.setOnAction(new EventHandler<ActionEvent>() {                 // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                currentstage = new Stage();                                      // make a new stage
                currentstage.setTitle("Current luggage");
                currentstage.setScene(current);
                currentstage.setResizable(false);                                // make it so it isn't resizeable
                currentstage.show();                                             // show the stage
            }
        }
        );

        //admin
        adminterugmenu = new Button();
        adminterugmenu.setText("Back");                                          // back button & style
        adminterugmenu.setPrefSize(200, 50);
        adminterugmenu.setTranslateY(-370);
        adminterugmenu.setTranslateX(700);
        adminterugmenu.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        adminterugmenu.setOnAction(new EventHandler<ActionEvent>() {             // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                thestage.setScene(menu);                                         // go to the next scene
            }
        }
        );

        userTableBtn = new Button();
        userTableBtn.setText("View Users");                                      // view users button & style
        userTableBtn.setPrefSize(200, 50);
        userTableBtn.setTranslateX(-400);
        userTableBtn.setTranslateY(-150);
        userTableBtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        userTableBtn.setOnAction(new EventHandler<ActionEvent>() {               // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                userTablePane.getChildren().add(admin1.adminTable());            // 
                userTableStage = new Stage();                                    // make a new stage
                userTableStage.setTitle("Users");                                // set the title
                userTableStage.setScene(userTable);                              // set the scene to userTable
                userTableStage.setResizable(false);                              // make it so it isn't resizeable
                userTableStage.show();                                           // show the stage
            }
        }
        );

        Button LuggageTableBtn = new Button();
        LuggageTableBtn.setText("View Luggage");                                 // view luggage button & style
        LuggageTableBtn.setPrefSize(200, 50);
        LuggageTableBtn.setTranslateX(-100);
        LuggageTableBtn.setTranslateY(-150);
        LuggageTableBtn.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        LuggageTableBtn.setOnAction(new EventHandler<ActionEvent>() {            // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                luggageTablePane.getChildren().add(admin1.adminTableLuggage());  //
                luggageTableStage = new Stage();                                 // make a new stage
                luggageTableStage.setTitle("Luggage");                           // set the title
                luggageTableStage.setScene(luggageTable);                        // set the scene to luggageTable
                luggageTableStage.setResizable(false);                           // make it so it isn't resizeable
                luggageTableStage.show();                                        // show the stage
            }
        }
        );

        Button createUser = new Button();
        createUser.setText("Create user");                                       // create user button & style
        createUser.setPrefSize(200, 50);
        createUser.setTranslateX(-400);
        createUser.setTranslateY(-50);
        createUser.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        createUser.setOnAction(new EventHandler<ActionEvent>() {                 // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                userCreateStage = new Stage();                                   // make a new stage       
                userCreateStage.setTitle("User creation");                       // set the title
                userCreateStage.setScene(userCreate);                            // set the scene to userCreate
                userCreateStage.setResizable(false);                             // make it so it isn't resizeable
                userCreateStage.show();                                          // show the stage
            }
        }
        );

        Button addUser = new Button();
        addUser.setText("Add");                                                  // add button & style
        addUser.setPrefSize(150, 50);
        addUser.setTranslateX(350);
        addUser.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        addUser.setOnAction(new EventHandler<ActionEvent>() {                    // this will happen when you click the button

            public void handle(ActionEvent event) {

                String[] Add = new String[3];                                    // create a new array from the type string called Add
                Add[0] = admin1.getTextAddusername();                            // fill the array
                Add[1] = admin1.getTextAddpassword();                            //
                Add[2] = admin1.getTextAddtoegang();                             //

                admind.Add(Add);                                                 // 

                userCreateStage.close();                                         // close the stage
                admin1.Check(Add[0]);                                            // check if the username exists in the database
                admin1.ClearUser();                                              // clear the fields
            }
        }
        );

        Button removeUser = new Button();
        removeUser.setText("Remove user");                                       // remove user button & style
        removeUser.setPrefSize(200, 50);
        removeUser.setTranslateX(-400);
        removeUser.setTranslateY(50);
        removeUser.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        removeUser.setOnAction(
                new EventHandler<ActionEvent>() {                                // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                userRemoveStage = new Stage();                                   // make a new stage
                userRemoveStage.setTitle("Removing User");                       // set the title
                userRemoveStage.setScene(userRemove);                            // set the scene to userRemove
                userRemoveStage.setResizable(false);                             // make it so it isn't resizeable
                userRemoveStage.show();                                          // show the stage
            }
        }
        );

        Button removeLuggage = new Button();
        removeLuggage.setText("Remove Luggage");                                 // remove luggage button & style
        removeLuggage.setPrefSize(200, 50);
        removeLuggage.setTranslateX(-100);
        removeLuggage.setTranslateY(-50);
        removeLuggage.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        removeLuggage.setOnAction(new EventHandler<ActionEvent>() {              // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                luggageRemoveStage = new Stage();                                // make a new stage
                luggageRemoveStage.setTitle("Luggage remove");                   // set the title
                luggageRemoveStage.setScene(luggageRemove);                      // set the scene to luggageRemove
                luggageRemoveStage.setResizable(false);                          // make it so it isn't resizeable
                luggageRemoveStage.show();                                       // show the stage
            }
        }
        );

        Button deleteUser = new Button();
        deleteUser.setText("Remove");                                            // remove button & style
        deleteUser.setPrefSize(150, 50);
        deleteUser.setTranslateX(350);
        deleteUser.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        deleteUser.setOnAction(new EventHandler<ActionEvent>() {                 // this will happen when you click the button

            public void handle(ActionEvent event) {
                String[] remove = new String[2];                                 // create a new array from the type string called remove
                remove[0] = admin1.getTextRemoveusername();                      // fill the array
                remove[1] = admin1.getTextRemovepassword();                      //

                admind.Delete(remove);                                           //

                userRemoveStage.close();                                         // close the stage
                admin1.ClearRemoveUser();                                        // clear the fields
            }
        }
        );

        Button deleteLuggage = new Button();
        deleteLuggage.setText("Delete");                                         // delete button & style
        deleteLuggage.setPrefSize(150, 50);
        deleteLuggage.setTranslateX(150);
        deleteLuggage.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        deleteLuggage.setOnAction(new EventHandler<ActionEvent>() {              // this will happen when you click the button

            public void handle(ActionEvent event) {
                String[] deleteLuggage = new String[1];                          // create a new array from the type string called deleteLuggage
                deleteLuggage[0] = admin1.getLuggageNr();                        // fill the array

                admind.luggageRemove(deleteLuggage);                             //

                luggageRemoveStage.close();                                      // close the stage

                admin1.ClearRemoveLuggage();                                     // clear the fields
            }
        }
        );

        Button updateUser = new Button();
        updateUser.setText("Update user");                                       // update user button & style
        updateUser.setPrefSize(200, 50);
        updateUser.setTranslateX(-400);
        updateUser.setTranslateY(150);
        updateUser.setStyle("-fx-base:darkcyan;-fx-border-color:black");

        updateUser.setOnAction(
                new EventHandler<ActionEvent>() {                                // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                userUpdateStage = new Stage();                                   // make a new stage
                userUpdateStage.setTitle("Update user");                         // set the title
                userUpdateStage.setScene(userUpdate);                            // set the scene to userUpdate
                userUpdateStage.setResizable(false);                             // make it so it isn't resizeable
                userUpdateStage.show();                                          // show the stage
            }
        }
        );

        Button update2User = new Button();
        update2User.setText("Update");                                           // update button & style
        update2User.setPrefSize(150, 50);
        update2User.setTranslateX(550);
        update2User.setStyle("fx-base:darkcyan;-fx-border-color:black");
        update2User.setOnAction(new EventHandler<ActionEvent>() {                // this will happen when you click the button

            public void handle(ActionEvent event) {
                String updateInfo[] = new String[4];                             // create a new array from the type string called updateInfo
                updateInfo[0] = admin1.getTextUpdateusername();                  //
                updateInfo[1] = admin1.getTextUpdatepassword();                  // fill the array
                updateInfo[2] = admin1.getTextUpdatetoegang();                   //
                updateInfo[3] = admin1.getTextUpdateCurrent();                   //

                admind.Update(updateInfo);                                       // 
                userUpdateStage.close();                                         // close the stage
                admin1.Check(updateInfo[0]);                                     // check if the username alreadyx exists in the database
                admin1.ClearUpdateUser();                                        // clear the fields
            }
        }
        );

        Button updateLuggage = new Button();
        updateLuggage.setText("Update Luggage");                                 // update luggage button & style
        updateLuggage.setPrefSize(200, 50);
        updateLuggage.setTranslateX(-100);
        updateLuggage.setTranslateY(50);
        updateLuggage.setStyle("-fx-base:darkcyan;-fx-border-color:black");
        updateLuggage.setOnAction(
                new EventHandler<ActionEvent>() {                                // this will happen when you click the button

            @Override
            public void handle(ActionEvent event
            ) {
                luggageUpdateStage = new Stage();                                // make a new stage
                luggageUpdateStage.setTitle("Luggage update");                   // set the title
                luggageUpdateStage.setScene(luggageUpdate);                      // set the scene to luggageUpdate
                luggageUpdateStage.setResizable(false);                          // make it so it isn't resizeable
                luggageUpdateStage.show();                                       // show the stage
            }
        }
        );

        Button update2Luggage = new Button();
        update2Luggage.setText("Update");                                        // update button & style
        update2Luggage.setPrefSize(150, 50);
        update2Luggage.setTranslateX(700);
        update2Luggage.setStyle("fx-base:darkcyan;-fx-border-color:black");
        update2Luggage.setOnAction(new EventHandler<ActionEvent>() {             // this will happen when you click the button

            public void handle(ActionEvent event) {
                String updateLuggage[] = new String[7];                          // create a new array from the type string called updateLuggage
                updateLuggage[0] = admin1.getLuggageUnr();                       //
                updateLuggage[1] = admin1.getLuggageType();                      //
                updateLuggage[2] = admin1.getLuggageBrand();                     // fill the array
                updateLuggage[3] = admin1.getLuggageCol();                       //
                updateLuggage[4] = admin1.getLuggageWeight();                    //
                updateLuggage[5] = admin1.getLuggageSpef();                      //
                updateLuggage[6] = admin1.getLuggageLFDM();                      //

                admind.luggageUpdate(updateLuggage);                             //

                luggageUpdateStage.close();                                      // close the stage
                admin1.ClearUpdateLuggage();                                     // clear the fields
            }
        }
        );
        
        Button unrLost = new Button();
        update2Luggage.setText("Search Unr");                                    // Unr button & style
        update2Luggage.setPrefSize(150, 50);
        update2Luggage.setTranslateX(700);
        update2Luggage.setStyle("fx-base:darkcyan;-fx-border-color:black");
        update2Luggage.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String unr = lost1.getTextUnr();
                
            }
        });
        
        Button unrFound = new Button();
        update2Luggage.setText("Search Unr");                                    // Unr button & style
        update2Luggage.setPrefSize(150, 50);
        update2Luggage.setTranslateX(700);
        update2Luggage.setStyle("fx-base:darkcyan;-fx-border-color:black");
        update2Luggage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String unr = found1.getTextUnr();
                
            }
        });

        //EINDE CONTROLS
        //PANES
        StackPane inlogschermpane = new StackPane();                             // create a new stackpane (lays out the children in a back-to-front stack
        inlogschermpane.getChildren().add(loginbtn);                             // add the login button
        inlogschermpane.getChildren().add(login.username());                     // add the username button
        inlogschermpane.getChildren().add(login.password());                     // add the password button
        inlogschermpane.getChildren().add(login.logologin());                    // add the logo
        inlogschermpane.setStyle("-fx-background-color:#FFFFFF");                // set the backgroundcolour

        menupane = new StackPane();                                              // create a new stackpane
        menupane.getChildren().add(logoutbtn);                                   // add the logout button
        menupane.getChildren().add(lostbtn);                                     // add the lost button
        menupane.getChildren().add(foundbtn);                                    // add the found button
        menupane.getChildren().add(statbtn);                                     // add the statistics button
        menupane.getChildren().add(adminbtn);                                    // add the admin button
        menupane.setStyle("-fx-background-color:#FFFFFF");                       // set the backgroundcolour

        lostpane = new StackPane();                                              // create a new stackpane
        lostpane.setStyle("-fx-background-color:#FFFFFF");                       // set the backgroundcolour
        lostpane.getChildren().add(lostterugmenu);                               // add the back to menu button
        lostpane.getChildren().add(lost1.date());                                // add the textfield date
        lostpane.getChildren().add(lost1.Time());                                // add the textfield time
        lostpane.getChildren().add(lost1.airport());                             // add the textfield airport
        lostpane.getChildren().add(lostnext);                                    // add the next button

        lost2pane = new StackPane();                                             // create a new stackpane
        lost2pane.setStyle("-fx-background-color:#FFFFFF");                      // set the backgroundcolour
        lost2pane.getChildren().add(lostback);                                   // add the back button
        lost2pane.getChildren().add(lost1.Naam());                               // add the textfield naam
        lost2pane.getChildren().add(lost1.adres());                              // add the textfield adres
        lost2pane.getChildren().add(lost1.City());                               // add the textfield city
        lost2pane.getChildren().add(lost1.Zip());                                // add the textfield zip
        lost2pane.getChildren().add(lost1.country());                            // add the textfield country
        lost2pane.getChildren().add(lost1.Phone());                              // add the textfield phone
        lost2pane.getChildren().add(lost1.Mail());                               // add the textfield mail
        lost2pane.getChildren().add(lostnext2);                                  // add the next button

        lost3pane = new StackPane();                                             // create a new stackpane
        lost3pane.setStyle("-fx-background-color:#FFFFFF");                      // set the backgroundcolour
        lost3pane.getChildren().add(lost1.Lugtype());                            // add the textfield lugtype
        lost3pane.getChildren().add(lost1.Lugbrand());                           // add the textfield lugbrand
        lost3pane.getChildren().add(lost1.Lugcolor());                           // add the textfield lugcolor
        lost3pane.getChildren().add(lost1.lugspef());                            // add the textfield lugspef
        lost3pane.getChildren().add(lost1.Lugweight());                          // add the textfield lugweight
        lost3pane.getChildren().add(lostback2);                                  // add the back button
        lost3pane.getChildren().add(lostnext3);                                  // add the next button

        lost4pane = new StackPane();                                             // create a new stackpane
        lost4pane.setStyle("-fx-background-color:#FFFFFF");                      // set the backgroundcolour
        lost4pane.getChildren().add(lost1.Labelnr());                            // add the textfield labelnr
        lost4pane.getChildren().add(lost1.Flightnr());                           // add the textfield flightnr
        lost4pane.getChildren().add(lost1.Destin());                             // add the textfield destin
        lost4pane.getChildren().add(search);                                     // add the search button
        lost4pane.getChildren().add(lostback3);                                  // add the back button

        lostfinalpane = new StackPane();                                         // create a new stackpane
        lostfinalpane.setStyle("-fx-background-color:#FFFFFF");                  // set the backgroundcolour
        lostfinalpane.getChildren().add(lost1.unr());
        lostfinalpane.getChildren().add(unrLost);

        foundpane = new StackPane();                                             // create a new stackpane
        foundpane.setStyle("-fx-background-color:#FFFFFF");                      // set the backgroundcolour
        foundpane.getChildren().add(foundterugmenu);                             // add the back button
        foundpane.getChildren().add(found1.date());                              // add the textfield date
        foundpane.getChildren().add(found1.Time());                              // add the textfield time
        foundpane.getChildren().add(found1.airport());                           // add the textfield airport
        foundpane.getChildren().add(foundnext);                                  // add the next button

        found2pane = new StackPane();                                            // create a new stackpane
        found2pane.setStyle("-fx-background-color:#FFFFFF");                     // set the backgroundcolour
        found2pane.getChildren().add(found1.Labelnr());                          // add the textfield labelnr
        found2pane.getChildren().add(found1.Flightnr());                         // add the textfield flightnr
        found2pane.getChildren().add(found1.Destin());                           // add the textfield destin
        found2pane.getChildren().add(found1.NameTrav());                         // add the textfield nametrav
        found2pane.getChildren().add(foundback);                                 // add the back button
        found2pane.getChildren().add(foundnext2);                                // add the next button

        found3pane = new StackPane();                                            // create a new stackpane
        found3pane.setStyle("-fx-background-color:#FFFFFF");                     // set the backgroundcolour
        found3pane.getChildren().add(found1.Lugtype());                          // add the textfield lugtype
        found3pane.getChildren().add(found1.Lugbrand());                         // add the textfield lugbrand
        found3pane.getChildren().add(found1.Lugcolor());                         // add the textfield lugcolor
        found3pane.getChildren().add(found1.Lugspef());                          // add the textfield lugspef
        found3pane.getChildren().add(found1.Lugweight());                        // add the textfield lugweight
        found3pane.getChildren().add(foundback2);                                // add the back button
        found3pane.getChildren().add(foundnext3);                                // add the next button

        foundfinalpane = new StackPane();                                        // create a new stackpane
        foundfinalpane.getChildren().add(foundfinalButton);                      // add the menu button
        foundfinalpane.getChildren().add(found1.unr());
        foundfinalpane.getChildren().add(unrFound);
        foundfinalpane.setStyle("-fx-background-color:#FFFFFF");                 // set the backgroundcolour

        statpane = new StackPane();                                              // create a new stackpane
        statpane.setStyle("-fx-background-color:#FFFFFF");                       // set the backgroundcolour
        statpane.getChildren().add(statterugmenu);                               // add the back button
        statpane.getChildren().add(yearbtn);                                     // add the year button
        statpane.getChildren().add(currentbtn);                                  // add the current button

        yearpane = new StackPane();                                              // create a new stackpane
        yearpane.setStyle("-fx-background-color:#FFFFFF");                       // set the backgroundcolour
        yearpane.getChildren().add(stat1.OverYear());                            // add the piechart overyear

        currentpane = new StackPane();                                           // create a new stackpane
        currentpane.setStyle("-fx-background-color:#FFFFFF");                    // set the backgroundcolour
        currentpane.getChildren().add(stat1.CurrentLuggage());                   // add the piechart currentluggage

        adminpane = new StackPane();                                             // create a new stackpane
        adminpane.setStyle("-fx-background-color:#FFFFFF");                      // set the backgroundcolour
        adminpane.getChildren().add(adminterugmenu);                             // add the back button
        adminpane.getChildren().add(userTableBtn);                               // add the view users button
        adminpane.getChildren().add(createUser);                                 // add the create user button 
        adminpane.getChildren().add(removeUser);                                 // add the remove user button
        adminpane.getChildren().add(updateUser);                                 // add the update user button
        adminpane.getChildren().add(LuggageTableBtn);                            // add the view luggage button
        adminpane.getChildren().add(removeLuggage);                              // add the remove luggage button
        adminpane.getChildren().add(updateLuggage);                              // add the update luggage button

        userTablePane = new StackPane();                                         // create a new stackpane
        userTablePane.setStyle("-fx-background-color:#FFFFFF");                  // set the backgroundcolour

        StackPane userCreatePane = new StackPane();                              // create a new stackpane
        userCreatePane.setStyle("-fx-background-color:#FFFFFF");                 // set the backgroundcolour
        userCreatePane.getChildren().add(admin1.addUsername());                  // add the textfield username 
        userCreatePane.getChildren().add(admin1.addPassword());                  // add the textfield password
        userCreatePane.getChildren().add(admin1.Toegang());                      // add the textfield toegang
        userCreatePane.getChildren().add(addUser);                               // add the button addUser

        userRemovePane = new StackPane();                                        // create a new stackpane
        userRemovePane.setStyle("-fx-background-color:#FFFFFF");                 // set the backgroundcolour
        userRemovePane.getChildren().add(admin1.removeUsername());               // add the textfield removeUsername
        userRemovePane.getChildren().add(admin1.removePassword());               // add the textfield removePassword
        userRemovePane.getChildren().add(deleteUser);                            // add the button deleteUser

        userUpdatePane = new StackPane();                                        // create a new stackpane
        userUpdatePane.setStyle("-fx-background-color:#FFFFFF");                 // set the backgroundcolour
        userUpdatePane.getChildren().add(admin1.updateUsername());               // add the textfield updateUsername
        userUpdatePane.getChildren().add(admin1.updatePassword());               // add the textfield updatePassword
        userUpdatePane.getChildren().add(admin1.updateToegang());                // add the textfield updateToegang
        userUpdatePane.getChildren().add(admin1.updateCurrentUsername());        // add the textfield updateCurrentUsername
        userUpdatePane.getChildren().add(update2User);                           // add the update2User button

        luggageTablePane = new StackPane();                                      // create a new stackpane
        luggageTablePane.setStyle("-fx-background-color:#FFFFFF");               // set the backgroundcolour

        luggageRemovePane = new StackPane();                                     // create a new stackpane
        luggageRemovePane.setStyle("-fx-background-color:#FFFFFF");              // set the backgroundcolour
        luggageRemovePane.getChildren().add(deleteLuggage);                      // add the deleteLuggage button
        luggageRemovePane.getChildren().add(admin1.luggageNr());                 // add the textfield luggageNr

        luggageUpdatePane = new StackPane();                                     // create a new stackpane
        luggageUpdatePane.setStyle("-fx-background-color:#FFFFFF");              // set the backgroundcolour
        luggageUpdatePane.getChildren().add(admin1.luggageUnr());                // add the textfield luggagenr
        luggageUpdatePane.getChildren().add(admin1.luggageType());               // add the textfield luggagetype
        luggageUpdatePane.getChildren().add(admin1.luggageBrand());              // add the textfield luggagebrand
        luggageUpdatePane.getChildren().add(admin1.luggageCol());                // add the textfield luggagecol
        luggageUpdatePane.getChildren().add(admin1.luggageWeight());             // add the textfield luggageweight
        luggageUpdatePane.getChildren().add(admin1.luggageSpef());               // add the textfield luggagespef
        luggageUpdatePane.getChildren().add(admin1.luggageLFDM());               // add the textfield luggagelfdm
        luggageUpdatePane.getChildren().add(update2Luggage);                     // add the update2Luggage button

        //geeft alle scenes in
        loginscherm = new Scene(inlogschermpane, 1600, 800);                     // set the height and width of the scene
        menu = new Scene(menupane, 1600, 800);                                   // set the height and width of the scene
        lost = new Scene(lostpane, 1600, 800);                                   // set the height and width of the scene
        lost2 = new Scene(lost2pane, 1600, 800);                                 // set the height and width of the scene
        lost3 = new Scene(lost3pane, 1600, 800);                                 // set the height and width of the scene
        lost4 = new Scene(lost4pane, 1600, 800);                                 // set the height and width of the scene
        lostfinal = new Scene(lostfinalpane, 1600, 800);                         // set the height and width of the scene
        found = new Scene(foundpane, 1600, 800);                                 // set the height and width of the scene
        found2 = new Scene(found2pane, 1600, 800);                               // set the height and width of the scene
        found3 = new Scene(found3pane, 1600, 800);                               // set the height and width of the scene
        foundfinal = new Scene(foundfinalpane, 1600, 800);                       // set the height and width of the scene
        stat = new Scene(statpane, 1600, 800);                                   // set the height and width of the scene
        year = new Scene(yearpane, 1200, 800);                                   // set the height and width of the scene
        current = new Scene(currentpane, 1200, 800);                             // set the height and width of the scene
        admin = new Scene(adminpane, 1600, 800);                                 // set the height and width of the scene
        userTable = new Scene(userTablePane, 300, 400);                          // set the height and width of the scene
        userCreate = new Scene(userCreatePane, 1000, 100);                       // set the height and width of the scene
        userRemove = new Scene(userRemovePane, 1000, 100);                       // set the height and width of the scene
        userUpdate = new Scene(userUpdatePane, 1300, 100);                       // set the height and width of the scene
        luggageTable = new Scene(luggageTablePane, 700, 700);                    // set the height and width of the scene
        luggageRemove = new Scene(luggageRemovePane, 500, 100);                  // set the height and width of the scene
        luggageUpdate = new Scene(luggageUpdatePane, 1600, 200);                 // set the height and width of the scene

        primaryStage.setTitle("Applicatie naam");                                // the title of our application
        primaryStage.setScene(admin);                                            // set the scene to admin
        primaryStage.setResizable(false);                                        // make it so it isn't resizeable
        primaryStage.show();                                                     // show the stage

    }
    public String[] persoon;                                                     // array of the type string called persoon
    private int toegang;                                                         // variable int called toegang

    /**
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {

        launch(args);

    }

}
