package proj;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Cross {

    private Line l1;
    private Line l2;
    private Pane pane;

    public Cross(Line l1, Line l2, Pane pane){
        this.l1 = l1;
        this.l2 = l2;
        this.pane = pane;
    }

    public void draw(){
        l1.setStartX(-50);
        l1.setStartY(-33);
        l1.setEndX(50);
        l1.setEndY(33);

        l2.setStartX(-50);
        l2.setStartY(33);
        l2.setEndX(50);
        l2.setEndY(-33);

    }

}
