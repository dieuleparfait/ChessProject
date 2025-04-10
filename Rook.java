public class Rook extends Piece {
    // to determine whether castling is allowed
    boolean hasMoved = false;

    public Rook(int player) {
        super(player);
        this.value = 5;
    }

    public Rook(int player, int value) {
        super(player);
    }

    public Rook(int posX, int posY, int player) {
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

        if (displacementX == 0) {
            int displacementSign = (displacementY > 0) ? 1 : -1;
            for (int i = 1; i < Math.abs(displacementY); i++) {
                if (board.state[this.posX][this.posY + i * displacementSign] != null) {
                    return false;
                }
            }
            return true;
        }
        else if (displacementY == 0) {
            int displacementSign = (displacementX > 0) ? 1 : -1;
            for (int i = 1; i < Math.abs(displacementX); i++) {
                if (board.state[this.posX + i * displacementSign][this.posY] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String getName() {
        return super.getName() + "Rook";
    }
}
