package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/** Controller for a basic drawing application.
 */
public class Controller
{
    @FXML
    private VBox rightArea;

    @FXML
    private Canvas canvas; // drawing area

    @FXML
    private ColorPickerController colorPickerController;

    @FXML
    private MenuController menuController;
    // user defined widget can be used as any other widgets

    /*
    // exemple using fx:include
    @FXML
    private SubviewController subviewController; // injection of sub-controller here
    // beware of the naming convention, if the fx:id used in the view (.fxml) is subview,
    // then the variable name to be used here is subviewController
    //                                                  ^^^^^^^^^^
    */

    /** Initialize controller
     */
    public void initialize()
    {
        // init drawing area
        clearImage();

        // define a basic event handler, more complex behavior should not use an unnamed class as done below
        EventHandler<MouseEvent> drawEventHandler =
                new EventHandler<javafx.scene.input.MouseEvent>() {
                    @Override
                    public void handle(javafx.scene.input.MouseEvent e) {
                        // similarly to lambda, unnamed class can capture the local scope
                        GraphicsContext gc = canvas.getGraphicsContext2D();
                        gc.setFill(colorPickerController.getSelectedColor());
                        int radius = 30;
                        gc.fillOval(e.getX()-radius/2, e.getY()-radius/2, radius, radius);
                    }
                };
        // register the event handler in the canvas in order to respond to click in the canvas area
        canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, drawEventHandler);

/*
        // The new widget/node can be created dynamically and inserted at runtime
        ColorPickerController anotherColorPicker = new ColorPickerController();
        rightArea.getChildren().add(anotherColorPicker);
/**/

    }

    /** Clear the canvas using the color white.
     *
     *  More complex behavior should not be defined here but in a dedicated model package !
     */
    public void clearImage() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}
