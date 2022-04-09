
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    public static List<Book> readBooks(String file){
        ArrayList<Book> books = new ArrayList();
        try{
            Files.lines(Paths.get(file))
                    .map(el -> el.split(","))
                    .map(el -> new Book(el[0], Integer.valueOf(el[1]), Integer.valueOf(el[2]), el[3]))
                    .forEach(el -> books.add(el));
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }
}
