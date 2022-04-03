public class Container {
    private int capacity;
    
    public Container(){
        this.capacity = 0;
    }
    public int contains(){
        return this.capacity;
    }
    public void add(int amount){
        if(amount > 0){
            int sum = amount + capacity;
            if(sum >= 100){
                this.capacity = 100;
            }else{
                this.capacity = sum;
            }
        }
    }
    public void remove(int amount){
        if(amount > 0){
            if(amount >= this.capacity){
                this.capacity = 0;
            }else{
                this.capacity -= amount;
            }
        }
    }
    public String toString(){
        return this.capacity + "/100";
    }
}
