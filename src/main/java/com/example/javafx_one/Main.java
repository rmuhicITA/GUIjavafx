package com.example.javafx_one;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application /*implements EventHandler<ActionEvent>*/ {

    public static void main(String[] args) {
        launch(args);
    }

    private Button button;

    @Override
    public void start(Stage stage) throws Exception {

        //UI control
        button = new Button("Klikni me");

        //Action event klase u kojoj se nalazi button
        //button.setOnAction(this);

        //EventHandler<ActionEvent> instanca
        //Anonymous inner class type
        /*EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello world pozvan od strane buttona");
            }
        };
        button.setOnAction(eventHandler);
        */
        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello world pozvan od strane buttona");
            }
        });*/

        //Nakon Java 8 => Lambda
        /*EventHandler<ActionEvent> handler = actionEvent -> System.out.println("Klik preko lambde");
        button.setOnAction(handler);*/
        //button.setOnAction(actionEvent -> System.out.println("Klik preko lambde"));
        //button.setOnAction(event -> handleButtonClick(event));
        //Method referenciranje (lambda samo poziva metodu)
        button.setOnAction(this::handleButtonClick);



        //Container
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        //Scene
        Scene scene = new Scene(stackPane, 300, 300);

        //Stage
        stage.setScene(scene);
        stage.setTitle("Nasa prva FX app");
        stage.show();
    }

    /*@Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button)
            System.out.println("Hello world pozvan od strane buttona");
        else if (actionEvent.getSource() == button)
            System.out.println("Hello world pozvan od strane buttona");
    }*/

    //Odvojena funkcija za poziv iz start fje (lambda poziv)
    public void handleButtonClick(ActionEvent event) {
        System.out.println("Klik preko lambde");
    }
}
