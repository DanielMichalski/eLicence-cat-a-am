package ui.a_am_chooser.logic;

import model.ChoosenCategory;
import ui.a_am_chooser.view.AAmFrame;
import ui.main_menu.view.MainMenuFrame;
import util.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Author: Daniel
 */
public class AAmController {
    private JDialog currentScreen;
    private JDialog nextScreen;

    public AAmController(AAmFrame currentScreen, JDialog nextScreen) {
        this.currentScreen = currentScreen;
        this.nextScreen = nextScreen;
    }

    public WindowListener getWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        FileUtils.deleteTempFolderContent();

                        currentScreen.dispose();

                        MainMenuFrame mv = new MainMenuFrame();
                        mv.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        mv.setVisible(true);
                    }
                });
            }
        };
    }

    class ACategorybtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showNextScreen(ChoosenCategory.A);
        }
    }

    class AAMCategorybtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showNextScreen(ChoosenCategory.AM);
        }
    }

    private void showNextScreen(ChoosenCategory a) {
        this.currentScreen.dispose();
        nextScreen.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        nextScreen.setVisible(true);
    }

    public void setaCategoryBtn(JButton aCategoryBtn) {
        aCategoryBtn.addActionListener(new ACategorybtnListener());
    }

    public void setaAmCategoryBtn(JButton aAmCategoryBtn) {
        aAmCategoryBtn.addActionListener(new AAMCategorybtnListener());
    }
}
