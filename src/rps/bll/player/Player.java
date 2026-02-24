package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private String name;
    private PlayerType type;

    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String getPlayerName() {
        return name;
    }


    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    /**
     * Decides the next move for the bot...
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {
        //Historic data to analyze and decide next move...
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();


        //Implement better AI here...

        // AI code that checks if the user enters the same move 3 times in a row and then the computer counters that move in the next round


        if (results.size() < 3){
            Move possibleMoves[] = Move.values();
            Move randomMove = possibleMoves[random.nextInt(possibleMoves.length)];
            return randomMove;

        }
        Result lastRound = results.get(results.size() - 1);
        Result secondLastRound = results.get(results.size() - 2);
        Result thirdLastRound = results.get(results.size() - 3);

        Move lastRoundHumanMove;
        if (lastRound.getWinnerPlayer().getPlayerType() == PlayerType.Human) {
            lastRoundHumanMove = lastRound.getWinnerMove();
        } else {
            lastRoundHumanMove = lastRound.getLoserMove();
        }


        Move secondLastRoundHumanMove;
        if (secondLastRound.getWinnerPlayer().getPlayerType() == PlayerType.Human) {
            secondLastRoundHumanMove = secondLastRound.getWinnerMove();
        } else {
            secondLastRoundHumanMove = secondLastRound.getLoserMove();
        }

        Move thirdLastRoundHumanMove;
        if (thirdLastRound.getWinnerPlayer().getPlayerType() == PlayerType.Human) {
            thirdLastRoundHumanMove = thirdLastRound.getWinnerMove();
        } else {
            thirdLastRoundHumanMove = thirdLastRound.getLoserMove();
        }


        if (lastRoundHumanMove == Move.Paper && secondLastRoundHumanMove == Move.Paper && thirdLastRoundHumanMove == Move.Paper ){
            results.clear();
            System.out.println("Countering move paper chosen multiple times, the AI will now return scissor");
            return Move.Scissor;


        }

        else if (lastRoundHumanMove == Move.Rock && secondLastRoundHumanMove == Move.Rock && thirdLastRoundHumanMove == Move.Rock ){
            results.clear();
            System.out.println("Countering move Rock chosen multiple times, the AI will now return Paper");

            return Move.Paper;
        }

        else if (lastRoundHumanMove == Move.Scissor && secondLastRoundHumanMove == Move.Scissor && thirdLastRoundHumanMove == Move.Scissor ){
            results.clear();
            System.out.println("Countering move Scissor chosen multiple times, the AI will now return Rock");

            return Move.Rock;
        }


        Move possibleMoves[] = Move.values();
        Move randomMove = possibleMoves[random.nextInt(possibleMoves.length)];
        return randomMove;


    }
    }
}
