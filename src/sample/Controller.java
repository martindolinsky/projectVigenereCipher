package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    public Pane pane;
    public Button btnChooseFile;
    public Button btnEncrypt;
    public Button btnDecrypt;

    public Controller() {

    }

    public void clickBtnChooseFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        Stage stage = (Stage) pane.getScene().getWindow();

        fileChooser.showOpenDialog(stage);
        System.out.println();
    }

    public void clickBtnEncrypt(ActionEvent actionEvent) {

    }

    public void clickBtnDecrypt(ActionEvent actionEvent) {

    }
}
