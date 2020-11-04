package controller;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ColorPicker {

    public ColorPicker() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ColorPicker.fxml"));
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
