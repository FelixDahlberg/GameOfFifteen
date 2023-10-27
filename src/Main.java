import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Main();
    }

    northPanel northPanel = new northPanel();
    centerPanel centerPanel = new centerPanel();
    southPanel southPanel = new southPanel();


    Main() {
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        northPanel.newGameButton.addActionListener(this);
        northPanel.changeColorOnGameButton.addActionListener(this);
        northPanel.changeColorOnNumbersButton.addActionListener(this);

        centerPanel.dimensionArray[0][0].setText(" ");
        centerPanel.dimensionArray[0][0].setVisible(false);

        centerPanel.dimensionArray[0][0].addActionListener(this);
        centerPanel.dimensionArray[0][1].addActionListener(this);
        centerPanel.dimensionArray[0][2].addActionListener(this);
        centerPanel.dimensionArray[0][3].addActionListener(this);
        centerPanel.dimensionArray[1][0].addActionListener(this);
        centerPanel.dimensionArray[1][1].addActionListener(this);
        centerPanel.dimensionArray[1][2].addActionListener(this);
        centerPanel.dimensionArray[1][3].addActionListener(this);
        centerPanel.dimensionArray[2][0].addActionListener(this);
        centerPanel.dimensionArray[2][1].addActionListener(this);
        centerPanel.dimensionArray[2][2].addActionListener(this);
        centerPanel.dimensionArray[2][3].addActionListener(this);
        centerPanel.dimensionArray[3][0].addActionListener(this);
        centerPanel.dimensionArray[3][1].addActionListener(this);
        centerPanel.dimensionArray[3][2].addActionListener(this);
        centerPanel.dimensionArray[3][3].addActionListener(this);


        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void updateMoveCounter() {
        southPanel.moveCounter++;
        southPanel.moveCounterLabel.setText("Antal drag: " + southPanel.moveCounter);
    }

    public void shuffleGame() {

    }

    public void moveTile(int a, int b) {
        if (a != 3) {
            if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                centerPanel.dimensionArray[a][b - 1].setText(centerPanel.dimensionArray[a][b].getText());
                centerPanel.dimensionArray[a][b - 1].setVisible(true);
                centerPanel.dimensionArray[a][b].setText(" ");
                centerPanel.dimensionArray[a][b].setVisible(false);
            } else if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                centerPanel.dimensionArray[a][b + 1].setText(centerPanel.dimensionArray[a][b].getText());
                centerPanel.dimensionArray[a][b + 1].setVisible(true);
                centerPanel.dimensionArray[a][b].setText(" ");
                centerPanel.dimensionArray[a][b].setVisible(false);
            } else if(centerPanel.dimensionArray[a - 1][b].getText().equals(" ")){
                centerPanel.dimensionArray[a - 1][b].setText(centerPanel.dimensionArray[a][b].getText());
                centerPanel.dimensionArray[a - 1][b].setVisible(true);
                centerPanel.dimensionArray[a][b].setText(" ");
                centerPanel.dimensionArray[a][b].setVisible(false);
            }
        }
        if (a != 0) {
             if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                centerPanel.dimensionArray[a][b + 1].setText(centerPanel.dimensionArray[a][b].getText());
                centerPanel.dimensionArray[a][b + 1].setVisible(true);
                centerPanel.dimensionArray[a][b].setText(" ");
                centerPanel.dimensionArray[a][b].setVisible(false);
            } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                centerPanel.dimensionArray[a][b - 1].setText(centerPanel.dimensionArray[a][b].getText());
                centerPanel.dimensionArray[a][b - 1].setVisible(true);
                centerPanel.dimensionArray[a][b].setText(" ");
                centerPanel.dimensionArray[a][b].setVisible(false);
            }
             else if (centerPanel.dimensionArray[a +1][b].getText().equals(" ")) {
                 centerPanel.dimensionArray[a+1][b].setText(centerPanel.dimensionArray[a][b].getText());
                 centerPanel.dimensionArray[a+1][b].setVisible(true);
                 centerPanel.dimensionArray[a][b].setText(" ");
                 centerPanel.dimensionArray[a][b].setVisible(false);
             }
        }
        if(b != 0){
           if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                centerPanel.dimensionArray[a][b - 1].setText(centerPanel.dimensionArray[a][b].getText());
                centerPanel.dimensionArray[a][b - 1].setVisible(true);
                centerPanel.dimensionArray[a][b].setText(" ");
                centerPanel.dimensionArray[a][b].setVisible(false);
            }
            else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                centerPanel.dimensionArray[a - 1][b].setText(centerPanel.dimensionArray[a][b].getText());
                centerPanel.dimensionArray[a - 1][b].setVisible(true);
                centerPanel.dimensionArray[a][b].setText(" ");
                centerPanel.dimensionArray[a][b].setVisible(false);
            }
            if(b != 3){
                if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                    centerPanel.dimensionArray[a][b - 1].setText(centerPanel.dimensionArray[a][b].getText());
                    centerPanel.dimensionArray[a][b - 1].setVisible(true);
                    centerPanel.dimensionArray[a][b].setText(" ");
                    centerPanel.dimensionArray[a][b].setVisible(false);
                }else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                    centerPanel.dimensionArray[a - 1][b].setText(centerPanel.dimensionArray[a][b].getText());
                    centerPanel.dimensionArray[a - 1][b].setVisible(true);
                    centerPanel.dimensionArray[a][b].setText(" ");
                    centerPanel.dimensionArray[a][b].setVisible(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == northPanel.newGameButton) {
            if (southPanel.timer.isRunning()) {
                southPanel.timer.stop();

            } else {
                southPanel.running = true;
                southPanel.timer.start();
            }
        }
        if (e.getSource() == northPanel.changeColorOnGameButton) {
            Color colorSelector = JColorChooser.showDialog(null, "Välj en färg på spelplanen", Color.BLACK);
            if (colorSelector != null) {
                northPanel.setBackground(colorSelector);
                centerPanel.setBackground(colorSelector);
                southPanel.setBackground(colorSelector);
            }
        }
        if (e.getSource() == northPanel.changeColorOnNumbersButton) {
            Color colorSelectorNumbers = JColorChooser.showDialog(null, "Välj en färg på brickorna", Color.WHITE);
            if (colorSelectorNumbers != null) {
                Component[] comps = centerPanel.getComponents();
                for (Component comp : comps) {
                    if (comp instanceof JButton) {
                        JButton b = (JButton) comp;
                        b.setBackground(colorSelectorNumbers);
                    }
                }
            }
        }
        if (e.getSource() == centerPanel.dimensionArray[0][0]) {
            moveTile(0, 0);
        }
        if (e.getSource() == centerPanel.dimensionArray[0][1]) {
            moveTile(0, 1);
        }
        if (e.getSource() == centerPanel.dimensionArray[0][2]) {
            moveTile(0, 2);
        }
        if (e.getSource() == centerPanel.dimensionArray[0][3]) {
            moveTile(0, 3);
        }
        if (e.getSource() == centerPanel.dimensionArray[1][0]) {
            moveTile(1, 0);
        }
        if (e.getSource() == centerPanel.dimensionArray[1][1]) {
            moveTile(1, 1);
        }
        if (e.getSource() == centerPanel.dimensionArray[1][2]) {
            moveTile(1, 2);
        }
        if (e.getSource() == centerPanel.dimensionArray[1][3]) {
            moveTile(1, 3);
        }
        if (e.getSource() == centerPanel.dimensionArray[2][0]) {
            moveTile(2, 0);
        }
        if (e.getSource() == centerPanel.dimensionArray[2][1]) {
            moveTile(2, 1);
        }
        if (e.getSource() == centerPanel.dimensionArray[2][2]) {
            moveTile(2, 2);
        }
        if (e.getSource() == centerPanel.dimensionArray[2][3]) {
            moveTile(2, 3);
        }
        if (e.getSource() == centerPanel.dimensionArray[3][0]) {
            moveTile(3, 0);
        }
        if (e.getSource() == centerPanel.dimensionArray[3][1]) {
            moveTile(3, 1);
        }
        if (e.getSource() == centerPanel.dimensionArray[3][2]) {
            moveTile(3, 2);
        }
        if (e.getSource() == centerPanel.dimensionArray[3][3]) {
            moveTile(3, 3);
        }

    }
}
