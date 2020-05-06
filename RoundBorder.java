import java.awt.*;

import javax.swing.border.AbstractBorder;

class RoundBorder extends AbstractBorder
{
    public void paintBorder(Component c, Graphics g,
                            int x, int y,
                            int width, int height) {
        Color oldColor = g.getColor();

        g.setColor(Color.white);
        g.drawRoundRect(x, y, width - 1, height - 1,
                        20, 20);

        g.setColor(oldColor);
    }

    public Insets getBorderInsets(Component c)       {
        return new Insets(4, 4, 4, 4);
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = 4;
        return insets;
    }

}