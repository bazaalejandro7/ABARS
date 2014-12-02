import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



/**
 * @author courtneyfennell
 *@created November 24, 2014
 */
@SuppressWarnings("serial")
public class AdminGUI extends JPanel {


	/**
	 * AdminGUI constructor 
	 */
	public AdminGUI(){
		JButton runButton = new JButton("Run Auction");
		runButton.addActionListener(new RunAuctionListener());

	}
	class RunAuctionListener implements ActionListener { // Inner class
		public void actionPerformed(ActionEvent e) {
			//call run auction method
		}
	}
}
