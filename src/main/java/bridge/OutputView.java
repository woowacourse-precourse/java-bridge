package bridge;

import static bridge.Const.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameHost gameHost) { // 여기서 player 위치는 index 로 따졌을 때 현재 위치인 것
        System.out.println(getPrintOfMap(gameHost, UP));
        System.out.println(getPrintOfMap(gameHost, DOWN));
        System.out.println();
    }

    private StringBuilder getPrintOfMap(GameHost gameHost, String position) {
        StringBuilder printOfMap = new StringBuilder();
        appendPastMap(gameHost, printOfMap, position);
        appendNowMap(gameHost, printOfMap, position);
        translateLastLetter(printOfMap);
        return printOfMap;
    }

    private void appendPastMap(GameHost gameHost, StringBuilder printOfMap, String position) {
        for (int index = 0; index < gameHost.getPlayerIndex(); index++) {
            if (gameHost.stepOfIndexInBridge(index).equals(position)) {
                printOfMap.append("| ").append("O ");
            }

            if (!gameHost.stepOfIndexInBridge(index).equals(position)) {
                printOfMap.append("| ").append("  ");
            }
        }
    }

    private void appendNowMap(GameHost gameHost, StringBuilder printOfMap,String position) {
        if (gameHost.getPlayerAlive()) { // 플레이어가 살아있을 떄
            appendNowMapWhenAlive(gameHost, printOfMap, position);
        }

        if (!gameHost.getPlayerAlive()) { // 플레이어가 죽었을 때
            appendNowMapWhenNotAlive(gameHost, printOfMap, position);
        }
    }

    private void appendNowMapWhenAlive(GameHost gameHost, StringBuilder printOfMap, String position) {
        if (gameHost.stepOfIndexInBridge(gameHost.getPlayerIndex()).equals(position)) {
            printOfMap.append("| ").append("O ");
        }

        if (!gameHost.stepOfIndexInBridge(gameHost.getPlayerIndex()).equals(position)) {
            printOfMap.append("| ").append("  ");
        }
    }

    private void appendNowMapWhenNotAlive(GameHost gameHost, StringBuilder printOfMap, String position) {
        if (gameHost.stepOfIndexInBridge(gameHost.getPlayerIndex()).equals(position)) {
            printOfMap.append("| ").append("  ");
        }

        if (!gameHost.stepOfIndexInBridge(gameHost.getPlayerIndex()).equals(position)) {
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
    public void printResult(GameHost gameHost) {
        printFinalMap(gameHost);
        printWhetherFailOrSuccess(gameHost);
        printNumberOfRetry(gameHost);
    }

    private void printFinalMap(GameHost gameHost) {
        System.out.println("최종 게임 결과");
        printMap(gameHost);
    }

    private void printWhetherFailOrSuccess(GameHost gameHost) {
        System.out.print("게임 성공 여부: ");
        System.out.println(gameHost.getResult());
    }

    private void printNumberOfRetry(GameHost gameHost) {
        System.out.print("총 시도한 횟수: ");
        System.out.println(gameHost.getRetry());
    }
}
