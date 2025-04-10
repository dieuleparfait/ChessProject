public class Turn {
    private int turnNumber;
    

    public Turn() {
        this.turnNumber = 1;
    }

    public Turn(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public void takeTurn(Player player) {
        //define player turn;

        turnNumber++;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}