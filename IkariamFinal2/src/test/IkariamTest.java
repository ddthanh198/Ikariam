package test;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import model.BattleField;
import model.BattleFieldFighting;
import ui.BattleFieldFightingUI;
import ui.BattleFieldUI;
import ui.HouseInfoUI;
import ui.IsLandUI;

public class IkariamTest {

    public static void main(String[] args) {
        IsLandUI isLandUI = new IsLandUI("Ikariam");
        isLandUI.showWindow();

//        isLandUI.addWindowStateListener(new WindowStateListener() {
//            public void windowStateChanged(WindowEvent event) {
//                boolean isMaximized = isMaximized(event.getNewState());
//                boolean wasMaximized = isMaximized(event.getOldState());
//                if (isMaximized && !wasMaximized) {
//                    isLandUI.isFullScreen = true;
//                    isLandUI.addControls();
//                    isLandUI.addEvents();
////                    isLandUI.showWindow();
////                    isLandUI.repaint();
//                } else if (wasMaximized && !isMaximized) {
//                    isLandUI.isFullScreen = false;
//                    isLandUI.addControls();
//                    isLandUI.addEvents();
////                    isLandUI.showWindow();
////                    isLandUI.repaint();
//                }
//            }
//        });
//    }
//    private static boolean isMaximized(int state) {
//    return (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
    }
}
