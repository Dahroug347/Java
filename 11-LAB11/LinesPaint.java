/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.*;
import java.awt.*;
import java.applet.*;


/**
 *
 * @author dahroug
 */
public class LinesPaint extends Applet implements MouseListener, MouseMotionListener
    {
        int x, y, x1, y1;
    @Override
    public void init() 
    {
        resize(this.getWidth(), this.getHeight());
        addMouseListener(this);
        addMouseMotionListener(this);  
    }


    @Override
    public void mouseClicked(MouseEvent e) 
    {
      
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {           
         
           x = e.getX();
           y = e.getY(); 

           
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        //x1 = e.getX();
        //y1 = e.getY();      
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        
           x1 = e.getX();
           y1 = e.getY();
           
           repaint();
           
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
        @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.drawLine(x, y, x1, y1);
    }
    
    
}
