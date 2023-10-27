import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInterface extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JButton playButton = new JButton("Nytt spel");
    JButton changeColorOnGameButton = new JButton("Byt färg på spelaplanen");
    JButton changeSizeButton = new JButton("Byt storlek till 3x3");
    JButton changeColorOnNumbersButton = new JButton("Byt färg på brickorna");
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

        northPanel.add(playButton);
        northPanel.add(changeColorOnGameButton);
        northPanel.add(changeSizeButton);
        northPanel.add(changeColorOnNumbersButton);

        for (int i = 0; i < 15; i++) {
            JButton boardNumbers = new JButton(String.valueOf(i + 1));
            boardNumbers.setPreferredSize(new Dimension(80, 80));
            southPanel.add(boardNumbers);

        }


        northPanel.setBackground(Color.WHITE);


        southPanel.add(emptyButton);
        emptyButton.setBackground(Color.BLACK);


        emptyButton.addActionListener(this);
        playButton.addActionListener(this);
        changeColorOnGameButton.addActionListener(this);
        changeSizeButton.addActionListener(this);
        changeColorOnNumbersButton.addActionListener(this);

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
        if (e.getSource() == changeColorOnGameButton) {
            Color colorSelector = JColorChooser.showDialog(null, "Välj en färg på spelplanen", Color.BLACK);
            if (colorSelector != null) {
                northPanel.setBackground(colorSelector);
            }

        } else if (e.getSource() == changeColorOnNumbersButton) {
            Color colorSelectorNumbers = JColorChooser.showDialog(null, "Välj en färg på brickorna", Color.WHITE);
            if (colorSelectorNumbers != null) {
                Component[] comps = southPanel.getComponents();
                for (Component comp : comps) {
                    if (comp instanceof JButton) {
                        JButton b = (JButton) comp;
                        b.setBackground(colorSelectorNumbers);
                    }
                }
            }
        } else if (e.getSource() == changeSizeButton) {
            String input = JOptionPane.showInputDialog(null, "Ange storlek (t.ex. 3 för 3x3, 5 för 5x5, osv):");
            try {
                int size = Integer.parseInt(input);
                if (size > 1 && size <= 10) {
                    southPanel.removeAll();
                    southPanel.setLayout(new GridLayout(size, size));
                    addButtonsToPanel(southPanel);
                    pack();
                } else {
                    JOptionPane.showMessageDialog(null, "Storleken måste vara mellan 2 och 10.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ogiltigt inmatningsformat. Ange en siffra.");
            }
        } else if (e.getSource() == playButton) {

        }
    }

}