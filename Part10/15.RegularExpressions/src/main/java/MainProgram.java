

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Checker checker = new Checker();
        System.out.println(checker.isDayOfWeek("tue"));
        System.out.println(checker.isDayOfWeek("abc"));
        System.out.println(checker.allVowels("oi"));
        System.out.println(checker.allVowels("queue"));
        System.out.println(checker.timeOfDay("17:23:05"));
        System.out.println(checker.timeOfDay("abc"));
        System.out.println(checker.timeOfDay("33:33:33"));
    }
}
