import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Mostafa Khaled (22001062)
// date:
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        
        // PROGRAM CODE
        c = new Card(0);
        // test Card class
        for(int i =0 ; i<52; i++){
            c = new Card(i);
            System.out.println( c);
            System.out.println();
        }
        

        
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        cards.shuffle();
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        p = new Player("pg");
        p.playCard();
        
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );

        scan.close();
    }
    
} // end of class CardGameTest
