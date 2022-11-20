package bridge.io;

import java.util.List;

public class TileView {

    public void printTiles(List<String> bridge, List<String> userMoving, String direction) {
        for (int curTile = 0; curTile < userMoving.size(); curTile++) {
            printTile(bridge, userMoving, direction, curTile);
            printSeparator(userMoving, curTile);
        }
    }

    private static void printTile(List<String> bridge, List<String> userMoving, String direction, int curTile) {
        System.out.print(" ");
        printMark(bridge.get(curTile), userMoving.get(curTile), direction);
        System.out.print(" ");
    }

    private static void printMark(String answer, String userInput, String direction) {
        if (isIncorrectInput(answer, userInput, direction)) {
            System.out.print("X");
            return;
        } else if (isCorrectInput(answer, userInput, direction)) {
            System.out.print("O");
            return;
        }
        System.out.print(" ");
    }

    private static boolean isIncorrectInput(String answer, String userInput, String direction) {
        return !answer.equals(userInput) && !answer.equals(direction);
    }

    private static boolean isCorrectInput(String answer, String userInput, String direction) {
        return answer.equals(userInput) && answer.equals(direction);
    }

    private static void printSeparator(List<String> userMoving, int curTile) {
        if (isLastTile(curTile, userMoving.size())) {
            System.out.print("|");
        }
    }

    private static boolean isLastTile(int tile, int tileSize) {
        return tile != (tileSize - 1);
    }
}
