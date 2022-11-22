package bridge.view;

import bridge.enums.OutputViewMessage;
import bridge.model.BridgeStatusModel;
import bridge.model.GameResultModel;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 패키지 변경가능
 * 매서드 이름 변경 불가, 인자와 반환 타입은 추가, 변경 가능
 * 매서드 추가 가능
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeStatusModel bridgeStatusModel) {
        System.out.println(bridgeStatusModel.getCurrentBridge());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResultModel gameResultModel) {
        printGameResultBridge(gameResultModel.getResultBridge());
        printGameSuccessOrFailure(gameResultModel.isSuccess());
        printGamePlaytime(gameResultModel.getPlaytime());
    }

    public void printStart() {
        System.out.println(OutputViewMessage.GAME_START.getMessage());
    }

    public void printBridgeLengthRequest() {
        System.out.println(OutputViewMessage.INPUT_BRIDGE_LENGTH.getMessage());
    }

    public void printUserMoveRequest() {
        System.out.println(OutputViewMessage.SELECT_BRIDGE_LOCATION.getMessage());
    }

    public void printGameRestartRequest() {
        System.out.println(OutputViewMessage.SELECT_GAME_RESTART.getMessage());
    }

    private void printGameResultBridge(String resultBridge) {
        System.out.println(OutputViewMessage.GAME_RESULT.getMessage());
        System.out.println(resultBridge);
    }

    private void printGameSuccessOrFailure(boolean result) {
        System.out.print(OutputViewMessage.GAME_SUCCESS_OR_FAILURE.getMessage());
        if (result) {
            System.out.println(OutputViewMessage.SUCCESS.getMessage());
            return;
        }
        System.out.println(OutputViewMessage.FAILURE.getMessage());
    }

    private void printGamePlaytime(int playtime) {
        System.out.print(OutputViewMessage.GAME_PLAYTIME.getMessage());
        System.out.println(playtime);
    }
}
