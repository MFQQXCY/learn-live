package beatbox;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel implements ControllerEventListener{

    private boolean msg = false;
    private Random random = new Random();

    @Override
    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(msg){
            int red = random.nextInt(250);
            int green  = random.nextInt(250);
            int blue = random.nextInt(250);
            g.setColor(new Color(red, green, blue));

            int height = random.nextInt(120) + 10;
            int width = random.nextInt(120) + 10;

            int xPos = random.nextInt(40) + 10;
            int yPos = random.nextInt(40) + 10;
            
            g.fillRect(xPos, yPos, width, height);
            msg  = false;
        }
    }
    
    
}
