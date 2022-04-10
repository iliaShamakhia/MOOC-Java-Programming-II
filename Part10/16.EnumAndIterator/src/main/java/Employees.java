
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    ArrayList<Person> employees;
    
    public Employees(){
        this.employees = new ArrayList();
    }
    public void add(Person personToAdd){
        this.employees.add(personToAdd);
    }
    public void add(List<Person> peopleToAdd){
        for(Person p : peopleToAdd){
            this.employees.add(p);
        }
    }
    public void print(){
        for(Person p : employees){
            System.out.println(p.toString());
        }
    }
    public void print(Education education){
        Iterator<Person> it = this.employees.iterator();
        while(it.hasNext()){
            Person tmp = it.next();
            if(tmp.getEducation() == education){
                System.out.println(tmp);
            }
        }
    }
    public void fire(Education education){
        Iterator<Person> it = this.employees.iterator();
        while(it.hasNext()){
            if(it.next().getEducation() == education){
                it.remove();
            }
        }
    }
}
