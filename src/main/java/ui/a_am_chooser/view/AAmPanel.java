package ui.a_am_chooser.view;

import util.Const;
import util.ImageUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 */
public class AAmPanel extends JPanel {
    private JLabel aCategoryBtn;
    private JLabel AmCategoryBtn;
    private JLabel chooseCategoryLbl;
    private JLabel closeBtn;

    public AAmPanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        setBackground(Const.Colors.BACKGROUND_COLOR);
        setLayout(null);
    }

    private void initializeComponents() {
        aCategoryBtn = createBtn("a.png", 50, 440);
        AmCategoryBtn = createBtn("am.png", 650, 440);
        chooseCategoryLbl = getChooseCategoryLbl();
        closeBtn = createCloseBtn();

        add(aCategoryBtn);
        add(AmCategoryBtn);
        add(chooseCategoryLbl);
        add(closeBtn);
    }

    private JLabel createCloseBtn() {
        final ImageIcon imgUn = ImageUtils.getProgramImage("close_btn.png");
        final JLabel button = new JLabel(imgUn);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBounds(915, 5, 40, 40);
        return button;
    }

    private JLabel getChooseCategoryLbl() {
        final ImageIcon imgUn = ImageUtils.getProgramImage("wybierz.png");

        final JLabel button = new JLabel(imgUn);
        button.setBounds(350, 440, 280, 85);
        return button;
    }

    private JLabel createBtn(String imgUnPath, int x, int y) {
        final ImageIcon imgUn = ImageUtils.getProgramImage(imgUnPath);

        final JLabel button = new JLabel(imgUn);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBounds(x, y, 280, 85);
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon programImage = ImageUtils.getProgramImage("bg.png");
        g.drawImage(programImage.getImage(), 0, 0, null);
    }

    public JLabel getaCategoryBtn() {
        return aCategoryBtn;
    }

    public JLabel getAmCategoryBtn() {
        return AmCategoryBtn;
    }

    public JLabel getCloseBtn() {
        return closeBtn;
    }
}
