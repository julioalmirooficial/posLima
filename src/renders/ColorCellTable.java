package renders;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorCellTable extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorCellTable(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        switch (table.getValueAt(row, columna_patron).toString()) {
            case "VENCIDO":
                setForeground(new Color(28, 60, 84));
                setBackground(new Color(255, 175, 175));
                break;
            case "VENCE MAÑANA":
                setBackground(new Color(255, 197, 72));
                setForeground(new Color(28, 60, 84));
                break;
            case "SIN FECHA":
                setBackground(new Color(184, 47, 18));
                setForeground(new Color(255, 255, 255));
                break;
            default:
                if (row % 2 == 0) {
                    setBackground(new Color(241, 246, 249));
                    setForeground(new Color(28, 60, 84));
                } else {
                    setBackground(new Color(215, 229, 237));
                    setForeground(new Color(28, 60, 84));
                }
                break;
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;
    }

}
