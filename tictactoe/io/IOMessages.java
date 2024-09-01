package tictactoe.io;

public enum IOMessages {
    ENTER_THE_CELLS("Enter the cells: "),
    ENTER_THE_COORDINATES("Enter the coordinates: "),
    ERROR_COORDINATES("Error! Coordinates should be from 1 to 3!"),
    ERROR_INVALID_FORMAT("Error! Invalid number format. You should enter numbers!"),
    ERROR_OCCUPIED_CELL("Error! This cell is occupied! Choose another one!"),
    WIN(" wins!"),
    DRAW("Draw!"),
    MAKE_BOT_MOVE("Making move level ")
    ;

    private final String TEXT;

    IOMessages(String text){
        this.TEXT = text;
    }

    public String getTEXT(){
        return this.TEXT;
    }

}
