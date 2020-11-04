package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

/** Controller for a basic ColorPicker consisting of three RGB sliders
 */
public class ColorPickerController extends VBox
{
    @FXML
    private Canvas canvasColorPick; // canvas for preview of the chosen color
    @FXML
    private Slider sliderColorR;
    @FXML
    private Slider sliderColorG;
    @FXML
    private Slider sliderColorB;

    public ColorPickerController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ColorPicker.fxml"));
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
        updateColorPicker(); // update preview color based on initial value of sliders

        // add listeners to update preview color based on sliders
        sliderColorR.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateColorPicker();
        });
        sliderColorG.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateColorPicker();
        });
        sliderColorB.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateColorPicker();
        });
    }

    /** Returns an RGB color described by the current value of the view's sliders
     *   @return the selected RGB color
     */
    public Color getSelectedColor() {
        return Color.rgb((int)sliderColorR.getValue(), (int)sliderColorG.getValue(), (int)sliderColorB.getValue());
    }

    /** Update the color previewer based on current value of the view's sliders
     */
    private void updateColorPicker() {
        GraphicsContext gc = canvasColorPick.getGraphicsContext2D(); // context used to issue drawing command
        gc.setFill(getSelectedColor()); // choose color for next operation
        gc.fillRect(0,0, canvasColorPick.getWidth(),canvasColorPick.getHeight());
    }
}
