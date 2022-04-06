
import java.util.ArrayList;

public class Box implements Packable{
    private ArrayList<Packable> items;
    private double capacity;
    
    public Box(double maximumCapacity){
        this.items = new ArrayList();
        this.capacity = maximumCapacity;
    }
    public double weight(){
        double total = 0.0;
        for(Packable item : items){
            total += item.weight();
        }
        return total;
    }
    public void add(Packable item){
        if((item.weight() + weight()) <= capacity){
            items.add(item);
        }
    }
    public String toString(){
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}
