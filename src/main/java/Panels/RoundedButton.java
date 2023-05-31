package Panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class RoundedButton extends JButton {
    private static final Color DEFAULT_BUTTON_COLOR = Color.decode("#212529");
    private static final Color DEFAULT_TEXT_COLOR = Color.decode("#DEE2E6");
    private static final Font DEFAULT_TEXT_FONT = new Font("Dialog", Font.BOLD, 12);

    private Color buttonColor;
    private Color textColor;
    private Font textFont;
    private int arcLength;

    public RoundedButton(String text, Color buttonColor, Color textColor, Font textFont, int arcLength) {
        super(text);
        this.buttonColor = buttonColor;
        this.textColor = textColor;
        this.textFont = textFont;
        this.arcLength = arcLength;
        setOpaque(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    public RoundedButton(String text, int arcLength) {
        this(text, DEFAULT_BUTTON_COLOR, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_FONT, arcLength);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        Shape shape = new RoundRectangle2D.Double(0, 0, width, height, arcLength, arcLength);

        if (getModel().isArmed()) {
            g2.setColor(buttonColor.darker());
        } else if (getModel().isRollover()) {
            g2.setColor(buttonColor.brighter());
        } else {
            g2.setColor(buttonColor);
        }

        g2.fill(shape);

        g2.setColor(textColor);
        g2.setFont(textFont);
        int textX = (width - g2.getFontMetrics().stringWidth(getText())) / 2;
        int textY = (height - g2.getFontMetrics().getHeight()) / 2 + g2.getFontMetrics().getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Empty method to prevent the default border painting
    }
}
