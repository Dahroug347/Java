import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/**
 *
 * @author dahroug
 */
public class JavaWord extends Applet implements KeyListener
{
    int x,y;

    @Override
    public void init() 
    {
        resize(this.getWidth(), this.getHeight());
        x = (this.getWidth()/2);
        y = (this.getHeight()/2);
        
        addKeyListener(this);
        
    }

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void keyTyped(KeyEvent e) 
    {
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_RIGHT:
            x+=10;
            
            if(x<this.getWidth()){
                repaint() ;
            }
            else{
                x=0;
                repaint();
            }
            break;
            
            case KeyEvent.VK_LEFT:
              x-=10 ;
            
            if(x>0){
                repaint() ;
            }
            else{
                x=this.getWidth();
                repaint();
            }
           

            break;
        
            case KeyEvent.VK_UP:
            y-=10;
            if(y>0){
                repaint() ;
            }
            else{
                y=this.getHeight();
                repaint();
            } 
            break;
            case KeyEvent.VK_DOWN:
            y+=10;
            if(y<this.getHeight()){
                repaint() ;
            }
            else{
                y=0;
                repaint();
            }
            break;
            default:
            break;
        }    
    }
       

    @Override
    public void keyReleased(KeyEvent e) 
    {
        

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.drawString("Java", x, y);
    }
}
