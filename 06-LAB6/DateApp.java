
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dahroug
 */
public class DateApp extends Applet implements Runnable

{
    Thread th;
    
    
    @Override
    public void init() 
    {
        th = new Thread(this);
        th.start();
    }

    @Override
    public void paint (Graphics s)
    {
        Date d = new Date();
        s.drawString(d.toString(), 50, 50);
    }
    
    @Override
    public void run() 
    {
        while (true)
        {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DateApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
