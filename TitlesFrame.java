package lab3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *This class sets the title of the program and window sizes of the program.
 *@author Mykhailov Vlad
 *@version 1.0
 */

public class TitlesFrame
        extends JFrame {
    public TitlesFrame() {
        this.initUI();
    }


    private void initUI() {

        /*
         * Sets the title for this frame to the specified string
         */
        this.setTitle("\u041a\u0440\u0438\u0432\u044b\u0435 \u0444\u0438\u0433\u0443\u0440\u044b");
        this.setDefaultCloseOperation(3);
        this.add(new TitlesPanel(17));
        /* sets size for frame
         *@param: width - the new width of this component in pixelsheight - the new height of this component in pixels
         */
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
    }

    /**
     * Causes doRun.run() to be executed asynchronously on the AWT event dispatching thread.
     * This will happen after all pending AWT events have been processed.
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);

            }
        });
    }

}

