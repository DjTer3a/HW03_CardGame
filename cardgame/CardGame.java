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


public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        players = new ArrayList<Player>();
        fullPack = new Cards(true);
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        scoreCard = new ScoreCard(players.size());
        fullPack.shuffle();
        roundNo = 0;
        turnOfPlayer = 0;
        for (int i = 0; i < players.size(); i++) {
            for(int j = 0; j < 13; j++) {
				players.get(i).add(fullPack.getTopCard());
            }
        }
        cardsOnTable = new Cards[players.size()];
        for (int i = 0; i < players.size(); i++) {
            cardsOnTable[i] = new Cards(false);
        }
    }
    

    /**
     * method to play turn.
     * @return boolean
     */
    public boolean playTurn( Player p, Card c)
    {
        if (isGameOver() == true || isTurnOf(p) == true ) {
            return false;
        }
        
        cardsOnTable[turnOfPlayer].addTopCard(c);
        
        if (! (turnOfPlayer == players.size() - 1) ) {
            turnOfPlayer++;

        }

        else {
            updateScores();
            if ( !isGameOver()) {
                roundNo++;
                turnOfPlayer = 0;
            }

        }


        return true;
    }
    

    /**
     * method to check if it is the turn of the player.
     * @return boolean
     */
    public boolean isTurnOf( Player p)
    {
        if ( getTurnOfPlayerNo() == players.indexOf(p) ) {
            return true;
        }

        else {
            return false;
        }
    }


    /**
     * method to update scores.
     * @return void
     */
    private void updateScores() {

        int maxCard = 0;
        int temp = 0;
        int playerNo = 0;
        for (int i = 0; i < players.size(); i++) {

            temp = cardsOnTable[i].getTopCard().getCardNo();
            if (temp > maxCard) {
                maxCard = temp;
                playerNo = i;
            }
        }

        scoreCard.update(playerNo, 1);

    }
    

    /**
     * method to get the score of the player.
     * @return int
     */
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore(playerNumber);
    }
    

    /**
     * method to get the name of the player.
     * @return String
     */
    public String getName( int playerNumber)
    {
        return players.get(playerNumber).getName();
    }
    

    /**
     * method to get the round number of the game.
     * @return int
     */
    public int getRoundNo()
    {
        return roundNo;
    }
    

    /**
     * method to get the turn of the player.
     * @return int
     */
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer+1;
    }
    

    /**
     * method to show the score card.
     * @return String
     */
    public String showScoreCard()
    {
        return scoreCard.toString();
    }


    /**
     * method to check if the game is over.
     * @return boolean
     */
    public boolean isGameOver()
    {
        if (roundNo == 13) {
            return true;
        }
        else {
            return false;
        }
    }
    

    /**
     * method to get the winner of the game.
     * @return Player[]
     */
    public Player[] getWinners()
    {
        Player[] winners;
        int[] winnersIndexes;
        int noOfWinners;

        winnersIndexes = scoreCard.getWinners();
        noOfWinners = winnersIndexes.length;
        winners = new Player[noOfWinners];


        for ( int i = 0; i < noOfWinners ; i++) {
            winners[i] = players.get( winnersIndexes[i]);
         }

        return winners;
    }
    
}