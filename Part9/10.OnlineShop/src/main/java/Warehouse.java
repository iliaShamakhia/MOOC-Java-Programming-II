
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stock;
    
    public Warehouse(){
        this.products = new HashMap();
        this.stock = new HashMap();
    }
    public void addProduct(String product, int price, int stock){
        if(!this.products.containsKey(product)){
            products.put(product, price);
            this.stock.put(product, stock);
        }else{
            int st = this.stock.get(product) + stock;
            this.stock.put(product, st);
        }
    }
    public int price(String product){
        if(!this.products.containsKey(product)){
            return -99;
        }
        return this.products.get(product);
    }
    public int stock(String product){
        if(this.stock.containsKey(product)){
            return this.stock.get(product);
        }
        return 0;
    }
    public boolean take(String product){
        if(this.stock.containsKey(product)){
            int st = this.stock.get(product) - 1;
            if(st >= 0){
                this.stock.put(product, st);
                return true;
            }
        }
        return false;
    }
    public Set<String> products(){
        return this.products.keySet();
    }
}
