/**
 * HW02 Instructions found on moodle
 * 
 * Style guidlines URL:-
 * http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 * 
 * 
 * @author Mostafa Higazy
 * @version 20/06/2021
 */

 
package cardgame;
public class Card
{
    // PROPERTIES
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5","6", "7", "8", "9", "10","J", "Q", "K"};
    final int NOOFCARDSINSUIT = 13;
    int  cardNo;
    
    
    // CONSTRUCTORS
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }
    
    /**
     * method to get the card face value.
     * @return int facValue
     */
    public int getFaceValue()
    {
        return cardNo % NOOFCARDSINSUIT;
    }
    
    /**
     * method to get the card number.
     * @return int cardNo
     */
    public int getCardNo() {
        return this.cardNo;
    }
    

    /**
     * method to get the card suit.
     * @return int suit
     */
    public int getSuit()
    {
        return cardNo / NOOFCARDSINSUIT;
    }
    

    /**
     * method to compare two cards.
     * @return boolean 
     */
    public int compareTo( Card c)
    {
        if (this.cardNo == c.cardNo ) {
            return 0;
        }
        else {
            if(this.cardNo > c.cardNo)
            {
                return 1;
            } 
            else
            {
                return -1;
            }
        }
    }
    

    /**
     * method to check if two cards are equal.
     * @return boolean 
     */
    public boolean equals( Card c)
    {
        if (this.getFaceValue() == c.getFaceValue() && this.getSuit() == c.getSuit() ) {
            return true;
        }

        else {

        return false;
        
        }
    }
    

    /**
     * method to convert anything in the class to string.
     * @return String 
     */
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
}