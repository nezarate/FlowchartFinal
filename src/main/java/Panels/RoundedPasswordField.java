package Panels;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.EmptyBorder;

public class RoundedPasswordField extends JPasswordField {
    private static final Color DEFAULT_BOX_COLOR = Color.decode("#212529");
    private static final Color DEFAULT_TEXT_COLOR = Color.decode("#DEE2E6");
    private static final Font DEFAULT_TEXT_FONT = new Font("Dialog", Font.PLAIN, 12);
    private static final int DEFAULT_ARC_LENGTH = 10;

    private Color boxColor;
    private Color textColor;
    private Font textFont;
    private int arcLength;

    public RoundedPasswordField(int columns, Color boxColor, Color textColor, Font textFont, int arcLength) {
        super(columns);
        this.boxColor = boxColor;
        this.textColor = textColor;
        this.textFont = textFont;
        this.arcLength = arcLength;
        setOpaque(false);
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    public RoundedPasswordField(int columns) {
        this(columns, DEFAULT_BOX_COLOR, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_FONT, DEFAULT_ARC_LENGTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        Shape shape = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arcLength, arcLength);

        g2.setColor(boxColor);
        g2.fill(shape);

        setForeground(textColor);
        setFont(textFont);

        super.paintComponent(g2);
        g2.dispose();
    }
}
