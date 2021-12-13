package maze.model;

import javafx.scene.paint.Color;

//Create an implementation that passes all tests in PuzzleTest.

public class Puzzle {

	private Maze dungeon;
	private Explorer hero;
	private Position goal;

	public Puzzle(int w, int h) {dungeon = new Maze(w, h);}

	public Color getColorFor(Position spot) {
		if (dungeon.inMaze(spot)) {
			return dungeon.getStateFor(spot).getColor();
		} else {return Color.BLACK;}
	}

	public boolean canEnter(Position spot) {
		if (dungeon.inMaze(spot)) {
			return dungeon.getStateFor(spot).canEnter();
		} else {return false;}
	}

	public void fill(Position spot) {
		if (dungeon.inMaze(spot)) {
			dungeon.setStateFor(spot, Cell.CLOSED);
		}
	}

	public boolean clear(Position spot) {
		if (dungeon.inMaze(spot) && !dungeon.inRoom(spot)) {
				dungeon.setStateFor(spot, Cell.OPEN);
				return true;
		}return false;

		}

	public int getWidth() {return dungeon.getWidth();}

	public int getHeight() {return dungeon.getHeight();}

	public boolean hasExplorer() {
		if(hero == null){
			return false;
		}else{
			return true;
		}
	}

	public void placeExplorer(Position p){hero = new Explorer(p);}

	public void moveExplorer(Move m){
		if (hasExplorer()){
			hero.move(m, dungeon);
		}
	}

	public Position getExplorerPosition(){
		return hero.getLocation();
	}

	public Direction getExplorerHeading(){
		return hero.getHeading();
	}

	public void placeGoal(Position p){
		goal = p;
	}

	public Position getGoal(){
		return goal;
	}
}
