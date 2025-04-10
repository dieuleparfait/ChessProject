
//thanks to x for this 
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;



public class ChessBoardPanel extends JPanel implements ActionListener {
    private static final int boardSize = 8;
    // private final Color[] COLOR_ARRAY = { Color.getColor("0x#FFFACD", 1),
    // Color.decode("0x#593E1A") };
    private final GridBagConstraints gbc = new GridBagConstraints();
    private final TileButton[][] tileButtons;
    private final Board board;
    private final JFrame jf;

    public ChessBoardPanel(Board board) {
        this.board = board;
        this.jf = new JFrame();
        tileButtons = new TileButton[9][9];
        setLayout(new GridBagLayout());

        //spaces between tiles
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.gbc.gridx = i;
                this.gbc.gridy = j;
                tileButtons[i][j] = new TileButton(board, i, j);
                add(tileButtons[i][j], gbc);
                tileButtons[i][j].addActionListener(this);
            }
        }
    }

    public void reloadBoard(Board board) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.gbc.gridx = i;
                this.gbc.gridy = j;
                remove(tileButtons[i][j]);
                tileButtons[i][j] = new TileButton(board, i, j);
                add(tileButtons[i][j], gbc);
                tileButtons[i][j].addActionListener(this);
            }
        }
        revalidate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        TileButton clickedButton = (TileButton) e.getSource();
        if (TileButton.buttonSelected != null) {
            if(clickedButton == TileButton.buttonSelected) {
                return;
            }
            if (board.pieceAt(TileButton.buttonSelected.x, TileButton.buttonSelected.y).validateMove(board, clickedButton.x, clickedButton.y)) {
                board.pieceAt(TileButton.buttonSelected.x, TileButton.buttonSelected.y).move(board, clickedButton.x, 
                        clickedButton.y);
                board.getChessBoardPanel().reloadBoard(board);
            }
            TileButton.buttonSelected = null;
        } else if (board.pieceAt(clickedButton.x, clickedButton.y) != null) {
            TileButton.buttonSelected = clickedButton;
        }

    }

    public Board getBoard() {
        return this.board;
    }

    public static void main(String[] args) {
        Board board = new Board();
        ChessBoardPanel c = new ChessBoardPanel(board);
        board.setChessBoardPanel(c);
        c.jf.setTitle("Chess app");
        c.jf.setSize(500, 500);
        c.jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c.jf.setVisible(true);
        c.jf.add(c);
    }

    public JFrame getJFrame() {
        return jf;
    }
}