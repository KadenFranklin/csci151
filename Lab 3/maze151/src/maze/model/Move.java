package maze.model;

// Create an implementation that passes all tests in MoveTest.

public enum Move {
    FORWARD{
        public Position newPosition(Position p, Direction d){
            return d.getNeighbor(p);
        }
        public Direction newDirection (Direction d){
            return d;
        }
    },LEFT{
        public Position newPosition(Position p, Direction d){
            return p;
        }
        public Direction newDirection (Direction d) {
            return d.getCounterclockwise();
        }
    },RIGHT{
        public Position newPosition(Position p, Direction d){
            return p;
        }
        public Direction newDirection (Direction d) {
            return d.getClockwise();
        }
    };

    public abstract Position newPosition(Position p, Direction d);
    public abstract Direction newDirection(Direction d);
}
