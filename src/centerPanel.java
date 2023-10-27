import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class centerPanel extends JPanel implements ActionListener {
    
    int rows = 4;
    int colums = 4;
    JButton[][] dimensionArray = new JButton[rows][colums];

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

        }
        getComponent(0).setVisible(false);
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