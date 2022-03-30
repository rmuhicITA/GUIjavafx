package com.example.javafx_one.property;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class CollectionDemo {
    public static void main(String[] args) {
        //Real-Barca 1:2
        ObservableList<Integer> matchScore = FXCollections.observableArrayList(1,2);
        matchScore.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                System.out.format("Real-Barcelona: %d - %d%n", change.getList().get(0),change.getList().get(1));
            }
        });
        matchScore.set(1,4);
    }
}
