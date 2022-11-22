package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Path;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP_PATH = Path.U.name();
    private static final String DOWN_PATH = Path.D.name();

    public void printGameMessage(String message) {
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printUpTunnel(bridgeGame.getUserPaths(), bridgeGame.getLastRoundResult());
        printDownTunnel(bridgeGame.getUserPaths(), bridgeGame.getLastRoundResult());
        printNewLine();
    }

    // 위 통로를 출력하는 함수
    private void printUpTunnel(List<String> userPaths, boolean lastRoundResult) {
        String upTunnel = "[ ";
        for (int i = 0; i < userPaths.size() - 1; i++) {
            String userPath = userPaths.get(i);
            upTunnel += Square.getSquareResult(userPath, UP_PATH) + " | ";
        }
        upTunnel += Square.getLastSquareResult(userPaths.get(userPaths.size() - 1), UP_PATH, lastRoundResult);

        System.out.println(upTunnel);
    }

    // 아래 통로를 출력하는 함수
    private void printDownTunnel(List<String> userPaths, boolean lastRoundResult) {
        String downTunnel = "[ ";
        for (int i = 0; i < userPaths.size() - 1; i++) {
            String userPath = userPaths.get(i);
            downTunnel += Square.getSquareResult(userPath, DOWN_PATH) + " | ";
        }
        downTunnel += Square.getLastSquareResult(userPaths.get(userPaths.size() - 1), DOWN_PATH, lastRoundResult);

        System.out.println(downTunnel);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        printSuccessOrFailure(bridgeGame);
        printTryCount(bridgeGame.getTryCount());
    }

    private void printSuccessOrFailure(BridgeGame bridgeGame) {
        if (bridgeGame.doesCrossedBridge()) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }

        System.out.println("게임 성공 여부: 실패");
    }

    private void printTryCount(int tryCount) {
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printNewLine() {
        System.out.println();
    }
}
