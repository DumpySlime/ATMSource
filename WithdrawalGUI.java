import javax.swing.JPanel;

public class WithdrawalGUI implements Defaultgui{

    private static JPanel mainPanel;

    protected WithdrawalGUI(){
    }


    public static JPanel getMainPanel(boolean inputError) {
        
        mainPanel = ATMgui.get().getdefaultGUI();

        ATMgui.get().setComponentText(
            mainPanel,
            Defaultgui.TITLE_LABEL,
            "<html><h1>Please select the exact amount,<br>or type the amount using the keypad.</h1>" 
            + (inputError ?
                "<h3><span style='color:red; text-weight:bold;'>Invalid input. Please try again.</span></h3>"
                : "") + "</html>"
            );

        ATMgui.get().setComponentText(mainPanel, Defaultgui.SELECTION4_LABEL, "$100");
        ATMgui.get().setComponentText(mainPanel, Defaultgui.SELECTION5_LABEL, "$500");
        ATMgui.get().setComponentText(mainPanel, Defaultgui.SELECTION6_LABEL, "$1000");
        ATMgui.get().setComponentText(mainPanel, Defaultgui.SELECTION7_LABEL, "Main Menu");
        
        for (int i = 0; i < 4; i++) {
            ATMgui.get().setSelectionDisplay(mainPanel, i, false);
        }
        
        return mainPanel;
   }
   
   public static JPanel getErrorScreen(String msg){
       mainPanel = ATMgui.get().getdefaultGUI();

        ATMgui.get().setComponentText(mainPanel, Defaultgui.TITLE_LABEL, 
                "<html></h2>Operation cancelled:</h2><br>" + msg + "</html>");

        ATMgui.get().setComponentText(mainPanel, "selection6", "Return to Main Menu");
        ATMgui.get().setComponentText(mainPanel, "selection7", "Take card and Exit");
        
        for (int i = 0; i <= 3; i++) {
            ATMgui.get().setSelectionDisplay(mainPanel, i, false);
        }
        
        for (int i = 4; i < 6; i++) {
            ATMgui.get().setSelectionDisplay(mainPanel, i, false);
        }
        
        return mainPanel;
   }
   
   public static JPanel getDispensedScreen(){
       mainPanel = ATMgui.get().getdefaultGUI();

        ATMgui.get().setComponentText(mainPanel, Defaultgui.TITLE_LABEL, "<html><h1>Please take your cash and your card</h1></html>");

        ATMgui.get().setComponentText(mainPanel, "selection6", "Return to Main Menu");
        ATMgui.get().setComponentText(mainPanel, "selection7", "Take card and Exit");
        
        for (int i = 0; i <= 3; i++) {
            ATMgui.get().setSelectionDisplay(mainPanel, i, false);
        }
        
        for (int i = 4; i < 6; i++) {
            ATMgui.get().setSelectionDisplay(mainPanel, i, false);
        }
        
        return mainPanel;
   }
   
}
