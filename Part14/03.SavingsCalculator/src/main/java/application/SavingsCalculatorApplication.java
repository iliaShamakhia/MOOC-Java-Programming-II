package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();
        
        VBox topBox = new VBox();
        BorderPane savingsPane = new BorderPane();
        savingsPane.setPadding(new Insets(10, 20, 10, 20));
        Label savingsLabel = new Label("Monthly savings");
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setMajorTickUnit(25.0f);
        savingsSlider.setBlockIncrement(25.0f);
        Label savingsCurrent = new Label(""+savingsSlider.getValue());
        savingsPane.setLeft(savingsLabel);
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsCurrent);
        
        BorderPane interestPane = new BorderPane();
        interestPane.setPadding(new Insets(10, 20, 10, 20));
        Label interestLabel = new Label("Yearly interest rate");
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setMajorTickUnit(10.0f);
        interestSlider.setBlockIncrement(1.0f);
        Label interestCurrent = new Label(""+interestSlider.getValue());
        interestPane.setLeft(interestLabel);
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestCurrent);
        
        topBox.getChildren().add(savingsPane);
        topBox.getChildren().add(interestPane);
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 125000, 25000);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");
        
        
        savingsSlider.valueProperty().addListener((ov, oldVal, newVal) ->{
            ArrayList<Double> savList = new ArrayList();
            if(lineChart.getData().size() > 0){
                lineChart.getData().remove(0);
            }
            XYChart.Series savingsData = new XYChart.Series();
            savingsCurrent.setText("" + newVal);
            savingsData.getData().clear();
            for(int i = 0; i <= 30; i++){
                double savings = (double)newVal * 12 * i;
                savingsData.getData().add(new LineChart.Data<Number,Number>(i, savings));
            }
            System.out.println(savList);
            lineChart.getData().add(savingsData);
        });
        
        
        interestSlider.valueProperty().addListener((ov, oldVal, newVal) ->{
            if(lineChart.getData().size() > 1){
                lineChart.getData().remove(1);
            }
            XYChart.Series interestData = new XYChart.Series();
            interestCurrent.setText("" + newVal);
            interestData.getData().clear();
            double total = 0.0;
            for(int i = 0; i <= 30; i++){
                if(i > 0){
                    double savings = total + savingsSlider.getValue() * 12;
                    double interest = savings + savings * ((double)newVal / 100);
                    total = interest;
                }
                interestData.getData().add(new LineChart.Data<Number,Number>(i, total));
            }
            lineChart.getData().add(interestData);
        });
        
        mainPane.setTop(topBox);
        mainPane.setCenter(lineChart);
        
        Scene view = new Scene(mainPane, 640, 480);
        stage.setScene(view);
        stage.show();
    }
}
