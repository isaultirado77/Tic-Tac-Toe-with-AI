package tictactoe.io;

public enum IOMessages {
    WELCOME("Welcome!"),
    ENTER_THE_CELLS("Enter the cells: ");

    private String text;

    IOMessages(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

}
