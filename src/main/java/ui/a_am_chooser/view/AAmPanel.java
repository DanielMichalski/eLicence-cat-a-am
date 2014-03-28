package ui.a_am_chooser.view;

import javax.swing.*;

/**
 * Author: Daniel
 */
public class AAmPanel extends JPanel {
    private JButton aCategoryBtn;
    private JButton aAmCategoryBtn;

    public AAmPanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        setLayout(null);
    }

    private void initializeComponents() {
        JLabel info = new JLabel("Wybierz kategorię");
        info.setBounds(10, 10, 200, 30);
        aCategoryBtn = createBtn("A", 10, 60, 100, 40);
        aAmCategoryBtn= createBtn("AM", 120, 60, 100, 40);

        add(info);
        add(aCategoryBtn);
        add(aAmCategoryBtn);
    }

    private JButton createBtn(String btnLabel, int x, int y, int width, int height) {
        JButton jButton = new JButton(btnLabel);
        jButton.setBounds(x, y, width, height);
        return jButton;
    }

    public JButton getaCategoryBtn() {
        return aCategoryBtn;
    }

    public JButton getaAmCategoryBtn() {
        return aAmCategoryBtn;
    }
}
