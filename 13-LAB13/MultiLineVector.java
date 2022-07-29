import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.util.*;




/**
 *
 * @author dahroug
 */
public class MultiLineVector extends Applet implements MouseListener, MouseMotionListener 
{
    int lFlag;
    int x, x1, y, y1;
    int it = 0;
    Vector<Line> v = new Vector<Line>();
    public class Line 
        {
            int a,b,c,d;
           Line (int x, int y, int z, int w)
            {
                a = x;
                b = y;
                c = z;
                d =  w;
            }
        }
    @Override
    public void init() 
    {
        resize(this.getWidth(), this.getHeight());
        addMouseListener(this);
        addMouseMotionListener(this);
        // TODO start asynchronous download of heavy resources
    }

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        x1 = e.getX();
        y1 = e.getY();
        v.add(it++,new Line (x, y, x1, y1));
        repaint();

       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {      
        x1 = e.getX();
        y1 = e.getY();
        
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    
     @Override
    public void paint(Graphics g)
    {
        
        g.setColor(Color.red);
        for (int i = 0; i<it; i++)
        {
            g.drawLine(v.get(i).a, v.get(i).b,  v.get(i).c,  v.get(i).d);                 
        }
        g.setColor(Color.BLUE);
        g.drawLine(x, y, x1, y1);
    }
        
}
