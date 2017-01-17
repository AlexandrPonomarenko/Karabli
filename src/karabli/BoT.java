
package karabli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoT extends JDialog
{
    JPanel panel, panelTwo, panelThree;
    private List<JbuttonKor> jbc;
    private String alf = "A B S D E F G H I J K L";
    private String alfcount = "1 2 3 4 5 6 7 8 9 10";
    private String[] count;
    private String[] bukva;
    private JButton btn;
    private Random random;
    int napravlenie = 0;
    int startUpPount = 0;
    private int[] four;
    private int[] three;
    private int[] two;
    
    public BoT()
    {
        four = new int[4];
        three = new int[3];
        two = new int[2];
        random = new Random();
        jbc = new ArrayList<>();
        bukva = alf.split(" ");
        count = alfcount.split(" ");
        
        panelTwo = new JPanel();
        panelThree = new JPanel();
        panel = new JPanel();
        
        panel.setLayout(new GridLayout(1,1));
        
        panelTwo.setLayout(new GridLayout(11, 11));
        setButton(panelTwo);
        panel.add(panelTwo);
        
        panelThree.setLayout(new BorderLayout());
        btn = new JButton("OK");
        panelThree.add(btn, BorderLayout.SOUTH);
        panel.add(panelThree);
        
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                setVisible(false);
//            }
//        });
        panel.setPreferredSize(new Dimension(1300, 700));
        add(panel, BorderLayout.CENTER);
        setShips();
        pack();
    }
    
    public BoT(JFrame frame)
    {
        super(frame, "TestBot", true);
        four = new int[4];
        three = new int[3];
        two = new int[2];
        random = new Random();
        jbc = new ArrayList<>();
        bukva = alf.split(" ");
        count = alfcount.split(" ");
        
        panelTwo = new JPanel();
        panelThree = new JPanel();
        panel = new JPanel();
        
        panel.setLayout(new GridLayout(1,1));
        
        panelTwo.setLayout(new GridLayout(11, 11));
        setButton(panelTwo);
        panel.add(panelTwo);
        
        panelThree.setLayout(new BorderLayout());
        btn = new JButton("OK");
        panelThree.add(btn, BorderLayout.SOUTH);
        panel.add(panelThree);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                setVisible(false);
                BoT.this.dispose();
                BoT.this.dispose();
            }
        });
        panel.setPreferredSize(new Dimension(1300, 700));
        add(panel, BorderLayout.CENTER);
        setShips();
        pack();
    }
    
    
    public List<JbuttonKor> getArrayStateBot()
    {
        return jbc;
    }
    
    public boolean getStateBotButton()
    {
        return true;
    }
    
    private void addButton(String name, JPanel p, int index)
    {
        JbuttonKor button1 = new JbuttonKor(name, index);
        button1.addEventBotPanel(new ActionEventBot());
        jbc.add(button1);
        button1.addButPanel(p);
    }
    
    
    private void proverkaChisla()
        {
            startUpPount = random.nextInt(108) + 12;
            System.out.println("-" + startUpPount + "-");
            if(jbc.get(startUpPount).getStateButton() || jbc.get(startUpPount).getStateButtonFixed() || jbc.get(startUpPount).getStateButtonSpase())
            {
                proverkaChisla();
            }
        }
        
        private void proverkaNapravlenia(int n)
        {
            if(n == 4)
            {
                napravlenie = jbc.get(startUpPount).proverkaFourShip();
                if(napravlenie == 0)
                {
                   proverkaNapravlenia(n);
                }
            }else if(n == 3)
            {
                napravlenie = jbc.get(startUpPount).proverkaThreeShip();
                if(napravlenie == 0)
                {
                   proverkaNapravlenia(n);
                }
            }else if(n == 2)
            {
                napravlenie = jbc.get(startUpPount).proverkaTwoShip();
                if(napravlenie == 0)
                {
                   proverkaNapravlenia(n);
                }
            }else if(n == 1)
            {
                napravlenie = jbc.get(startUpPount).proverkaOneShip();
                if(napravlenie == 0)
                {
                   proverkaNapravlenia(n);
                }
            }
        }
        
    private void setShips()
    {
        otrisovkakarablia(four);
        
        for(int i = 0;i < 2;i++)
        {
            otrisovkakarablia(three);
        }
        
        for(int i = 0;i < 3;i++)
        {
            otrisovkakarablia(two);
        }
        
        for(int i = 0;i < 4;i++)
        {
            otrisovkakarablia();
        }
    }
    
    private void otrisovkakarablia(int[] mas)
    {
        proverkaChisla();

        proverkaNapravlenia(mas.length);
        
        zapolnitMas(mas, napravlenie);
        for(int i = 0;i < mas.length;i++)
        {
            jbc.get(mas[i]).setShip();
            jbc.get(mas[i]).onSpaceKorabl();
        }
    }
    
    private void otrisovkakarablia()
    {
        proverkaChisla();
        jbc.get(startUpPount).setShip();
        jbc.get(startUpPount).onSpaceKorabl();
    }
    private void zapolnitMas( int[] mas, int n)
        {
            if(n == 1)
            {
                mas[0] = startUpPount;
                for(int i = 1;i < mas.length;i++)
                {
                    mas[i] = mas[i - 1] -11; 
                }
            }else if(n == 2)
            {
                mas[0] = startUpPount;
                for(int i = 1;i < mas.length;i++)
                {
                    mas[i] = mas[i - 1] +11;
                }
            }else if(n == 3)
            {
                mas[0] = startUpPount;
                for(int i = 1;i < mas.length;i++)
                {
                    mas[i] = mas[i - 1] +1;
                }
            }else if(n == 4)
            {
                mas[0] = startUpPount;
                for(int i = 1;i < mas.length;i++)
                {
                    mas[i] = mas[i - 1] -1;
                }
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
            }else{addButton(i + "", p, i);}
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
    
//    private int pologitelnoe()
//    {
//        return random.nextInt(5) + 1;
//    }
//    
//    private int otrizatelnoe()
//    {
//        return random.nextInt(-5) - 1;
//    }
//    
//    private int ostatokOrNo()
//    {
//        return random.nextInt(8) + 1;
//    }
//    
//    
//    
//    private void setFourShip()
//    {
//        
//    }
    
    public class ActionEventBot implements ActionListener
    {
        
        public ActionEventBot()
        {
//            proverkaChisla();
//            
//            proverkaNapravlenia();
//            
//            zapolnitMas(four, napravlenie);
//            for(int i = 0;i < four.length;i++)
//            {
//                jbc.get(four[i]).setShip();
//                jbc.get(four[i]).onSpaceKorabl();
//            }
        }
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
//            startUpPount = random.nextInt(210)+ 12;
//            while(true)
//            {
//                if(proverkaChisla(startUpPount)){break;}
//            }
//            napravlenie = jbc.get(startUpPount).proverkaFourShip();
//            zapolnitMas(four, napravlenie);
//            for(int i = 0;i < four.length;i++)
//            {
//                jbc.get(four[i]).setShip();
//                jbc.get(four[i]).onFriends();
//                jbc.get(four[i]).offVerOrGor();
//            }
            
        }
            
    }
}
