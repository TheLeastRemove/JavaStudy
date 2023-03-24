package Solutions;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Annulus extends JPanel {

    private int outerRadius;
    private int innerRadius;
    private Color color;

    public Annulus(int outerRadius, int innerRadius, Color color) {
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - outerRadius * 2) / 2;
        int y = (getHeight() - outerRadius * 2) / 2;
        g.setColor(color);
        g.fillArc(x, y, outerRadius * 2, outerRadius * 2, 0, 360);
        g.setColor(getBackground());
        g.fillArc(x + (outerRadius - innerRadius), y + (outerRadius - innerRadius),
                innerRadius * 2, innerRadius * 2, 0, 360);
    }

    public double getArea() {
        double outerArea = Math.PI * Math.pow(outerRadius, 2);
        double innerArea = Math.PI * Math.pow(innerRadius, 2);
        return outerArea - innerArea;
    }

    public double getPerimeter() {
        return 2 * Math.PI * (outerRadius + innerRadius);
    }

    public static void main(String[] args) {
        int outerRadius = 100; // 外圆半径
        int innerRadius = 20; // 内圆半径
        Color color = Color.orange; // 填充颜色
        if (innerRadius >= outerRadius - 10 || innerRadius >= outerRadius / 2) {
            throw new IllegalArgumentException("内部图形尺寸过大");
        }
        Annulus annulus = new Annulus(outerRadius, innerRadius, color);
        JFrame frame = new JFrame("Solutions.Annulus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(outerRadius * 2, outerRadius * 2);
        frame.setContentPane(annulus);
        frame.setVisible(true);
        System.out.println("面积：" + annulus.getArea());
        System.out.println("周长：" + annulus.getPerimeter());
    }
}

