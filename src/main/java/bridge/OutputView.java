package bridge;

import java.util.ArrayList;
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
    public void printMap(List<String> bridge, int currentUserPosition, boolean isFail) {
        List<String> upperBridgeResult = getUpperBridgeResult(bridge, currentUserPosition, isFail);
        List<String> lowerBridgeResult = getLowerBridgeResult(bridge, currentUserPosition, isFail);
        printBridgeResult(upperBridgeResult);
        printBridgeResult(lowerBridgeResult);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, int currentUserPosition, boolean isFail) {
        System.out.println("최종 게임 결과");
        printMap(bridge, currentUserPosition, isFail);
    }

    public void printResultMessage(boolean gameWinStatus, int totalTryCount) {
        System.out.println("게임 성공 여부: " + getGameWinStatusMessage(gameWinStatus));
        System.out.println("총 시도한 횟수: " + totalTryCount);
    }

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printReadBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printReadMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printReadGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    private void printBridgeResult(List<String> bridgeResult) {
        System.out.println("[" + String.join("|", bridgeResult) + "]");
    }

    private List<String> getUpperBridgeResult(List<String> bridge, int currentUserPosition, boolean isFail) {
        List<String> upperBridgeResult = new ArrayList<>();
        for (int bridgeIndex = 0; bridgeIndex <= currentUserPosition; bridgeIndex++) {
            upperBridgeResult.add(compareBridgeBlock(bridge.get(bridgeIndex), "U"));
        }
        if (isFail) {
            upperBridgeResult.set(currentUserPosition, compareFailBridgeBlock(upperBridgeResult.get(currentUserPosition), isFail));
        }
        return upperBridgeResult;
    }

    private List<String> getLowerBridgeResult(List<String> bridge, int currentUserPosition, boolean isFail) {
        List<String> lowerBridgeResult = new ArrayList<>();
        for (int bridgeIndex = 0; bridgeIndex <= currentUserPosition; bridgeIndex++) {
            lowerBridgeResult.add(compareBridgeBlock(bridge.get(bridgeIndex), "D"));
        }
        if (isFail) {
            lowerBridgeResult.set(currentUserPosition, compareFailBridgeBlock(lowerBridgeResult.get(currentUserPosition), isFail));
        }
        return lowerBridgeResult;
    }

    private String compareBridgeBlock(String bridgeBlock, String comparatorBridgeBlock) {
        if (bridgeBlock.equals(comparatorBridgeBlock)) {
            return " O ";
        }
        return "   ";
    }

    private String compareFailBridgeBlock(String lastBridgeBlock, boolean isFail) {
        if (lastBridgeBlock.equals("   ") && isFail) {
            return " X ";
        }
        return "   ";
    }

    private String getGameWinStatusMessage(boolean gameWinStatus) {
        if (gameWinStatus) {
            return "성공";
        }
        return "실패";
    }
}
