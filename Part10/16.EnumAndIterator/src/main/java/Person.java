public class Person {
    private String name;
    private Education education;
    
    public Person(String name, Education education){
        this.name = name;
        this.education = education;
    }
    public String getName(){
        return this.name;
    }
    public Education getEducation(){
        return this.education;
    }
    public String toString(){
        return this.getName() + ", " + this.getEducation();
    }
}
