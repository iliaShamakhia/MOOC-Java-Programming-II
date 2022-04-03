
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int liquid1 = 0;
        int liquid2 = 0;
        System.out.println("First: " + liquid1 + "/100");
        System.out.println("Second: " + liquid2 + "/100");
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
                if(amount > 0){
                    int sum = liquid1 + amount;
                    if(sum >= 100){
                        liquid1 = 100;
                    }else{
                        liquid1 = sum;
                    }
                }
                System.out.println("First: " + liquid1 + "/100");
                System.out.println("Second: " + liquid2 + "/100");
            }
            if(command.equals("move")){
                if(liquid1 != 0){
                    if(amount > 0){
                        int sum = 0;
                        if(amount >= liquid1){
                            sum = liquid1 + liquid2;
                            liquid1 = 0;
                        }else{
                            liquid1 -= amount;
                            sum = amount + liquid2; 
                        }
                        if(sum >= 100){
                            liquid2 = 100;
                        }else{
                            liquid2 = sum;
                        }
                    }
                }
                System.out.println("First: " + liquid1 + "/100");
                System.out.println("Second: " + liquid2 + "/100");
            }
            if(command.equals("remove")){
                if(amount > 0){
                    if(amount >= liquid2){
                        liquid2 = 0;
                    }else{
                        liquid2 -= amount;
                    }
                }
                System.out.println("First: " + liquid1 + "/100");
                System.out.println("Second: " + liquid2 + "/100");
            }
        }
    }

}
