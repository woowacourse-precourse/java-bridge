package bridge.view;

import static bridge.player.PlayerMove.D;
import static bridge.player.PlayerMove.U;
import static bridge.result.GameStatus.FAIL;

import bridge.result.GameStatus;
import bridge.result.Result;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String INPUT_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String MAP_START = "[ ";
    private static final String MAP_END = " ]";
    private static final String MAP_WALL = " | ";
    private static final String MAP_EMPTY_SQUARE = " ";
    private static final String MAP_CORRECT_SQUARE = "O";
    private static final String MAP_WRONG_SQUARE = "X";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        printUpperBridge(result);
        printLowerBridge(result);
    }

    public void printInputGameCommand() {
        System.out.println(INPUT_GAME_COMMAND_MESSAGE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printInputBridgeSizeMessage() {
        System.out.println(INPUT_SIZE_MESSAGE);
    }

    public void printInputMoveMessage() {
        System.out.println(INPUT_MOVE_MESSAGE);
    }


    private void printUpperBridge(Result result) {
        List<String> squares = result.getSquares();
        int squaresSize = squares.size();
        System.out.print(MAP_START);
        for (int squareIdx = 0; squareIdx < squaresSize - 1; squareIdx++) {
            printUpperBridgeSquare(squares.get(squareIdx));
            printMapWall();
        }
        printLastUpperBridgeSquare(squares.get(squaresSize - 1), result.getGameStatus());
    }

    private void printLowerBridge(Result result) {
        List<String> squares = result.getSquares();
        int squaresSize = squares.size();
        System.out.print(MAP_START);
        for (int squareIdx = 0; squareIdx < squaresSize - 1; squareIdx++) {
            printLowerBridgeSquare(squares.get(squareIdx));
            printMapWall();
        }
        printLastLowerBridgeSquare(squares.get(squaresSize - 1), result.getGameStatus());
    }

    private void printMapWall() {
        System.out.print(MAP_WALL);
    }

    private void printWrongSquare(GameStatus gameStatus) {
        if (gameStatus.equals(FAIL)) {
            System.out.print(MAP_WRONG_SQUARE);
        }
    }

    private void printCorrectSquare(GameStatus gameStatus) {
        if (!gameStatus.equals(FAIL)) {
            System.out.print(MAP_CORRECT_SQUARE);
        }
    }

    private void printEmptySquare() {
        System.out.print(MAP_EMPTY_SQUARE);
    }

    private void printLowerBridgeSquare(String square) {
        if (square.equals(D.toString())) {
            System.out.print(MAP_CORRECT_SQUARE);
            return;
        }
        System.out.print(MAP_EMPTY_SQUARE);
    }

    private void printUpperBridgeSquare(String square) {
        if (square.equals(U.toString())) {
            System.out.print(MAP_CORRECT_SQUARE);
            return;
        }
        System.out.print(MAP_EMPTY_SQUARE);
    }

    private void printLastUpperBridgeSquare(String LastSquare, GameStatus gameStatus) {
        if (LastSquare.equals(D.toString())) {
            System.out.print(MAP_EMPTY_SQUARE);
            System.out.println(MAP_END);
            return;
        }
        printWrongSquare(gameStatus);
        printCorrectSquare(gameStatus);
        System.out.println(MAP_END);
    }

    private void printLastLowerBridgeSquare(String LastSquare, GameStatus gameStatus) {
        if (LastSquare.equals(U.toString())) {
            printEmptySquare();
            System.out.println(MAP_END);
            return;
        }
        printWrongSquare(gameStatus);
        printCorrectSquare(gameStatus);
        System.out.println(MAP_END);
    }
}
