
import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abbreviations;
    
    public Abbreviations(){
        this.abbreviations = new HashMap();
    }
    public void addAbbreviation(String abbreviation, String explanation){
        if(this.hasAbbreviation(abbreviation)){
            System.out.println("Abbreviation already added!");
        }else{
            abbreviation = sanitizedString(abbreviation);
            explanation = sanitizedString(explanation);
            this.abbreviations.put(abbreviation, explanation);
        }
    }
    public boolean hasAbbreviation(String abbreviation){
        abbreviation = sanitizedString(abbreviation);
        if(this.abbreviations.containsKey(abbreviation)){
            return true;
        }
        return false;
    }
    public String findExplanationFor(String abbreviation){
        if(hasAbbreviation(abbreviation)){
            abbreviation = sanitizedString(abbreviation);
            return this.abbreviations.get(abbreviation);
        }else{
            return null;
        }
    }
    public String sanitizedString(String string) {
        if (string == null) {
            return "";
        }

        string = string.toLowerCase();
        return string.trim();
    }
}
