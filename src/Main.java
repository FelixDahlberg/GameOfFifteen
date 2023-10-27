import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Main();
    }

    northPanel northPanel = new northPanel();
    JPanel centerPanel = new JPanel(new GridLayout(4, 4));
    southPanel southPanel = new southPanel();


    Main() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        northPanel.newGameButton.addActionListener(this);


        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == northPanel.newGameButton) {
            southPanel.moveCounter++;
            southPanel.moveCounterPanel.setText(String.valueOf(southPanel.moveCounter));
            if (southPanel.timer.isRunning()) {
                southPanel.timer.stop();

            } else {
                southPanel.running = true;
                southPanel.timer.start();
            }
        }
    }
}