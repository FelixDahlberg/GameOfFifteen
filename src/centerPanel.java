import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class centerPanel extends JPanel {
    
    int rows = 4;
    int colums = 4;
    JButton[][] dimensionArray = new JButton[rows][colums];
    ArrayList<JButton> buttonList = new ArrayList<>();

    public centerPanel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 16; i++) {
            JButton boardNumbers = new JButton(String.valueOf(i + 1));
            boardNumbers.setPreferredSize(new Dimension(80, 80));
            add(boardNumbers);
            buttonList.add(boardNumbers);
        }
        
        int numberOfButtons = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                dimensionArray[i][j] = buttonList.get(numberOfButtons);
                numberOfButtons++;
            }
        }
    }
}