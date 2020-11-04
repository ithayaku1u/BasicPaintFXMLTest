package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;


import java.io.IOException;

/** Controller for a basic ColorPicker consisting of three RGB sliders
 */
public class MenuController extends MenuBar
{
    public MenuController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        initialize();
    }

    /** Initialize controller
     */
    public void initialize()
    {
    }

}
