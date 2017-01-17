
package karabli;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import karabli.DialogButtonWindow.ActionBatton;
import karabli.ActionButtonPaneltwo.*;
import karabli.BoT.ActionEventBot;
import karabli.Karabli.ActionButton;

public class JbuttonKor 
{
    enum State {NONE, FIXED, SHIP, SPASE, BROKEN_SHIP, MISS, OFF, SEA};
    enum Direction { VERTICAL, HORIZONTAL };
    private JButton btn;
    private State state;
    public JbuttonKor top;
    public JbuttonKor bottom;
    public JbuttonKor left;
    public JbuttonKor right;
    private ImageIcon image;
    
    

    public JbuttonKor(String name, int index) 
    {
        state = State.NONE;
        btn = new JButton(name);
        btn.setActionCommand(Integer.toString(index));
    }
    
    public JbuttonKor(){};
    
    private void changeState(State s)
    {
        state = s;
        switch(s)
        {
            case NONE:
                btn.setEnabled(true);
                break;
                
            case FIXED:
                btn.setEnabled(false);
                //btn.setBackground(Color.LIGHT_GRAY);
                setbaclgraundColorButton(102,194,255);
                break;
                
            case SHIP:
                btn.setBackground(Color.WHITE);
                btn.setEnabled(false);
                btn.setIcon(new ImageIcon("ship-front-view.png"));
                break;
            
            case SPASE:
                btn.setEnabled(false);
                btn.setBackground(Color.DARK_GRAY);
                break;
              
            case BROKEN_SHIP:
                btn.setEnabled(false);
                //btn.setBackground(Color.GREEN);
                int b = btn.getWidth();
                int c = btn.getHeight();
                image = new ImageIcon("cross_48_2186.png");
                image.getImage().getScaledInstance(b, c, java.awt.Image.SCALE_SMOOTH);
                btn.setIcon(image);
                System.out.println(c + "------------" + b);
                break;
              
            case MISS:
                btn.setEnabled(false);
                
                //btn.setBackground(Color.YELLOW);
                btn.setIcon(new ImageIcon("icon.png"));
                break;    
                
            case OFF:
                btn.setEnabled(false);
                //setbaclgraundColorButton();
                break;
                
            case SEA:
                setbaclgraundColorButton(51, 255, 153);
                btn.setIcon(new ImageIcon("waves.png"));
        } 
    }
    
    public void addButPanel(JPanel p)
    {
        p.add(btn);
    }
    
    public void addEvent(ActionBatton ab)
    {
        btn.addActionListener(ab);
    }
    
    public void addEvent(ActionButtonPaneltwo abp)
    {
        btn.addActionListener(abp);
    }
    
    public void addEventPanelOne(ActionButton ab)
    {
        btn.addActionListener(ab);
    }
    
    public void addEventBotPanel(ActionEventBot apb)
    {
        btn.addActionListener(apb);
    }
    public void setEnaBut()
    {
        changeState(State.FIXED);
    }
    
    public void setSeaButtonEn()
    {
        changeState(State.SEA);
        btn.setEnabled(false);
    }
    
    public void setEnaButOff()
    {
        changeState(State.OFF);
    }
    
    public void setTop(JbuttonKor top)
    {
        this.top = top;
    }
    public void setBottom(JbuttonKor bottom)
    {
        this.bottom = bottom;
    }
    public void setLeft(JbuttonKor left)
    {
        this.left = left;
    }
    public void setRight(JbuttonKor right)
    {
        this.right = right;
    }
    
    public State getState()
    {
        return state;
    }
    
    public boolean isFixed()
    {
        return state == State.FIXED;
    }
    
    public void setShip()
    {
        changeState(State.SHIP);
    }
    
    public void setSea()
    {
        changeState(State.SEA);
    }
    
    public void setMiss()
    {
        changeState(State.MISS);
    }
    
    public void setBrokenShip()
    {
        changeState(State.BROKEN_SHIP);
    }
    
    public void setOff()
    {
        changeState(State.OFF);
    }
    
    public void setFixet()
    {
        changeState(State.FIXED);
    }
    
    public void setSpase()
    {
        changeState(State.SPASE);
    }
    
    public void setNone()
    {
        changeState(State.NONE);
    }
    
    public boolean getStateButton()
    {
        return state ==  State.SHIP;
    }
    
    public boolean getStateButtonSpase()
    {
        return state ==  State.SPASE;
    }
    
    public boolean getStateButtonFixed()
    {
        return state ==  State.FIXED;
    }
    
    public boolean getStateButtonOff()
    {
        return state ==  State.OFF;
    }
    
    public boolean getStateButtonMiss()
    {
        return state ==  State.MISS;
    }
    
    public boolean getStateButtonBrokenShip()
    {
        return state ==  State.BROKEN_SHIP;
    }
    
    public void setbaclgraundColorButton(int r, int g, int b)
    {
        btn.setBackground(new Color(r,g,b));
    }

    public void off()
    {
        if(state == State.NONE)
        {
            changeState(State.OFF);
        }
    }
    
    public void on()
    {
        if(state != State.SHIP && state != State.FIXED && state != State.SPASE)
        {
            changeState(State.NONE);
        }
    }
    
//    private void setNone (JbuttonKor b, Direction d) {
//        JbuttonKor f[] = new JbuttonKor[2];
//        if (b.left != null && b.getState() != State.SPASE) {
//            if (b.getState() == State.SHIP) {
//                switch(d) {
//                    case VERTICAL:
//                        f[0] = b.left;
//                        f[1] = b.right;
//                        break;
//                    case HORIZONTAL:
//                        f[0] = b.top;
//                        f[1] = b.bottom;
//                    break;
//                }
//                
//                for (int i = 0; i < f.length; i++) 
//                {
//                    if (f[i].left != null && f[i].getState() != State.SPASE)
//                    {
//                        f[i].changeState(State.OFF);
//                    }
//                }
//            } else {
//                b.changeState(State.NONE);
//            }
//        }
//    }
    
    public void onFriends()
    {
//        setNone(top, Direction.VERTICAL);
//        setNone(left, Direction.HORIZONTAL);
//        setNone(right, Direction.HORIZONTAL);
//        setNone(bottom, Direction.VERTICAL);
        
        if(top != null && top.getState() != State.SHIP && top.getState() != State.SPASE)
        {
            top.changeState(State.NONE);
        }
        
        if(bottom != null && bottom.getState() != State.SHIP && bottom.getState() != State.SPASE)
        {
            bottom.changeState(State.NONE);
        }
        
        if(left != null && left.getState() != State.SHIP && left.getState() != State.SPASE)
        {
            left.changeState(State.NONE);
        }
        
        if(right != null && right.getState() != State.SHIP && right.getState() != State.SPASE)
        {
            right.changeState(State.NONE);
        }
    }
    public void offVerOrGor()
    {
        
        if(top != null && top.getState() == State.SHIP || bottom != null && bottom.getState() == State.SHIP) 
            //&& top.getState() != State.FIXED || bottom.getState() != State.FIXED)
        {
            if(bottom != null && bottom.getState() == State.SHIP)
            {
                if(bottom.left != null)bottom.left.setEnaBut();
                if(bottom.right != null)bottom.right.setEnaBut();
            }else if(top != null && top.getState() == State.SHIP)
            {
                if(top.left != null)top.left.setEnaBut();
                if(top.right != null)top.right.setEnaBut();
            }
            if(left != null)left.setEnaBut();
            if(right != null)right.setEnaBut();
        }else if(left != null && left.getState() == State.SHIP || right != null && right.getState() == State.SHIP) 
            //&& left.getState() != State.FIXED || right.getState() != State.FIXED)
        {
            if(right != null && right.getState() == State.SHIP)
            {
                if(right.top != null)right.top.setEnaBut();
                if(right.bottom != null)right.bottom.setEnaBut();
            }else if(left != null && left.getState() == State.SHIP)
            {
                if(left.top != null)left.top.setEnaBut();
                if(left.bottom != null)left.bottom.setEnaBut();
            }
            if(top != null)top.setEnaBut();
            if(bottom != null)bottom.setEnaBut();
        }
    }
    
    
    public void onSpaceKorabl()
    {
        if(JbuttonKor.this.getState() == State.SHIP)
        {
            if(top != null && top.getState() != State.SHIP)
            {
                if(top != null)top.setSpase();
                if(top.left != null)top.left.setSpase();
                if(top.right != null)top.right.setSpase();
            }
            if(bottom != null && bottom.getState() != State.SHIP)
            {
                if(bottom != null)bottom.setSpase();
                if(bottom.left != null)bottom.left.setSpase();
                if(bottom.right != null)bottom.right.setSpase();
            }
            if(left != null && left.getState() != State.SHIP)
            {
                if(left != null)left.setSpase();
                if(left.top != null)left.top.setSpase();
                if(left.bottom != null)left.bottom.setSpase();
            }
            if(right != null && right.getState() != State.SHIP)
            {
                if(right != null)right.setSpase();
                if(right.top != null)right.top.setSpase();
                if(right.bottom != null)right.bottom.setSpase();
            }
        }
    }
    
    public int proverkaFourShip()
    {
        if((top != null && top.getState() != State.FIXED && 
                top.getState() != State.SHIP && top.getState() != State.SPASE) &&
           (top.top != null && top.top.getState() != State.FIXED && 
                top.top.getState() != State.SHIP && top.top.getState() != State.SPASE) && 
           (top.top.top != null && top.top.top.getState() != State.FIXED && 
                top.top.top.getState() != State.SHIP && top.top.top.getState() != State.SPASE) &&
           (top.top.top.top != null && top.top.top.top.getState() != State.FIXED && 
                top.top.top.top.getState() != State.SHIP && top.top.top.top.getState() != State.SPASE))
        {
            return 1;
        }else if((bottom != null && bottom.getState() != State.FIXED &&
                    bottom.getState() != State.SHIP && bottom.getState() != State.SPASE) && 
                 (bottom.bottom != null && bottom.bottom.getState() != State.FIXED &&
                    bottom.bottom.getState() != State.SHIP && bottom.bottom.getState() != State.SPASE) && 
                 (bottom.bottom.bottom != null && bottom.bottom.bottom.getState() != State.FIXED &&
                    bottom.bottom.bottom.getState() != State.SHIP && bottom.bottom.bottom.getState() != State.SPASE) && 
                 (bottom.bottom.bottom.bottom != null && bottom.bottom.bottom.bottom.getState() != State.FIXED &&
                    bottom.bottom.bottom.bottom.getState() != State.SHIP && bottom.bottom.bottom.bottom.getState() != State.SPASE))
        {
            return 2;
        }else if((right != null && right.getState() != State.FIXED && 
                    right.getState() != State.SHIP && right.getState() != State.SPASE) && 
                 (right.right != null && right.right.getState() != State.FIXED && 
                    right.right.getState() != State.SHIP && right.right.getState() != State.SPASE) && 
                 (right.right.right != null && right.right.right.getState() != State.FIXED && 
                    right.right.right.getState() != State.SHIP && right.right.right.getState() != State.SPASE) && 
                 (right.right.right.right != null && right.right.right.right.getState() != State.FIXED && 
                    right.right.right.right.getState() != State.SHIP && right.right.right.right.getState() != State.SPASE))
        {
            return 3;
        }else if((left != null && left.getState() != State.FIXED && 
                    left.getState() != State.SHIP && left.getState() != State.SPASE) && 
                 (left.left != null && left.left.getState() != State.FIXED && 
                    left.left.getState() != State.SHIP && left.left.getState() != State.SPASE) && 
                 (left.left.left != null && left.left.left.getState() != State.FIXED && 
                    left.left.left.getState() != State.SHIP && left.left.left.getState() != State.SPASE) && 
                 (left.left.left.left != null && left.left.left.left.getState() != State.FIXED && 
                    left.left.left.left.getState() != State.SHIP && left.left.left.left.getState() != State.SPASE))
        {
            return 4;
        }
        
        return 0;
    }
    
    public int proverkaThreeShip()
    {
        if((top != null && top.getState() != State.FIXED && 
                top.getState() != State.SHIP && top.getState() != State.SPASE) && 
           (top.top != null && top.top.getState() != State.FIXED && 
                top.top.getState() != State.SHIP && top.top.getState() != State.SPASE) && 
           (top.top.top != null && top.top.top.getState() != State.FIXED && 
                top.top.top.getState() != State.SHIP && top.top.top.getState() != State.SPASE))
        {
            return 1;
        }else if((bottom != null && bottom.getState() != State.FIXED &&
                    bottom.getState() != State.SHIP && bottom.getState() != State.SPASE) && 
                 (bottom.bottom != null && bottom.bottom.getState() != State.FIXED &&
                    bottom.bottom.getState() != State.SHIP && bottom.bottom.getState() != State.SPASE) && 
                 (bottom.bottom.bottom != null && bottom.bottom.bottom.getState() != State.FIXED &&
                    bottom.bottom.bottom.getState() != State.SHIP && bottom.bottom.bottom.getState() != State.SPASE))
        {
            return 2;
        }else if((right != null && right.getState() != State.FIXED && 
                    right.getState() != State.SHIP && right.getState() != State.SPASE) && 
                 (right.right != null && right.right.getState() != State.FIXED && 
                    right.right.getState() != State.SHIP && right.right.getState() != State.SPASE) && 
                 (right.right.right != null && right.right.right.getState() != State.FIXED && 
                    right.right.right.getState() != State.SHIP && right.right.right.getState() != State.SPASE))
        {
            return 3;
        }else if((left != null && left.getState() != State.FIXED && 
                    left.getState() != State.SHIP && left.getState() != State.SPASE) && 
                 (left.left != null && left.left.getState() != State.FIXED && 
                    left.left.getState() != State.SHIP && left.left.getState() != State.SPASE) && 
                 (left.left.left != null && left.left.left.getState() != State.FIXED && 
                    left.left.left.getState() != State.SHIP && left.left.left.getState() != State.SPASE))
        {
            return 4;
        }
        
        return 0;
    }
    
    public int proverkaTwoShip()
    {
        if((top != null && top.getState() != State.FIXED && 
                top.getState() != State.SHIP && top.getState() != State.SPASE) && 
           (top.top != null && top.top.getState() != State.FIXED && 
                top.top.getState() != State.SHIP && top.top.getState() != State.SPASE))
        {
            return 1;
        }else if((bottom != null && bottom.getState() != State.FIXED &&
                    bottom.getState() != State.SHIP && bottom.getState() != State.SPASE) && 
                 (bottom.bottom != null && bottom.bottom.getState() != State.FIXED &&
                    bottom.bottom.getState() != State.SHIP && bottom.bottom.getState() != State.SPASE))
        {
            return 2;
        }else if((right != null && right.getState() != State.FIXED && 
                    right.getState() != State.SHIP && right.getState() != State.SPASE) && 
                 (right.right != null && right.right.getState() != State.FIXED && 
                    right.right.getState() != State.SHIP && right.right.getState() != State.SPASE))
        {
            return 3;
        }else if((left != null && left.getState() != State.FIXED && 
                    left.getState() != State.SHIP && left.getState() != State.SPASE) && 
                 (left.left != null && left.left.getState() != State.FIXED && 
                    left.left.getState() != State.SHIP && left.left.getState() != State.SPASE))
        {
            return 4;
        }
        
        return 0;
    }
    
    public int proverkaOneShip()
    {
        if((top != null && top.getState() != State.FIXED && 
            top.getState() != State.SHIP && top.getState() != State.SPASE))
        {
            return 1;
        }else if((bottom != null && bottom.getState() != State.FIXED &&
                  bottom.getState() != State.SHIP && bottom.getState() != State.SPASE))
        {
            return 2;
        }else if((right != null && right.getState() != State.FIXED && 
                  right.getState() != State.SHIP && right.getState() != State.SPASE))
        {
            return 3;
        }else if((left != null && left.getState() != State.FIXED && 
                  left.getState() != State.SHIP && left.getState() != State.SPASE))
        {
            return 4;
        }
        
        return 0;
    }
    
    public boolean CheckOneShipBot()
    {
        if((top != null && top.getState() != State.BROKEN_SHIP && top.getState() != State.SHIP) &&
                (bottom != null && bottom.getState() != State.BROKEN_SHIP && bottom.getState() != State.SHIP) &&
                (right != null && right.getState() != State.BROKEN_SHIP && right.getState() != State.SHIP) &&
                (left != null && left.getState() != State.BROKEN_SHIP && left.getState() != State.SHIP))
        {
            return true;
        }
        
        return false;
    }
    
    
}
