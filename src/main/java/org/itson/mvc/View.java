/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class View implements Observer {
    private Model model;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel drawingPanel;
    private JPanel iCanDrawHere;

    public View(Model model) {
        this.model = model;
        model.addObserver(this);

        frame = new JFrame("MVC Example");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(model.getCircleColor());
                Point circlePos = model.getCirclePosition();
                g.fillOval(circlePos.x, circlePos.y, 50, 50);
            }
        };
        drawingPanel.setBackground(Color.WHITE);
        mainPanel.add(drawingPanel, BorderLayout.CENTER);

        // Panel específico para dibujar
      // Panel específico para dibujar
iCanDrawHere = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, iCanDrawHere.getWidth(), iCanDrawHere.getHeight());
    }
};
iCanDrawHere.setBackground(Color.LIGHT_GRAY);
mainPanel.add(iCanDrawHere, BorderLayout.WEST);
iCanDrawHere.setPreferredSize(new Dimension(100, mainPanel.getHeight())); // Establece el tamaño del panel


        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        drawingPanel.repaint();
    }

    public JPanel getDrawingPanel() {
        return drawingPanel;
    }

    public JPanel getICanDrawHerePanel() {
        return iCanDrawHere;
    }

}
