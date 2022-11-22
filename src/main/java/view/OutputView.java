package view;

import bridge.BridgeGame;
import bridge.GameStatus;
import bridge.command.MoveCommand;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String FINAL_RESULT = "최종 게임 결과";
    public static final String IS_CLEAR = "게임 성공 여부: ";
    public static final String TOTAL_NUMBER_ATTEMPTS = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        List<String> movingPosition = bridgeGame.getMovingPositions();
        List<String> result = bridgeGame.getResult();
        printTopPositionBridge(movingPosition, result);
        printLowPositionBridge(movingPosition, result);
        System.out.println();
    }

    private static void printTopPositionBridge(List<String> movingPosition, List<String> result) {
        for (int i = 0; i < result.size(); i++) {
            printLeftFrame(result, i);
            printTopOX(movingPosition, result, i);
            printSeparator(result, i);
            printRightFrame(result, i);
        }
    }

    private static void printTopOX(List<String> movingPosition, List<String> result, int i) {
        if (Objects.equals(movingPosition.get(i), MoveCommand.UP.getCommand())) {
            System.out.print(" " + result.get(i) + " ");
        }
        if (!Objects.equals(movingPosition.get(i), MoveCommand.UP.getCommand())) {
            System.out.print(" " + " " + " ");
        }
    }

    private static void printLowPositionBridge(List<String> movingPosition, List<String> result) {
        for (int i = 0; i < result.size(); i++) {
            printLeftFrame(result, i);
            printLowOX(movingPosition, result, i);
            printSeparator(result, i);
            printRightFrame(result, i);
        }
    }

    private static void printLowOX(List<String> movingPosition, List<String> result, int i) {
        if (Objects.equals(movingPosition.get(i), MoveCommand.DOWN.getCommand())) {
            System.out.print(" " + result.get(i) + " ");
        }
        if (!Objects.equals(movingPosition.get(i), MoveCommand.DOWN.getCommand())) {
            System.out.print(" " + " " + " ");
        }
    }

    private static void printSeparator(List<String> result, int i) {
        if (i != result.size() - 1) {
            System.out.print("|");
        }
    }

    private static void printLeftFrame(List<String> result, int i) {
        if (i == 0) {
            System.out.print("[");
        }
    }
    private static void printRightFrame(List<String> result, int i) {
        if (i == result.size() - 1) {
            System.out.println("]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame, GameStatus gameStatus) {
        printFinalBridge(bridgeGame);
        printSuccessStatus(gameStatus);
        System.out.println(TOTAL_NUMBER_ATTEMPTS + bridgeGame.getCount());
    }

    private static void printFinalBridge(BridgeGame bridgeGame) {
        System.out.println(FINAL_RESULT);
        printMap(bridgeGame);
    }

    private static void printSuccessStatus(GameStatus gameStatus) {
        System.out.print(IS_CLEAR);
        if (gameStatus.isFailure()) {
            System.out.println("실패");
        }
        if (!gameStatus.isFailure()) {
            System.out.println("성공");
        }
    }
}
