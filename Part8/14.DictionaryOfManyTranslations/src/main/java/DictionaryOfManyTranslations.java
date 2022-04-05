
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> translations;
    
    public DictionaryOfManyTranslations(){
        this.translations = new HashMap();
    }
    public void add(String word, String translation){
        this.translations.putIfAbsent(word, new ArrayList<>());
        this.translations.get(word).add(translation);
    }
    public ArrayList<String> translate(String word){
        return this.translations.getOrDefault(word, new ArrayList<String>());
    }
    public void remove(String word){
        if(this.translations.containsKey(word)){
            this.translations.remove(word);
        }
    }
}
