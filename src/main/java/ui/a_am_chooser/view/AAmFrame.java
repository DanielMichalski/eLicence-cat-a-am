package ui.a_am_chooser.view;

import database.dao.TextsDao;
import ui.a_am_chooser.logic.AAmController;
import util.ApplicationUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Author: Daniel
 */
public class AAmFrame extends JDialog {

    public static final int HEIGHT = 600;
    public static final int WIDTH = 960;

    public AAmFrame(JDialog nextScreen) {
        setUpDialog();
        initializeComponents(nextScreen);
    }

    private void setUpDialog() {
        setSize(WIDTH, HEIGHT);
        setTitle(TextsDao.getText("view.CategoryChooser.title"));
        setModal(true);
        setResizable(false);
        setIgnoreRepaint(false);
        setUndecorated(true);
        ApplicationUtils.setApplicationIcon(this);
        setLocationRelativeTo(null);
        setWindowRemoveble();
    }

    private void setWindowRemoveble() {
        final Point point = new Point();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (!e.isMetaDown()) {
                    point.x = e.getX();
                    point.y = e.getY();
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (!e.isMetaDown()) {
                    Point p = getLocation();
                    setLocation(p.x + e.getX() - point.x,
                            p.y + e.getY() - point.y);
                }
            }
        });
    }

    private void initializeComponents(JDialog nextScreen) {
        AAmController controller = new AAmController(this, nextScreen);

        AAmPanel aAmPanel = new AAmPanel();
        add(aAmPanel);

        controller.setaCategoryBtn(aAmPanel.getaCategoryBtn());
        controller.setaAmCategoryBtn(aAmPanel.getAmCategoryBtn());
        controller.setCloseBtn(aAmPanel.getCloseBtn());

        addWindowListener(controller.getWindowListener());
    }
}
