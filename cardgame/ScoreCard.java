package cardgame;
import java.util.ArrayList;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:
// date:
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
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
    
} // end class ScoreCard
