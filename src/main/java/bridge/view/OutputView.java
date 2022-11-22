package bridge.view;

import bridge.domain.Player;

import static bridge.constant.ConsoleMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println(START_GAME.getMessage());
        printBlank();
    }

    public void printAskForBridgeSize() {
        System.out.println(ASK_FOR_BRIDGE_SIZE.getMessage());
    }

    public void printAskForStep() {
        System.out.println(ASK_FOR_USER_STEP.getMessage());
    }

    public void printAskForRetry() {
        System.out.println(ASK_FOR_RETRY.getMessage());
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        System.out.println(String.format("[ %s ]", String.join(" | ", player.getUpperFootPrint())));
        System.out.println(String.format("[ %s ]", String.join(" | ", player.getLowerFootPrint())));
        printBlank();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printResult(Player player) {
        System.out.println(FINAL_RESULT.getMessage());
        printMap(player);
        printGameSuccess(player);
        printTrials(player);
    }

    private void printBlank() {
        System.out.println();
    }

    private void printGameSuccess(Player player) {
        if (player.isSuccess()) {
            System.out.println(GAME_SUCCESS.getMessage());
        }

        if (!player.isSuccess()) {
            System.out.println(GAME_FAIL.getMessage());
        }
    }

    private void printTrials(Player player) {
        System.out.println(
                String.format(TOTAL_TRIALS.getMessage(), player.showTrials())
        );
    }
}
