public class Knight extends Piece {

    public Knight(int player) {
        super(player);
        this.value = 3;
    }

    public Knight(int player, int value) {
        super(player, value);
    }

    public Knight(int posX, int posY, int player) {
        super(posX, posY, player);
    }

    public boolean move(Board board, int finalX, int finalY) {
        if (this.validateMove(board, finalX, finalY)) {
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
        if (Math.abs(displacementX) == 2 && Math.abs(displacementY) == 1 || Math.abs(displacementX) == 1
                && Math.abs(displacementY) == 2) {
            return true;
        }
        return false;
    }
    
    public String getName() {
        return super.getName() + "Knight";
    }
}
