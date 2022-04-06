public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance){
        super(productName, capacity);
        this.history = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }
    public String history(){
        return this.history.toString();
    }
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        this.history.add(this.getBalance());
    }
    public double takeFromWarehouse(double amount){
        double res = super.takeFromWarehouse(amount);
        this.history.add(this.getBalance());
        return res;
    }
    public void printAnalysis(){
        String res = "Product: " + this.getName() + "\n" +
                "History: " + this.history() + "\n" +
                "Largest amount of product: " + this.history.maxValue() + "\n" +
                "Smallest amount of product: " + this.history.minValue() + "\n" +
                "Average: " + this.history.average();
        System.out.println(res); 
    }
}
