/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.BattleFieldFighting;

/**
 *
 * @author THANH
 */
public class PnXSpeed extends JPanel{
    private JLabel lbText;
    private JComboBox cbXSpeed;
    
    public PnXSpeed(){
        this.lbText = new JLabel();
        
        String items[] = {"x1","x2","x5","x10","x15","x30","x60"};
        cbXSpeed = new JComboBox(items);
        addControl();
        addEvents();
    }
    
    private void addControl(){
        this.setBackground(new Color(251,232,193));
        
        lbText.setText("Tăng tốc độ");
        lbText.setBounds(10, 10, 100, 20);
        
        cbXSpeed.setBounds(120, 10, 50, 20);
        
        this.add(lbText);
        this.add(cbXSpeed);
    }
    
    private void addEvents(){
        cbXSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = cbXSpeed.getSelectedIndex();
                System.out.println("chon " + pos);
                switch(pos){
                    case 0:
                        BattleFieldFighting.xSpeed = 1;
                        break;
                    case 1:
                        BattleFieldFighting.xSpeed = 2;
                        break;
                    case 2:
                        BattleFieldFighting.xSpeed = 5;
                        break;    
                    case 3:
                        BattleFieldFighting.xSpeed = 10;
                        break;
                    case 4:
                        BattleFieldFighting.xSpeed = 15;
                        break;
                    case 5:
                        BattleFieldFighting.xSpeed = 30;
                        break;
                    case 6:
                        BattleFieldFighting.xSpeed = 60;
                        break;
                }
            }
        });
    }
}
