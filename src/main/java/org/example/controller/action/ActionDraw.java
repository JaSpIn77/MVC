package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.factory.ShapeFactory;
import org.example.model.factory.ShapeState;

import java.awt.*;

public class ActionDraw implements AppAction {
    private Point firstPoint;
    private Point secondPoint;
    private Model model;
    private ShapeFactory shapeFactory;
    private final ShapeState shapeState;

    public ActionDraw(Model model, ShapeState shapeState) {
        this.model = model;
        this.shapeState = shapeState;
        shapeFactory = ShapeFactory.getInstance();
        model.setDrawableShape(shapeFactory.createShape(shapeState));
    }

    @Override
    public void mousePressed(Point point) {
        firstPoint = point;
        MyShape shape = shapeFactory.createShape(shapeState);
        model.addShape(shape);
    }

    @Override
    public void mouseDragged(Point point) {
        secondPoint = point;
        model.changeShape(firstPoint, point);
    }
}
