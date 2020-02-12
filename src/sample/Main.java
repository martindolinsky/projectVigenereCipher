package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Vigenre Cipher");
        primaryStage.setScene(new Scene(root, 450, 275));
        primaryStage.show();
        MyFile myFile = new MyFile("src/data.txt","src");
		System.out.println(new VigenereCipher().encrypt("ZeBrA","/Users/martindolinsky/Downloads/projectVigenereCipher/src/data.txt"));
		System.out.println(new VigenereCipher().decrypt("zEbRa","/Users/martindolinsky/Downloads/projectVigenereCipher/src/data_encrypt.txt"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
