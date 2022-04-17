package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("First view!"));
        Button toSecondView = new Button("To second view!");
        borderPane.setCenter(toSecondView);
        Scene first = new Scene(borderPane);
        VBox vBox = new VBox();
        Button toThirdView = new Button("To the third view!");
        vBox.getChildren().add(toThirdView);
        vBox.getChildren().add(new Label("Second view!"));
        Scene second = new Scene(vBox);
        GridPane grid = new GridPane();
        grid.add(new Label("Third view!"), 0, 0);
        Button toFirstView = new Button("To first view!");
        grid.add(toFirstView, 1, 1);
        Scene third = new Scene(grid);
        
        toSecondView.setOnAction(event -> {
            stage.setScene(second);
        });
        
        toThirdView.setOnAction(event -> {
            stage.setScene(third);
        });
        
        toFirstView.setOnAction(event -> {
            stage.setScene(first);
        });
        stage.setScene(first);
        stage.show();
    }

}
