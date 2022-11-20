package bridge.view.map;

import static bridge.command.enums.PlayerMove.D;
import static bridge.command.enums.PlayerMove.U;
import static bridge.result.GameStatus.FAIL;

import bridge.result.GameStatus;
import java.util.ArrayList;
import java.util.List;

public class OutputMapView {

    private static final int LAST_ONE = 1;
    private static final int START_INDEX = 0;
    private static final String MAP_START = "[ ";
    private static final String MAP_UPPER_END = " ]";
    private static final String MAP_LOWER_END = " ]\n";
    private static final String MAP_WALL = " | ";
    private static final String MAP_EMPTY_SQUARE = " ";
    private static final String MAP_CORRECT_SQUARE = "O";
    private static final String MAP_WRONG_SQUARE = "X";

    public static void printUpperBridge(List<String> squares, GameStatus gameStatus) {
        List<String> upperSquares = new ArrayList<>(squares);

        printStartMap();
        printUpperSquares(upperSquares, gameStatus);
        printEndUpperMap();
    }

    public static void printLowerBridge(List<String> squares, GameStatus gameStatus) {
        List<String> lowerSquares = new ArrayList<>(squares);

        printStartMap();
        printLowerSquares(lowerSquares, gameStatus);
        printEndLowerMap();
    }

    private static void printUpperSquares(List<String> squares, GameStatus gameStatus) {
        while (squares.size() != LAST_ONE) {
            printUpperSquare(squares.remove(START_INDEX));
            printMapWall();
        }
        printLastUpperSquare(squares.remove(START_INDEX), gameStatus);
    }

    private static void printLowerSquares(List<String> squares, GameStatus gameStatus) {
        while (squares.size() != LAST_ONE) {
            printLowerSquare(squares.remove(START_INDEX));
            printMapWall();
        }
        printLastLowerSquare(squares.remove(START_INDEX), gameStatus);
    }

    private static void printUpperSquare(String square) {
        if (square.equals(D.toString())) {
            printEmptySquare();
            return;
        }
        printCorrectSquare();
    }

    private static void printLowerSquare(String square) {
        if (square.equals(U.toString())) {
            printEmptySquare();
            return;
        }
        printCorrectSquare();
    }


    private static void printLastUpperSquare(String LastSquare, GameStatus gameStatus) {
        if (LastSquare.equals(D.toString())) {
            printEmptySquare();
            return;
        }
        System.out.print(determineLastPrintSquare(gameStatus));
    }

    private static void printLastLowerSquare(String LastSquare, GameStatus gameStatus) {
        if (LastSquare.equals(U.toString())) {
            printEmptySquare();
            return;
        }
        System.out.print(determineLastPrintSquare(gameStatus));
    }

    private static String determineLastPrintSquare(GameStatus gameStatus) {
        if (!gameStatus.equals(FAIL)) {
            return MAP_CORRECT_SQUARE;
        }
        return MAP_WRONG_SQUARE;
    }

    private static void printEmptySquare() {
        System.out.print(MAP_EMPTY_SQUARE);
    }

    private static void printCorrectSquare() {
        System.out.print(MAP_CORRECT_SQUARE);
    }

    private static void printMapWall() {
        System.out.print(MAP_WALL);
    }

    private static void printStartMap() {
        System.out.print(MAP_START);
    }

    private static void printEndUpperMap() {
        System.out.println(MAP_UPPER_END);
    }

    private static void printEndLowerMap() {
        System.out.println(MAP_LOWER_END);
    }
}
