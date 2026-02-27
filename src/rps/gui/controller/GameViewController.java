package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rps.bll.game.GameManager;
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

import java.net.URL;
import java.util.ResourceBundle;

import static rps.bll.game.Move.Rock;
import static rps.bll.player.PlayerType.AI;

/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {


    @FXML
    private Label lblResult;
    public GameManager gameManager;
    public Result result;
    public Label lblPlayerHumanScore;
    public Label lblPlayerAIScore;
    public Label lblRoundNumber;


    public int AIScore = 0;
    public int HumanScore = 0;
    public int roundNumber = 0;



    /**
     * Initializes the controller class.
     */




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IPlayer human = new Player("Human", PlayerType.Human);
        IPlayer bot = new Player("AI", PlayerType.AI);
        gameManager = new GameManager(human, bot);
    }




    @FXML
    private void btnRock(ActionEvent actionEvent) {
        Move playerMove = Move.Rock;
        updateUI(playerMove);
    }

    @FXML
    private void btnPaper(ActionEvent actionEvent) {
        Move playerMove = Move.Paper;
        updateUI(playerMove);
    }

    @FXML
    private void btnScissor(ActionEvent actionEvent) {
        Move playerMove = Move.Scissor;
        updateUI(playerMove);
    }


    private void updateUI(Move playerMove){

        roundNumber++;
        lblRoundNumber.setText("Round number: " + roundNumber);


        result = gameManager.playRound(playerMove);

        Move aiMove;
        if (result.getWinnerPlayer().getPlayerType() == PlayerType.AI) { aiMove = result.getWinnerMove();
        } else { aiMove = result.getLoserMove();
        }
        if (result.getWinnerMove() == result.getLoserMove()){

            lblResult.setText(" Human move: " + playerMove + "\n AI Move: " + aiMove + "\n The result is a tie");
            return;
        }

        else {


            lblResult.setText(" Human move: " + playerMove + "\n AI Move: " + aiMove + "\n Winner of the match: " + result.getWinnerPlayer().getPlayerName());


        }

        if (result.getWinnerPlayer().getPlayerType() == PlayerType.AI){
            AIScore++;
            lblPlayerAIScore.setText("AI Score: " + AIScore);
        }
        else if (result.getWinnerPlayer().getPlayerType() == PlayerType.Human) {
            HumanScore++;
            lblPlayerHumanScore.setText("Human Score: " + HumanScore);
        }

    }
}
