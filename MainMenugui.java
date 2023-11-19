import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenugui implements Defaultgui{
	private JPanel mainMenu;
	private BankDatabase bankDB;

	private int currentAccountNumber; // current user's account number

	private static final ATMgui SCREEN = ATMgui.get();
	
	protected MainMenugui() {

		mainMenu = getdefaultGUI();
		
		// change title to "Main Menu"
		setComponentText(mainMenu, "Title", "Main Menu", 1, 20);
		
		setComponentText(mainMenu, "selection4", "View my balance");

		// change selection names
		setComponentText(mainMenu, "selection4", "View my balance");
		setComponentText(mainMenu, "selection5", "Withdraw cash");
		setComponentText(mainMenu, "selection6", "Transfer funds");
		setComponentText(mainMenu, "selection7", "Exit");
		// Set the rest of the selection with no text
		for (int i = 0; i < 4; i++) {
			setSelectionDisplay(mainMenu, i, false);
		}

		bankDB = new BankDatabase();
	}

	public int getAccountNumber(){ return currentAccountNumber;}

	/**
	 * Authenticate user to proceed with their transaction with the inofrmation provided
	 * @param accountNumber the Account Number to login
	 * @param pin the PIN of the account number
	 * @return boolean whether the authentication is successful
	 */
	private boolean authenticateUser(int accountNumber, int pin){
		if(bankDB.authenticateUser( accountNumber, pin )){ // Try to login the user
			currentAccountNumber = accountNumber; // sets the current accunt number
			return true;
		}
		return false;
	}

	
	public JPanel getPanel() {
		return mainMenu;
	}
	
	public void setallSelectionListener() {
		// set action listener for view balance
		/* */
		//ActionListener viewBalance = ;
		ATMgui.get().setSelectionListener(2, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Transaction temp = new BalanceInquiry( getAccountNumber(), ATMgui.get(),bankDB );
				temp.execute();
			}
		});

		System.out.println("a");
		
		// set action listener for withdraw
		ActionListener withdraw = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Transaction temp = new Withdrawal( currentAccountNumber, SCREEN, 
               		bankDB, /*keypad, cashDispenser*/new Keypad(), new CashDispenser() );
				temp.execute();
				//ATMgui.get().display(GUIType.Withdrawal);
			}
			
		};
		ATMgui.get().setSelectionListener(6, withdraw);

		System.out.println("b");
		
		// set action listener for transfer fund
		ActionListener transferFund = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Transaction temp = new Transfer( currentAccountNumber, SCREEN, 
               		bankDB, new Keypad() );
			}
			
		};
		ATMgui.get().setSelectionListener(3, transferFund);
		System.out.println("c");
		
		// set action listener for exit
		ActionListener exit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ATMgui.get().display(GUIType.Exit);
			}
			
		};
		ATMgui.get().setSelectionListener(7, exit);

		System.out.println("d");
	}
}
