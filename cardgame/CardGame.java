package cardgame;

import java.util.ArrayList;
// Cardgame
// author:
// date:
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
    
    // methods
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
    
    public boolean isTurnOf( Player p)
    {
        if ( getTurnOfPlayerNo() == players.indexOf(p) ) {
            return true;
        }

        else {
            return false;
        }
    }




    public boolean isGameOver()
    {
        if (roundNo == 13) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore(playerNumber);
    }
    
    public String getName( int playerNumber)
    {
        return players.get(playerNumber).getName();
    }
    
    public int getRoundNo()
    {
        return roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer+1;
    }
    
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
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}