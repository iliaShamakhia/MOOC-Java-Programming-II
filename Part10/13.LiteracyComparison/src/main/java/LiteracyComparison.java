
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try{
            Files.lines(Paths.get("literacy.csv"))
                    .map(el -> el.split(","))
                    .sorted((d1,d2) -> {
                        double f = Double.valueOf(d1[5]);
                        double s = Double.valueOf(d2[5]);
                        if(f>s)return 1;
                        if(s>f)return -1;
                        return 0;
                    })
                    .forEach(el -> System.out.println(el[3]+" ("+el[4]+"),"+el[2].replace(" (%)", "")+", "+el[5]));
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
