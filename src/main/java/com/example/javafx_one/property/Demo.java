package com.example.javafx_one.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Demo {
    public static void main(String[] args) {
        Integer number = 23;
        IntegerProperty numberProperty = new SimpleIntegerProperty(23);
        numberProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                System.out.println("Stara vrijednost:" + oldValue+ " nova vrijednost: "+newValue);
            }
        });
        System.out.println(numberProperty.get());
        numberProperty.set(24);
        System.out.println(numberProperty.get());
        System.out.println("Not java fx property" +number);
        number = 24;
        System.out.println("Not java fx property" +number);
        numberProperty.set(24); //sta ce se desiti?
        numberProperty.set(25); //da li ce biti pozvan changed() ??
    }
}
