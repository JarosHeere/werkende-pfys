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

        username = new TextField();                 //text die gebruikersnaam print bij inlogscherm
        username.setPromptText("Username");
        username.setFont(Font.font("Verdana", 20));
        username.setTranslateY(-20);
        username.setMaxWidth(220);

        return username;
    }

    PasswordField password() {

        password = new PasswordField();        //veld om wachtwoord in te vullen
        password.setPromptText("Password");
        password.setMaxWidth(220);
        password.setFont(Font.font("Verdana", 20));
        password.setTranslateY(30);

        return password;
    }

    ImageView logologin() {
        logologin = new ImageView("download.png");       //voegt corendon logo toe aan loginscherm
        logologin.setTranslateY(-120);

        return logologin;
    }

    public String getTextUsername() {

        return username.getText();
    }

    public String getTextPassword() {

        return password.getText();
    }

    public void Clear(){
        username.setText("");
        password.setText("");
        
    }
}
