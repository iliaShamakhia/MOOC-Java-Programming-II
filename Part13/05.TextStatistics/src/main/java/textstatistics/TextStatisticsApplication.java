package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().add(new Label("Letters: 0"));
        hBox.getChildren().add(new Label("Words: 0"));
        hBox.getChildren().add(new Label("The longest word is:"));
        borderPane.setCenter(new TextArea());
        borderPane.setBottom(hBox);
        
        Scene scene = new Scene(borderPane);
        
        stage.setScene(scene);
        stage.show();
        
    }

}
