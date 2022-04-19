package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application{

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        ArrayList<String> years = new ArrayList();
        try (Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            int i = 0;
            while (scanner.hasNextLine()) {
                if(i == 0){
                   String[] yearRow = scanner.nextLine().split("\t");
                   for(String year : yearRow){
                       years.add(year);
                   }
                   i++;
                }
                String[] partyRow = scanner.nextLine().split("\t");
                XYChart.Series pData = new XYChart.Series();
                pData.setName(partyRow[0]);
                for(int j = 1; j < partyRow.length; j++){
                    if(partyRow[j].equals("-"))continue;
                    pData.getData().add(new XYChart.Data(Integer.valueOf(years.get(j)), Double.valueOf(partyRow[j])));
                }
                lineChart.getData().add(pData);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

}
