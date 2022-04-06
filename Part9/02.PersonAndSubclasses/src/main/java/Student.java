public class Student extends Person{
    private int credits;
    
    public Student(String name, String address){
        super(name, address);
        this.credits = 0;
    }
    public void study(){
        this.credits++;
    }
    public int credits(){
        return this.credits;
    }
    public String toString(){
        return this.getName() + "\n" + "  " + this.getAddress() + "\n" + "  " + "Study credits " + this.credits();
    }
}
