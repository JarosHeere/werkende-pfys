package pyfs;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author merij
 */
public class Login {

    private TextField username;
    private PasswordField password;
    private Text loginerror;
    private ImageView logologin;
    private Button loginbtn;
    private Stage thestage;

    Login() {

    }

    TextField username() {

        username = new TextField();                 //textfield for username
        username.setPromptText("Username");
        username.setFont(Font.font("Verdana", 20));
        username.setTranslateY(-20);
        username.setMaxWidth(220);

        return username;
    }

    PasswordField password() {

        password = new PasswordField();        //texttfield for password
        password.setPromptText("Password");
        password.setMaxWidth(220);
        password.setFont(Font.font("Verdana", 20));
        password.setTranslateY(30);

        return password;
    }

    ImageView logologin() {
        logologin = new ImageView("download.png");       //adding corendon logo to login screen
        logologin.setTranslateY(-120);

        return logologin;
    }

    public String getTextUsername() { //return username

        return username.getText();
    }

    public String getTextPassword() {//return password

        return password.getText();
    }

    public void Clear(){//clear the textfields from login
        username.setText("");
        password.setText("");
        
    }
}
