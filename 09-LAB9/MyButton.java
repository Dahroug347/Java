import java.awt.event.*;
import java.awt.*;
import java.applet.*;
/**
 *
 * @author dahroug
 */
public class MyButton extends Applet{
int x;
Button i;
Button d;
@Override
public void init()

{   

i = new Button("Increment");
i.addActionListener((ActionEvent ev) -> {
    if(x<10){
        x++ ;
    }
    if(x<=10){
        repaint() ;
    }
});

d= new Button("Decrement");
d.addActionListener((ActionEvent ev) -> {
    if(x>0){
        x-- ;
    }
    if(x>=0){
        repaint() ;
        
    }
});
add(d);
add(i);

}
@Override
public void paint(Graphics g){
g.drawString("value of x = " + x, 150, 200);
}
}