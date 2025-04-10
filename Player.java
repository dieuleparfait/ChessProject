public class Player {
    private int player;
    private PlayerType playerType;
    private Piece[] pieces;

    public Player(PlayerType playerType, int player) {
        this.playerType = playerType;
        this.player = player;
        if (player == 1) {
            this.pieces[0] = new Rook(0, 0, 1);
            this.pieces[1] = new Knight(1, 0, 1);
            this.pieces[2] = new Bishop(2, 0, 1);
            this.pieces[3] = new Queen(3, 0, 1);
            this.pieces[4] = new King(4, 0, 1);
            this.pieces[5] = new Bishop(5, 0, 1);
            this.pieces[6] = new Knight(6, 0, 1);
            this.pieces[7] = new Rook(7, 0, 1);
            for (int i = 0; i < 8; i++) {
                this.pieces[8 + i] = new Pawn(i, 1, 1);
            }
        } else {
            this.pieces[0] = new Rook(0, 7, 2);
            this.pieces[1] = new Knight(1, 7, 2);
            this.pieces[2] = new Bishop(2, 7, 2);
            this.pieces[3] = new Queen(3, 7, 2);
            this.pieces[4] = new King(4, 7, 2);
            this.pieces[5] = new Bishop(5, 7, 2);
            this.pieces[6] = new Knight(6, 7, 2);
            this.pieces[7] = new Rook(7, 7, 2);
            for (int i = 0; i < 8; i++) {
                this.pieces[8 + i] = new Pawn(i, 7, 2);
            }
        }
    }

    public PlayerType getType() {
        return playerType;
    }

    public int getPlayer() {
        return this.player;
    }

    public Piece[] getPieces() {
        return this.pieces;
    }
}
