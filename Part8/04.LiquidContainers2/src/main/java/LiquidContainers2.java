
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();
        System.out.println("First: " + first);
        System.out.println("Second: " + second);

        while (true) {
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] inputs = input.split(" ");
            String command = inputs[0];
            int amount = Integer.valueOf(inputs[1]);
            if(command.equals("add")){
                first.add(amount);
                System.out.println("First: " + first);
                System.out.println("Second: " + second);
                continue;
            }
            if(command.equals("move")){
                if(amount <= first.contains()){
                    second.add(amount);
                }else{
                    second.add(first.contains());
                }
                first.remove(amount);
                System.out.println("First: " + first);
                System.out.println("Second: " + second);
                continue;
            }
            if(command.equals("remove")){
                second.remove(amount);
                System.out.println("First: " + first);
                System.out.println("Second: " + second);
                continue;
            }
            
        }
    }

}
