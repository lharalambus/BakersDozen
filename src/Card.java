import javax.swing.ImageIcon;
public class Card{

   private int value;
   private String suit;
   private ImageIcon image;
   
   //Creates a card and adds its respective image from the cards file
   public Card(int value, String suit){
      this.value = value;
      this.suit = suit;
      this.image = new ImageIcon("cards/", value + suit + ".gif");
   }
   //Returns suit of card, mainly for debugging
   public String getSuit(){
      return suit;
   }
   //Returns value of card, mainly for debugging
   public int getValue(){
      return value;
   }
}