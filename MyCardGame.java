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


public class MyCardGame
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        System.out.println( "Start of MyCardGame\n");
        

        // CONSTANTS
        final int MENU_EXIT    = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_PLAY_P4 = 4;
        final int MENU_SCORES  = 5;
        

        // VARIABLES
        Player     p1, p2, p3, p4;
        CardGame   game;
        int        selection;


        // create players...
        p1 = new Player( "p1");
        p2 = new Player( "p2");
        p3 = new Player( "p3");
        p4 = new Player( "p4");

        
        // create game with the 4 players...
        game = new CardGame( p1, p2, p3, p4);
        

        // display menu, get and process selection, until exit
        do 
        {
            // display menu
            System.out.println();
            System.out.println( "MyCardGame   Round: " + game.getRoundNo() + "\t TurnOfPlayer: " + (game.getTurnOfPlayerNo()) );
            System.out.println();
            System.out.println( MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays" );
            System.out.println( MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays" );
            System.out.println( MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays" );
            System.out.println( MENU_PLAY_P4 + " - Player " + MENU_PLAY_P4 + " plays" );
            System.out.println( MENU_SCORES  + " - Show scores" );
            

            // ask for and get selection
            System.out.println();
            System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
            selection = scan.nextInt();
            

            // player 1 selection.
            if ( selection == MENU_PLAY_P1 ){
                play( p1, game);
            }
                
            

            // player 2 selection.
            else if ( selection == MENU_PLAY_P2 ){
                play( p2, game);
            }
                
            

            // player 3 selection.
            else if ( selection == MENU_PLAY_P3 ){
                play( p3, game);
            }
               

            // player 4 selection.
            else if ( selection == MENU_PLAY_P4 ){
                play( p4, game);
            }
                


            // score selection.
            else if ( selection == MENU_SCORES ) {
                System.out.println( game.showScoreCard() );
            }
                

            // exit selection.
            else if ( selection != MENU_EXIT){
                System.out.println( "Invalid selection! \n" );
            }
                
            
        } while ( selection != MENU_EXIT && !game.isGameOver());

        // display winners
        if ( game.isGameOver()) {
            if (game.getWinners().length > 1) {
               System.out.print( "The Winners Are : " + game.getWinners()[0].getName());
               for ( int i = 1; i < game.getWinners().length; i++) {
                  System.out.println( ", " + game.getWinners()[i].getName());
               }
               System.out.println( game.showScoreCard() );
            }
            else {
               System.out.print( "The Winner is : ");
               System.out.println( game.getWinners()[0].getName());
               System.out.println( game.showScoreCard() );
            }
         }
        
        System.out.println( "\nEnd of MyCardGame\n" );
        scan.close();   
    }

    // get the card, c, that player p wants to play
    // pass c to the game, see if it accepted c from p
    // if game didn't accept the card, give c back to the player! 
    // return accepted.
    private static boolean play( Player p, CardGame game)
    {
        Card       c;
        boolean    accepted;
        
        accepted = false;
        c=p.playCard();
        if (game.playTurn(p, c)) {

            accepted = true;
        }

        else {
            accepted = false;
            System.out.println("Its not your turn");
            p.add(c);
        }
        return accepted;
    }
    
} // end class MyCardGame
