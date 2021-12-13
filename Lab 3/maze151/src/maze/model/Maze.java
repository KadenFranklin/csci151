package maze.model;

import javafx.geometry.Pos;

import java.io.ObjectInputStream;

public class Maze {

	private Cell[][] cells;

	public Maze(int width, int height) {
		cells = new Cell[width][height];
		for (int c = 0; c < width; c++){
			for (int c1 = 0; c1 < height; c1++){
				cells[c][c1] = Cell.CLOSED;
			}
		}
	}

	public int getWidth() {return cells.length;}

	public int getHeight() {return cells[0].length;}

	public boolean inMaze(Position p) {
		if ((p.getX() >= cells.length) || (p.getY() >= cells[0].length)) {
			return false;
		} else if ((p.getX() < 0) || (p.getY() < 0)) {
				return false;
		} else{return true;}
	}

	public Cell getStateFor(Position p) {
		if (inMaze(p)) {
			return cells[p.getX()][p.getY()] ;
		} else {return Cell.CLOSED;}
	}

	public void setStateFor(Position p, Cell state) {
		if (inMaze(p)) {
			cells[p.getX()][p.getY()] = state;
		}
	}

	public boolean inRoom(Position p) {
		Position NofP = Direction.NORTH.getNeighbor(p);
		Position NEofP = Direction.EAST.getNeighbor(NofP);
		Position NWofP = Direction.WEST.getNeighbor(NofP);
		Position EofP = Direction.EAST.getNeighbor(p);
		Position SofP = Direction.SOUTH.getNeighbor(p);
		Position SEofP = Direction.EAST.getNeighbor(SofP);
		Position SWofP = Direction.WEST.getNeighbor(SofP);
		Position WofP = Direction.WEST.getNeighbor(p);

		if (getStateFor(p) == Cell.OPEN) {
			if (getStateFor(NofP) == Cell.OPEN) {
				if (getStateFor(NEofP) == Cell.OPEN) {
					if (getStateFor(EofP) == Cell.OPEN) {
						return true;
					}
				} else if (getStateFor(NWofP) == Cell.OPEN) {
					if (getStateFor(WofP) == Cell.OPEN) {
						return true;
					}
				}
			}
			if (getStateFor(SofP) == Cell.OPEN) {
				if (getStateFor(SEofP) == Cell.OPEN) {
					return  (getStateFor(EofP) == Cell.OPEN);

				} else if (getStateFor(SWofP) == Cell.OPEN) {
					return (getStateFor(WofP) == Cell.OPEN);
				}
			}
		}return false;
	}

	public int numOpenNeighbors(Position p) {
		int neighborsCount = 0;
		Position n = Direction.NORTH.getNeighbor(p);
		Position e = Direction.EAST.getNeighbor(p);
		Position s = Direction.SOUTH.getNeighbor(p);
		Position w = Direction.WEST.getNeighbor(p);

		if (getStateFor(n) == Cell.OPEN) {
			neighborsCount++;
		}if (getStateFor(e) == Cell.OPEN) {
			neighborsCount++;
		}if (getStateFor(s) == Cell.OPEN) {
			neighborsCount++;
		}if (getStateFor(w) == Cell.OPEN) {
			neighborsCount++;
		}return neighborsCount;
	}

}