package lab3;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * This class creates generic lightweight container.
 *@author Mykhailov Vlad
 *@version 1.0
 */
public class TitlesPanel
extends JPanel
implements ActionListener {
	/**
	 * Provides control over geometry, coordinate transformations, color management, and text layout
	 */
    private Graphics2D g2d;
    /**
     * Creates a Timer object, registering one or more action listeners on it, and starting the timer using the start method. 
     */
    private Timer animation;
    private boolean is_done = true;
    private int start_angle = 0;
    private int shape;

    public TitlesPanel(int _shape) {
        this.shape = _shape;
        this.animation = new Timer(50, this);
        this.animation.setInitialDelay(50);
        this.animation.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (this.is_done) {
            this.repaint();
        }
    }
/**
 * Allow an application to draw onto components that are realized on various devices, as well as onto off-screen images.
                    * @param g graphic context
 */
            private void doDrawing(Graphics g) {
                this.is_done = false;
                this.g2d = (Graphics2D)g;
                this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Dimension size = this.getSize();
                Insets insets = this.getInsets();
                int w = size.width - insets.left - insets.right;
                int h = size.height - insets.top - insets.bottom;
                ShapeFactory shape = new ShapeFactory(this.shape);
                this.g2d.setStroke(shape.stroke);
                this.g2d.setPaint(shape.paint);
                double angle = this.start_angle++;
                if (this.start_angle > 360) {
                    this.start_angle = 0;
        }
        double dr = 90.0 / ((double)w / ((double)shape.width * 1.5));
        int j = shape.height;
        while (j < h) {
            int i = shape.width;
            while (i < w) {
                angle = angle > 360.0 ? 0.0 : angle + dr;
                AffineTransform transform = new AffineTransform();
                transform.translate(i, j);
                transform.rotate(Math.toRadians(angle));
                this.g2d.draw(transform.createTransformedShape(shape.shape));
                i = (int)((double)i + (double)shape.width * 1.5);
            }
            j = (int)((double)j + (double)shape.height * 1.5);
        }
        this.is_done = true;
    }

    @Override
    
    /**
     *rotected void paintComponent(Graphics g)
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.doDrawing(g);
    }
}
