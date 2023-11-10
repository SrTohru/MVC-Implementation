/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.mvc;

/**
 *
 * @author PC
 */
public class MVC {

    public static void main(String[] args) {
    Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}
