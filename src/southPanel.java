import javax.swing.*;


public class southPanel extends JPanel {
    
    int moveCounter = 0;
    JLabel moveCounterLabel = new JLabel("Antal drag: " + moveCounter);
    JLabel timerLabel = new JLabel("Time: 0");
    Timer timer;

    int seconds = 0;
    boolean running = true;
    southPanel(){
        
        add(moveCounterLabel);
        add(timerLabel);
        
        timer = new Timer(1000, e -> {
            if (running) {
                seconds++;
                timerLabel.setText("Timer: " + seconds);
            }
        });
        
    }
}
