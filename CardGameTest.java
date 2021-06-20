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


import java.util.Scanner;
import cardgame.*;


public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        System.out.println( "Start of CardGameTest\n");
        
        
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
        
        
        // end of class CardGameTest
        System.out.println( "\nEnd of CardGameTest\n" );
        scan.close();
    }
} 
