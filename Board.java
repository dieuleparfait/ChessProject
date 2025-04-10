public class Board {
    Piece[][] state;
    ChessBoardPanel chessBoardPanel;
    int currentPlayer;

    public Board() {
        currentPlayer = 1;
        this.chessBoardPanel = null;
        this.state = new Piece[9][9];
        // create white pieces
        this.state[0][0] = new Rook(0, 0, 1);
        this.state[1][0] = new Knight(1, 0, 1);
        this.state[2][0] = new Bishop(2, 0, 1);
        this.state[3][0] = new Queen(3, 0, 1);
        this.state[4][0] = new King(4, 0, 1);
        this.state[5][0] = new Bishop(5, 0, 1);
        this.state[6][0] = new Knight(6, 0, 1);
        this.state[7][0] = new Rook(7, 0, 1);
        for (int i = 0; i < 8; i++)
            this.state[i][1] = new Pawn(i, 1, 1);

        // create black pieces
        this.state[0][7] = new Rook(0, 7, 2);
        this.state[1][7] = new Knight(1, 7, 2);
        this.state[2][7] = new Bishop(2, 7, 2);
        this.state[3][7] = new Queen(3, 7, 2);
        this.state[4][7] = new King(4, 7, 2);
        this.state[5][7] = new Bishop(5, 7, 2);
        this.state[6][7] = new Knight(6, 7, 2);
        this.state[7][7] = new Rook(7, 7, 2);
        for (int i = 0; i < 8; i++)
            this.state[i][6] = new Pawn(i, 6, 2);
    }


    public Piece pieceAt(int i, int j) {
        return state[i][j];
    }

    public void setPieceAt(Piece piece, int i, int j) {
        this.state[i][j] = piece;
    }

    public ChessBoardPanel getChessBoardPanel() {
        return chessBoardPanel;
    }

    public void setChessBoardPanel(ChessBoardPanel chessBoardPanel) {
        this.chessBoardPanel = chessBoardPanel;
    }

    public void updateCurrentPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void printBoardState() {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (this.state[i][j] instanceof Knight) {
                    System.out.print("N ");
                } else if (this.state[i][j] instanceof Rook) {
                    System.out.print("R ");
                } else if (this.state[i][j] instanceof Bishop) {
                    System.out.print("B ");
                } else if (this.state[i][j] instanceof King) {
                    System.out.print("K ");
                } else if (this.state[i][j] instanceof Queen) {
                    System.out.print("Q ");
                } else if (this.state[i][j] instanceof Pawn) {
                    System.out.print("P ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}