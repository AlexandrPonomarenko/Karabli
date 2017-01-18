package karabli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jdk.nashorn.internal.ir.BreakNode;


public class Karabli extends JFrame
{
    int c = 0;
    private static final int DEF_H = 700;
    private static final int DEF_W = 1300;
    private String nameIP;
    private String alf = "A B S D E F G H I J K L";
    private String alfcount = "1 2 3 4 5 6 7 8 9 10";
    private String[] bukva;
    private String[] count;
    private List<JbuttonKor> jbc;
    private ArrayList<JbuttonKor> jbcPanelTwo;
    private Iterator<JButton> jbciter;
    private DialogWindow dialog;
    private BoT testBot;
    private BoT bot;
    private DialogButtonWindow dialog2;
    private JPanel panel, panel1 , panel2;
    private ActionButton addButtonListener = new ActionButton();
    private JbuttonKor butkor;
    private ArrayList<JbuttonKor> colbutkor;
    private List<JbuttonKor> colBot;
    private int[] state;
    private boolean stateBot = true;
    
    public Karabli()
    {
        setSize(DEF_W, DEF_H);
        colbutkor = new ArrayList<>();
        colBot = new ArrayList<>();
        jbc = new ArrayList<>();
        jbcPanelTwo = new ArrayList<>();
        bukva = alf.split(" ");
        count = alfcount.split(" ");
        bot = new BoT();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("New");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
            }
        });
        menu.add(menuItem);
        
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        menu.add(itemExit);
        
        JMenuItem itemConnect = new JMenuItem("Connect");
        itemConnect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(dialog == null)
                {
                    dialog = new DialogWindow(Karabli.this);
                    dialog.setVisible(true);
                } else if(dialog != null)
                {
                    dialog = new DialogWindow(Karabli.this);
                    dialog.setVisible(true);
                }
            }
        });
        menu.add(itemConnect);
        
        JMenuItem itemSetKorabl = new JMenuItem("SetShips");
        itemSetKorabl.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
//                if(dialog2 == null)
//                {
//                    dialog2 = new DialogButtonWindow(Karabli.this);
//                    dialog2.setVisible(true);
//                }else if(dialog2 != null)
//                {
//                    dialog2 = new DialogButtonWindow(Karabli.this);
//                    dialog2.setVisible(true);
//                }
                
                dialog2 = new DialogButtonWindow(Karabli.this);
                
                dialog2.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e)
                    {
                        System.out.println("jdialog window closed");
                        Karabli.this.receptionInt(dialog2.getArray());
                        Karabli.this.setStateButton();
                    }
                });
                dialog2.setVisible(true);
            }
        });
        menu.add(itemSetKorabl);
        
        JMenuItem bot = new JMenuItem("Game to bot");
        bot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                testBot = new BoT(Karabli.this);
                testBot.addWindowListener(new WindowAdapter() 
                {
                    @Override
                    public void windowClosed(WindowEvent e)
                    {
                        Karabli.this.receptionBot(testBot.getArrayStateBot());
                        Karabli.this.getBooleanStateButton(testBot.getStateBotButton());
                    }
                });
                testBot.setVisible(true);
                
            }
        });
        menu.add(bot);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        //panel.setPreferredSize(new Dimension(500, 500));
        
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(11, 11));
        panel1.setPreferredSize(new Dimension(400, 400));
        setButton(panel1);
        panel.add(panel1);
        
        
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(11, 11));
        setButtonPanelTwo(panel2);
        panel.add(panel2);
        
        
        add(panel, BorderLayout.CENTER);
       // collectionFor();
       state = new int[jbc.size()];
    }
    
    public ArrayList<JbuttonKor> getColl()
    {
        return jbcPanelTwo;
    }
    
    public int[] getMas()
    {
        return state;
    }
    public void receptionBot(List<JbuttonKor> ajb)
    {
        for(int i = 0;i < ajb.size();i++)
        {
            colBot.add(ajb.get(i));
        }
        System.out.println(colBot.size() + "================");
    }
    
    public void getBooleanStateButton(boolean state)
    {
        if(state == stateBot)
        {
            stateBot = state;
        }else stateBot = false;
    }
    
    public void reception(List<JbuttonKor> ajb)
    {
        for(int i = 0;i < ajb.size();i++)
        {
            colbutkor.add(ajb.get(i));
            System.out.println(colbutkor.size() + "================");
        }
    }
    
    public void receptionInt(int[] mas)
    {
        for(int i = 0;i < mas.length;i++)
        {
            if(mas[i] == 1)
            {
                state[i] = 1;
            }else state[i] = 0;
        }
    }
    
    private void addButton(String name,JPanel p,int index)
    {
        JbuttonKor button = new JbuttonKor(name , index);
        button.addEventPanelOne(new ActionButton());
        jbc.add(button);
        button.addButPanel(p);
    }
    
    private void addButtonPanelTwo(String name,JPanel p,int index)
    {
        JbuttonKor button1 = new JbuttonKor(name, index);
        button1.addEvent(new ActionButtonPaneltwo(Karabli.this));
        jbcPanelTwo.add(button1);
        button1.addButPanel(p);
    }
//    private void setSizeButton()
//    {
//        if(c != jbc.size() - 1)
//        {
//            jbc.get(c).setPreferredSize(new Dimension(10, 10));
//            c++;
//        }else {c = 0;}
//    }
    
    private void collectionFor()
    {
        while(jbciter.hasNext())
        {
            jbciter.next().setPreferredSize(new Dimension(10, 10));
        }
    }
    
    private void setButton(JPanel p)
    {   int e = 11;
        int c = 0;
        int a = 0;
        for(int i = 0; i < 121; i++)
        {
            if(i == 0)
            {
                addButton("You", p, i);
                jbc.get(i).setEnaBut();
            }else if( i > 0 && i < 11)
            {
                addButton(count[c], p , i);
                jbc.get(i).setEnaBut();
                c++;
            }else if(i == e)
            {
                addButton(bukva[a], p, i);
                jbc.get(i).setEnaBut();
                e+=11;
                a++;
            }else
            {
                addButton("", p, i);
                jbc.get(i).setSea();
            }
        }
    }
    
    private void setButtonPanelTwo(JPanel p)
    {
        int e = 11;
        int c = 0;
        int a = 0;
        for(int i = 0; i < 121; i++)
        {
            if(i == 0)
            {
                addButtonPanelTwo("Enemy", p, i);
                jbcPanelTwo.get(i).setEnaBut();
            }else if( i > 0 && i < 11)
            {
                addButtonPanelTwo(count[c], p , i);
                jbcPanelTwo.get(i).setEnaBut();
                c++;
            }else if(i == e)
            {
                addButtonPanelTwo(bukva[a], p, i);
                jbcPanelTwo.get(i).setEnaBut();
                e+=11;
                a++;
            }else
            {
                addButtonPanelTwo("", p, i);
                jbcPanelTwo.get(i).setSeaButtonEn();
            }
        }
        //offOneGor_OnO_neVer(jbcPanelTwo);
        //offOneGor_OnO_neVer(colbutkor);
        //System.out.println(jbcPanelTwo.size() + "Панель2 кнопок для установки");
        //System.out.println(colbutkor.size() + "Состояние кнопок пришелшие с установки короблей");
        
    }
    
    public void setStateButton()
    {
        for(int i = 11; i < jbcPanelTwo.size();i++)
        {
            System.out.println(state[i]);
            if(state[i] == 1)
            {
                jbcPanelTwo.get(i).setShip();
            }else if(!(i == 11 ||
                     i == 22 ||
                     i == 33 ||
                     i == 44 ||
                     i == 55 ||
                     i == 66 || 
                     i == 77 ||
                     i == 88 ||
                     i == 99 ||
                     i == 110))
            {
                jbcPanelTwo.get(i).setSea();
                //jbcPanelTwo.get(i).setEnaButOff();
            }
        }
    }
    
    private void offOneGor_OnO_neVer(ArrayList<JbuttonKor> coll)
    {
        for(int i = 0;i < coll.size(); i++)
        {
            if(!coll.get(i).isFixed())
            {
                if(!coll.get(i - 11).isFixed())
                {
                    coll.get(i).setTop(coll.get(i - 11));
                }
                
                if(i + 11 < coll.size() && !coll.get(i + 11).isFixed())
                {
                    coll.get(i).setBottom(coll.get(i + 11));
                }
                
                if(!coll.get(i - 1).isFixed())
                {
                    coll.get(i).setLeft(coll.get(i - 1));
                }
                
                if(i + 1 < coll.size() && !coll.get(i + 1).isFixed())
                {
                    coll.get(i).setRight(coll.get(i + 1));
                }
            }
        }
    }
    
    public void setStateButPaneTwo()
    {
        for(int i = 1;i < jbcPanelTwo.size();i++)
        {
            if(colbutkor.get(i).getState() == new JbuttonKor().getState())
            {
                jbcPanelTwo.get(i).setNone();
            }else if(colbutkor.get(i).getState() == new JbuttonKor().getState())
            {
                jbcPanelTwo.get(i).setShip();
            }else if(colbutkor.get(i).getState() == new JbuttonKor().getState())
            {
                jbcPanelTwo.get(i).setSpase();
            }else if(colbutkor.get(i).getState() == new JbuttonKor().getState())
            {
                jbcPanelTwo.get(i).setFixet();
            }else if(colbutkor.get(i).getState() == new JbuttonKor().getState())
            {
                jbcPanelTwo.get(i).setOff();
            } 
        }
    }
    public class ActionButton implements ActionListener
    {
        private int index = 0;
        private int botBrokShip = 0;
        private int gamerBrokShip = 0;
        private boolean state = true;
        private Random r = new Random();
        private int random;
        private int tempIndex;
        private MyVictoriFrame m;
        private String bot = "PC";
        private String player = "Player";
        private int top = 1;
        private int bottom = 2;
        private int left = 3;
        private int rigch = 4;
        
        
        public ActionButton() 
        {
            
        }
           
        
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(colBot.size() == 0)
            {
                JOptionPane.showMessageDialog(Karabli.this, "Set Ship");
            }
            JButton b;
            b = (JButton)e.getSource();
            index = Integer.parseInt(b.getActionCommand());
            JbuttonKor bk = jbc.get(index);
            flagBool();
            
        }
        
        private void proVictori(String s)
        {
            m = new MyVictoriFrame(s);
        }
        
        public int index()
        {
            return index;
        }
        
        public void flagBool()
        {
            if(state)
            {
                //proVictori(player);
                shot(index);
            }else if(!state)
            {
                //offAll();
                shotBot(trueInt());
            }
        }
        
        public void shot(int index)
        {
            if(colBot.get(index).getStateButton())
            {
                state = true;
                jbc.get(index).setBrokenShip();
                gamerBrokShip ++;
                if(gamerBrokShip == 20)
                {
                    proVictori(player);
                    gamerBrokShip = 0;
                }
                
            }else
            {
                state = false;
                jbc.get(index).setMiss();
                flagBool();
            }
        } 
        
        public void shotBot(int index)
        {
            if(jbcPanelTwo.get(index).getStateButton())
            {
                tempIndex = index;
                state = false;
                jbcPanelTwo.get(index).setBrokenShip();
        
                flagBool();
                botBrokShip ++;
                if(botBrokShip == 20)
                {
                    proVictori(bot);
                    botBrokShip = 0;
                }
                //shotBot(trueInt());
            }else
            {
                state = true;
                jbcPanelTwo.get(index).setMiss();
                //onAll();
            }
        }
        private void logicShotBot(int tempIndex)
        {
            if(! jbcPanelTwo.get(tempIndex + top).getStateButtonMiss() && (jbcPanelTwo.get(tempIndex + top).getStateButton()))
            {
                jbcPanelTwo.get(tempIndex + top).setBrokenShip();
                logicShotBot(tempIndex + top);
            }else
            {
                jbcPanelTwo.get(tempIndex + top).setMiss();
            }
        }

        private int trueInt()
        {
            random = r.nextInt(110) + 11;
            if (
                    random == 11 ||
                    random == 22 ||
                    random == 33 ||
                    random == 44 ||
                    random == 55 ||
                    random == 66 ||
                    random == 77 ||
                    random == 88 ||
                    random == 99 ||
                    random == 110 ||
                    jbcPanelTwo.get(random).getStateButtonMiss() ||
                    jbcPanelTwo.get(random).getStateButtonBrokenShip()
                )
            {
                trueInt();
            }
            return random;
        }
    }

    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() 
            {
                
                JFrame frame = new Karabli();
                //frame.setSize(700, 1000);
                frame.setTitle("BattleShip");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                
            }
        });
    }
    
}
