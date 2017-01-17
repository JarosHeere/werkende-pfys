package pyfs;

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
    private TextField unr;
    private TextArea lugspef;

    public String getTextUnr() {
        return unr.getText().toLowerCase();
    }

    public String getTextLugspef() {// return text of lugspef
        return lugspef.getText().toLowerCase();
    }

    public String getTextDestin() {//return text of destin
        return destin.getText().toLowerCase();
    }

    public String getTextFlightnr() {//return text of flightnr
        return flightnr.getText().toLowerCase();
    }

    public String getTextLabelnr() {//return text of labelnr
        return labelnr.getText().toLowerCase();
    }

    public String getTextlugweight() {//return text of lugweight
        return lugweight.getText().toLowerCase();
    }

    public String getTextLugcolor() {//return text of lugcolor
        return lugcolor.getText().toLowerCase();
    }

    public String getTextLygbrand() {//return text of lugbrand
        return lugbrand.getText().toLowerCase();
    }

    public String getTextLugype() {//return text of lugtupe
        return lugtype.getText().toLowerCase();
    }

    public String getTextNaam() {//return text of naam
        return naam.getText().toLowerCase();
    }

    public String getTextAdres() {//return text of adres
        return adres.getText().toLowerCase();
    }

    public String getTextZip() {//return text of zip
        return zip.getText().toLowerCase();
    }

    public String getTextCountry() {//return text of country
        return country.getText().toLowerCase();
    }

    public String getTextPhone() {//return text of phone
        return phone.getText().toLowerCase();
    }

    public String getTextMail() {//return text of mail
        return mail.getText().toLowerCase();
    }

    public String getCity() {//return text of city
        return city.getText().toLowerCase();
    }

    public String getAirport() {//return text of airport
        return airport.getText().toLowerCase();
    }

    public String getTime() {//return text of time
        return time.getText().toLowerCase();
    }

    public String getDate() {//return text of date
        return date.getText();
    }

    TextField unr() {
        unr = new TextField();
        unr.setPromptText("Unr");
        unr.setFont(Font.font("Verdana", 20));
        unr.setMaxWidth(220);
        unr.setTranslateY(300);

        return unr;
    }

    TextField date() {//creating textfield for date

        date = new TextField();
        date.setPromptText("YYYY-MM-DD");
        date.setMaxWidth(220);
        date.setTranslateY(-50);

        return date;
    }

    TextField Time() {

        time = new TextField();                //creating textfield for time
        time.setPromptText("Time (HH:MM)");
        time.setFont(Font.font("Verdana", 20));
        time.setMaxWidth(220);
        time.setTranslateY(0);

        return time;
    }

    TextField airport() {

        airport = new TextField();                 //creating textfield for airport
        airport.setPromptText("Airport");
        airport.setTranslateY(50);
        airport.setMaxWidth(220);

        return airport;

    }

    TextField Naam() {
        naam = new TextField();                //creating textfield for naam
        naam.setPromptText("Name");
        naam.setFont(Font.font("Verdana", 20));
        naam.setMaxWidth(220);
        naam.setTranslateY(-250);

        return naam;
    }

    TextField adres() {

        adres = new TextField();                 //creating textfield for adres
        adres.setPromptText("Adress");
        adres.setFont(Font.font("Verdana", 20));
        adres.setMaxWidth(220);
        adres.setTranslateY(-200);

        return adres;
    }

    TextField City() {

        city = new TextField();                 //creating textfield for city
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
        lugtype.setPromptText("Luggage type");
        lugtype.setFont(Font.font("Verdana", 20));
        lugtype.setMaxWidth(300);
        lugtype.setTranslateY(-200);

        return lugtype;
    }

    TextField Lugbrand() {
        lugbrand = new TextField();                 //text voor tas merk invullen
        lugbrand.setPromptText("Luggage brand");
        lugbrand.setFont(Font.font("Verdana", 20));
        lugbrand.setMaxWidth(300);
        lugbrand.setTranslateY(-150);

        return lugbrand;
    }

    TextField Lugcolor() {
        lugcolor = new TextField();                 //text voor kleur invullen
        lugcolor.setPromptText("Luggage color");
        lugcolor.setFont(Font.font("Verdana", 20));
        lugcolor.setMaxWidth(300);
        lugcolor.setTranslateY(-100);

        return lugcolor;
    }

    TextField Lugweight() {
        lugweight = new TextField();                 //text voor gewicht invullen
        lugweight.setPromptText("Luggage weight");
        lugweight.setFont(Font.font("Verdana", 20));
        lugweight.setMaxWidth(300);
        lugweight.setTranslateY(-50);

        return lugweight;
    }

    TextArea lugspef() {
        lugspef = new TextArea();                   //text voor bijzonderheden tas invullen
        lugspef.setPromptText("Luggage specifications");
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

    public void Clear() {

        time.setText("");
        city.setText("");
        naam.setText("");
        adres.setText("");
        zip.setText("");
        country.setText("");
        phone.setText("");
        mail.setText("");
        lugtype.setText("");
        lugbrand.setText("");
        lugcolor.setText("");
        lugweight.setText("");
        labelnr.setText("");
        flightnr.setText("");
        destin.setText("");
        date.setText("");
        lugspef.setText("");
        airport.setText("");
    }

    public void ClearUnr() {
        unr.setText("");
    }
}
