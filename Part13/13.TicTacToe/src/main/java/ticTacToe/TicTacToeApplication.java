package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{


    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GameLogic game = new GameLogic();
        BorderPane layout = new BorderPane();
        Label infoLabel = new Label("Turn: " + game.getTurn());
        infoLabel.setFont(Font.font("Monospaced", 30));
        layout.setTop(infoLabel);
        GridPane grid = new GridPane();
        Button btn1 = new Button(" ");
        btn1.setFont(Font.font("Monospaced", 40));
        Button btn2 = new Button(" ");
        btn2.setFont(Font.font("Monospaced", 40));
        Button btn3 = new Button(" ");
        btn3.setFont(Font.font("Monospaced", 40));
        Button btn4 = new Button(" ");
        btn4.setFont(Font.font("Monospaced", 40));
        Button btn5 = new Button(" ");
        btn5.setFont(Font.font("Monospaced", 40));
        Button btn6 = new Button(" ");
        btn6.setFont(Font.font("Monospaced", 40));
        Button btn7 = new Button(" ");
        btn7.setFont(Font.font("Monospaced", 40));
        Button btn8 = new Button(" ");
        btn8.setFont(Font.font("Monospaced", 40));
        Button btn9 = new Button(" ");
        btn9.setFont(Font.font("Monospaced", 40));
        grid.add(btn1, 0, 0);
        grid.add(btn2, 0, 1);
        grid.add(btn3, 0, 2);
        grid.add(btn4, 1, 0);
        grid.add(btn5, 1, 1);
        grid.add(btn6, 1, 2);
        grid.add(btn7, 2, 0);
        grid.add(btn8, 2, 1);
        grid.add(btn9, 2, 2);
        btn1.setOnAction(event -> {
            if(game.setChoice(0, 0)){
                btn1.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn2.setOnAction(event -> {
            if(game.setChoice(0, 1)){
                btn2.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn3.setOnAction(event -> {
            if(game.setChoice(0, 2)){
                btn3.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn4.setOnAction(event -> {
            if(game.setChoice(1, 0)){
                btn4.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn5.setOnAction(event -> {
            if(game.setChoice(1, 1)){
                btn5.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn6.setOnAction(event -> {
            if(game.setChoice(1, 2)){
                btn6.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn7.setOnAction(event -> {
            if(game.setChoice(2, 0)){
                btn7.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn8.setOnAction(event -> {
            if(game.setChoice(2, 1)){
                btn8.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        btn9.setOnAction(event -> {
            if(game.setChoice(2, 2)){
                btn9.setText(game.getTurn().equals("X")?"O":"X");
                infoLabel.setText(checkWon(game, stage)?"The end!":"Turn: " + game.getTurn());
            }
        });
        layout.setCenter(grid);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    
    public boolean checkWon(GameLogic game, Stage stage){
        String hasWon = game.hasWon();
        if(hasWon.equals("X") || hasWon.equals("O")){
            return true;
        }
        return false;
    }

}
