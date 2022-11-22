package bridge.view;

import bridge.domain.BridgeState;
import bridge.service.BridgeGame;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String GAME_END_MESSAGE = "최종 게임 결과";
    public static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    public static final String GAME_TRIAL_MESSAGE = "총 시도한 횟수: ";

    public static final String SUCCESS_MESSAGE = "성공";
    public static final String FAIL_MESSAGE = "실패";

    private static final String STRING_OPENER = "[ ";
    private static final String STRING_CLOSER = " ]";
    private static final String DELIMITER = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeState bridgeState) {
        printMessage(convertBridgeToString(bridgeState.getUpperBridge()));
        printMessage(convertBridgeToString(bridgeState.getLowerBridge()));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        printMessage(GAME_END_MESSAGE);
        printMessage(convertBridgeToString(bridgeGame.getBridgeState().getUpperBridge()));
        printMessage(convertBridgeToString(bridgeGame.getBridgeState().getLowerBridge()));
        printMessage(GAME_RESULT_MESSAGE + getResultMessage(bridgeGame));
        printMessage(GAME_TRIAL_MESSAGE + bridgeGame.getTrial());
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private String getResultMessage(BridgeGame bridgeGame) {
        if (bridgeGame.canContinue()) {
            return FAIL_MESSAGE;
        }
        return SUCCESS_MESSAGE;
    }

    private String convertBridgeToString(List<String> bridge) {
        StringBuilder sb = new StringBuilder();
        sb.append(STRING_OPENER);
        sb.append(bridge.stream().collect(Collectors.joining(DELIMITER)));
        sb.append(STRING_CLOSER);
        return sb.toString();
    }
}
