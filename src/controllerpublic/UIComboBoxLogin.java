package controllerpublic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class UIComboBoxLogin extends BasicComboBoxUI{
    
    Color bg = new Color(18,41,58);
    Color color = new Color(255,255,255);
    Color bgSelect = new Color(117,95,238);
    Font fuentes = new Font("Tahoma", Font.BOLD, 14);

    public static UIComboBoxLogin createUI(JComponent com) {
        return new UIComboBoxLogin();
    }

    @Override
    protected JButton createArrowButton() {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(getClass().getResource("/icons/drop_down.png")));
        btn.setBorder(BorderFactory.createLineBorder(bg, 1));
        btn.setContentAreaFilled(false);
        btn.setBackground(bg);
        return btn;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(bg);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    @Override
    protected ListCellRenderer createRenderer() {

        return new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                list.setSelectionBackground(bgSelect);
                list.setForeground(color);
                list.setFont(fuentes);
                list.setCursor(Cursor.getPredefinedCursor(12));
                if (index != -1) {
                    setIcon(new ImageIcon(getClass().getResource("/icons/icon_items.png")));
                }
                return this;
            }

        };
    }
}
