package bridge.io;

import bridge.validator.MovingType;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> userMoving) {
        printUpperMap(bridge, userMoving);
        printLowerMap(bridge, userMoving);
    }

    private void printUpperMap(List<String> bridge, List<String> userMoving) {
        printLeftWall();
        printTiles(bridge, userMoving, MovingType.UP_MOVING.getValue());
        printRightWall();
    }

    private void printLowerMap(List<String> bridge, List<String> userMoving) {
        printLeftWall();
        printTiles(bridge, userMoving, MovingType.DOWN_MOVING.getValue());
        printRightWall();
    }

    private void printLeftWall() {
        System.out.print("[");
    }

    private void printRightWall() {
        System.out.println("]");
    }

    private void printTiles(List<String> bridge, List<String> userMoving, String direction) {
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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> userMoving, int attemptCount) {
        System.out.println();
        System.out.println(OutputText.GAME_END.getOutputText());

        printMap(bridge, userMoving);
        printGameInfo(bridge, userMoving, attemptCount);
    }

    private void printGameInfo(List<String> bridge, List<String> userMoving, int attemptCount) {
        System.out.println();
        printGameResult(bridge, userMoving);
        printAttemptNum(attemptCount);
    }

    private void printGameResult(List<String> bridge, List<String> userMoving) {
        boolean gameClear = isGameClear(bridge, userMoving);

        String gameResultMsg = OutputText.getGameResultMsg(gameClear);
        System.out.println(gameResultMsg);
    }

    private boolean isGameClear(List<String> bridge, List<String> userMoving) {
        return (bridge.size() == userMoving.size()) &&
                (bridge.get(bridge.size() - 1).equals(userMoving.get(userMoving.size() - 1)));
    }

    private static void printAttemptNum(int attemptCount) {
        String attemptStr = String.format(OutputText.ATTEMPT.getOutputText(), attemptCount);
        System.out.println(attemptStr);
    }
}
