import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoginGUI implements Defaultgui{

    private JPanel login;
    private BankDatabase loginBankDB;

    private int currentAccountNumber;

    private Font loginFont;

    public int accountNumber;
    public int PIN;

    protected LoginGUI(){
        System.out.println("Login");
        login = getdefaultGUI();
        loginFont = new Font("loginFont", 1 ,20);

        setComponentText(login, "Title", "Please Enter Your Account Number", loginFont);


        for (int i = 0; i < 8; i++) {
            setSelectionDisplay(login, i, false);
        }

        loginBankDB = new BankDatabase();

    }

    public JPanel getPanel() {
        return login;
    }

    // Acc number enter
    public void setAllListener() {
        // Acc number enter
        ATMgui.get().setEnterListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String accountNumberinput = getTextPaneText (login);
                setComponentText(login, "Title", accountNumberinput, loginFont);
                //String input = getTextPaneText( TransferGUI );
                System.out.println(accountNumberinput);
                passwordCheck();
                System.out.println("enter acc number");
            }
        });
    }
    // Password check
    public void passwordCheck(){
        ATMgui.get().setEnterListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){

                setComponentText(login, "Title", "Please Enter Your PIN", loginFont);

                String PINinput = getTextPaneText (login);
                //PIN = Integer.parseInt(PINinput);
                boolean userAuthenticated = loginBankDB.authenticateUser( accountNumber, PIN );
                System.out.println("password enter");
                // check whether authentication succeeded
                if ( userAuthenticated )
                {
                    currentAccountNumber = accountNumber; // save user's account #
                    ATMgui.get().display(GUIType.MainMenu);
                    // proceeed to main menu
                }

                else{

                    setComponentText(login, "Title", "Account Number or PIN wrong, Please Enter Again", loginFont);

                    ATMgui.get().setEnterListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent evt){
                            passwordCheck();
                            System.out.println("wrong acc or pin");
                        }
                    });
                }
            }
        });
    }
}
