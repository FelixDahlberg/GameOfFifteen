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
    
    
    
    Main(){
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        northPanel.newGameButton.addActionListener(this);
        northPanel.changeColorOnGameButton.addActionListener(this);
        northPanel.changeColorOnNumbersButton.addActionListener(this);

        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void updateMoveCounter(){
        southPanel.moveCounter ++;
        southPanel.moveCounterLabel.setText("Antal drag: " + southPanel.moveCounter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == northPanel.newGameButton){
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
        if (e.getSource() == centerPanel.dimensionArray[0][1]){
            if(centerPanel.dimensionArray[0][0].getText().equals(" ") ) {
                centerPanel.dimensionArray[0][1].setText(" ");
                centerPanel.dimensionArray[0][1].setVisible(false);
                centerPanel.dimensionArray[0][0].setText("1");
                centerPanel.dimensionArray[0][0].setVisible(true);
                
            }
        }
    }
}