package dictionary;

public class Dictionary {
    private String word;
    private String translation;
    
    public Dictionary(String word, String translation){
        this.word = word;
        this.translation = translation;
    }
    
    public String getWord(){
        return word;
    }
    
    public String getTranslation(){
        return translation;
    }
}
