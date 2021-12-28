package maze.model;

import java.util.Comparator;

public class TrailEstimator implements Comparator<Trail> {
    private Puzzle puzzle;

    public TrailEstimator(Puzzle target) {
        puzzle = target;
    }

    /**
     * The estimate should be calculated using the manhattanDistanceTo
     * method of the Position class.
     * @param t a Trail to be estimated
     * @return the length of the given Trail, plus an estimate for the
     * remaining length of the trail.
     */
    public int estimateFor(Trail t) {
        // TODO Step 7 Implement your solution
        return (t.getLength() + t.getEnd().manhattanDistanceTo(puzzle.getGoal()) );
    }

    /**
     * The compare method will compare two Trail objects, using using
     * the estimate for each Trail calculated in the above method.
     * Return -1 if the first Trail estimate is less than the second,
     * 0 if they are equal, and 1 if the first Trail estimate is
     * greater than the second.
     */
    @Override
    public int compare(Trail o1, Trail o2) {
         int a = estimateFor(o1);
         int b = estimateFor(o2);
         if (a < b){ return -1;}
         else if (a == b) { return 0; }
         else { return 0; }
    }
}

