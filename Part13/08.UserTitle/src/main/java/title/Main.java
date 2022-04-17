package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a title");
        String title = new Scanner(System.in).nextLine();
        Application.launch(UserTitle.class, "--title=" + title);

    }

}
