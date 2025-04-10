public class Pawn extends Piece {
    public Pawn(int player) {
        super(player);
        this.value = 1;
    }

    public Pawn(int player, int value) {
        super(player);
        this.value = value;
    }

    public Pawn(int posX, int posY, int player) {
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

        int YdisplacementSign = (this.player == 1) ? 1 : -1;
        int displacementY = finalY - this.posY;
        System.out.println();
        System.out.println("Final y: " + finalY);
        System.out.println("this.posY: " + this.posY);
        if (displacementY * YdisplacementSign == 1) {
            if (validateAdvance(board, finalX, finalY)) {
                return true;
            } else if (validateCapture(board, finalX, finalY)) {
                return true;
            }
        } else if (displacementY * YdisplacementSign == 2 && validateDouble(board, finalX, finalY)) {
            return true;
        }
        return false;
    }

    public boolean validateCapture(Board board, int finalX, int finalY) {
        int displacementX = finalX - this.posX;

        if (Math.abs(displacementX) == 1) {
            if (board.pieceAt(finalX, finalY) != null
                    && board.pieceAt(finalX, finalY).getPlayer() != this.getPlayer()) {
                return true;
            }
        }
        return false;
    }

    public boolean validateAdvance(Board board, int finalX, int finalY) {
        int displacementX = finalX - this.posX;

        if (displacementX == 0) {
            if (board.pieceAt(finalX, finalY) == null) {
                return true;
            }
        }
        return false;
    }

    public boolean validateDouble(Board board, int finalX, int finalY) {
        int displacementX = finalX - this.posX;
        int initialPositionY = (this.player == 1) ? 1 : 6;

        if (this.posY != initialPositionY) {
            return false;
        }
        if (displacementX == 0) {
            if (board.pieceAt(finalX, finalY) == null && board.pieceAt(finalX, (this.posY + finalY) / 2) == null) {
                return true;
            }
        }
        return false;

    }

    public void promotion(Board board) {
        int posY;

        if (this.player == 1) {
            posY = 7;
        } else {
            posY = 0;
        }
        board.state[this.posX][posY] = new Queen(this.player);
        board.state[this.posX][this.posY] = null; // not sure if this is necessary
    }

    public String getName() {
        return super.getName() + "Pawn";
    }
}