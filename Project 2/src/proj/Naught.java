package proj;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class Naught {

    private double x;
    private double y;
    private double dX;
    private double dY;
    private double radius;
    private Circle circle;
    private Pane pane;

    public Naught(double radius, Circle circle, Pane pane){
        x = 0;
        y = 0;
        dX = 50;
        dY = 33;
        this.radius = 30;
        this.circle = circle;
        this.pane = pane;
    }

    public void draw() {
        circle.setRadius(radius);
        circle.setTranslateX(x);
        circle.setTranslateY(y);
    }
}
