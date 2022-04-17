package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField();
        Button button = new Button("Update");
        
        Label label = new Label("");
        VBox vBox = new VBox();
        vBox.getChildren().add(textField);
        vBox.getChildren().add(button);
        vBox.getChildren().add(label);
        Scene scene = new Scene(vBox);
        button.setOnAction(event -> {
           label.setText(textField.getText());
        });
        stage.setScene(scene);
        stage.show();
    }

}
