package textstatistics;

import java.util.Arrays;
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
        //int letters = 0;
        //int words = 0;
        //String longestWord = "";
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        TextArea textArea = new TextArea(); 
        Label lettersLabel = new Label("Letters: ");
        Label wordsLabel = new Label("Words: ");
        Label longestWordLabel = new Label("The longest word is: ");
        hBox.setSpacing(10);
        hBox.getChildren().add(lettersLabel);
        hBox.getChildren().add(wordsLabel);
        hBox.getChildren().add(longestWordLabel);
        borderPane.setCenter(textArea);
        borderPane.setBottom(hBox);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int letters = newValue.length();
            String[] words = newValue.split(" ");
            String longestWord = Arrays.stream(words).sorted((a, b) -> b.length() - a.length()).findFirst().get();
            lettersLabel.setText("Letters: " + letters);
            wordsLabel.setText("Words: " + words.length);
            longestWordLabel.setText("The longest word is: " + longestWord);
        });
        Scene scene = new Scene(borderPane);
        
        stage.setScene(scene);
        stage.show();
    }

}
