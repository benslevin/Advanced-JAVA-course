
//This class is the logic for the game, a matrix of the board is created and filled where the disks are to later see who the winner is
public class GameLogic {

    protected static int[][] gameBoard = new int[GameGraphic.ROW][GameGraphic.COL]; // 6 rows, 7 columns

    //This function searches for the next free cell in the column chosen by the player
    protected static int nextFreeCell(int col){
        for(int i = GameGraphic.ROW - 1; i >= 0; i--){
            if(gameBoard[i][col] == 0){
                addFullCell(i , col);
                return i;
            }
        }
        return -1;
    }

    //This function checks to see if the column in the top row is free
    protected static boolean isColFree(int col){
        return (gameBoard[0][col] == 0);
    }

    //This function sets the player number in the cell that is played for later use, to see who the winner is
    protected static void addFullCell(int row, int col){
        if((GameGraphic.turnPlayed % 2) == 0){
            gameBoard[row][col] = 2; // Player 2
        } else {
            gameBoard[row][col] = 1; // Player 1
        }
        //System.out.println("\n");
        //printGameBoard();//Prints the logic board of the game for better visual
    }

    //This function checks the winner each turn
    protected static boolean isWinner(int player){
        // horizontalCheck
        for (int i = 0; i < gameBoard.length; i++){//checks for 4 disks in a row
            for (int j = 0; j < gameBoard[0].length-3; j++){//in each row
                if (gameBoard[i][j] == player && gameBoard[i][j+1] == player && gameBoard[i][j+2] == player && gameBoard[i][j+3] == player){
                    return true;
                }
            }
        }
        // verticalCheck
        for (int i = 0; i < gameBoard.length-3; i++){
            for (int j = 0; j < gameBoard[0].length; j++){
                if (gameBoard[i][j] == player && gameBoard[i+1][j] == player && gameBoard[i+2][j] == player && gameBoard[i+3][j] == player){
                    return true;
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i=3; i < gameBoard.length; i++){
            for (int j=0; j < gameBoard[0].length-3; j++){
                if (gameBoard[i][j] == player && gameBoard[i-1][j+1] == player && gameBoard[i-2][j+2] == player && gameBoard[i-3][j+3] == player)
                    return true;
            }
        }
        // descendingDiagonalCheck
        for (int i=3; i < gameBoard.length; i++){
            for (int j=3; j < gameBoard[0].length; j++){
                if (gameBoard[i][j] == player && gameBoard[i-1][j-1] == player && gameBoard[i-2][j-2] == player && gameBoard[i-3][j-3] == player)
                    return true;
            }
        }
        return false;
    }

    //This function sets te game board back to all 0' for the next game
    protected static void clear(){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                gameBoard[i][j] = 0;
            }
        }
        //System.out.printf("\n");
        //printGameBoard();//Prints the clear game board to check it's all 0'
    }

    //This function is a helping function to see the board printed out
/*    private static void printGameBoard(){
        for(int i = 0 ; i < gameBoard.length ; i++){//rows
            for(int j = 0; j < gameBoard[0].length; j++){//columns
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }*/

}
