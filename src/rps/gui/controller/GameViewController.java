package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {


    @FXML
    private Label lblResult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnRock(ActionEvent actionEvent) {
    }

    @FXML
    private void btnPaper(ActionEvent actionEvent) {
    }

    @FXML
    private void btnScissor(ActionEvent actionEvent) {
    }
}
