package bridge.ui;

import bridge.domain.BridgeGameHost;
import bridge.domain.Player;

import static bridge.constant.Const.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printOpeningPhrase() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printRequestBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printRequestMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGameHost bridgeGameHost) { // 여기서 player 위치는 index 로 따졌을 때 현재 위치인 것
        System.out.println(getPrintOfMap(bridgeGameHost, UP));
        System.out.println(getPrintOfMap(bridgeGameHost, DOWN));
        System.out.println();
    }

    private StringBuilder getPrintOfMap(BridgeGameHost bridgeGameHost, String position) {
        StringBuilder printOfMap = new StringBuilder();
        appendPastMap(bridgeGameHost, printOfMap, position);
        appendNowMap(bridgeGameHost, printOfMap, position);
        translateLastLetter(printOfMap);
        return printOfMap;
    }

    private void appendPastMap(BridgeGameHost bridgeGameHost, StringBuilder printOfMap, String position) {
        for (int index = 0; index < Player.getIndex(); index++) {
            if (bridgeGameHost.stepOfIndexInBridge(index).equals(position)) {
                printOfMap.append("| ").append("O ");
            }

            if (!bridgeGameHost.stepOfIndexInBridge(index).equals(position)) {
                printOfMap.append("| ").append("  ");
            }
        }
    }

    private void appendNowMap(BridgeGameHost bridgeGameHost, StringBuilder printOfMap, String position) {
        if (Player.getAlive()) { // 플레이어가 살아있을 떄
            appendNowMapWhenAlive(bridgeGameHost, printOfMap, position);
        }

        if (!Player.getAlive()) { // 플레이어가 죽었을 때
            appendNowMapWhenNotAlive(bridgeGameHost, printOfMap, position);
        }
    }

    private void appendNowMapWhenAlive(BridgeGameHost bridgeGameHost, StringBuilder printOfMap, String position) {
        if (bridgeGameHost.stepOfIndexInBridge(Player.getIndex()).equals(position)) {
            printOfMap.append("| ").append("O ");
        }

        if (!bridgeGameHost.stepOfIndexInBridge(Player.getIndex()).equals(position)) {
            printOfMap.append("| ").append("  ");
        }
    }

    private void appendNowMapWhenNotAlive(BridgeGameHost bridgeGameHost, StringBuilder printOfMap, String position) {
        if (bridgeGameHost.stepOfIndexInBridge(Player.getIndex()).equals(position)) {
            printOfMap.append("| ").append("  ");
        }

        if (!bridgeGameHost.stepOfIndexInBridge(Player.getIndex()).equals(position)) {
            printOfMap.append("| ").append("X ");
        }
    }

    private void translateLastLetter(StringBuilder printOfMap) {
        printOfMap.setCharAt(0, '[');
        printOfMap.append("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameHost bridgeGameHost) {
        printFinalMap(bridgeGameHost);
        printWhetherFailOrSuccess(bridgeGameHost);
        printNumberOfRetry(bridgeGameHost);
    }

    private void printFinalMap(BridgeGameHost bridgeGameHost) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGameHost);
    }

    private void printWhetherFailOrSuccess(BridgeGameHost bridgeGameHost) {
        System.out.print("게임 성공 여부: ");
        System.out.println(bridgeGameHost.getResult());
    }

    private void printNumberOfRetry(BridgeGameHost bridgeGameHost) {
        System.out.print("총 시도한 횟수: ");
        System.out.println(Player.getNumberOfRetry());
    }
}
