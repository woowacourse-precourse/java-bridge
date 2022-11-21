package bridge;

import static constant.Values.Message.*;

import constant.Values.BridgeCase;
import constant.Values.MoveCase;
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
        List<MoveCase> result = bridgeGame.getResults();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(BRIDGE_OPEN.getMessage());
        appendUpBridge(stringBuffer, result);
        stringBuffer.append("\n" + BRIDGE_OPEN.getMessage());
        appendDownBridge(stringBuffer, result);
        return stringBuffer.toString();
    }

    public void appendUpBridge(StringBuffer stringBuffer, List<MoveCase> result) {
        for (int index = 0; index < result.size(); ++index) {
            stringBuffer.append(result.get(index).getUp());
            stringBuffer.append(BRIDGE_SPLIT.getMessage());
        }
        stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
        stringBuffer.append(BRIDGE_CLOSE.getMessage());
    }

    public void appendDownBridge(StringBuffer stringBuffer, List<MoveCase> result) {
        for (int index = 0; index < result.size(); ++index) {
            stringBuffer.append(result.get(index).getDown());
            stringBuffer.append(BRIDGE_SPLIT.getMessage());
        }
        stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
        stringBuffer.append(BRIDGE_CLOSE.getMessage());
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
        System.out.println("\n" + GAME_RESULT.getMessage());
        printMap(bridgeGame);
    }

    public void printGameSuccess(boolean result) {
        System.out.println(
                "\n" + String.format(GAME_SUCCESS.getMessage(), BridgeCase.findByResult(result).getMessage()));
    }

    public void printGameTry(BridgeGame bridgeGame) {
        System.out.println(String.format(GAME_TRY.getMessage(), bridgeGame.getGameTry()));
    }

    public void printErrorMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println("\n" + String.format(ERROR_MESSAGE.getMessage(), illegalArgumentException.getMessage()));
    }

}
