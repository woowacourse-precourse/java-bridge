package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    /**
     * 게임 시작 메시지를 출력한다.
     */
    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 다리 길이를 입력받는 메시지를 출력한다.
     */
    public void printInputBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸을 입력받는 메시지를 출력한다.
     */
    public void printInputMove() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 게임을 다시 시도할지 여부 메시지를 출력한다.
     */
    public void printInputRetry() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> playerBridge, List<String> bridge) {
        printUpBridge(playerBridge, bridge);
        printDownBridge(playerBridge, bridge);
    }

    /**
     * 위쪽에 있는 다리 정보를 출력한다.
     *
     * @param playerBridge 플레이어 입력 정보
     * @param bridge       다리 정보
     */
    public void printUpBridge(List<String> playerBridge, List<String> bridge) {
        System.out.print("[");
        System.out.print(printUpBridgeCheck(playerBridge.get(0), bridge.get(0)));
        for (int i = 1; i < playerBridge.size(); i++) {
            System.out.print("|");
            System.out.print(printUpBridgeCheck(playerBridge.get(i), bridge.get(i)));
        }
        System.out.println("]");
    }

    /**
     * 아래쪽에 있는 다리 정보를 출력한다.
     *
     * @param playerBridge 플레이어 입력 정보
     * @param bridge       다리 정보
     */
    public void printDownBridge(List<String> playerBridge, List<String> bridge) {
        System.out.print("[");
        System.out.print(printDownBridgeCheck(playerBridge.get(0), bridge.get(0)));
        for (int i = 1; i < playerBridge.size(); i++) {
            System.out.print("|");
            System.out.print(printDownBridgeCheck(playerBridge.get(i), bridge.get(i)));
        }
        System.out.println("]");
    }

    /**
     * 위쪽에 있는 다리가 O인지 공백인지 체크한다.
     *
     * @param playerBlock
     * @param bridgeBlock
     */
    public String printUpBridgeCheck(String playerBlock, String bridgeBlock) {
        if (playerBlock.equals(bridgeBlock) && playerBlock.equals("U")) {
            return " O ";
        }
        if (playerBlock.equals(bridgeBlock) && playerBlock.equals("D")) {
            return "   ";
        }
        if (playerBlock.equals("U") && !playerBlock.equals(bridgeBlock)) {
            return " X ";
        }
        return "   ";
    }

    public String printDownBridgeCheck(String playerBlock, String bridgeBlock) {
        if (playerBlock.equals(bridgeBlock) && playerBlock.equals("D")) {
            return " O ";
        }
        if (playerBlock.equals(bridgeBlock) && playerBlock.equals("U")) {
            return "   ";
        }
        if (playerBlock.equals("D") && !playerBlock.equals(bridgeBlock)) {
            return " X ";
        }
        return "   ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
