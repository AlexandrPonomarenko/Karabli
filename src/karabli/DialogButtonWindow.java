package karabli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DialogButtonWindow extends JDialog
{
    private JLabel label;
    private JPanel panel, panel1, panel2;
    private JButton button;
    private ActionBatton addButtonListener;
    private String alf = "A B S D E F G H I J K L";
    private String alfcount = "1 2 3 4 5 6 7 8 9 10";
    private String[] bukva;
    private String[] count;
    private JTextField fild;
    private List<JbuttonKor> jbc;
    private List<JButton> btn;
    private int[] state;
    
    
    private int shipFour[] = new int[4];
    private int shipThree[] = new int[6];
    private int shipTwo[] = new int[8];
    private int shipOne[] = new int[4];

    private int[] tipKorablia = new int[4];
    private int[] kolKorTipa = new int[4];
    private int[] kolSekkor = new int[4];
    private int countOfCell = 0;
    
    private int typeOfShip = 4;
    private int maxCell = 0;   // количество ячеек в корабле
    private int maxShips = 0;   // количество кораблей которых нужно установить
    private int cirrentIntShip = 0;   // количество установленных ячеек корабля
    private JFrame frame;
    public DialogButtonWindow(JFrame frame) 
    {
        super(frame, "SetKarabli", true);
        this.frame = frame;
        jbc = new ArrayList<>();
        btn = new ArrayList<>();
        bukva = alf.split(" ");
        count = alfcount.split(" ");
        label = new JLabel("Set Korabl");
        
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(11,11));
        setButton(panel1);
        panel.add(panel1);
        
        
        panel2 = new JPanel();
        //panel2.setLayout(new GridLayout(2,2));
        panel2.setLayout(new BorderLayout());
        button = new JButton("OK");
        fild = new JTextField("Выбкрите 1 - четырехпалый корабль,2 - трехпалых, 3 двухпалых, 4 однопалых");
        fild.setPreferredSize(new Dimension(400,100));
        panel2.add(label, BorderLayout.NORTH);
        panel2.add(fild, BorderLayout.CENTER);
        panel2.add(button,BorderLayout.SOUTH);
        button.setPreferredSize(new Dimension(50, 50));
        panel.add(panel2);
        
        
        addButtonListener = new ActionBatton();
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                setVisible(false);
//                new Karabli().reception(jbc);
                //new Karabli().receptionInt(state);
                  
                  DialogButtonWindow.this.dispose();
            }
        });
        panel.setPreferredSize(new Dimension(1300, 650));
        add(panel,BorderLayout.CENTER);
        pack();
        
    }
    public int[] getArray() {
        return state;
    }
    private void addButton(String name,JPanel p, int index)
    {
        JbuttonKor button1 = new JbuttonKor(name, index);
        button1.addEvent(new ActionBatton());
        jbc.add(button1);
        button1.addButPanel(p);
    }
    
    
    private void setButton(JPanel p)
    {   int e = 11;
        int c = 0;
        int a = 0;
        for(int i = 0; i < 121; i++)
        {
            if(i == 0)
            {
                addButton("*", p, i);
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
            }else{addButton("", p, i);}
        }
        
        for(int i = 0;i < jbc.size(); i++)
        {
            if(!jbc.get(i).isFixed())
            {
                if(!jbc.get(i - 11).isFixed())
                {
                    jbc.get(i).setTop(jbc.get(i - 11));
                }
                
                if(i + 11 < jbc.size() && !jbc.get(i + 11).isFixed())
                {
                    jbc.get(i).setBottom(jbc.get(i + 11));
                }
                
                if(!jbc.get(i - 1).isFixed())
                {
                    jbc.get(i).setLeft(jbc.get(i - 1));
                }
                
                if(i + 1 < jbc.size() && !jbc.get(i + 1).isFixed())
                {
                    jbc.get(i).setRight(jbc.get(i + 1));
                }
            }
        }
    }
    
    public class ActionBatton implements ActionListener
    {
       
        public ActionBatton() 
        {
//            for(int i = 1;kolKorTipa.length >= i;i++)
//            {
//                kolKorTipa[i - 1] = kolKorTipa.length - i + 1;
//                kolSekkor[i - 1] = i;
//                tipKorablia[i - 1] = i;
//            }
//            setNewShip("4");
            setNewShop();
            state = new int[jbc.size()];
        }

        private void setNewShop()
        {
            switch(typeOfShip)
            {
                case 4:
                    maxCell = 4;
                    maxShips = 1;
                    break;
                case 3:
                    maxCell = 3;
                    maxShips = 2;
                    break;
                case 2:
                    maxCell = 2;
                    maxShips = 3;
                    break;
                case 1:
                    maxCell = 1;
                    maxShips = 4;
                    break;
            }
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) 
        {
//    private int typeOfShip = 4;
//    private int maxCell = 0;   // количество ячеек в корабле
//    private int maxShips = 0;   // количество кораблей которых нужно установить
//    private int cirrentIntShip = 0;   // количество установленных ячеек корабля
            
                JButton b;
                b = (JButton) e.getSource();
                int index = Integer.parseInt(b.getActionCommand());
                JbuttonKor bk = jbc.get(index);
                
                if(cirrentIntShip == 0){offAll();}
                bk.setShip();
                bk.onFriends();
                bk.offVerOrGor();
                
                
                cirrentIntShip++;
                
                if (cirrentIntShip == maxCell) 
                {
                    onAll();
                    for(int i = 0;i < jbc.size();i++)
                    {   
                        jbc.get(i).onSpaceKorabl();
                    }
                    
                    maxShips--;
                    cirrentIntShip = 0;
                    if (maxShips == 0) 
                    {
                        typeOfShip--;
                        if(typeOfShip < 1 && maxShips == 0)
                        {
                            offAll();
                            setStateIntShip();
                        }
                        setNewShop();
                    }
                    //if(typeOfShip == 1 && maxShips == 0)offAll();
                }
                
                
//                if(cirrentIntShip == 4)
//                {
//                    onAll();
//                    
//                    for(int i = 0;i < jbc.size();i++)
//                    {
//                        
//                        jbc.get(i).onSpaceKorabl();
//                    }
//                    
//                    cirrentIntShip = 0;
//                }
                
                //showLine(index);
//                setLocCoordination(index);
//                countOfCell += 1;
//                System.out.print("-->" + maxCell + "<---");
//                if(countOfCell == maxCell -  1)
//                {
//                    countOfCell = 0;
//                    maxShips--;
//                }
//                
//                if(maxShips == 0)
//                {
//                    cirrentIntShip--;
//                    setNewShip(Integer.toString(cirrentIntShip));
//                }
                
        }
        private void setStateIntShip()
        {
            for(int i = 0;i < jbc.size();i++)
            {
                if(jbc.get(i).getStateButton())
                {
                    state[i] = 1;
                }else
                {
                    state[i] = 0;
                }
            }
        }
        private void offAll()
        {
            for(int i = 0; i < jbc.size(); i++)
            {
                jbc.get(i).off();
            }
        }
        
        private void onAll()
        {
            for(int i = 0; i < jbc.size(); i++)
            {
                jbc.get(i).on();
            }
        }
        
        private void setLocCoordination(String i)
        {
            int index = Integer.parseInt(i);
            if(maxCell == 4)
            {
                shipFour[countOfCell] = index;
            }else if(maxCell == 3)
            {
                shipThree[countOfCell] = index;
            }else if(maxCell == 2)
            {
                shipTwo[countOfCell] = index;
            }else if(maxCell == 1)
            {
                shipOne[countOfCell] = index;
            }
        }
        
        private void setNewShip(String s)
        {
            if("4".equals(s))
            {
                maxShips = 1;
                maxCell = 4;
            }else if("3".equals(s))
            {
                maxShips = 2;
                maxCell = 3;
            }else if("2".equals(s))
            {
                maxShips = 3;
                maxCell = 2;
            }else if("1".equals(s))
            {
                maxShips = 1;
                maxCell = 4;
                //if(maxCell == 4)offAll();
            }
        }
        
//        private void showLine(String str)
//        {
//            int index = Integer.parseInt(str);
//            
//            for(int i = 0;i < jbc.size(); i++)
//            {
//                jbc.get(i).setEnabled(false);
//            }
//            System.out.print(countOfCell);
//            if(countOfCell == 0)
//            {
//                if(index + 1 < index / 11 * 11 + 10)
//                {
//                    jbc.get(index + 1).setEnabled(true);
//                }
//                if(index - 1 >= index / 11 * 11 + 1)
//                {
//                    jbc.get(index - 1).setEnabled(true);
//                }
//                if(index + 11 <= 121)
//                {
//                    jbc.get(index + 11).setEnabled(true);
//                }
//                if(index - 11 > 11)
//                {
//                    jbc.get(index - 11).setEnabled(true);
//                }
//            }else
//            {
//                int i = getFirstCell();
//                if(i == index + countOfCell * 11)
//                {
//                    System.out.print("top");
//                    if(index - 11 > 11)
//                    {
//                        jbc.get(index - 11).setEnabled(true);
//                    }
//                    if(i + 11 <= 121)
//                    {
//                        jbc.get(i + 11).setEnabled(true);
//                    }
//                }else if(i == index - countOfCell * 11)
//                {
//                    System.out.print("bottom");
//                    if(i - 11 > 11)
//                    {
//                        jbc.get(i - 11).setEnabled(true);
//                    }
//                    if(index + 11 <= 121)
//                    {
//                        jbc.get(index + 11).setEnabled(true);
//                    }
//                }else if(i == index + countOfCell)
//                {
//                    System.out.print("right");
//                    if(index + 1 < index / 11 * 11 + 10)
//                    {
//                        jbc.get(index + 1).setEnabled(true);
//                    }
//                    if(i - 1 >= i / 11 * 11 + 1)
//                    {
//                        jbc.get(i - 1).setEnabled(true);
//                    }
//                }else if(i == index - countOfCell)
//                {
//                    System.out.print("left");
//                    if(i + 1 < i / 11 * 11 + 10)
//                    {
//                        jbc.get(i + 1).setEnabled(true);
//                    }
//                    if(index - 1 >= index / 11 * 11 + 1)
//                    {
//                        jbc.get(index - 1).setEnabled(true);
//                    }
//                }
//            }
//            
//            
//        }
        
//        private void showLine2(String str)
//        {
//            int index = Integer.parseInt(str);
//            int a = index;
//            int stroka = index / 10;
//            int start = stroka * 10 + stroka + 1;
//            for(int i = 0;i < jbc.size(); i++)
//            {
//                jbc.get(i).setEnabled(false);
//            }
//            
//            jbc.get(index + 1).setEnabled(true);
//            jbc.get(index - 1).setEnabled(true);
//            jbc.get(index + 11).setEnabled(true);
//            jbc.get(index - 11).setEnabled(true);
////            for(int i = start;i < start + 10; i++)
////            {
////                jbc.get(i).setEnabled(true);
////            }
////            while(a > 10){a -=11;}
////            
////            for(int i = a + 11; i < jbc.size(); i += 11)
////            {
////                jbc.get(i).setEnabled(true);
////            }
//        }
    
//        private void copyColl()
//        {
//            int j = 0;
//            int c = 11;
//            for(int i = 0;i < jbc.size();i++)
//            {
//                if(i > 11 && i != c)
//                {  
//                    btn.add(jbc.get(i));
//                    c += 11;
//                }
//                
//            }
//            System.out.println(btn.size());
//        }
        private int getFirstCell()
        {
            if(maxCell == 4)
            {
                 return shipFour[0] ;
            }else if(maxCell == 3)
            {
                return shipThree[0] ;
            }else
            {
                return shipTwo[0];
            }
            
        }
    }
}
