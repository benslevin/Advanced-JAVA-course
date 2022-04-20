

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class PaintOnPane {

    @FXML
    private Pane pane;

    @FXML
    private ColorPicker colorPicker;

    private boolean filled; //shape filled or not
    ArrayList<Shape> shapes = new ArrayList<Shape>(); // saves the shapes in an array list
    private double xStart, yStart, xEnd, yEnd;
    private int shapeNumber = 0;//sets the shape chosen from the menu bar

    //This function clears all the pane
    @FXML
    void clearPrs(ActionEvent event) {
        pane.getChildren().removeAll(shapes);//removes the shapes from the pane
        shapes.clear();//removes the shapes from the arraylist
    }

    //Getting the option in the shape menu bar
    @FXML
    void drawCircle(ActionEvent event) {
        chooseShape(2);
    }

    //Getting the option in the shape menu bar
    @FXML
    void drawLine(ActionEvent event) {
        chooseShape(1);
    }

    //Getting the option in the shape menu bar
    @FXML
    void drawSquare(ActionEvent event) {
        chooseShape(3);
    }

    //Getting the option in the filled menu bar and setting the boolean value
    @FXML
    void filled(ActionEvent event) {
        filled = true;
    }

    //This function gets the starting coordinates for the shape
    @FXML
    void mousePress(MouseEvent event) {
        xStart = event.getX();
        yStart = event.getY();
        //System.out.println(filled + "");
    }

    //This function gets the ending coordinates for the shape and starts the process for drawing the shape
    @FXML
    void mouseRls(MouseEvent event) {
        xEnd = event.getX();
        yEnd = event.getY();
        //System.out.println(xEnd);
        //System.out.println(yEnd);
        createShape(shapeNumber);
    }

    //Getting the option in the filled menu bar and setting the boolean value
    @FXML
    void noFill(ActionEvent event) {
        filled = false;
    }

    //This function deletes the last shape drawn on the pane
    @FXML
    void undoPrs(ActionEvent event) {
        if(shapes.size() > 0) {
            pane.getChildren().remove(shapes.get(shapes.size() - 1));
            shapes.remove(shapes.get(shapes.size() - 1));
        }
    }

    //Checks the value of the menu bar of the shape for further use
    public void chooseShape(int number){
        if (number == 1){
            //System.out.println("drawing line");
            shapeNumber = 1;
        } else if(number == 2){
            //System.out.println("drawing circle");
            shapeNumber = 2;
        } else {
            //System.out.println("drawing square");
            shapeNumber = 3;
        }
    }

    //A function to add the shapes created to the arraylist
    private void addShapeToArray(Shape shape){
        shapes.add(shape);
        //printArray();
    }

    //A function that gets the shape the user wants to draw and checks all other parameters (color + fill) and draws the shape on the pane
    //Adds the shape to an arraylist for further use (undo, clear)
    public void createShape(int number){
        Color color = colorPicker.getValue();//getting the color from the color picker
        if(shapeNumber == 1) { //Draw line + set color + add to array
            Line line = new Line(xStart, yStart, xEnd, yEnd);
            line.setStroke(color);
            pane.getChildren().add(line);
            addShapeToArray(line);
        } else if(shapeNumber == 2) {//Draw circle + set color + set fill + add to array
            Circle circle = new Circle(xStart, yStart, calcRadius(xStart, yStart, xEnd, yEnd));
            circle.setStroke(color);
            if(filled){
                circle.setFill(color);
            } else {
                circle.setFill(Color.TRANSPARENT);
            }
            pane.getChildren().add(circle);
            addShapeToArray(circle);
        } else if(shapeNumber == 3) {//Draw rectangle + set color + set fill + add to array
            double newEndX = Math.abs(xEnd - xStart);//in case  the value is under 0, so we can create squares from right to left
            double newEndY = Math.abs(yEnd - yStart);//in case  the value is under 0, so we can create squares from right to left
            Rectangle rectangle = new Rectangle(xStart, yStart, newEndX, newEndY);
            rectangle.setStroke(color);
            if(filled){
                rectangle.setFill(color);
            } else {
                rectangle.setFill(Color.TRANSPARENT);
            }
            pane.getChildren().add(rectangle);
            addShapeToArray(rectangle);
        }
    }

    //A function to check the array and print it if necessary
  /*  private void printArray(){
        System.out.println("\nThe array includes:");
        if(shapes.size() > 0) {
            for (Shape shape : shapes) {
                System.out.println(shape);
            }
        }
    }*/

    //A function to calculate the radius of a circle with 2 points
    private double calcRadius(double x1, double y1, double x2, double y2){
        return Math.sqrt((Math.pow((x2-x1),2) + Math.pow((y2-y1), 2)));
    }

}
