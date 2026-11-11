package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.factory.ShapeFactory;
import org.example.model.factory.ShapeType;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;

// TODO: Сделать singleton класс
public class Controller {
    
    private static Controller instance;
    private final Model model;
    private final MyFrame frame;
    private final MyPanel panel;
    private Point2D firstPoint;
    private Point2D secondPoint;
    private ShapeFactory shapeFactory;
    private Controller() {
        model = new Model();
        shapeFactory = ShapeFactory.getInstance();

        MyShape shape = shapeFactory.createDefaultShape();
        model.setDrawableShape(shape);

        panel = new MyPanel(this);
        // TODO: Поменять наблюдатель на более современную реализацию
        model.addObserver(panel);

        frame = new MyFrame();
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
    public void mousePressed(Point2D p){
        firstPoint = p;
        MyShape shape = shapeFactory.createDefaultShape();
        model.addShape(shape);
    }
    public void mouseDragged(Point2D p){
        secondPoint = p;
        model.changeShape(firstPoint, secondPoint);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
