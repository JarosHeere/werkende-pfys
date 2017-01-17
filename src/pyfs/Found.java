package pyfs;

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
    private TextField unr;
    private TextArea lugspef;

    Found() {

    }
    
    public String getTextUnr() {
        return unr.getText().toLowerCase();
    }

    public TextField getDate() {                                                 // the getter of date
        return date;
    }

    public String getTime() {                                                    // the getter of time
        return time.getText().toLowerCase();
    }

    public String getLabelnr() {                                                 // the getter of labelnr
        return labelnr.getText().toLowerCase();
    }

    public String getFlightnr() {                                                // the getter of flightnr
        return flightnr.getText().toLowerCase();
    }

    public String getDestin() {                                                  // the getter of destin
        return destin.getText().toLowerCase();
    }

    public String getNametrav() {                                                // the getter of nametrav
        return nametrav.getText().toLowerCase();
    }

    public String getLugtype() {                                                 // the getter of lugtype
        return lugtype.getText().toLowerCase();
    }

    public String getLugbrand() {                                                // the getter of lugbrand
        return lugbrand.getText().toLowerCase();
    }

    public String getLugcolor() {                                                // the getter of lugcolor
        return lugcolor.getText().toLowerCase();
    }

    public String getLugweight() {                                               // the getter of lugweight
        return lugweight.getText().toLowerCase();
    }

    public String getAirport() {                                                 // the getter of airport
        return airport.getText().toLowerCase();
    }

    public String getLugspef() {                                                 // the getter of lugspef
        return lugspef.getText().toLowerCase();
    }
    
    TextField unr() {
        unr = new TextField();
        unr.setPromptText("Unr");
        unr.setFont(Font.font("Verdana", 20));
        unr.setMaxWidth(220);
        unr.setTranslateY(300);

        return unr;
    }

    TextField date() {                                                           // create the textfield date                                                                      
        date = new TextField();
        date.setPromptText("YYYY-MM-DD");
        date.setMaxWidth(220);
        date.setTranslateY(-50);
        return date;
    }

    TextField Time() {                                                           // create the textfield time
        time = new TextField();
        time.setPromptText("Time (HH:MM)");
        time.setFont(Font.font("Verdana", 20));
        time.setMaxWidth(220);
        time.setTranslateY(0);
        return time;
    }

    TextField airport() {                                                        // create the textfield airport
        airport = new TextField();
        airport.setPromptText("Airport");
        airport.setFont(Font.font("Verdana", 20));
        airport.setTranslateY(50);
        airport.setMaxWidth(220);
        return airport;
    }

    TextField Labelnr() {                                                       // create the textfield labelnr
        labelnr = new TextField();
        labelnr.setPromptText("Label number");
        labelnr.setFont(Font.font("Verdana", 20));
        labelnr.setMaxWidth(220);
        labelnr.setTranslateY(-50);
        return labelnr;
    }

    TextField Flightnr() {                                                       // create the textfield flightnr
        flightnr = new TextField();
        flightnr.setPromptText("Flight number");
        flightnr.setFont(Font.font("Verdana", 20));
        flightnr.setMaxWidth(220);
        flightnr.setTranslateY(0);
        return flightnr;
    }

    TextField Destin() {                                                         // create the textfield destin
        destin = new TextField();
        destin.setPromptText("Destination");
        destin.setFont(Font.font("Verdana", 20));
        destin.setMaxWidth(220);
        destin.setTranslateY(50);
        return destin;
    }

    TextField NameTrav() {                                                       // create the textfield nametrav
        nametrav = new TextField();
        nametrav.setPromptText("Name Traveller");
        nametrav.setFont(Font.font("Verdana", 20));
        nametrav.setMaxWidth(220);
        nametrav.setTranslateY(50);
        return nametrav;
    }

    TextField Lugtype() {                                                       // create the textfield lugtype

        lugtype = new TextField();
        lugtype.setPromptText("Luggage type");
        lugtype.setFont(Font.font("Verdana", 20));
        lugtype.setMaxWidth(300);
        lugtype.setTranslateY(-200);
        return lugtype;
    }

    TextField Lugbrand() {                                                       // create the textfield lugbrand
        lugbrand = new TextField();
        lugbrand.setPromptText("Luggage brand");
        lugbrand.setFont(Font.font("Verdana", 20));
        lugbrand.setMaxWidth(300);
        lugbrand.setTranslateY(-150);
        return lugbrand;
    }

    TextField Lugcolor() {                                                       // create the textfield lugcolor
        lugcolor = new TextField();
        lugcolor.setPromptText("Luggage color");
        lugcolor.setFont(Font.font("Verdana", 20));
        lugcolor.setMaxWidth(300);
        lugcolor.setTranslateY(-100);
        return lugcolor;
    }

    TextField Lugweight() {                                                      // create the textfield lugweight
        lugweight = new TextField();
        lugweight.setPromptText("Luggage weight");
        lugweight.setFont(Font.font("Verdana", 20));
        lugweight.setMaxWidth(300);
        lugweight.setTranslateY(-50);
        return lugweight;
    }

    TextArea Lugspef() {                                                         // create the textfield lugspef
        lugspef = new TextArea();
        lugspef.setPromptText("Luggage specifications");
        lugspef.setFont(Font.font("Verdana", 20));
        lugspef.setMaxSize(300, 160);
        lugspef.setTranslateY(60);
        return lugspef;
    }

    public void Clear() {                                                         // method to clear the fields
        time.setText("");
        labelnr.setText("");
        flightnr.setText("");
        destin.setText("");
        nametrav.setText("");
        lugtype.setText("");
        lugbrand.setText("");
        lugcolor.setText("");
        lugweight.setText("");
        date.setText("");
        airport.setText("");
        lugspef.setText("");

    }
}
