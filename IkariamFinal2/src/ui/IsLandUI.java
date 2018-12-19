package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.BattleFieldFighting;

import model.House;

public class IsLandUI extends JFrame {

    public boolean isFullScreen = false;

    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btnWaveAttack;
    JTextArea txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17;
    JLabel lblIsLand;
    public static JButton currentButton;
    public static House currentHouse;
    public static JTextArea currentTextField;
    public HouseInfoUI houseInfoUI;
    public static House[] house;
    public static House myHouse;
    public static BattleFieldFightingUI bffUI;

    public IsLandUI(String title) {
        super(title);
        house = new House[18];
        currentHouse = new House();
        currentButton = new JButton();
        for (int i = 1; i < 18; i++) {
            house[i] = new House();
            house[i].setId(i);
        }

        houseInfoUI = new HouseInfoUI();
        addControls();
        addEvents();
    }

    public void addControls() {
        Container con = getContentPane();

        JPanel pnMain = new JPanel();
        pnMain.setLayout(null);
        con.add(pnMain);

        JMenuBar menuBar = new JMenuBar();

        JMenu xem = new JMenu("Xem");

        JMenuItem itemXemTranDauDangDienRa = new JMenuItem("Xem trận đấu");
        itemXemTranDauDangDienRa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.currentHouse.getBattleFieldFighting());
                IsLandUI.bffUI.showWindow();
            }
        });

        JMenuItem itemXemThoiGian = new JMenuItem("Xem thời gian");
        itemXemThoiGian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myHouse != null) {
//                    new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy()).setVisible(true);
                    WaveAttackUI.waveAttackUI.setVisible(true);
                } 
            }
        });

        xem.add(itemXemTranDauDangDienRa);
        xem.add(itemXemThoiGian);

        JMenu sua = new JMenu("Sửa");

        JMenuItem itemSuaNhaMinh = new JMenuItem("Sửa nhà mình");
        itemSuaNhaMinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 
            }
        });

        JMenuItem itemSuaNhaDich = new JMenuItem("Sửa nhà địch");
        itemSuaNhaDich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 
            }
        });

        JMenuItem itemSuaNhaDongMinh = new JMenuItem("Sửa nhà đồng minh");
        itemSuaNhaDongMinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 
            }
        });

        sua.add(itemSuaNhaMinh);
        sua.add(itemSuaNhaDich);
        sua.add(itemSuaNhaDongMinh);

        JMenu chinhTocDo = new JMenu("Chỉnh tốc độ");

        JMenuItem itemChinhTocDox1 = new JMenuItem("tăng tốc x1");
        itemChinhTocDox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFieldFighting.xSpeed = 1; 
            }
        });

        JMenuItem itemChinhTocDox2 = new JMenuItem("tăng tốc x2");
        itemChinhTocDox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFieldFighting.xSpeed = 2;
            }
        });
        
        
        
        JMenuItem itemChinhTocDox5 = new JMenuItem("tăng tốc x5");
        itemChinhTocDox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFieldFighting.xSpeed = 5; 
            }
        });
        
        JMenuItem itemChinhTocDox10 = new JMenuItem("tăng tốc x10");
        itemChinhTocDox10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFieldFighting.xSpeed = 10; 
            }
        });
        
        JMenuItem itemChinhTocDox15 = new JMenuItem("tăng tốc x15");
        itemChinhTocDox15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFieldFighting.xSpeed = 15; 
            }
        });
        
        JMenuItem itemChinhTocDox30 = new JMenuItem("tăng tốc x30");
        itemChinhTocDox30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFieldFighting.xSpeed = 30; 
            }
        });
        
        JMenuItem itemChinhTocDox60 = new JMenuItem("tăng tốc x60");
        itemChinhTocDox60.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFieldFighting.xSpeed = 60; 
            }
        });

        chinhTocDo.add(itemChinhTocDox1);
        chinhTocDo.add(itemChinhTocDox2);
        chinhTocDo.add(itemChinhTocDox5);
        chinhTocDo.add(itemChinhTocDox10);
        chinhTocDo.add(itemChinhTocDox15);
        chinhTocDo.add(itemChinhTocDox30);
        chinhTocDo.add(itemChinhTocDox60);

        menuBar.add(xem);
        menuBar.add(sua);
        menuBar.add(chinhTocDo);
        setJMenuBar(menuBar);
//        pnMain.add(menuBar);

        if (!isFullScreen) {
            addControlsNotFullScreen(pnMain);
        } else {
            addControlsFullScreen(pnMain);
        }
    }

    public void addControlsFullScreen(JPanel pnMain) {
        System.out.println("addControlsFullScreen");
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        pnMain.setMaximumSize(screenSize);

        btn1 = new MyJButtonFlag();
        btn1.setBounds(50, 50, 30, 30);
        txt1 = new JTextArea();
        txt1.setBounds(165, 255, 50, 12);
        txt1.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt1.setEditable(false);
        txt1.setVisible(false);
        txt1.setLineWrap(true);
        txt1.setWrapStyleWord(true);
        pnMain.add(btn1);
        pnMain.add(txt1);
//
//        btn2 = new MyJButtonFlag();
//        btn2.setBounds(270, 235, 30, 30);
//        txt2 = new JTextArea();
//        txt2.setBounds(260, 265, 50, 12);
//        txt2.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt2.setEditable(false);
//        txt2.setVisible(false);
//        txt2.setLineWrap(true);
//        txt2.setWrapStyleWord(true);
//        pnMain.add(txt2);
//        pnMain.add(btn2);
//
//        btn3 = new MyJButtonFlag();
//        btn3.setBounds(370, 190, 30, 30);
//        txt3 = new JTextArea();
//        txt3.setBounds(360, 220, 50, 12);
//        txt3.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt3.setEditable(false);
//        txt3.setVisible(false);
//        txt3.setLineWrap(true);
//        txt3.setWrapStyleWord(true);
//        pnMain.add(txt3);
//        pnMain.add(btn3);
//
//        btn4 = new MyJButtonFlag();
//        btn4.setBounds(470, 135, 30, 30);
//        txt4 = new JTextArea();
//        txt4.setBounds(460, 165, 50, 12);
//        txt4.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt4.setEditable(false);
//        txt4.setVisible(false);
//        txt4.setLineWrap(true);
//        txt4.setWrapStyleWord(true);
//        pnMain.add(txt4);
//        pnMain.add(btn4);
//
//        btn5 = new MyJButtonFlag();
//        btn5.setBounds(770, 165, 30, 30);
//        txt5 = new JTextArea();
//        txt5.setBounds(760, 195, 50, 12);
//        txt5.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt5.setEditable(false);
//        txt5.setVisible(false);
//        pnMain.add(txt5);
//        pnMain.add(btn5);
//
//        btn6 = new MyJButtonFlag();
//        btn6.setBounds(650, 125, 30, 30);
//        txt6 = new JTextArea();
//        txt6.setBounds(640, 155, 50, 12);
//        txt6.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt6.setEditable(false);
//        txt6.setVisible(false);
//        pnMain.add(txt6);
//        pnMain.add(btn6);
//
//        btn7 = new MyJButtonFlag();
//        btn7.setBounds(145, 300, 30, 30);
//        txt7 = new JTextArea();
//        txt7.setBounds(135, 330, 50, 12);
//        txt7.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt7.setEditable(false);
//        txt7.setVisible(false);
//        pnMain.add(txt7);
//        pnMain.add(btn7);
//
//        btn8 = new MyJButtonFlag();
//        btn8.setBounds(125, 450, 30, 30);
//        txt8 = new JTextArea();
//        txt8.setBounds(115, 480, 50, 12);
//        txt8.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt8.setEditable(false);
//        txt8.setVisible(false);
//        pnMain.add(txt8);
//        pnMain.add(btn8);
//
//        btn9 = new MyJButtonFlag();
//        btn9.setBounds(345, 455, 30, 30);
//        txt9 = new JTextArea();
//        txt9.setBounds(335, 485, 50, 12);
//        txt9.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt9.setEditable(false);
//        txt9.setVisible(false);
//        pnMain.add(txt9);
//        pnMain.add(btn9);
//
//        btn10 = new MyJButtonFlag();
//        btn10.setBounds(240, 480, 30, 30);
//        txt10 = new JTextArea();
//        txt10.setBounds(230, 510, 50, 12);
//        txt10.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt10.setEditable(false);
//        txt10.setVisible(false);
//        pnMain.add(txt10);
//        pnMain.add(btn10);
//
//        btn11 = new MyJButtonFlag();
//        btn11.setBounds(370, 550, 30, 30);
//        txt11 = new JTextArea();
//        txt11.setBounds(360, 580, 50, 12);
//        txt11.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt11.setEditable(false);
//        txt11.setVisible(false);
//        pnMain.add(txt11);
//        pnMain.add(btn11);
//
//        btn12 = new MyJButtonFlag();
//        btn12.setBounds(585, 530, 30, 30);
//        txt12 = new JTextArea();
//        txt12.setBounds(575, 560, 50, 12);
//        txt12.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt12.setEditable(false);
//        txt12.setVisible(false);
//        pnMain.add(txt12);
//        pnMain.add(btn12);
//
//        btn13 = new MyJButtonFlag();
//        btn13.setBounds(700, 475, 30, 30);
//        txt13 = new JTextArea();
//        txt13.setBounds(690, 505, 50, 12);
//        txt13.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt13.setEditable(false);
//        txt13.setVisible(false);
//        pnMain.add(txt13);
//        pnMain.add(btn13);
//
//        btn14 = new MyJButtonFlag();
//        btn14.setBounds(835, 450, 30, 30);
//        txt14 = new JTextArea();
//        txt14.setBounds(825, 480, 50, 12);
//        txt14.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt14.setEditable(false);
//        txt14.setVisible(false);
//        pnMain.add(txt14);
//        pnMain.add(btn14);
//
//        btn15 = new MyJButtonFlag();
//        btn15.setBounds(835, 370, 30, 30);
//        txt15 = new JTextArea();
//        txt15.setBounds(825, 400, 50, 12);
//        txt15.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt15.setEditable(false);
//        txt15.setVisible(false);
//        pnMain.add(txt15);
//        pnMain.add(btn15);
//
//        btn16 = new MyJButtonFlag();
//        btn16.setBounds(815, 275, 30, 30);
//        txt16 = new JTextArea();
//        txt16.setBounds(805, 305, 50, 12);
//        txt16.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt16.setEditable(false);
//        txt16.setVisible(false);
//        pnMain.add(txt16);
//        pnMain.add(btn16);
//
//        btn17 = new MyJButtonFlag();
//        btn17.setBounds(670, 280, 30, 30);
//        txt17 = new JTextArea();
//        txt17.setBounds(660, 310, 50, 12);
//        txt17.setFont(new Font(Font.SERIF, Font.BOLD, 10));
//        txt17.setEditable(false);
//        txt17.setVisible(false);
//        pnMain.add(txt17);
//        pnMain.add(btn17);
//
//        btnWaveAttack = new JButton("");
//        btnWaveAttack.setBounds(775, 10, 70, 100);
//        btnWaveAttack.setOpaque(false);
//        btnWaveAttack.setContentAreaFilled(false);
//        btnWaveAttack.setBorder(null);
//        pnMain.add(btnWaveAttack);
//
//        lblIsLand = new JLabel();
//        lblIsLand.setBounds(0, 10, (int) screenSize.getWidth(), (int) screenSize.getHeight());
//        System.out.println(lblIsLand.getWidth() + "  " + lblIsLand.getHeight());
//
////        ImageIcon icon = new ImageIcon("/image/island.jpg");
////        Image image = icon.getImage();
////        Image newImage = image.getScaledInstance((int) lblIsLand.getWidth(), (int) lblIsLand.getHeight(), Image.SCALE_SMOOTH);
////        ImageIcon imageIcon = new ImageIcon(newImage);
////        lblIsLand.setIcon(imageIcon);
////        lblIsLand.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/image/island.jpg")).getImage().getScaledInstance((int) lblIsLand.getWidth(), (int) lblIsLand.getHeight(), Image.SCALE_SMOOTH))  );
////        lblIsLand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image.battleField/attackField1-4.png")));
//        pnMain.add(lblIsLand);
    }

    public void addControlsNotFullScreen(JPanel pnMain) {
        System.out.println("addControlsNotFullScreen");
        btn1 = new MyJButtonFlag();
        btn1.setBounds(175, 225, 30, 30);
        txt1 = new JTextArea();
        txt1.setBounds(165, 255, 50, 12);
        txt1.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt1.setEditable(false);
        txt1.setVisible(false);
        txt1.setLineWrap(true);
        txt1.setWrapStyleWord(true);
        pnMain.add(btn1);
        pnMain.add(txt1);

        btn2 = new MyJButtonFlag();
        btn2.setBounds(270, 235, 30, 30);
        txt2 = new JTextArea();
        txt2.setBounds(260, 265, 50, 12);
        txt2.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt2.setEditable(false);
        txt2.setVisible(false);
        txt2.setLineWrap(true);
        txt2.setWrapStyleWord(true);
        pnMain.add(txt2);
        pnMain.add(btn2);

        btn3 = new MyJButtonFlag();
        btn3.setBounds(370, 190, 30, 30);
        txt3 = new JTextArea();
        txt3.setBounds(360, 220, 50, 12);
        txt3.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt3.setEditable(false);
        txt3.setVisible(false);
        txt3.setLineWrap(true);
        txt3.setWrapStyleWord(true);
        pnMain.add(txt3);
        pnMain.add(btn3);

        btn4 = new MyJButtonFlag();
        btn4.setBounds(470, 135, 30, 30);
        txt4 = new JTextArea();
        txt4.setBounds(460, 165, 50, 12);
        txt4.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt4.setEditable(false);
        txt4.setVisible(false);
        txt4.setLineWrap(true);
        txt4.setWrapStyleWord(true);
        pnMain.add(txt4);
        pnMain.add(btn4);

        btn5 = new MyJButtonFlag();
        btn5.setBounds(770, 165, 30, 30);
        txt5 = new JTextArea();
        txt5.setBounds(760, 195, 50, 12);
        txt5.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt5.setEditable(false);
        txt5.setVisible(false);
        pnMain.add(txt5);
        pnMain.add(btn5);

        btn6 = new MyJButtonFlag();
        btn6.setBounds(650, 125, 30, 30);
        txt6 = new JTextArea();
        txt6.setBounds(640, 155, 50, 12);
        txt6.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt6.setEditable(false);
        txt6.setVisible(false);
        pnMain.add(txt6);
        pnMain.add(btn6);

        btn7 = new MyJButtonFlag();
        btn7.setBounds(145, 300, 30, 30);
        txt7 = new JTextArea();
        txt7.setBounds(135, 330, 50, 12);
        txt7.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt7.setEditable(false);
        txt7.setVisible(false);
        pnMain.add(txt7);
        pnMain.add(btn7);

        btn8 = new MyJButtonFlag();
        btn8.setBounds(125, 450, 30, 30);
        txt8 = new JTextArea();
        txt8.setBounds(115, 480, 50, 12);
        txt8.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt8.setEditable(false);
        txt8.setVisible(false);
        pnMain.add(txt8);
        pnMain.add(btn8);

        btn9 = new MyJButtonFlag();
        btn9.setBounds(345, 455, 30, 30);
        txt9 = new JTextArea();
        txt9.setBounds(335, 485, 50, 12);
        txt9.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt9.setEditable(false);
        txt9.setVisible(false);
        pnMain.add(txt9);
        pnMain.add(btn9);

        btn10 = new MyJButtonFlag();
        btn10.setBounds(240, 480, 30, 30);
        txt10 = new JTextArea();
        txt10.setBounds(230, 510, 50, 12);
        txt10.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt10.setEditable(false);
        txt10.setVisible(false);
        pnMain.add(txt10);
        pnMain.add(btn10);

        btn11 = new MyJButtonFlag();
        btn11.setBounds(370, 550, 30, 30);
        txt11 = new JTextArea();
        txt11.setBounds(360, 580, 50, 12);
        txt11.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt11.setEditable(false);
        txt11.setVisible(false);
        pnMain.add(txt11);
        pnMain.add(btn11);

        btn12 = new MyJButtonFlag();
        btn12.setBounds(585, 530, 30, 30);
        txt12 = new JTextArea();
        txt12.setBounds(575, 560, 50, 12);
        txt12.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt12.setEditable(false);
        txt12.setVisible(false);
        pnMain.add(txt12);
        pnMain.add(btn12);

        btn13 = new MyJButtonFlag();
        btn13.setBounds(700, 475, 30, 30);
        txt13 = new JTextArea();
        txt13.setBounds(690, 505, 50, 12);
        txt13.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt13.setEditable(false);
        txt13.setVisible(false);
        pnMain.add(txt13);
        pnMain.add(btn13);

        btn14 = new MyJButtonFlag();
        btn14.setBounds(835, 450, 30, 30);
        txt14 = new JTextArea();
        txt14.setBounds(825, 480, 50, 12);
        txt14.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt14.setEditable(false);
        txt14.setVisible(false);
        pnMain.add(txt14);
        pnMain.add(btn14);

        btn15 = new MyJButtonFlag();
        btn15.setBounds(835, 370, 30, 30);
        txt15 = new JTextArea();
        txt15.setBounds(825, 400, 50, 12);
        txt15.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt15.setEditable(false);
        txt15.setVisible(false);
        pnMain.add(txt15);
        pnMain.add(btn15);

        btn16 = new MyJButtonFlag();
        btn16.setBounds(815, 275, 30, 30);
        txt16 = new JTextArea();
        txt16.setBounds(805, 305, 50, 12);
        txt16.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt16.setEditable(false);
        txt16.setVisible(false);
        pnMain.add(txt16);
        pnMain.add(btn16);

        btn17 = new MyJButtonFlag();
        btn17.setBounds(670, 280, 30, 30);
        txt17 = new JTextArea();
        txt17.setBounds(660, 310, 50, 12);
        txt17.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        txt17.setEditable(false);
        txt17.setVisible(false);
        pnMain.add(txt17);
        pnMain.add(btn17);

        btnWaveAttack = new JButton("");
        btnWaveAttack.setBounds(775, 10, 70, 100);
        btnWaveAttack.setOpaque(false);
        btnWaveAttack.setContentAreaFilled(false);
        btnWaveAttack.setBorder(null);
        pnMain.add(btnWaveAttack);

        lblIsLand = new JLabel();
        lblIsLand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/island.jpg")));
        pnMain.add(lblIsLand);
        lblIsLand.setBounds(0, 10, 1000, 665);
    }

    public void addEvents() {
        btnWaveAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myHouse != null) {
//                    new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy()).setVisible(true);
                    WaveAttackUI.waveAttackUI.setVisible(true);
                }
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[1];
                currentButton = btn1;
                currentTextField = txt1;
                houseInfoUI.showWindow();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[2];
                currentButton = btn2;
                currentTextField = txt2;
                houseInfoUI.showWindow();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[3];
                currentButton = btn3;
                currentTextField = txt3;
                houseInfoUI.showWindow();
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[4];
                currentButton = btn4;
                currentTextField = txt4;
                houseInfoUI.showWindow();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                currentHouse = house[5];
                currentButton = btn5;
                currentTextField = txt5;
                houseInfoUI.showWindow();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[6];
                currentButton = btn6;
                currentTextField = txt6;
                houseInfoUI.showWindow();
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[7];
                currentButton = btn7;
                currentTextField = txt7;
                houseInfoUI.showWindow();
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[8];
                currentButton = btn8;
                currentTextField = txt8;
                houseInfoUI.showWindow();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[9];
                currentButton = btn9;
                currentTextField = txt9;
                houseInfoUI.showWindow();
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[10];
                currentButton = btn10;
                currentTextField = txt10;
                houseInfoUI.showWindow();
            }
        });
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[11];
                currentButton = btn11;
                currentTextField = txt11;
                houseInfoUI.showWindow();
            }
        });
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[12];
                currentButton = btn12;
                currentTextField = txt12;
                houseInfoUI.showWindow();
            }
        });
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[13];
                currentButton = btn13;
                currentTextField = txt13;
                houseInfoUI.showWindow();
            }
        });
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[14];
                currentButton = btn14;
                currentTextField = txt14;
                houseInfoUI.showWindow();
            }
        });
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[15];
                currentButton = btn15;
                currentTextField = txt15;
                houseInfoUI.showWindow();
            }
        });
        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[16];
                currentButton = btn16;
                currentTextField = txt16;
                houseInfoUI.showWindow();
            }
        });
        btn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[17];
                currentButton = btn17;
                currentTextField = txt17;
                houseInfoUI.showWindow();
            }
        });
    }

    public void showWindow() {
        System.out.println("showWindow");
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        if(!isFullScreen){
//            setSize(1000, 665);
//        }else{
//            setSize((int) scre  enSize.getWidth(), (int) screenSize.getHeight());
////            setSize(1000, 665);
//        }
        setSize(1000, 665);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
