
import java.util.ArrayList;

public class OneItemBox extends Box{
    private int capacity;
    private ArrayList<Item> item;
    
    public OneItemBox(){
        this.capacity = 1;
        this.item = new ArrayList();
    }

    @Override
    public void add(Item item) {
        if(this.item.size() == 0){
            this.item.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        if(this.item.size() == 0)return false;
        return this.item.get(0).equals(item);
    }
}
