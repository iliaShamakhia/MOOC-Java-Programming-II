package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
    private ArrayList<Dictionary> dictionary;
    private String fileName;
    
    public SaveableDictionary(){
        this.dictionary = new ArrayList<Dictionary>();
    }
    
    public SaveableDictionary(String file){
        this();
        this.fileName = file;
    }
    
    public boolean load(){
        try (Scanner reader = new Scanner(new File(fileName))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                dictionary.add(new Dictionary(parts[0], parts[1]));
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean save(){
        try{
            PrintWriter writer = new PrintWriter(fileName);
            for(Dictionary dict : dictionary){
                writer.print(dict.getWord());
                writer.print(":");
                writer.println(dict.getTranslation());
            }
            writer.close();
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public void add(String words, String translation){
        if(!dictionary.contains(words)){
            dictionary.add(new Dictionary(words, translation));
        }
    }
    
    public String translate(String word){
        for(Dictionary dict : dictionary){
            if(dict.getWord().equals(word)){
                return dict.getTranslation();
            }else if(dict.getTranslation().equals(word)){
                return dict.getWord();
            }
        }
        return null;
    }
    
    public void delete(String word){
        for(Dictionary dict : dictionary){
            if(dict.getWord().equals(word) || dict.getTranslation().equals(word)){
                dictionary.remove(dict);
                break;
            }
        }
    }
}
