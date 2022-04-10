
import java.util.ArrayList;

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList();
    }
    public void add(Card card){
        this.hand.add(card);
    }
    public void print(){
        this.hand.stream().forEach(crd -> System.out.println(crd));
    }
    public void sort(){
        this.hand.sort((c1,c2) -> c1.compareTo(c2));
    }

    @Override
    public int compareTo(Hand o) {
        int a = this.hand.stream().map(el -> el.getValue()).reduce(0,(prev, val) -> prev += val).intValue();
        int b = o.hand.stream().map(el -> el.getValue()).reduce(0, (prev, val) -> prev += val).intValue();
        return a - b;
    }
    
    public void sortBySuit(){
        this.hand.sort((c1,c2) -> {
            if(c1.getSuit().ordinal() > c2.getSuit().ordinal()){
                return 1;
            }
            if(c1.getSuit().ordinal() < c2.getSuit().ordinal()){
                return -1;
            }
            return c1.getValue() - c2.getValue();
        });
    }
}
