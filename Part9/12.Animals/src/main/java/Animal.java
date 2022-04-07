abstract class Animal {
    protected String name;
    
    public Animal(String name){
        this.name = name;
    }
    protected String getName(){
        return this.name;
    }
    protected void eat(){
        System.out.println(getName() + " eats");
    }
    protected void sleep(){
        System.out.println(getName() + " sleeps");
    }
}
