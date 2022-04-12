package FlightControl;
import flightControl.ui.TextUI;
import flightControl.logic.FlightControl;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       FlightControl fc = new FlightControl();
       TextUI ui = new TextUI(fc, sc);
       ui.start();
    }
}
