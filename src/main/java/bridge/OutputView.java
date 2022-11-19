package bridge;

import static constant.Values.Message.*;

import constant.Values.BridgeCase;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println(GAME_START.getMessage());
    }

    public void printInputSize() {
        System.out.println("\n" + INPUT_SIZE.getMessage());
    }

    public void printSelectMove() {
        System.out.println("\n" + SELECT_MOVE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(makeMap(bridgeGame));
    }

    public String makeMap(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        List<String> moves = bridgeGame.getMoves();
        StringBuffer stringBuffer = new StringBuffer(BRIDGE_OPEN.getMessage());
        for(int index=0;index<bridge.size();++index) {

        }
        return "";
    }

    public void appendUpBridge(boolean equals,String value) {

    }

    public void printSelectRetry() {
        System.out.println("\n" + SELECT_RETRY.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        printMap(bridgeGame);
    }

    public void printGameSuccess(BridgeCase bridgeCase) {
        System.out.println("\n" + String.format(GAME_SUCCESS.getMessage(), bridgeCase.getMessage()));
    }

    public void printGameTry(int tryCount) {
        System.out.println("\n" + String.format(GAME_TRY.getMessage(), tryCount));
    }

    public void printErrorMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println("\n" + String.format(ERROR_MESSAGE.getMessage(), illegalArgumentException.getMessage()));
    }

}
