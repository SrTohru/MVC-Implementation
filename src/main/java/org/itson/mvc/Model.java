/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;

public class Model extends Observable {
    private Point circlePosition;
    private Color circleColor;

    public Model() {
        circlePosition = new Point(100, 100);
        circleColor = Color.YELLOW;
    }

    public Point getCirclePosition() {
        return circlePosition;
    }

    public Color getCircleColor() {
        return circleColor;
    }

    public void setCirclePosition(Point newPosition) {
        circlePosition = newPosition;
        setChanged();
        notifyObservers();
    }

    public void setCircleColor(Color newColor) {
        circleColor = newColor;
        setChanged();
        notifyObservers();
    }
}
