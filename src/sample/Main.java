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
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        MyFile myFile = new MyFile();
        //System.out.println(myFile.readFile("src/data.txt"));
        myFile.hash("src/data.txt","src/data_encrypt.txt","ahoj");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
