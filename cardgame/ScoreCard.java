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
import java.util.ArrayList;



public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructor
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    

    /**
     * method to update the ScoreCard with the player's score.
     * @return void
     */
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    

    /**
     * method to get the player's score.
     * @return int
     */
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    

    /**
     * method to get the winner of the game.
     * @return int[]
     */
    public int[] getWinners()
    {
        int[] winners;
        int highestScore = 0;
        ArrayList<Integer> winnersList = new ArrayList<Integer>();

        for ( int i = 0; i < scores.length; i++) {
            highestScore = Math.max(highestScore, scores[i]);
        }

        for ( int i = 0; i < scores.length; i++) {
            if ( scores[i] == highestScore) {
                winnersList.add(i);
            }
        }

        winners = new int[winnersList.size()];
        for ( int i = 0; i < winnersList.size(); i++) {
            winners[i] = winnersList.get(i);
        }
  
        return winners;
    }
    

    /**
     * method to convert anything in the class to string.
     * @return String
     */
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + (playerNo+1) + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
} // end class ScoreCard
