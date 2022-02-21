package com.example.muokkaaympyraa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MuokkaaYmpyraa extends Application {
    private double uusiX;
    private double uusiY;
    public void start(Stage stage) {
        StackPane pane = new StackPane();
        Circle ympyra = new Circle(100);
        ympyra.setStroke(Color.BLACK);
        ympyra.setFill(Color.WHITE);
        pane.getChildren().add(ympyra);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        Button vasen = new Button("Vasemmalle");
        Button oikea = new Button("Oikealle");
        Button ylos = new Button("Ylös");
        Button alas = new Button("Alas");
        hbox.getChildren().addAll(vasen, oikea, ylos, alas);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hbox);
        BorderPane.setAlignment(hbox, Pos.CENTER);

        vasen.setOnAction(e ->
            {
                uusiX -= ympyra.getBoundsInParent().getMinX() - 10 < 0 ? ympyra.getBoundsInParent().getMinX() : 10;
                ympyra.setTranslateX(uusiX);

            }
        );
        oikea.setOnAction(e ->
            {
                uusiX += ympyra.getBoundsInParent().getMaxX() + 10 > ympyra.getParent().getLayoutBounds().getMaxX()
                        ? ympyra.getParent().getLayoutBounds().getMaxX() - ympyra.getBoundsInParent().getMaxX() : 10;
                ympyra.setTranslateX(uusiX);
            }
        );
        ylos.setOnAction(e ->
                {
                uusiX = ympyra.getCenterX() + uusiX - 10;
                uusiY -= ympyra.getBoundsInParent().getMinY() - 10 < 0 ? ympyra.getBoundsInParent().getMinY() : 10;
                ympyra.setTranslateY(uusiY);
                }
        );
        alas.setOnAction(e ->
            {
                uusiY += ympyra.getBoundsInParent().getMaxY() + 10 > ympyra.getParent().getLayoutBounds().getMaxY()
                        ? ympyra.getParent().getLayoutBounds().getMaxY() - ympyra.getBoundsInParent().getMaxY() : 10;
                ympyra.setTranslateY(uusiY);
            }
        );

        Scene scene = new Scene(borderPane, 300, 300);
        stage.setTitle("Muokkaa ympyrää");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
