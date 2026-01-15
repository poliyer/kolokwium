package circles;

import javax.swing.*;

public class CircleThread extends Thread {

    private final Circle circle;
    private final JPanel panel;

    public CircleThread(Circle circle, JPanel panel) {
        this.circle = circle;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (circle.isRunning()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {}
            panel.repaint();
        }
    }
}
