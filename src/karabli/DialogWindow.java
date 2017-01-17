package karabli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DialogWindow extends JDialog
{
    private String ipName;
    private JTextField textip = new JTextField();
    
    
    public DialogWindow(JFrame frame)
    {
        super(frame,"ConnectIPAdres",true);
        add(textip,BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ipName = textip.getText();
                setVisible(false);
            }
        });
        panel.add(button);
        panel.setPreferredSize(new Dimension(250, 200));
        add(panel,BorderLayout.SOUTH);
        pack();
    }
    
    public String getIp()
    {
        return ipName;
    }
    
}
