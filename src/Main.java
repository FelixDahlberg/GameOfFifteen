import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Main extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Main();
    }

    northPanel northPanel = new northPanel();
    centerPanel centerPanel = new centerPanel();
    southPanel southPanel = new southPanel();


    Main() {
        setTitle("Game Of Fifteen");
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        northPanel.newGameButton.addActionListener(this);
        northPanel.changeColorOnGameButton.addActionListener(this);
        northPanel.changeColorOnNumbersButton.addActionListener(this);

        southPanel.timer.start();

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
        if (a - 1 == -1 || a + 1 == 4 || b - 1 == -1 || b + 1 == 4) {
            if (a - 1 == -1) {
                if (b - 1 == -1) {
                    if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                        moveDown(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                        moveRight(a, b);
                        updateMoveCounter();
                    }
                } else if (b + 1 == 4) {
                    if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                        moveDown(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                        moveLeft(a, b);
                        updateMoveCounter();
                    }
                } else {
                    if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                        moveDown(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                        moveLeft(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                        moveRight(a, b);
                        updateMoveCounter();
                    }
                }
            }
            if (a + 1 == 4) {
                if (b - 1 == -1) {
                    if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                        moveUp(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                        moveRight(a, b);
                        updateMoveCounter();
                    }
                } else if (b + 1 == 4) {
                    if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                        moveLeft(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                        moveUp(a, b);
                        updateMoveCounter();
                    }
                } else {
                    if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                        moveRight(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                        moveUp(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                        moveLeft(a, b);
                        updateMoveCounter();
                    }
                }
            }
            if (b - 1 == -1) {
                if (a + 1 == 4) {
                    if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                        moveRight(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                        moveUp(a, b);
                        updateMoveCounter();
                    }
                } else if (a - 1 == -1) {
                    if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                        moveDown(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                        moveRight(a, b);
                        updateMoveCounter();
                    }
                } else {
                    if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                        moveDown(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                        moveRight(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                        moveUp(a, b);
                        updateMoveCounter();
                    }
                }
            }
            if (b + 1 == 4) {
                if (a - 1 == -1) {
                    if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                        moveDown(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                        moveLeft(a, b);
                        updateMoveCounter();
                    }
                } else if (a + 1 == 4) {
                    if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                        moveUp(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                        moveLeft(a, b);
                        updateMoveCounter();
                    }
                } else {
                    if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                        moveDown(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                        moveUp(a, b);
                        updateMoveCounter();
                    } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                        moveLeft(a, b);
                        updateMoveCounter();
                    }
                }
            }
        } else {
            if (centerPanel.dimensionArray[a + 1][b].getText().equals(" ")) {
                moveDown(a, b);
                updateMoveCounter();
            } else if (centerPanel.dimensionArray[a][b + 1].getText().equals(" ")) {
                moveRight(a, b);
                updateMoveCounter();
            } else if (centerPanel.dimensionArray[a - 1][b].getText().equals(" ")) {
                moveUp(a, b);
                updateMoveCounter();
            } else if (centerPanel.dimensionArray[a][b - 1].getText().equals(" ")) {
                moveLeft(a, b);
                updateMoveCounter();
            }
        }
    }

    public void moveRight(int a, int b) {
        centerPanel.dimensionArray[a][b + 1].setText(centerPanel.dimensionArray[a][b].getText());
        centerPanel.dimensionArray[a][b + 1].setVisible(true);
        centerPanel.dimensionArray[a][b].setText(" ");
        centerPanel.dimensionArray[a][b].setVisible(false);
    }

    public void moveLeft(int a, int b) {
        centerPanel.dimensionArray[a][b - 1].setText(centerPanel.dimensionArray[a][b].getText());
        centerPanel.dimensionArray[a][b - 1].setVisible(true);
        centerPanel.dimensionArray[a][b].setText(" ");
        centerPanel.dimensionArray[a][b].setVisible(false);
    }

    public void moveUp(int a, int b) {
        centerPanel.dimensionArray[a - 1][b].setText(centerPanel.dimensionArray[a][b].getText());
        centerPanel.dimensionArray[a - 1][b].setVisible(true);
        centerPanel.dimensionArray[a][b].setText(" ");
        centerPanel.dimensionArray[a][b].setVisible(false);
    }

    public void moveDown(int a, int b) {
        centerPanel.dimensionArray[a + 1][b].setText(centerPanel.dimensionArray[a][b].getText());
        centerPanel.dimensionArray[a + 1][b].setVisible(true);
        centerPanel.dimensionArray[a][b].setText(" ");
        centerPanel.dimensionArray[a][b].setVisible(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == northPanel.newGameButton) {
            shuffleGame();
            southPanel.seconds = 0;
            southPanel.timer.start();

        }
        if (e.getSource() == northPanel.changeColorOnGameButton) {
            Color colorSelector = JColorChooser.showDialog(null, "Välj en färg på spelplanen", Color.BLACK);
            if (colorSelector != null) {
                northPanel.setBackground(colorSelector);
                centerPanel.setBackground(colorSelector);
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
