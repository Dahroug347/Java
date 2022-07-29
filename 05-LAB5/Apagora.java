/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmoud
 */

public class Apagora extends Applet

{
    
    Button a;
    
    
    static int x = 0;
    Thread th;
    
    @Override
    public void init() 
    {
        a = new Button("ON/OFF");
        
        a.addActionListener((ActionEvent ev) -> 
        {
            x ^= 1;
            repaint();
        }                                               );
        
      add(a);  
    }

    @Override
    public void paint (Graphics ellipse)
    {
        
        
        switch (x)
        {
            case 0:
                ellipse.drawOval(50, 50, 200, 50);
                ellipse.setColor(Color.YELLOW);
                ellipse.fillOval(51, 51, 198, 48);
       
                ellipse.setColor(Color.BLACK);
                ellipse.drawOval(60, 130, 30, 50);
                ellipse.setColor(Color.WHITE);
                ellipse.fillOval(61, 131, 28, 48);

                 ellipse.setColor(Color.BLACK);
                 ellipse.drawOval(110, 110, 60, 90);
                 ellipse.setColor(Color.WHITE);
                 ellipse.fillOval(111, 111, 58, 88);

                 ellipse.setColor(Color.BLACK);
                ellipse.drawOval(190, 130, 30, 50);
                ellipse.setColor(Color.WHITE);
                ellipse.fillOval(191, 131, 28, 48);
                
                ellipse.setColor(Color.BLACK);
                ellipse.drawLine(50, 80, 30, 200);

                ellipse.drawLine(250, 80, 270 ,200);

                ellipse.drawArc(30, 180, 240, 40, 180, 175);

                ellipse.drawLine(150, 220, 130 ,300);
                ellipse.drawLine(170, 220, 200 ,300);

                ellipse.drawRect(60 ,300, 200, 20);
                
            break;  
            
            case 1:
                
                ellipse.drawOval(50, 50, 200, 50);
                ellipse.setColor(Color.YELLOW);
                ellipse.fillOval(51, 51, 198, 48);
       
                ellipse.setColor(Color.BLACK);
                ellipse.drawOval(60, 130, 30, 50);
                ellipse.setColor(Color.GREEN);
                ellipse.fillOval(61, 131, 28, 48);

                 ellipse.setColor(Color.BLACK);
                 ellipse.drawOval(110, 110, 60, 90);
                 ellipse.setColor(Color.YELLOW);
                 ellipse.fillOval(111, 111, 58, 88);

                 ellipse.setColor(Color.BLACK);
                ellipse.drawOval(190, 130, 30, 50);
                ellipse.setColor(Color.RED);
                ellipse.fillOval(191, 131, 28, 48);
                
                ellipse.setColor(Color.BLACK);
                ellipse.drawLine(50, 80, 30, 200);

                ellipse.drawLine(250, 80, 270 ,200);

                ellipse.drawArc(30, 180, 240, 40, 180, 175);

                ellipse.drawLine(150, 220, 130 ,300);
                ellipse.drawLine(170, 220, 200 ,300);

                ellipse.drawRect(60 ,300, 200, 20);
                
            break;
                
        }
        
    }

}