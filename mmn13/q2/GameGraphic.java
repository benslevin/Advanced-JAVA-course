

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

//This class creates the graphic aspect of the game '4 in a row'
public class GameGraphic {

    @FXML
    private GridPane grid;

    private Button[] buttons;
    protected final static int COL = 7;
    protected final static int ROW = 6; // there are 7 buttons in the lowest row
    protected static int turnPlayed = 1;
    private ArrayList<Shape> disks = new ArrayList<Shape>();
    protected final int player1 = 1;
    protected final int player2 = 2;

    public void initialize(){
        handleButtons();
    }

    //This function is activated when the clear button is pressed, sets all necessary fields to the start position
    @FXML
    void clearPrs(ActionEvent event) {
        grid.getChildren().removeAll(disks); // Remove the disks from the board, so you can play again
        GameLogic.clear();//Clears the logic game board for next game
        turnPlayed = 1; // Sets the disks again so the first player gets the same color
    }

    //This function puts the column buttons in the lowest part of the grid pane for the game
    private void handleButtons(){
        buttons = new Button[COL];
        for(int i = 0; i < COL; i++){
            buttons[i] = new Button(i+1 + "");
            buttons[i].setPrefSize(grid.getPrefWidth(), grid.getPrefHeight() / COL);
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    handleButtonsEvent(actionEvent);
                }
            });
            grid.add(buttons[i], i, COL);
        }
    }

    //This function is activated when the button is pressed, sets the game in motion
    private void handleButtonsEvent(ActionEvent actionEvent){
        Button temp = (Button) actionEvent.getSource();
        int number = Integer.parseInt(temp.getText());
        //System.out.println(number);//Prints the number pressed by the user
        drawDisk(number);
        //GameLogic.isWinner();
        if(GameLogic.isWinner(player1)){
            winnerMessage(player1);
        } else if(GameLogic.isWinner(player2)){
            winnerMessage(player2);
        }
    }

    //Private function to set an alert for the winner
    private static void winnerMessage(int player){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("The winner is: Player " + player + "\nThe game has ended, please press clear button to play again");
        a.show();
    }

    //This function get the column number from the user and checks to see if the play is legal, if ywe, places a new disk in the correct cell, if not an alert pops up
    protected void drawDisk(int number){
        int culNumber = number - 1; // The numbering is different because in the scene builder they start from 0, and in the game they start from 1
        if(GameLogic.isColFree(culNumber)) {
            Circle circle = setDiskAndColor(number);
            int freeCell = GameLogic.nextFreeCell(culNumber);//puts the disk in the next free cell on the board
            grid.add(circle, culNumber, freeCell);//adding the disk to the grid, COL is where the buttons are, so we put them one row above
            disks.add(circle);//Adds the shape to the array, so we can delete the array when user presses 'clear'
            turnPlayed++;//Counter for turns, sets the disks blue or red
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The column is not free, illegal move, choose a different column");
            a.show();
        }
    }

    //This function changes the disk color depending on the turn
    private Circle setDiskAndColor(int number){
        Circle circle = new Circle(20);//Creating a shape to put in the grid
        if ((turnPlayed % 2) == 0) { // player 2
            circle.setFill(Color.RED);
        }
        else{ // player 1
            circle.setFill(Color.BLUE);
        }
        circle.setStroke(Color.BLACK);
        circle.setOpacity(0.85);
        return circle;
    }

}
