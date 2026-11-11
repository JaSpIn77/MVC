package org.example.model;

import lombok.Setter;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {

    @Setter
    private MyShape drawableShape;
    @Setter
    private List<MyShape> shapeList;
    private Model shape;

    public Model() {
        this.shapeList = new ArrayList<>();
    }

    public void addShape(MyShape shape) {
        drawableShape = shape;
        shapeList.add(shape);
    }
    public void setMyShape(MyShape myShape) {
        this.drawableShape = myShape;
    }

    public void changeShape(Point2D x, Point2D y) {
        drawableShape.setFrame(x, y);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        drawableShape.draw(g);
        shapeList.forEach(shape -> shape.draw(g));
        for (MyShape shape : shapeList) {
            shape.draw(g);
        }
    }

}
