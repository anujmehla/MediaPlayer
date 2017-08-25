package sample;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {
    //lets create a constructor with parameter
    //to create a media we need to create there things
    // 1 Media itself
    // 2 MediaPlayer
    // 3 MediaView
    // and each of them goes into each other
    // media will go into player
    // player will go into the view
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;

    Mediabar bar;

    public Player(String file) {
        // here we are going to create a new media with file
        media = new Media(file);
        // going to create a player with that media
        player = new MediaPlayer(media);
        // and finally that view with player
        view = new MediaView(player);
        // so , now that our player has been setup
        // now we want to add that player to centre for that we are going to need
        // to add that pane
        //lets initialize pane here
        mpane= new Pane();
        //now add view to the pane
        // for that we need to call the function getChildren
        mpane.getChildren().add(view);
        // now we have this pane we need to add this to our border pane
        setCenter(mpane);

        bar = new Mediabar(player);
        setBottom(bar);
        setStyle("-fx-background-color: aliceblue");

        // and last thing we are going to do is play
        player.play();
    }
}
