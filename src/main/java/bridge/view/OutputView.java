package bridge.view;

import bridge.domain.BridgeGame;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP_PATH = "U";
    private static final String DOWN_PATH = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userPaths, boolean recentRoundResult) {
        printUpTunnel(userPaths, recentRoundResult);
        printDownTunnel(userPaths, recentRoundResult);
    }

    // 위 통로를 출력하는 함수
    private void printUpTunnel(List<String> userPaths, boolean recentResult) {
        String upTunnel = "[";
        int index = 0;
        for ( ; index < userPaths.size() - 1; index++) {
            String tmpPath = userPaths.get(index);
            upTunnel += getSquareResult(tmpPath, UP_PATH);
        }
        upTunnel += getLastSquareResult(userPaths.get(index), UP_PATH, recentResult);

        System.out.println(upTunnel);
    }

    // 아래 통로를 출력하는 함수
    private void printDownTunnel(List<String> userPaths, boolean recentResult) {
        String downTunnel = "[";
        for (int i = 0 ; i < userPaths.size() - 1; i++) {
            String tmpPath = userPaths.get(i);
            downTunnel += getSquareResult(tmpPath, DOWN_PATH);
        }
        downTunnel += getLastSquareResult(userPaths.get(userPaths.size() - 1), DOWN_PATH, recentResult);

        System.out.println(downTunnel);
    }

    // 하나의 칸을 문자열로 반환하는 함수
    private String getSquareResult(String userPath, String correctPath) {
        String outputPath = "   |";
        if (userPath.equals(correctPath)) {
            outputPath = " O |";
        }

        return outputPath;
    }

    private String getLastSquareResult(String lastUserPath, String lastBridgePath, boolean recentResult) {
        if (lastUserPath.equals(lastBridgePath)) {
            if (recentResult == true) {
                return " O ]";
            }
            return " X ]";
        }

        return "   ]";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean lastRoundResult) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getPassedPaths(), lastRoundResult);
        printNewLine();
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

    private void printNewLine() {
        System.out.println();
    }
}
