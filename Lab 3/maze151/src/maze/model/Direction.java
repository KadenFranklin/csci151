package maze.model;

// Implement all methods for each Enum value.

public enum Direction {
	NORTH {
		@Override
		public Direction getClockwise() {return Direction.EAST;}

		@Override
		public Direction getCounterclockwise() {return Direction.WEST;}

		@Override
		public double getRotation() {return 180.0;}
	},
	SOUTH {
		@Override
		public Direction getClockwise() {return Direction.WEST;}

		@Override
		public Direction getCounterclockwise() {return Direction.EAST;}

		@Override
		public double getRotation() {return 0.0;}
	},
	EAST {
		@Override
		public Direction getClockwise() {return Direction.SOUTH;}

		@Override
		public Direction getCounterclockwise() {return Direction.NORTH;}

		@Override
		public double getRotation() {return -90.0;}
	},
	WEST {
		@Override
		public Direction getClockwise() {return Direction.NORTH;}

		@Override
		public Direction getCounterclockwise() {return Direction.SOUTH;}

		@Override
		public double getRotation() {return 90.0;}
	};
	
	public Position getNeighbor(Position src) {
		return new Position(src.getX() - (int)(Math.sin(Math.toRadians(getRotation()))),
				src.getY() + (int)(Math.cos(Math.toRadians(getRotation()))));
	}
	
	public abstract Direction getClockwise();
	public abstract Direction getCounterclockwise();
	public abstract double getRotation();
}
