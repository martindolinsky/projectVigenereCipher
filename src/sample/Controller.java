package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.*;
import java.io.File;

public class Controller {
    public Pane pane;
    public Button btnChooseFile;
    public Button btnEncrypt;
    public Button btnDecrypt;
	public TextField txtfldKey;
	public Label lblSourceFile;
	public Label lblFileContent;

    public void clickBtnChooseFile(ActionEvent actionEvent) {
		JFileChooser fileChooser = new JFileChooser("/Users/martindolinsky/Downloads/projectVigenereCipher/src");
		int state = fileChooser.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			MyFile myFile = new MyFile(selectedFile.getAbsolutePath(), selectedFile.getParent());
			lblSourceFile.setText(selectedFile.getAbsolutePath());
			lblFileContent.setText(myFile.readFile(selectedFile.getAbsolutePath()));
		} else if (state == JFileChooser.CANCEL_OPTION) {
			System.out.println("CANCELED");
		}
    }

    public void clickBtnEncrypt(ActionEvent actionEvent) {
		VigenereCipher vigenereCipher = new VigenereCipher();
		lblFileContent.setText(vigenereCipher.encrypt(txtfldKey.getText(), lblSourceFile.getText()));
    }

    public void clickBtnDecrypt(ActionEvent actionEvent) {
		VigenereCipher vigenereCipher = new VigenereCipher();
		lblFileContent.setText(vigenereCipher.decrypt(txtfldKey.getText(), lblSourceFile.getText()));
    }
}
