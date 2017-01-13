package pyfs;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author merij
 */
public class Found {
    
  
    private TextField time, labelnr, flightnr, destin, nametrav, lugtype, lugbrand, lugcolor, lugweight, date;
    private TextField airport;
    private TextArea lugspef;
    
    Found() {

    }

    public TextField getDate() {
        return date;
    }

    public String getTime() {
        return time.getText().toLowerCase();
    }

    public String getLabelnr() {
        return labelnr.getText().toLowerCase();
    }

    public String getFlightnr() {
        return flightnr.getText().toLowerCase();
    }

    public String getDestin() {
        return destin.getText().toLowerCase();
    }

    public String getNametrav() {
        return nametrav.getText().toLowerCase();
    }

    public String getLugtype() {
        return lugtype.getText().toLowerCase();
    }

    public String getLugbrand() {
        return lugbrand.getText().toLowerCase();
    }

    public String getLugcolor() {
        return lugcolor.getText().toLowerCase();
    }

    public String getLugweight() {
        return lugweight.getText().toLowerCase();
    }

    public String getAirport() {
        return airport.getText().toLowerCase();
    }

    public String getLugspef() {
        return lugspef.getText().toLowerCase();
    }

    
    
    TextField date() {

        date = new TextField();
        date.setPromptText("YYYY-MM-DD");
        date.setMaxWidth(220);
        date.setTranslateY(-50);

        return date;
    }

    TextField Time() {

        time = new TextField();                 //text voor tijd invullen
        time.setPromptText("Time (HH:MM)");
        time.setFont(Font.font("Verdana", 20));
        time.setMaxWidth(220);
        time.setTranslateY(0);

        return time;
    }

    TextField airport() {

        airport = new TextField();                 //text voor vliegveld
        airport.setPromptText("Airport");
        airport.setFont(Font.font("Verdana", 20));
        airport.setTranslateY(50);
        airport.setMaxWidth(220);
     

        return airport;

    }
    
     TextField Labelnr() {

        labelnr = new TextField();                 //text voor label invullen
        labelnr.setPromptText("Label number");
        labelnr.setFont(Font.font("Verdana", 20));
        labelnr.setMaxWidth(220);
        labelnr.setTranslateY(-50);

        return labelnr;
    }

    TextField Flightnr() {
        flightnr = new TextField();                 //text voor vluchtnummer invullen
        flightnr.setPromptText("Flight number");
        flightnr.setFont(Font.font("Verdana", 20));
        flightnr.setMaxWidth(220);
        flightnr.setTranslateY(0);

        return flightnr;
    }

    TextField Destin() {
        destin = new TextField();                 //text voor bestemming invullen
        destin.setPromptText("Destination");
        destin.setFont(Font.font("Verdana", 20));
        destin.setMaxWidth(220);
        destin.setTranslateY(50);

        return destin;
    }
    
    TextField NameTrav() {
        
        nametrav = new TextField();             //text voor naam invullen
        nametrav.setPromptText("Name Traveller");
        nametrav.setFont(Font.font("Verdana", 20));
        nametrav.setMaxWidth(220);
        nametrav.setTranslateY(50);
        
        
        return nametrav;
    }
    
     TextField Lugtype() {

        lugtype = new TextField();                 //text voor bagage soort invullen
        lugtype.setPromptText("Lugage type");
        lugtype.setFont(Font.font("Verdana", 20));
        lugtype.setMaxWidth(300);
        lugtype.setTranslateY(-200);

        return lugtype;
    }

    TextField Lugbrand() {
        lugbrand = new TextField();                 //text voor band invullen
        lugbrand.setPromptText("Lugage brand");
        lugbrand.setFont(Font.font("Verdana", 20));
        lugbrand.setMaxWidth(300);
        lugbrand.setTranslateY(-150);

        return lugbrand;
    }

    TextField Lugcolor() {
        lugcolor = new TextField();                 //text voor tas kleur invullen
        lugcolor.setPromptText("Lugage color");
        lugcolor.setFont(Font.font("Verdana", 20));
        lugcolor.setMaxWidth(300);
        lugcolor.setTranslateY(-100);

        return lugcolor;
    }

    TextField Lugweight() {
        lugweight = new TextField();                 //text voor gewicht invullen
        lugweight.setPromptText("Lugage weight");
        lugweight.setFont(Font.font("Verdana", 20));
        lugweight.setMaxWidth(300);
        lugweight.setTranslateY(-50);

        return lugweight;
    }

    TextArea Lugspef() {                    // text voor bijzondere eigenschappen
        lugspef = new TextArea();
        lugspef.setPromptText("Lugage specifications");
        lugspef.setFont(Font.font("Verdana", 20));
        lugspef.setMaxSize(300, 160);
        lugspef.setTranslateY(60);

        return lugspef;
    }
    
}
