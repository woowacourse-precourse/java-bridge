package bridge.view;

import bridge.domain.BridgeGame;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printIntro() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printRequestBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printRequestMove() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> upperBridge = setBridge(bridgeGame.getMark(), "U");
        List<String> loserBridge = setBridge(bridgeGame.getMark(), "D");

        if (!bridgeGame.checkPassable()) {
            setImpassable(upperBridge, loserBridge);
        }
        printBridge(upperBridge);
        printBridge(loserBridge);
    }

    private void printBridge(List<String> bridge) {
        System.out.print("[ ");
        for (int i = 0; i < bridge.size(); i++) {
            System.out.print(bridge.get(i));
            if (i == bridge.size() - 1) {
                break;
            }
            System.out.print(" | ");
        }
        System.out.println(" ]");
    }

    private void setImpassable(List<String> upperBridge, List<String> lowerBridge) {
        int lastIndex = upperBridge.size() - 1;

        if (upperBridge.get(lastIndex).equals("O")) {
            upperBridge.set(lastIndex, "X");
            return;
        }
        lowerBridge.set(lastIndex, "X");
    }

    private List<String> setBridge(List<String> mark, String which) {
        List<String> bridge = new ArrayList<>();

        for (String i : mark) {
            if (i.equals(which)) {
                bridge.add("O");
                continue;
            }
            bridge.add(" ");
        }
        return bridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        String result = "실패";
        if (bridgeGame.gameComplete()) {
            result = "성공";
        }
        System.out.println("\n게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + bridgeGame.getChallenge());
    }

    public void printError() {
        System.out.println(ExceptionView.message);
    }
}
