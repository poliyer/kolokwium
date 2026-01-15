package circles;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DrawingPanel extends JPanel {

    private final List<Circle> circles = new ArrayList<>();
    private Circle activeCircle;

    public DrawingPanel() {
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (activeCircle!=null) {
                    activeCircle.move(e.getKeyCode(), getWidth(), getHeight());
                    repaint();

                    if (activeCircle.isAtBorder(getWidth(), getHeight())) {
                        activeCircle.stop();
                        activeCircle = null;
                    }
                }
            }
        });
    }

    public void addCircle(int radius) {
        // Circle circle = new Circle(radius, 50, 50);

        int cx=getWidth()/2;
        int cy=getHeight()/2;

        Circle circle  = new Circle(radius, cx, cy);

        circles.add(circle);
        activeCircle = circle;


        new CircleThread(circle, this).start();
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle c : circles) {
             c.draw(g);
        }
    }
}
