package karabli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import karabli.*;

public class ActionButtonPaneltwo implements ActionListener
{
    private Karabli kor;
    public ActionButtonPaneltwo(Karabli frame)
    { 
        kor = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton b;
        b = (JButton) e.getSource();
        int index = Integer.parseInt(b.getActionCommand());
        JbuttonKor bk = kor.getColl().get(index);
        
        kor.setStateButton();
    }
    
}
