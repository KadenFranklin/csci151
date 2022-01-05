package proj;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class TicTacToeController {

    private int turn = 0;
    private ArrayList<Pane> naughtList;
    private ArrayList<Pane> crossList;

    @FXML
    private BorderPane rootPane = new BorderPane();
    @FXML
    private Pane pane_1;
    @FXML
    private Pane pane_2;
    @FXML
    private Pane pane_3;
    @FXML
    private Pane pane_4;
    @FXML
    private Pane pane_5;
    @FXML
    private Pane pane_6;
    @FXML
    private Pane pane_7;
    @FXML
    private Pane pane_8;
    @FXML
    private Pane pane_9;
    @FXML
    private Label label;

    @FXML
    public void placeChar_1(){
        if (turn % 2 == 0 && isOpen(pane_1)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_1);
            naughtList.add(pane_1);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_1)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_1);
            crossList.add(pane_1);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_2(){
        if (turn % 2 == 0 && isOpen(pane_2)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_2);
            naughtList.add(pane_2);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_2)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_2);
            crossList.add(pane_2);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_3(){
        if (turn % 2 == 0 && isOpen(pane_3)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_3);
            naughtList.add(pane_3);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_3)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_3);
            crossList.add(pane_3);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_4(){
        if (turn % 2 == 0 && isOpen(pane_4)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_4);
            naughtList.add(pane_4);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_4)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_4);
            crossList.add(pane_4);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_5(){
        if (turn % 2 == 0 && isOpen(pane_5)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_5);
            naughtList.add(pane_5);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_5)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_5);
            crossList.add(pane_5);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_6(){
        if (turn % 2 == 0 && isOpen(pane_6)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_6);
            naughtList.add(pane_6);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_6)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_6);
            crossList.add(pane_6);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_7(){
        if (turn % 2 == 0 && isOpen(pane_7)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_7);
            naughtList.add(pane_1);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_7)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_7);
            crossList.add(pane_7);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_8(){
        if (turn % 2 == 0 && isOpen(pane_8)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_8);
            naughtList.add(pane_8);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_8)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_8);
            crossList.add(pane_8);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    @FXML
    public void placeChar_9(){
        if (turn % 2 == 0 && isOpen(pane_9)){
            Circle c1 = new Circle();
            c1.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            new Naught(30, c1, pane_9);
            naughtList.add(pane_9);
            turn++;
        }
        else if (turn % 2 != 0 && isOpen(pane_9)) {
            Line l1 = new Line(-50, -33, 50, 33);
            Line l2 = new Line(-50, 33, 50, -33);
            l1.setStroke(Color.BLACK);
            l2.setStroke(Color.BLACK);
            new Cross(l1, l2, pane_9);
            crossList.add(pane_9);
            turn++;
        }
        else{ label.setText("Please select an open spot."); }
    }

    public boolean isOpen(Pane pane){
        if (pane.getChildren() == null) {
            return true;
        }
        else{ return false; }
    }

    public boolean gameFinished(){
        if (crossList.contains(pane_1) && crossList.contains(pane_2) && crossList.contains(pane_3)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (crossList.contains(pane_4) && crossList.contains(pane_5) && crossList.contains(pane_6)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (crossList.contains(pane_7) && crossList.contains(pane_8) && crossList.contains(pane_9)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (crossList.contains(pane_7) && crossList.contains(pane_5) && crossList.contains(pane_3)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (crossList.contains(pane_9) && crossList.contains(pane_5) && crossList.contains(pane_1)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (crossList.contains(pane_7) && crossList.contains(pane_4) && crossList.contains(pane_1)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (crossList.contains(pane_8) && crossList.contains(pane_5) && crossList.contains(pane_2)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (crossList.contains(pane_9) && crossList.contains(pane_6) && crossList.contains(pane_3)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_1) && naughtList.contains(pane_2) && naughtList.contains(pane_3)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_4) && naughtList.contains(pane_5) && naughtList.contains(pane_6)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_7) && naughtList.contains(pane_8) && naughtList.contains(pane_9)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_7) && naughtList.contains(pane_5) && naughtList.contains(pane_3)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_9) && naughtList.contains(pane_5) && naughtList.contains(pane_1)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_7) && naughtList.contains(pane_4) && naughtList.contains(pane_1)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_8) && naughtList.contains(pane_5) && naughtList.contains(pane_2)) {
            label.setText("Game Finished!");
            return true;
        }
        else if (naughtList.contains(pane_9) && naughtList.contains(pane_6) && naughtList.contains(pane_3)) {
            label.setText("Game Finished!");
            return true;
        } return false;
    }
}
