package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.controller.action.AppAction;
import org.example.model.Model;
import org.example.model.factory.ShapeState;
import org.example.model.factory.ShapeType;
import org.example.view.MenuCreator;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import javax.swing.*;
import java.awt.*;

// TODO: Сделать singleton класс
public class Controller {
    
    private static Controller instance;
    private final Model model;
    private final MyFrame frame;
    private final MyPanel panel;
    private AppAction action;
    private ShapeState shapeState;



    private Controller() {
        model = new Model();
        panel = new MyPanel(this);
        model.addObserver(panel);
        frame = new MyFrame();
        shapeState = new ShapeState(ShapeType.RECTANGULAR_SHAPE, true, Color.RED);
        action = new ActionDraw(model, shapeState);

        MenuCreator menuCreator = MenuCreator.getInstance();
        menuCreator.setController(this);
        menuCreator.setShapeState(shapeState);
        JMenuBar menuBar = menuCreator.createMenu();
        frame.setJMenuBar(menuBar);


        JToolBar jToolBar = menuCreator.createToolBar(JToolBar.VERTICAL);
        frame.add(jToolBar, BorderLayout.EAST);


        frame.setPanel(panel);
        panel.revalidate();
        panel.repaint();
    }



    public static synchronized Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    public void mousePressed(Point point) {
       action.mousePressed(point);
    }
    public void mouseDragged(Point point) {
       action.mouseDragged(point);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
    public void switchActionDraw() {
        action = new ActionDraw(model, shapeState);
    }
}
