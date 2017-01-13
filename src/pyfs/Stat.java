package pyfs;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

/**
 *
 * @author merij
 */
public class Stat {

  private PieChart piechart;

    public Stat() {
        
        
    }

    public PieChart OverYear() {
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Found & destroyed", 22),
                new PieChart.Data("Still lost", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Lugage over 1 year");
      
              
        
        return chart;
    }

    public PieChart CurrentLugage() {
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Lost at the moment", 220),
                new PieChart.Data("Back to owners", 260),
                new PieChart.Data("Found", 195));
               
               
        final PieChart chart2 = new PieChart(pieChartData);
        chart2.setTitle("Current lugage");
        
        return chart2;
    }
    
    
    
    

}
