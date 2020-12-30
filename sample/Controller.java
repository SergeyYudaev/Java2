package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    public javafx.scene.control.TextField TextField;
    @FXML
    public javafx.scene.control.TextArea TextArea;

    public void ClickButtonSend(ActionEvent actionEvent) {
        if (TextField.getText().length() > 0) {
            TextArea.appendText(TextField.getText() + "\n");
            TextField.clear();
            TextField.requestFocus();
        }
    }

    public void EnterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER && TextField.getText().length() > 0) {
            TextArea.appendText(TextField.getText() + "\n");
            TextField.clear();
            TextField.requestFocus();
        }
    }
}
