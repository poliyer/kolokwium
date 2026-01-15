package circles;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private DrawingPanel drawingPanel;
    private JTextField radiusField;

    public MainFrame() {
        setTitle("Kołka; Wątki");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        drawingPanel=new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        radiusField = new JTextField("20", 5);
        JButton addButton=new JButton("Dodaj kołko");

        addButton.addActionListener(e -> {
            int r = Integer.parseInt(radiusField.getText());
            drawingPanel.addCircle(r);
        });

        controlPanel.add(new JLabel("Promień:"));
        controlPanel.add(radiusField);
        controlPanel.add(addButton);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);

    }
}
