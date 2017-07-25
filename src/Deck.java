import java.util.Random;
import java.lang.Math;
public class Deck{
   private Card[] ourDeck;
   private int ourCard;
   public Deck(){
      int values[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
      String suits[] = {"h", "s", "c", "d"};
      
      ourDeck = new Card[52];
      ourCard = 0;
      //Adds all 52 cards to the deck
      for(int i = 0; i < values.length; i++){
         for(int j = 0; j < suits.length; j++){
            ourDeck[i + (j*13)] = new Card(values[i], suits[j]);
         }
      }
   }
   
   /* JUST FOR TESTING PURPOSES TO SEE IF IT WAS SHUFFLING CORRECTLY, UNCOMMENT IF NEEDED
   public String getSuitInDeck(int index){
         return ourDeck[index].getSuit();
      }
      
   public int getValueInDeck(int index){
         return ourDeck[index].getValue();
      }
   */   
   
   //Function that shuffles the deck
   public void shuffleDeck(){
      for (int i = 0; i < ourDeck.length; i++){
      //Random index for new card
         int j = (int)(Math.random() * ourDeck.length);
      //Rearranges card based on index
         Card temp = ourDeck[i];
         ourDeck[i] = ourDeck[j];
         ourDeck[j] = temp;
      }
   }
   
   
   /* ONLY USED FOR TESTING PURPOSES
   public static void main(String[] args){
      Deck deck = new Deck();
      deck.shuffleDeck();
      System.out.println(deck.getSuitInDeck(12) + deck.getValueInDeck(12));
      }
   */
      
}