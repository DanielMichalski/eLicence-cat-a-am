package ui.a_am_chooser.logic;

import database.provider.LearningQuestionProvider;
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
    util.ChoosenCategory choosenCategory = util.ChoosenCategory.getInstance();

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

    class ACategorybtnListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            choosenCategory.setChoosenCategory(ChoosenCategory.A);
            LearningQuestionProvider learningProvider = LearningQuestionProvider.getInstance(true);
            showNextScreen();
        }
    }

    class AAMCategorybtnListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            choosenCategory.setChoosenCategory(ChoosenCategory.AM);
            LearningQuestionProvider learningProvider = LearningQuestionProvider.getInstance(true);
            showNextScreen();
        }
    }

    class CloseBtnListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            currentScreen.dispose();

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainMenuFrame frame = new MainMenuFrame();
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            });

        }
    }

    private void showNextScreen() {
        this.currentScreen.dispose();
        nextScreen.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        nextScreen.setVisible(true);
    }

    public void setaCategoryBtn(JLabel aCategoryBtn) {
        aCategoryBtn.addMouseListener(new ACategorybtnListener());
    }

    public void setaAmCategoryBtn(JLabel aAmCategoryBtn) {
        aAmCategoryBtn.addMouseListener(new AAMCategorybtnListener());
    }

    public void setCloseBtn(JLabel closeBtn) {
        closeBtn.addMouseListener(new CloseBtnListener());
    }
}
