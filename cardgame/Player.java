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


public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructor
    public Player( String name)
    {
        this.name = name;
        hand = new Cards(false);
    }
    

    /**
     * method to play the card at the top of the pack.
     * @return Card
     */
    public Card playCard()
    {
        Card c = new Card(0);
        c = hand.getTopCard();
        System.out.println(c + " was played by " + name);
        return c;
    }
    
    /**
     * method to get the name of the player.
     * @return String
     */
    public String getName()
    {
        return name;
    }
    

    /**
     * method to add the card to the top of the pack.
     * @return void
     */
    public void add( Card c)
    {
        this.hand.addTopCard(c);
    }
    
} // end class Player
