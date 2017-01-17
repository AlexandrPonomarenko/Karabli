package karabli;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyVictoriFrame extends JFrame
{
    int height = 300;
    int width = 300;
    private String vic = "Victori";
    
    public MyVictoriFrame(String s)
    {
     //JFrame frame = new JFrame("InputDialog Example #1");

    JOptionPane.showMessageDialog(this,vic + " " + s);
 
        //System.out.printf("The user's name is '%s'.\n", name);
        //System.exit(0);
    }
}
