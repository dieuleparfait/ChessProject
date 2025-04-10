public abstract class Piece {
    int player;
    int value;
    int posX;
    int posY;

    protected Piece(int player) {
        this.player = player;
    }

    protected Piece(int player, int value) {
        this.player = player;
        this.value = value;
    }

    protected Piece(int posX, int posY, int player) {
        this.player = player;
        this.posX = posX;
        this.posY = posY;
    }

    protected boolean move(Board board, int finalX, int finalY) {
        board.state[finalX][finalY] = this;
        board.state[posX][posY] = null;
        this.posX = finalX;
        this.posY = finalY;
        board.updateCurrentPlayer();
        return true;
    }

    protected boolean validateMove(Board board, int finalX, int finalY) {

        int displacementX = finalX - this.posX;
        int displacementY = finalY - this.posY;

        if (this.player != board.getCurrentPlayer() || (displacementX == 0 && displacementY == 0)) {
            return false;
        }
        if (board.pieceAt(finalX, finalY) != null
                && board.pieceAt(finalX, finalY).getPlayer() == board.pieceAt(this.posX, this.posY)
                        .getPlayer()) {
            return false;
        }

        return true;

    }

    public String getName() {
        if (this.player == 1)
            return "White";
        return "Black";
    }

    public int getPlayer() {
        return this.player;
    }
}
