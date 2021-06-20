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
import java.util.Random;



public class Cards
{
    // properties
    final int NOOFCARDSINFULLPACK = 52;
    Card[] cards;
    // number of cards currently in collection
    int    valid;  
    

    // constructor
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    

    /**
     * method to create the card pack.
     * @return void
     */
    private void createFullPackOfCards()
    {
        for (int card = 0; card < 52; card++) {
            addTopCard(new Card(card));
        }
    }
    

    /**
     * method to shuffle the card pack.
     * @return void
     */
    public void shuffle()
    {
        Random rand = new Random();
		
		for (int i = 0; i < cards.length; i++) {
			int randomIndexToSwap = rand.nextInt(cards.length);
			Card temp = cards[randomIndexToSwap];
			cards[randomIndexToSwap] = cards[i];
			cards[i] = temp;
		}
    }
    

    /**
     * method to get the first card of the pack.
     * @return Card
     */
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    

    /**
     * method add the first card of the pack.
     * @return boolean
     */
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;
            valid++;
            return true;
        }
        return false;
    } 
} // end class Cards
