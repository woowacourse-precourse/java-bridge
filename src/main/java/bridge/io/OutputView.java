package bridge.io;

import bridge.validator.MoveType;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final TileView tileView = new TileView();

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
        tileView.printTiles(bridge, userMoving, MoveType.UP_MOVING.getValue());
        printRightWall();
    }

    private void printLowerMap(List<String> bridge, List<String> userMoving) {
        printLeftWall();
        tileView.printTiles(bridge, userMoving, MoveType.DOWN_MOVING.getValue());
        printRightWall();
    }

    private void printLeftWall() {
        System.out.print("[");
    }

    private void printRightWall() {
        System.out.println("]");
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
