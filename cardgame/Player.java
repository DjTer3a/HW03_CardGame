package cardgame;

// Player - Simple card game player with name and hand of cards
// author:
// date:
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    public Player( String name)
    {
        this.name = name;
        hand = new Cards(false);
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    
    public void add( Card c)
    {
        this.hand.addTopCard(c);
    }
    
    public Card playCard()
    {
        Card c = new Card(0);
        c = hand.getTopCard();
        System.out.println(c + " was played by " + name);
        return c;
    }
    
} // end class Player
