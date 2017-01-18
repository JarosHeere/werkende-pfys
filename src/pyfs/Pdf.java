package pyfs;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ahmet Can
 */
public class Pdf {

        ResultsFound resultfound = new ResultsFound();
        mysql Mysql = new mysql();
        final String USERNAME = Mysql.username();
        final String PASSWORD = Mysql.password();
        final String CONN_STRING = Mysql.urlmysql();
        
    
    public void ExportPdf1() {

        Document doc = new Document();
        try {
            
            Connection conn;
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet query_set = stmt.executeQuery("SELECT * From persoon");
            PdfWriter.getInstance(doc, new FileOutputStream("Results.pdf"));
            doc.open();
            //Paragraph paragraph = new Paragraph();
            doc.add((Element) query_set);
            //PdfPTable my_report_table = new PdfPTable(8);
            //PdfPCell table_cell;
            //while(query_set.next()){
               
            //}
            //doc.add(paragraph);
            doc.close();
            
            query_set.close();
            stmt.close(); 
            conn.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
