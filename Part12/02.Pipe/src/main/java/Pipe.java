
import java.util.ArrayList;

public class Pipe<T> {
    
    private ArrayList<T> pipe;
    
    public Pipe(){
        this.pipe = new ArrayList<T>();
    }
    
    public void putIntoPipe(T value){
        this.pipe.add(value);
    }
    
    public T takeFromPipe(){
        if(this.pipe.size() == 0){
            return null;
        }else{
            return this.pipe.remove(0);
        }
    }
    
    public boolean isInPipe(){
        return this.pipe.size() > 0;
    }
}
