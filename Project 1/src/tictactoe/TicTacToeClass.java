package tictactoe;

public class TicTacToeClass {

    private char [][] grid;

    public TicTacToeClass() {
        grid = new char [][] {
                {' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '}};
    }

    public String toString(){
        String s = "";
        for (int c = 0; c < grid.length; c++) {
            for (int c1 = 0; c1 < grid[c].length; c1++) {
                s += grid[c][c1];
            }
            s += "\n";
        }
        return s;
    }

    public boolean isOpen(int space) {

        if ((space == 1) && (grid[0][0] == ' ')) {
            return true;
        }
        else if ((space == 2) && (grid[0][2] == ' ')) {
            return true;
        }
        else if ((space == 3) && (grid[0][4] == ' ')) {
            return true;
        }
        else if ((space == 4) && (grid[2][0] == ' ')) {
            return true;
        }
        else if ((space == 5) && (grid[2][2] == ' ')) {
            return true;
        }
        else if ((space == 6) && (grid[2][4] == ' ')) {
            return true;
        }
        else if ((space == 7) && (grid[4][0] == ' ')) {
            return true;
        }
        else if ((space == 8) && (grid[4][2] == ' ')) {
            return true;
        }
        else if ((space == 9) && (grid[4][4] == ' ')) {
            return true;
        }
        else {
            return false;
        }
    }

    public char getPlayer(int player) {

        char place = ' ';

        if(player % 2 == 0) {
            place = 'O';
        }
        else {
            place = 'X';
        }
        return place;
    }

    public void playTurn(int space, int player){

        char thisTurnChar = getPlayer(player);

        if(isOpen(space)) {
            if (space == 1) {
                grid[0][0] = thisTurnChar;
            }
            else if (space == 2) {
                grid[0][2] = thisTurnChar;
            }
            else if (space == 3) {
                grid[0][4] = thisTurnChar;
            }
            else if (space == 4) {
                grid[2][0] = thisTurnChar;
            }
            else if (space == 5) {
                grid[2][2] = thisTurnChar;
            }
            else if (space == 6) {
                grid[2][4] = thisTurnChar;
            }
            else if (space == 7) {
                grid[4][0] = thisTurnChar;
            }
            else if (space == 8) {
                grid[4][2] = thisTurnChar;
            }
            else if (space == 9) {
                grid[4][4] = thisTurnChar;
            }
        }
    }

    public boolean gameFinished(int player){
        char thisTurnChar = getPlayer(player);
        if((grid[0][0] == thisTurnChar) && (grid[0][2] == thisTurnChar) && (grid[0][4] == thisTurnChar)) {
            return true;
        }
        else if((grid[2][0] == thisTurnChar) && (grid[2][2] == thisTurnChar) && (grid[2][4] == thisTurnChar)) {
            return true;
        }
        else if((grid[4][0] == thisTurnChar) && (grid[4][2] == thisTurnChar) && (grid[4][4] == thisTurnChar)) {
            return true;
        }
        else if((grid[0][0] == thisTurnChar) && (grid[2][0] == thisTurnChar) && (grid[4][0] == thisTurnChar)) {
            return true;
        }
        else if((grid[0][2] == thisTurnChar) && (grid[2][2] == thisTurnChar) && (grid[4][2] == thisTurnChar)) {
            return true;
        }
        else if((grid[0][4] == thisTurnChar) && (grid[2][4] == thisTurnChar) && (grid[4][4] == thisTurnChar)) {
            return true;
        }
        else if((grid[0][0] == thisTurnChar) && (grid[2][2] == thisTurnChar) && (grid[4][4] == thisTurnChar)) {
            return true;
        }
        else if((grid[0][4] == thisTurnChar) && (grid[2][2] == thisTurnChar) && (grid[4][0] == thisTurnChar)) {
            return true;
        }
        else if((grid[0][0] != ' ') && (grid[0][2] != ' ') && (grid[0][4] != ' ') && (grid[2][0] != ' ') && (grid[2][2] != ' ') && (grid[2][4] != ' ') && (grid[4][0] != ' ') && (grid[4][2] != ' ') && (grid[4][4] != ' ')) {
            return true;
        }
        return false;
        }
}

