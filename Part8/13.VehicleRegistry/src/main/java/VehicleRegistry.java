
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry(){
        this.registry = new HashMap();
    }
    public boolean add(LicensePlate licensePlate, String owner){
        if(this.registry.containsKey(licensePlate)){
            return false;
        }else{
            registry.put(licensePlate, owner);
            return true;
        }
    }
    public String get(LicensePlate licensePlate){
        return this.registry.getOrDefault(licensePlate, null);
    }
    public boolean remove(LicensePlate licensePlate){
        if(this.registry.containsKey(licensePlate)){
            this.registry.remove(licensePlate);
            return true;
        }
        return false;
    }
    public void printLicensePlates(){
        for(LicensePlate plate : this.registry.keySet()){
            System.out.println(plate);
        }
    }
    public void printOwners(){
        HashMap<String,Boolean> owners = new HashMap();
        for(String owner : this.registry.values()){
            if(!owners.containsKey(owner)){
                System.out.println(owner);
                owners.put(owner,true);
            }
        }
    }
}
