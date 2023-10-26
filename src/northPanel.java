import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class northPanel extends JPanel implements ActionListener {
    
    JButton newGameButton = new JButton("New Game");
    
    JButton exitButton = new JButton("Exit");
    northPanel(){
        add(newGameButton);
        add(exitButton);
        newGameButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
}
