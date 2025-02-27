import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsP extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
        Font BerlinFont = new Font("Berlin Sans FB Demi", 0,getHeight()/25);
        g.setFont(BerlinFont);
        FontMetrics font = g.getFontMetrics();
        String str = "Hussain's house cool house:)";
        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        g.setColor(Color.lightGray);
        g.fillRect(getWidth()/3,getHeight()/4,getWidth()/3,getHeight()/3);
        g.setColor(Color.orange);
        g.fillPolygon(new int[] {getWidth()/2, getWidth()/3, getWidth()*2/3}, new int[] {font.getAscent(), getHeight()/4, getHeight()/4}, 3);
        g.setColor(Color.black);
        g.fillOval(getWidth()*5/12,getHeight()/8,getWidth()/6,getHeight()/8);
        g.setColor(Color.yellow);
        g.fillArc(getWidth()*5/12,getHeight()/8,getWidth()/6,getHeight()/8, 0,60);
        g.fillArc(getWidth()*5/12,getHeight()/8,getWidth()/6,getHeight()/8, 120,60);
        g.fillArc(getWidth()*5/12,getHeight()/8,getWidth()/6,getHeight()/8, 240,60);
        g.setColor(Color.blue);
        g.drawString(str, (getWidth()-font.stringWidth(str))/2, (font.getAscent()));
        setBackground(Color.cyan);
    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Art Project");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsP();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
