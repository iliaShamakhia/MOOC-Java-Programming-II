
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nums = new ArrayList();
        while(true){
            String input = scanner.nextLine();
            if(Integer.valueOf(input) == -1){
                break;
            }
            nums.add(input);
        }
        nums.stream().mapToInt(el -> Integer.valueOf(el)).filter(el -> (el >= 1 && el <= 5)).forEach(el -> System.out.println(el));
    }
}
