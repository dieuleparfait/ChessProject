public class King extends Piece {
    boolean hasMoved = false;

    public King(int player) {
        super(player);
        this.value = 5000; //some large number such that all other pieces are irrelevant in comparison
    }

    public King(int player, int value) {
        super(player, value);
    }

    public King(int posX, int posY, int player) {
        super(posX, posY, player);
    }

    public boolean move(Board board, int finalX, int finalY) {
        if (this.validateMove(board, finalX, finalY)) {
            hasMoved = true;
            super.move(board, finalX, finalY);
        }
        return false;
    }
    
    public boolean validateMove(Board board, int finalX, int finalY) {
        if (!super.validateMove(board, finalX, finalY)) {
            return false;
        }

        int displacementX = finalX - this.posX;
        int displacementY = finalY - this.posY;

        if (Math.abs(displacementX) <= 1 && Math.abs(displacementY) <= 1) {
            return true;
        }
        return false;
    }




    public String getName() {
        return super.getName() + "King";
    }
}
