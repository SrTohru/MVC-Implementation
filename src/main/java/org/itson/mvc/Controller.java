/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getICanDrawHerePanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickPoint = e.getPoint();
                if (isInsideICanDrawHere(clickPoint)) {
                    model.setCirclePosition(clickPoint);
                } else {
                    JOptionPane.showMessageDialog(null, "Solo puedes pintar dentro del área designada.");
                }
            }
        });

        // Cambiar el color del círculo con clic derecho
        view.getICanDrawHerePanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    Color newColor = JColorChooser.showDialog(null, "Elige el color del círculo", Color.BLUE);
                    if (newColor != null) {
                        model.setCircleColor(newColor);
                    }
                }
            }
        });
    }

    private boolean isInsideICanDrawHere(Point point) {
        JPanel iCanDrawHerePanel = view.getICanDrawHerePanel();
        return point.getX() >= 0 && point.getX() <= iCanDrawHerePanel.getWidth() &&
               point.getY() >= 0 && point.getY() <= iCanDrawHerePanel.getHeight();
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}

