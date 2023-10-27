import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInterface extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();
    
    JButton changeSizeButton = new JButton("Byt storlek till 3x3");
    
    JButton emptyButton = new JButton(" ");
    int rows = 4;
    int colums = 4;
    JButton[][] dimensionArray = new JButton[rows][colums];

    public GameInterface() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }


        this.add(panel);
        panel.setLayout(new BorderLayout());
        southPanel.setLayout(new GridLayout(4, 4));
        northPanel.setLayout(new FlowLayout());
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(southPanel, BorderLayout.SOUTH);
        
        northPanel.add(changeSizeButton);

        for (int i = 0; i < 15; i++) {
            JButton boardNumbers = new JButton(String.valueOf(i + 1));
            boardNumbers.setPreferredSize(new Dimension(80, 80));
            southPanel.add(boardNumbers);

        }


        northPanel.setBackground(Color.WHITE);


        southPanel.add(emptyButton);
        emptyButton.setBackground(Color.BLACK);


        emptyButton.addActionListener(this);
        changeSizeButton.addActionListener(this);
        

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    private static void addButtonsToPanel(JPanel panel) {
        for (int i = 0; i < panel.getComponentCount(); i++) {
            JButton button = new JButton(String.valueOf(i + 1));
            panel.add(button);
        }
    }

    public static void main(String[] args) {
        GameInterface g = new GameInterface();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}