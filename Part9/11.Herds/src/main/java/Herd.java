
import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable{
    private List<Movable> herd;
    
    public Herd(){
        this.herd = new ArrayList();
    }
    public String toString(){
        String res = "";
        for(Movable org : herd){
            res += (org + "\n");
        }
        return res;
    }
    public void addToHerd(Movable movable){
        this.herd.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable org : herd){
            org.move(dx, dy);
        }
    }
}
