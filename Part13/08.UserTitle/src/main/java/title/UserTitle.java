package title;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class UserTitle extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parameters params = getParameters();
        String title = params.getNamed().get("title");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new Label(title));
        
        Scene scene = new Scene(borderPane);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }


}
