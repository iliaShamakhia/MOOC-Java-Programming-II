package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid1 = new GridPane();
        Label label1 = new Label("Enter your name and start");
        TextField textField = new TextField();
        Button button = new Button("Start");
        grid1.add(label1, 0, 0);
        grid1.add(textField, 0, 1);
        grid1.add(button, 0, 2);
        grid1.setPrefSize(300, 180);
        grid1.setAlignment(Pos.CENTER);
        grid1.setVgap(10);
        grid1.setHgap(10);
        grid1.setPadding(new Insets(20, 20, 20, 20));
        Scene scene1 = new Scene(grid1);
        
        Label label2 = new Label();
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(300, 180);
        stackPane.getChildren().add(label2);
        stackPane.setAlignment(Pos.CENTER);
        Scene scene2 = new Scene(stackPane);
        
        button.setOnAction(event -> {
            label2.setText("Welcome " + textField.getText()+"!");
            stage.setScene(scene2);
        });
        stage.setScene(scene1);
        stage.show();
    }
}
