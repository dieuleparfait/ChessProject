public class Bishop extends Piece {

    public Bishop(int side) {
        super(side);
        this.value = 3;
    }

    public Bishop(int side, int value) {
        super(side, value);
    }

    public Bishop(int posX, int posY, int side) {
        super(posX, posY, side);
    }

    public boolean move(Board board, int finalX, int finalY) {
        if (this.validateMove(board, finalX, finalY)) {
            super.move(board, finalX, finalY);
        }
        return false;
    }

    // public int[][] getAvailableMoves(Board board) {
    // int[][] availableMoves = new int[2][];

    // return availableMoves;
    // }

    public boolean validateMove(Board board, int finalX, int finalY) {
        if (!super.validateMove(board, finalX, finalY)) {
            return false;
        }
        int displacementX = finalX - this.posX;
        int displacementY = finalY - this.posY;

        if (Math.abs(displacementX) != Math.abs(displacementY)) {
            return false;
        }

        int XSign = displacementX / Math.abs(displacementX);
        int YSign = displacementY / Math.abs(displacementY);

        for (int i = 1; i < Math.abs(displacementX); i++) {
            if (board.state[this.posX + XSign * i][this.posY + YSign * i]  != null)
                return false;
        }

        return true;
    }
    
    public String getName() {
        return super.getName() + "Bishop";
    }
}