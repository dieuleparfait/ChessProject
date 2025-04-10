public class Queen extends Piece {

    public Queen(int player) {
        super(player);
        this.value = 9;
    }

    public Queen(int player, int value) {
        super(player);
    }

    public Queen(int posX, int posY, int player) {
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
        int XSign;
        int YSign;

        if (displacementX == 0) {
            YSign = displacementY / Math.abs(displacementY);
            for (int i = 1; i < Math.abs(displacementY); i++) {
                if (board.state[this.posX][this.posY + YSign * i] instanceof Piece) {
                    return false;
                }
            }
            return true;
        } else if (displacementY == 0) {
            XSign = displacementX / Math.abs(displacementX);
            for (int i = 1; i < Math.abs(displacementX); i++) {
                if (board.state[this.posX + XSign * i][this.posY] instanceof Piece) {
                    return false;
                }
            }
            return true;
        }
        if (Math.abs(displacementX) != Math.abs(displacementY)) {
            return false;
        }

        XSign = displacementX / Math.abs(displacementX);
        YSign = displacementY / Math.abs(displacementY);

        for (int i = 1; i < Math.abs(displacementX) - 1; i++) {
            if (board.state[this.posX + XSign * i][this.posY + YSign * i] instanceof Piece)
                return false;
        }
        return true;
    }

    public String getName() {
        return super.getName() + "Queen";
    }
}
