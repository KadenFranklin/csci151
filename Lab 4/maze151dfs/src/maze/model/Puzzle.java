package maze.model;

import javafx.scene.paint.Color;
import maze.searchers.ArrayStack;
import maze.searchers.Stack;

//Create an implementation that passes all tests in PuzzleTest.

public class Puzzle {
	
	private Maze dungeon;
	private Explorer hero;
	private Position goal;

	public Puzzle(int w, int h) {
		dungeon = new Maze(w, h);
	}
	
	public Color getColorFor(Position spot) {
		return dungeon.getStateFor(spot).getColor();
	}

	public boolean canEnter(Position spot) {
		return dungeon.getStateFor(spot).canEnter();
	}

	public void fill(Position spot) {
		dungeon.setStateFor(spot, Cell.CLOSED);
	}

	public boolean clear(Position spot) {
		if (dungeon.inMaze(spot)) {
			dungeon.setStateFor(spot, Cell.OPEN);
			if (dungeon.inRoom((spot))) {
				dungeon.setStateFor(spot, Cell.CLOSED);
				return false;
			}
			return true;
		}
		return false;
	}

	public int getWidth() {
		return dungeon.getWidth();
	}

	public int getHeight() {
		return dungeon.getHeight();
	}

	public boolean hasExplorer() {
		return hero != null;
	}

	public void placeExplorer(Position p) {
		hero = new Explorer(p);
	}

	public void moveExplorer(Move m) {
		if (hasExplorer()) {
			hero.move(m, dungeon);
		}
	}

	public Position getExplorerPosition() {
		if (hasExplorer()) {
			return hero.getLocation();
		}
		return null;
	}

	public Direction getExplorerHeading() {
		if (hasExplorer()) {
			return hero.getHeading();
		}
		return null;
	}

	public void placeGoal(Position p) {
		goal = p;
	}

	public Position getGoal() {
		return goal;
	}

	public void tunnelRandomly() {
		ArrayStack<Position> a = new ArrayStack<Position>(8);
		a.push(new Position(0, 0));
		while (a.size() > 0) {
			Position c = a.peek();
			if (clear(a.pop())) {
				for (int i = 0; i < 4; i++) {
					if (dungeon.getStateFor(Direction.randomDirections()[i].getNeighbor(c)).equals(Cell.CLOSED)) {
						a.push(Direction.randomDirections()[i].getNeighbor(c));
					}
				}
			}
		}
	}

	public Trail solve(Stack<Trail> solver) {
		if((hero == null) || (goal == null)){
			return null;
		}
		solver.push(new Trail(hero.getLocation(), null));
		while(solver.size() > 0){
			Trail c = solver.pop();
			if(c.getEnd().equals(goal)){
				return c;
			}
			dungeon.setStateFor(c.getEnd(),Cell.VISITED);
			Direction[]g = Direction.values();
			for(int i = 0; i < Direction.values().length; i++){
				if(dungeon.getStateFor(g[i].getNeighbor(c.getEnd())) == Cell.OPEN) {
					solver.push(new Trail(g[i].getNeighbor(c.getEnd()), c));
				}
			}
		}
		return null;
	}


	// NEW FOR THIS LAB!!
	public void clearVisits() {
		dungeon.clearVisits();
	}

	// NEW FOR THIS LAB!!
	public int getCountOf(Cell cellType) {
		return dungeon.getCountOf(cellType);
	}

	// NEW FOR THIS LAB!!
	public boolean hasGoal() {return goal != null;}

}
