package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();
        
        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                imageWriter.setColor(xCoordinate, yCoordinate, newColor);

                xCoordinate++;
            }

            yCoordinate++;
        }

        ImageView image = new ImageView(targetImage);
        
        /////////
        PixelReader pixels = sourceImage.getPixelReader();

        WritableImage negativeImage1 = new WritableImage(width, height);
        PixelWriter writer = negativeImage1.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                Color pixelColor = pixels.getColor(x, y);
                double red = pixelColor.getRed();
                double green = pixelColor.getGreen();
                double blue = pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();

                Color newColor = new Color((1.0 - red), (1.0 - green), (1.0 - blue), opacity);

                writer.setColor(x, y, newColor);
            }
        }
        ////////
        
        ImageView image1 = new ImageView(negativeImage1);
        
        ///////
        Image newImage1 = image1.getImage();
        PixelReader image1Reader = newImage1.getPixelReader();
        
        int wid = (int)(newImage1.getWidth() / 2);
        int hei = (int)(newImage1.getHeight() / 2);
        
        WritableImage newTargetImage = new WritableImage(width, height);
        PixelWriter newImageWriter = newTargetImage.getPixelWriter();
        
        for(int i = 0; i < hei; i++){
            for(int j = 0; j < wid; j++){
                Color color = image1Reader.getColor(j*2, i*2);
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                newImageWriter.setColor(j, i, newColor);
                newImageWriter.setColor(wid+j, i, newColor);
                newImageWriter.setColor(j, hei+i, newColor);
                newImageWriter.setColor(wid+j, hei+i, newColor);
            }
        }
        
        ImageView imageN = new ImageView(newTargetImage);
        ////////
        
        Pane pane = new Pane();
        
        pane.getChildren().add(imageN);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
