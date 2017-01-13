package pyfs;

import java.time.format.DateTimeFormatter;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author merij
 */
public class Lost {

    private TextField time;
    private TextField city;
    private TextField airport;
    private TextField naam;
    private TextField adres, zip, country, phone, mail, lugtype, lugbrand, lugcolor, lugweight, labelnr, flightnr, destin, date;
    private TextArea lugspef;

    public String getTextLugspef() {
        return lugspef.getText().toLowerCase();
    }

    public String getTextDestin() {
        return destin.getText().toLowerCase();
    }

    public String getTextFlightnr() {
        return flightnr.getText().toLowerCase();
    }

    public String getTextLabelnr() {
        return labelnr.getText().toLowerCase();
    }

    public String getTextlugweight() {
        return lugweight.getText().toLowerCase();
    }

    public String getTextLugcolor() {
        return lugcolor.getText().toLowerCase();
    }

    public String getTextLygbrand() {
        return lugbrand.getText().toLowerCase();
    }

    public String getTextLugype() {
        return lugtype.getText().toLowerCase();
    }

    public String getTextNaam() {

        return naam.getText().toLowerCase();
    }

    public String getTextAdres() {
        return adres.getText().toLowerCase();
    }

    public String getTextZip() {
        return zip.getText().toLowerCase();
    }

    public String getTextCountry() {
        return country.getText().toLowerCase();
    }

    public String getTextPhone() {
        return phone.getText().toLowerCase();

    }

    public String getTextMail() {
        return mail.getText().toLowerCase();
    }

    public String getCity() {
        return city.getText().toLowerCase();
    }
    
     public String getAirport() {
        return airport.getText().toLowerCase();
    }

    public String getTime() {
        return time.getText().toLowerCase();
    }
     
      public String getDate() {
        return date.getText();
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
        airport.setTranslateY(50);
        airport.setMaxWidth(220);
        
      

        return airport;

    }

    TextField Naam() {
        naam = new TextField();                 //text voor naam invullen
        naam.setPromptText("Name");
        naam.setFont(Font.font("Verdana", 20));
        naam.setMaxWidth(220);
        naam.setTranslateY(-250);

        return naam;
    }

    TextField adres() {

        adres = new TextField();                 //text voor adres invullen
        adres.setPromptText("Adress");
        adres.setFont(Font.font("Verdana", 20));
        adres.setMaxWidth(220);
        adres.setTranslateY(-200);

        return adres;
    }

    TextField City() {

        city = new TextField();                 //text voor woonplaats invullen
        city.setPromptText("City");
        city.setFont(Font.font("Verdana", 20));
        city.setMaxWidth(220);
        city.setTranslateY(-150);

        return city;
    }

    TextField Zip() {
        zip = new TextField();              //text voor postcode invullen
        zip.setPromptText("Zip code");
        zip.setFont(Font.font("Verdana", 20));
        zip.setMaxWidth(220);
        zip.setTranslateY(-100);

        return zip;
    }

    TextField country() {               //text voor land invullen
        country = new TextField();
        country.setPromptText("Country");
        country.setFont(Font.font("Verdana", 20));
        country.setMaxWidth(220);
        country.setTranslateY(-50);

        return country;
    }

    TextField Phone() {

        phone = new TextField();            //text voor telefoonnummer
        phone.setPromptText("Phone number");
        phone.setFont(Font.font("Verdana", 20));
        phone.setMaxWidth(220);
        phone.setTranslateY(0);

        return phone;
    }

    TextField Mail() {
        mail = new TextField();             //text voor E-mail adres
        mail.setPromptText("E-mail");
        mail.setFont(Font.font("Verdana", 20));
        mail.setMaxWidth(220);
        mail.setTranslateY(50);

        return mail;
    }

    TextField Lugtype() {

        lugtype = new TextField();                 //text voor bagage type invullen
        lugtype.setPromptText("Lugage type");
        lugtype.setFont(Font.font("Verdana", 20));
        lugtype.setMaxWidth(300);
        lugtype.setTranslateY(-200);

        return lugtype;
    }

    TextField Lugbrand() {
        lugbrand = new TextField();                 //text voor tas merk invullen
        lugbrand.setPromptText("Lugage brand");
        lugbrand.setFont(Font.font("Verdana", 20));
        lugbrand.setMaxWidth(300);
        lugbrand.setTranslateY(-150);

        return lugbrand;
    }

    TextField Lugcolor() {
        lugcolor = new TextField();                 //text voor kleur invullen
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

    TextArea lugspef() {
        lugspef = new TextArea();                   //text voor bijzonderheden tas invullen
        lugspef.setPromptText("Lugage specifications");
        lugspef.setFont(Font.font("Verdana", 20));
        lugspef.setMaxSize(300, 160);
        lugspef.setTranslateY(60);

        return lugspef;
    }

    TextField Labelnr() {

        labelnr = new TextField();                 //text voor labelnummer invullen
        labelnr.setPromptText("Label number");
        labelnr.setFont(Font.font("Verdana", 20));
        labelnr.setMaxWidth(220);
        labelnr.setTranslateY(-50);

        return labelnr;
    }

    TextField Flightnr() {
        flightnr = new TextField();                 //text voor vlucht nummer invullen
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

}
