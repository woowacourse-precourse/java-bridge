package bridge;

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
    public void printMap(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        List<String> playerCommand = bridgeGame.getPlayerCommand();

        printRow(bridge, playerCommand, "U");
        printRow(bridge, playerCommand, "D");
    }

    private void printRow(List<String> bridge, List<String> playerCommand, String row) {
        System.out.print("[");
        for (int i = 0; i < playerCommand.size(); i++) {
            printStep(bridge.get(i), playerCommand.get(i), row);
            if (i + 1 != playerCommand.size()) {
                System.out.print("|");
            }
        }
        System.out.println("]");
    }

    private void printStep(String bridgeCommand, String playerCommand, String row){
        if (playerCommand.equals(row)) {
            if (playerCommand.equals(bridgeCommand)) {
                System.out.print(" O ");
            }
            if (!playerCommand.equals(bridgeCommand)) {
                System.out.print(" X ");
            }
        }
        if (!playerCommand.equals(row)) System.out.print("   ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.printf("게임 성공 여부: %s\n", bridgeGame.getStatus());
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getNumberOfTry());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
