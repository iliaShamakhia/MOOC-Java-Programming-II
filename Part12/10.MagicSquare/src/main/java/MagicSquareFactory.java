
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int n = size;
        int nsqr = n * n;
        int i = 0, j = n / 2;

        for (int k = 1; k <= nsqr; ++k){
          square.placeValue(i, j, k);
          i--;
          j++;
          if(k % n == 0){
            i += 2; 
            --j; 
          }else{
            if (j == n){ 
              j -= n;
            }else if(i < 0){ 
              i += n;
            }
          }
        }
        return square;
    }

}
