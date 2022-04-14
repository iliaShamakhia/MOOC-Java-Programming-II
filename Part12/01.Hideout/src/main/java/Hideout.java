public class Hideout<T> {
    
    private T toHide;
    
    public Hideout(){
        
    }
    
    public void putIntoHideout(T toHide){
        this.toHide = toHide;
    }
    
    public T takeFromHideout(){
        T temp = this.toHide;
        this.toHide = null;
        return temp;
    }
    
    public boolean isInHideout(){
        return toHide == null? false : true;
    }
}
