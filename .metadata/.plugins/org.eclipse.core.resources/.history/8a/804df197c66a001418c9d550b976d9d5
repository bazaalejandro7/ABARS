/*
 * Copyright (c) 1995-1997 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import com.sun.java.swing.JRadioButton;
import com.sun.java.swing.ButtonGroup;
import com.sun.java.swing.JPanel;
import com.sun.java.swing.JFrame;
import com.sun.java.swing.event.ChangeListener;
import com.sun.java.swing.event.ChangeEvent;

/**
 * An application that displays two JRadioButtons.  The JRadioButtons
 * determine the look and feel used by the application.
 */
public class RadioButtonDemo extends JPanel {
    static JFrame frame;
    static String first = new String("Button 1");
    static String second = new String("Button 2");

    public RadioButtonDemo() {
	super(true);

	// Create the buttons.
	JRadioButton firstButton = new JRadioButton(first);
        firstButton.setKeyAccelerator('1'); 
	firstButton.setActionCommand(first);
	firstButton.setSelected(true);

	JRadioButton secondButton = new JRadioButton(second);
        secondButton.setKeyAccelerator('2'); 
	secondButton.setActionCommand(second);

	// Group the radio buttons.
	ButtonGroup group = new ButtonGroup();
	group.add(firstButton);
	group.add(secondButton);

        // Register a listener for the radio buttons.
	RadioListener myListener = new RadioListener();
	firstButton.addActionListener(myListener);
	firstButton.addChangeListener(myListener);
	firstButton.addItemListener(myListener);
	secondButton.addActionListener(myListener);
	secondButton.addChangeListener(myListener);
	secondButton.addItemListener(myListener);

	add(firstButton);
	add(secondButton);
    }


    /** Listens to the radio buttons. */
    class RadioListener implements ActionListener, //only one event type needed
				   ChangeListener, //for curiosity only
				   ItemListener {  //for curiosity only
	public void actionPerformed(ActionEvent e) {
	    String factoryName = null;

	    System.out.print("ActionEvent received: ");
	    if (e.getActionCommand() == first) {
		System.out.println(first + " pressed.");
	    } else {
		System.out.println(second + " pressed.");
	    }
	}

	public void itemStateChanged(ItemEvent e) {
	    System.out.println("ItemEvent received: " 
			       + e.getItem()
			       + " is now "
			       + ((e.getStateChange() == ItemEvent.SELECTED)?
				   "selected.":"unselected"));
	}

	public void stateChanged(ChangeEvent e) {
	    System.out.println("ChangeEvent received from: "
			       + e.getSource());
	}
    }

    public static void main(String s[]) {
         WindowListener l = new WindowAdapter() {
             public void windowClosing(WindowEvent e) {System.exit(0);}
         };
 
         frame = new JFrame("RadioButtonDemo");
         frame.addWindowListener(l);
         frame.add("Center", new RadioButtonDemo());
         frame.pack();
         frame.setVisible(true);
    }
}
