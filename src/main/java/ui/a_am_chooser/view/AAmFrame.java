package ui.a_am_chooser.view;

import database.dao.TextsDao;
import ui.a_am_chooser.logic.AAmController;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 */
public class AAmFrame extends JDialog {

    public static final int WIDTH = 250;
    public static final int HEIGHT = 150;

    public AAmFrame(JDialog nextScreen) {
        setUpDialog();
        initializeComponents(nextScreen);
        setLocationRelativeTo(null);
    }

    private void setUpDialog() {
        setSize(new Dimension(WIDTH, HEIGHT));
        setTitle(TextsDao.getText("view.CategoryChooser.title"));
        setModal(true);
        setResizable(false);
    }

    private void initializeComponents(JDialog nextScreen) {
        AAmController controller = new AAmController(this, nextScreen);

        AAmPanel aAmPanel = new AAmPanel();
        add(aAmPanel);

        controller.setaCategoryBtn(aAmPanel.getaCategoryBtn());
        controller.setaAmCategoryBtn(aAmPanel.getaAmCategoryBtn());

        addWindowListener(controller.getWindowListener());
    }
}
