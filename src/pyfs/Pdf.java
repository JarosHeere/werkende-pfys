package pyfs;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
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
            
            PdfPTable my_report_table = new PdfPTable(8);
            PdfPCell table_cell;
            while (query_set.next()) {                
                                    String dept_id = query_set.getString("name");
                                    table_cell=new PdfPCell(new Phrase(dept_id));
                                    my_report_table.addCell(table_cell);
                                    String dept_name=query_set.getString("adress");
                                    table_cell=new PdfPCell(new Phrase(dept_name));
                                    my_report_table.addCell(table_cell);
                                    String manager_id=query_set.getString("city");
                                    table_cell=new PdfPCell(new Phrase(manager_id));
                                    my_report_table.addCell(table_cell);
                                    String location_id=query_set.getString("zip");
                                    table_cell=new PdfPCell(new Phrase(location_id));
                                    my_report_table.addCell(table_cell);
                                    }
               
            //}
            //doc.add(paragraph);
            doc.add(my_report_table);
            doc.close();
            
            query_set.close();
            stmt.close(); 
            conn.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
