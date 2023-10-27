import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class centerPanel extends JPanel implements ActionListener {

    
    JButton emptyButton = new JButton("hej");
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
        

        
        emptyButton.addActionListener(this);


    }

    private static void addButtonsToPanel(JPanel panel) {
        for (int i = 0; i < panel.getComponentCount(); i++) {
            JButton button = new JButton(String.valueOf(i + 1));
            panel.add(button);
        }
    }

    public static void main(String[] args) {
        centerPanel g = new centerPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}