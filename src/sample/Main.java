package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Main extends Application {

    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/
    //here in this project we have 3 main classes one is main it helps us in running the application
    // Player class to play the video and audio
    // and 3rd and last class controller to control the media at bottom


    Player player;
    FileChooser fileChooser;

    public void start(final Stage primaryStage)
    {


        MenuItem open = new MenuItem("Open");
        Menu file= new Menu("File");
        MenuBar menuBar= new MenuBar();

        file.getItems().add(open);
        menuBar.getMenus().add(file);

        fileChooser = new FileChooser();

        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.player.pause();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file!= null)
                {
                    try {
                        player = new Player(file.toURI().toURL().toExternalForm());
                        Scene scene = new Scene(player,720,535, Color.BLACK);
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


           // here we are going to put our starter stage
        // show the video
        // add media controllar bar

        // this is class we are going to create it later
        // in paramerter we need to pass video url
        player= new Player("file:/C:/Users/hp/Desktop/ab.mp4");

        player.setTop(menuBar);

        // lets add this to our scene
        Scene scene= new Scene(player,944,570,Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Player");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
