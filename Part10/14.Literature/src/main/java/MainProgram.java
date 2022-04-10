
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList();
        //books.add(new Book("The Ringing Lullaby Book",0));
        //books.add(new Book("The Exiting Transpotation Vehicles",0));
        //books.add(new Book("The Snowy Forest Calls",12));
        //books.add(new Book("Litmanen 10",10));
        while(true){
            System.out.println("Input the name of the book, empty stops:");
            String name = scanner.nextLine();
            if(name.isEmpty()){
                break;
            }
            System.out.println("Input the age recommendation:");
            int age = Integer.valueOf(scanner.nextLine());
            books.add(new Book(name, age));
        }
        System.out.println(books.size() + " books in total.");
        System.out.println("Books:");
        //books.stream().sorted((b1, b2) -> b1.getAge() - b2.getAge()).forEach(el -> System.out.println(el));
        Comparator<Book> comparator = Comparator
              .comparing(Book::getAge)
              .thenComparing(Book::getName);

        Collections.sort(books, comparator);

        for (Book b: books) {
            System.out.println(b);
        }
    }

}
