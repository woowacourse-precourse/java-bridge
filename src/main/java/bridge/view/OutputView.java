package bridge.view;

import static bridge.constant.InformationMessage.*;

import bridge.constant.InformationMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printRequestBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public void printRequestBridgeMarkToMove() {
        System.out.println(INPUT_BRIDGE_MARK_TO_MOVE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String resultMap) {
        System.out.println(resultMap);
    }

    public void printRequestRetryCommand() {
        System.out.println(INPUT_BRIDGE_MOVE_RETRY);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String resultMap, boolean success, int gamePlayCount) {
        System.out.println(GAME_RESULT_HEADER);
        printMap(resultMap);
        String resultMessage = "실패";
        if(success) {
            resultMessage = "성공";
        }
        System.out.printf(GAME_RESULT_IS_SUCCESS_GAME, resultMessage);
        System.out.printf(GAME_RESULT_PLAY_COUNT, gamePlayCount);
    }
}
