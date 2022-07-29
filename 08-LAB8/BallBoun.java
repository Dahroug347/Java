
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author dahroug
 */
public class BallBoun extends Applet implements Runnable, java.awt.event.MouseListener {

    public Integer flag = 1;
    int delaytime = 35;
    Integer x = 0;
    Integer y = 75;
    int direction = 1;
    Thread th;

    @Override
    public void init() {
        addMouseListener(this);
        th = new Thread(this);
        th.start();
            
    }

    @Override
    public void paint(Graphics ball) {
        switch (direction) {
            case 1:
                ball.drawOval(x, y, 50, 50);
                ball.setColor(Color.RED);
                ball.fillOval(x + 1, y + 1, 48, 48);
                
                break;

            case 2:
                ball.drawOval(x, y, 50, 50);
                ball.setColor(Color.BLUE);
                ball.fillOval(x + 1, y + 1, 48, 48);
                break;

            case 3:
                ball.drawOval(x, y, 50, 50);
                ball.setColor(Color.GREEN);
                ball.fillOval(x + 1, y + 1, 48, 48);
                break;

            case 4:
                ball.drawOval(x, y, 50, 50);
                ball.setColor(Color.BLACK);
                ball.fillOval(x + 1, y + 1, 48, 48);
                break;
        }

    }
    
      @Override
    public void mouseClicked(MouseEvent e) 
    {
              
        flag ^= 1;
            if (flag == 0)
            {
            
                th.suspend();
            }
            
            else
           th.resume();
        
          //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {

        while (true) {
            
            switch (direction) {
                case 1:
                    while (y < 150) {
                        x += 2;
                        y += 2;
                        repaint();
                        try {
                            Thread.sleep(delaytime);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BallBoun.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    direction = 2;

                    break;

                case 2:
                    while (x < 300 ) {
                        x += 2;
                        y -= 1;
                        repaint();
                        try {
                            Thread.sleep(delaytime);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BallBoun.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    direction = 3;
                    break;

                case 3:
                    while (y > 0) {
                        x -= 2;
                        y -= 2;
                        repaint();
                        try {
                            Thread.sleep(delaytime);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BallBoun.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    direction = 4;
                    break;

                case 4:
                    while (x > 0) {
                        x -= 2;
                        y += 1;
                        repaint();
                        try {
                            Thread.sleep(delaytime);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BallBoun.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    direction = 1;
                    break;

            }

        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
