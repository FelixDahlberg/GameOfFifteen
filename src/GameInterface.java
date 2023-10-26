import javax.swing.*;
import java.awt.*;

public class GameInterface extends JFrame {

    JPanel p = new JPanel();
    JButton B1 = new JButton();
    JButton B2 = new JButton();
    JButton B3 = new JButton();
    JButton B4 = new JButton();
    JButton B5 = new JButton();
    JButton B6 = new JButton();
    JButton B7 = new JButton();
    JButton B8 = new JButton();
    JButton B9 = new JButton();
    JButton B10 = new JButton();
    JButton B11 = new JButton();
    JButton B12 = new JButton();
    JButton B13 = new JButton();
    JButton B14 = new JButton();
    JButton B15 = new JButton();
    JButton B16 = new JButton();

    GameInterface() {
        add(p);
        p.setLayout(new GridLayout(4, 4));
        p.add(B1);p.add(B2);p.add(B3);p.add(B4);
        p.add(B5);p.add(B6);p.add(B7);p.add(B8);
        p.add(B9);p.add(B10);p.add(B11);p.add(B12);
        p.add(B13);p.add(B14);p.add(B15);p.add(B16);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GameInterface g = new GameInterface();
    }
}


