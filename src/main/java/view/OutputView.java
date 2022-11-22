package view;

import bridge.BridgeGame;
import response.UserInputException;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame game) {
        StringBuilder topBridge = initTopBridge();
        StringBuilder bottomBridge = initBottomBridge();

        topBridge = printTopBridgeStatus(game, topBridge);
        bottomBridge = printBottomBridgeStatus(game, bottomBridge);

        System.out.println(closeTopBridge(topBridge));
        System.out.println(closeBottomBridge(bottomBridge));
        System.out.println();
    }

    /**
     * printMap을 위한 methods
     * initTopBridge(),initBottomBridge() - 위, 아래 두개의 다리 시작("[")
     * closeTopBridge(), closeBottomBridge() - 위, 아래 두개의 다리 끝("]")
     * printBridgeMapStatus() - 사용자 입력 다리 현 상태 출력
     */
    private StringBuilder initTopBridge() {
        StringBuilder topBridge = new StringBuilder();
        topBridge.append("[");

        return topBridge;
    }

    private StringBuilder initBottomBridge() {
        StringBuilder bottomBridge = new StringBuilder();
        bottomBridge.append("[");

        return bottomBridge;
    }

    private String closeTopBridge(StringBuilder topBridge) {
        topBridge.deleteCharAt(topBridge.length() - 1);
        topBridge.append("]");

        return topBridge.toString();
    }

    private String closeBottomBridge(StringBuilder bottomBridge) {
        bottomBridge.deleteCharAt(bottomBridge.length() - 1);
        bottomBridge.append("]");

        return bottomBridge.toString();
    }

    /**
     *  printTopBridgeStatus, printBottomBridgeStatus
     *  - 사용자 입력에 맞게 그 결과 StringBuilder에 append
     *  getTopStringByStatus, getBottomStringByStatus
     *  - 사용자 입력과 실제 다리 비교해서 그 결과 String 반환
     */

    private StringBuilder printTopBridgeStatus(BridgeGame game, StringBuilder topBridge) {
        for (int i = 0; i < game.getUserInput().size(); i++) {
            String appendTarget = getTopStringByStatus(game.getBridge().get(i), game.getUserInput().get(i));

            topBridge.append(appendTarget);
        }
        return topBridge;
    }

    private StringBuilder printBottomBridgeStatus(BridgeGame game, StringBuilder bottomBridge) {
        for (int i = 0; i < game.getUserInput().size(); i++) {
            String appendTarget = getBottomStringByStatus(game.getBridge().get(i), game.getUserInput().get(i));

            bottomBridge.append(appendTarget);
        }
        return bottomBridge;
    }


    private String getTopStringByStatus(String bridge, String user) {
        if (user.equals("U") && bridge.equals("U")) {
            return " O |";
        }
        if (user.equals("U") && bridge.equals("D")) {
            return " X |";
        }
        return "   |";
    }

    private String getBottomStringByStatus(String bridge, String user) {
        if (user.equals("D") && bridge.equals("D")) {
            return " O |";
        }
        if (user.equals("D") && bridge.equals("U")) {
            return " X |";
        }
        return "   |";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game, boolean successOrNot) {
        System.out.println("최종 게임 결과");

        printMap(game);

        if (successOrNot) {
            printSuccessMessage(game.getTrialCount());
            return;
        }

        printFailureMessage(game.getTrialCount());
        System.out.println();
    }

    /**
     * Print Game Result Message
     */
    private void printSuccessMessage(int trial) {
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: "+ trial);
    }

    private void printFailureMessage(int trial) {
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + trial);
    }

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * Print Exception Message
     */
    public void printUserInputExceptionMessage(UserInputException userInputException) {
        System.out.println(userInputException.getMessage());
    }


    /**
     * Print User Input Request Message
     */
    public void printBridgeSizeRequestMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovementRequestMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printExitCodeRequestMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

}
