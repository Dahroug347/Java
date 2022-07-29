
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

/**
 *
 * @author dahroug
 */
public class MultiLines extends Applet implements MouseListener, MouseMotionListener {

    int flag = 0;
    int x, x1, y, y1;
    final int SIZE = 10;
    int it = 0;
    Point[] starts;
    Point[] ends;

    @Override
    public void init() {
        starts = new Point[SIZE];
        for (int i = 0; i < SIZE; i++) {
            starts[i] = new Point();
        }
        ends = new Point[SIZE];
        for (int i = 0; i < SIZE; i++) {
            ends[i] = new Point();
        }

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
    public void mousePressed(MouseEvent e) {

        x = e.getX();
        y = e.getY();

        starts[it].x = x;
        starts[it].y = y;

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        ends[it].x = e.getX();
        ends[it].y = e.getY();
        it++;
        try {
            if (it > (SIZE-1)) {
                flag = 1;
            }

        } catch (ArrayIndexOutOfBoundsException ev) {
            repaint();
        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        x1 = e.getX();
        y1 = e.getY();

        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        if (flag == 1) {
            g.drawString(" error you are out of array bounds", 100, 100);
        } else {
            g.setColor(Color.red);
            for (int i = 0; i < it; i++) {
                g.drawLine(starts[i].x, starts[i].y, ends[i].x, ends[i].y);
            }
            g.drawLine(x, y, x1, y1);
        }

    }

}
