package circles;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Circle {

    private int x, y, r;
    private volatile boolean running = true;

    public Circle(int r, int x, int y) {
        this.r = r;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.drawOval(x-r, y-r, 2*r, 2*r);
    }

    public void move(int key, int maxW, int maxH) {
        switch (key) {
            case KeyEvent.VK_LEFT -> x-=5;
            case KeyEvent.VK_RIGHT -> x+=5;
            case KeyEvent.VK_UP -> y-=5;
            case KeyEvent.VK_DOWN -> y+=5;
        }

        x=Math.max(r, Math.min(x, maxW-r));
        y=Math.max(r, Math.min(y, maxH-r));

    }

    public boolean isAtBorder(int w, int h) {
        return x==r || y==r || x==w-r || y==h-r;
    }

    public void stop() {
        running=false;
    }

    public boolean isRunning() {
        return running;
    }
}