import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 program to update the display with number of times mouse is clicked and a reste button.
 * 
 * @author Hussain Ali,
 * @author Gregory Drapeau
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener{
	//Instance variables
	String toDisplay;
	int clicks = 0;
	JPanel panel;
	JButton button;
	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {
		//Creating the frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MousePressCounter");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method

		panel = new JPanel(new BorderLayout()) {
			/**
			 * Paint component method to paint our display on the window
			 * @param g Graphics object which paints objects on the panel
			 */
			@Override
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				toDisplay = "Mouse press count: "+clicks;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}
		};
		//Create the reset button at the south of the panel with an action  listener
		button = new JButton("Reset");
		button.addActionListener(this);
		panel.add(button, BorderLayout.SOUTH);

		//Adds panel to the frame and listeners to the panel 
		frame.add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * Method to be trigerred when mouse is clicked in the window
	 * A click anywhere in the window should increment clicks
	 * 
	 * @param e Mouse event that holds the mouse event when mouse is clicked 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		clicks++;
		System.out.println("mouseClicked: " + clicks);
		panel.repaint();
	}
	/**
	 * Method to be trigerred when an action is performed with an action listener
	 * Only one action listener so we know it is always the reset button
	 * 
	 * @param e Action event that holds the Action event when action event listener gets trigerred
	 */
	public void actionPerformed(ActionEvent e){
		clicks=0;
		panel.repaint();
	}

	/**
	 * Main method to start the java swing program 
	 * 
	 * @param args stores arguments to be passed to the method
	 */
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
