//thanks to x for this 
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

public class TileButton extends JButton {
    static TileButton buttonSelected = null;
    Board board;
    int x, y;

    public TileButton(Board board, int x, int y) {
        this.setPreferredSize(new Dimension(100, 100));
        this.board = board;
        this.x = x;
        this.y = y;
        if ((x + y) % 2 == 1) {
            this.setBackground(Color.GREEN);
        } else {
            this.setBackground(Color.WHITE);
        }
        String pieceName = (board.state[x][y] != null) ? board.state[x][y].getName() : "BlankIcon";
        this.setIcon(new ImageIcon("./assets/" + pieceName + ".png"));
        this.setBorderPainted(false);
    }


    @Override
    public String toString() {
        String str = "x: " + x + " et y " + y;
        return str;
    }
}