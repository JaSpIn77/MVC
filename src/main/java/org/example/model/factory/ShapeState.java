package org.example.model.factory;

import java.awt.*;
import java.util.Objects;

public class ShapeState {
    private ShapeType shapeType;
    private Color color;
    private boolean isFill;


    public ShapeState(ShapeType shapeType, boolean isFill, Color color) {
        this.shapeType = Objects.requireNonNullElse(shapeType, ShapeType.RECTANGULAR_SHAPE);
        this.color = Objects.requireNonNullElse(color, Color.BLACK);
        this.isFill = isFill;
    }
    public ShapeState(boolean isFill) {
        this.isFill = isFill;
    }

    public boolean isFill() {
        return isFill;
    }

    public void setFill(boolean fill) {
        isFill = fill;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
