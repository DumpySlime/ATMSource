import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingConstants;

public class Exitgui{
	
	private static JPanel 
		exitGUI,
		countdownGUI;
	private static JLabel 
		exitMessage,
		countdownMessage;
	private static Timer timer;
	private static int 
		counter = 5,
		delay = 1000;
	
	protected Exitgui() {
		
		// create exit message
		exitMessage = new JLabel();
		exitMessage.setFont(new Font("exit", 1, 20));
	    exitMessage.setHorizontalAlignment(SwingConstants.CENTER);
		exitMessage.setText("Please take your card");
		
		// create count down panel
		countdownGUI = new JPanel(new BorderLayout());
		countdownMessage = new JLabel();
		countdownGUI.add(countdownMessage, BorderLayout.EAST);
		
		// create exit gui
		exitGUI = new JPanel(new BorderLayout());
		exitGUI.add(exitMessage, BorderLayout.CENTER);
		exitGUI.add(countdownGUI, BorderLayout.SOUTH);
		
		//System.out.println("Exitgui setInterface() out");
		
	}
	
	public void setallSelectionListener() {
		
		ActionListener countdown = new ActionListener()
        {   
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(counter == 0)
                {
                    timer.stop();
    				ATMgui.get().display(GUIType.MainMenu);
					counter = 5;
                }
                else
                {
                    countdownMessage.setText("Return to Login page in " + counter + " seconds");
                    counter--;
                }
            }
        };
        
        timer = new Timer(delay, countdown);
        timer.setInitialDelay(0);
        timer.start();
	}
	
	public JPanel getPanel() {
		return exitGUI;
	}
}
