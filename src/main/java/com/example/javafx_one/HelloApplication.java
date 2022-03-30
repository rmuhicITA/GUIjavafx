package com.example.javafx_one;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        IntegerProperty counter = new SimpleIntegerProperty(1);
        int counterValue = counter.get();
        System.out.println(counterValue);
        counter.set(2);
        counterValue = counter.get();
        System.out.println(counterValue);
        IntegerProperty counter = new SimpleIntegerProperty(100);
        counter.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
                System.out.print("Counter changed ");
                System.out.println("Old= "+oldValue+", new=" +newValue);
            }
        });
        counter.setValue(123);
        IntegerProperty counter = new SimpleIntegerProperty(100);
        counter.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println(observable);
            }
        });
        counter.setValue(123);*/
        IntegerProperty home = new SimpleIntegerProperty(0);
        IntegerProperty away = new SimpleIntegerProperty(0);
        FileWriter myWriter = new FileWriter("filename.txt");
        home.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                try {
                    myWriter.write(" Home old: "+number +", home new: " +t1+" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        away.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                try {
                    myWriter.write(" Away:" +number +", away new: " +t1);
                    myWriter.write(System.getProperty("line.separator"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        while(true){
            Random random = new Random();
            home.setValue(random.nextInt(10));
            away.setValue(random.nextInt(10));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}