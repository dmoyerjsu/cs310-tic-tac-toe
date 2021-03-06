package edu.jsu.mcis;
import java.util.Arrays; 

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE;
    
        for(int i=0; i < width; i++){
            for(int j=0; j < width; j++){
                board[i][j] = Mark.EMPTY;
            }
        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
        boolean test = false;
        if(isValidSquare(row, col)){
            if(!isSquareMarked(row, col)){
                if(xTurn){
                    board[row][col] = Mark.X;
                }

                else{
                    board[row][col] = Mark.O;
                }

                test = true;
                xTurn = !xTurn;

            }

            return test;
        }

        return false;

        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        if((row < width) && (row >= 0) && (col < width) && (col >= 0)){
            return true;
        }

        else{
            return false;
        }
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        if(board[row][col] == Mark.EMPTY){
            return false;
        }

        else{
            return true;
        }

            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        Mark field = board[row][col];
        return field;
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if(isMarkWin(Mark.X)){
            return Result.X;
        }

        else if(isMarkWin(Mark.O)){
            return Result.O;
        }

        else if(isTie()){
            return Result.TIE;
        }

        else{
            return Result.NONE;
        }
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE

        //Check for horizontal win
        int counter = 0;
        for(int a = 0; a < width; a++){
            counter = 0;
            for(int b = 0; b < width; b++){
                if(getMark(a, b) == mark){
                    counter++;
                 }
             }

            if(counter == width){
                return true;
             }
            
        }

        //Check for vertical win
        for(int c = 0; c < width; c++){
            counter = 0;
            for(int d = 0; d < width; d++){
                if(getMark(d, c) == mark){
                    counter++;
                }
            }

            if(counter == width){
                return true;
            }
        }

        //Check diagnol 1
        counter = 0;
        for(int e = 0; e < width; e++){
            if(getMark(e, e) == mark){
                counter++;
            }

            if(counter == width){
                return true;
            }

        }

        //Check diagnol 2
        counter = 0;
        for(int f = 0; f < width; f++){
            if(getMark(width-f-1, f) == mark){
                counter++;
            }

            if(counter == width){
                return true;
            }

        }

        if(counter == width){
            return true;
        }
        
        return false;

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
        if(isMarkWin(Mark.X) || isMarkWin(Mark.O)){
            return false;
        }

        for(int a = 0; a < width; a++){
            for(int b = 0; b < width; b++){
                if(getMark(a, b) == Mark.EMPTY){
                    return false;
                }
            }
        }

        return true;
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE

        for(int i = 0; i < width; i++){
            output.append(i);
        }

        for(int j = 0; j < width; j++){
            output.append("\n");
            output.append(j + " ");

            for(int k = 0; k < width; k++){
                output.append(board[j][k]);
            }
        }

        output.append("\n");

        return output.toString();
        
    }
    
}
