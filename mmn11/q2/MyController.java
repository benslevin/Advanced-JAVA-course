
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class MyController {
    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    final int SIZE = 10;

    public void initialize() {
        gc = canv.getGraphicsContext2D();
        drawGrid(); // Draws the grid to show on launch
    }

    @FXML
    protected void btnPrs() { // When the button is pressed in the top left corner, 10% of the cell will be filled

        double height = canv.getHeight();
        double width = canv.getWidth();
        int numberOfCells = (int)((height / SIZE) * (width / SIZE)); // Calculates the number of cells in the grid (each cell is 10*10)
        int numberOfCellsToFill = (int) (numberOfCells * 0.1); // Number of cells to fill (10% of total number)

        gc.clearRect(0, 0 , width, height); // Clearing the canvas for the next fill of cells
        drawGrid(); // Draws a new grid

        Random r = new Random();

        gc.setFill(Color.BLACK); // Fills the cells in black

        boolean[][] matrix = new boolean[(int)width][(int)height]; // Boolean matrix to check that no cell is filled more than once
        int value = 0;
        // Randomly choosing the cells to fill
        while(value < numberOfCellsToFill){ // Checks that the number of cells needed to be filled is achieved
            int x = r.nextInt((int)width/SIZE);
            int y = r.nextInt((int)height/SIZE);
            if (!hasRandom(matrix, x, y)) {
                gc.fillRect(x * SIZE, y * SIZE, SIZE, SIZE); // Fills the cell, mult by size to get the beginning of the line for the cell to fill
                value++;
            }
        }
    }

    // Draws a grid on the canvas
    public void drawGrid(){
        double height = canv.getHeight();
        double width = canv.getWidth();

        for(int i = 0; i < width; i+=SIZE){
            gc.strokeLine(i ,0 , i, height );
        }
        for(int i = 0; i < height; i+=SIZE){
            gc.strokeLine(0 ,i , width, i );
        }
        // Fills the boundaries
        gc.strokeRect(0, height, width, height);
        gc.strokeLine(width, 0, width, height);
    }

    // Verifies that each cell filled is unique
    public boolean hasRandom(boolean[][] matrix, int x, int y){
        return matrix[x][y]; // Returns the boolean value of the cell to be filled, if false - fill it, else don't fill it because it's full
    }
}