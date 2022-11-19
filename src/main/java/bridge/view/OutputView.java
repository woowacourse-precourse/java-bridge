package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_SUCCESS_WHETHER = "게임 성공 여부: ";
    private static final String GAME_ATTEMPT_COUNT = "총 시도한 횟수: ";
    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAILURE = "실패";
    private static final String START_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String BRIDGE_DIVISION = " | ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> lowBridge, List<String> highBridge) {
        System.out.println(formatBridge(highBridge, new StringBuilder()));
        System.out.println(formatBridge(lowBridge, new StringBuilder()));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Integer attemptNumber, boolean isSuccess) {
        System.out.println(GAME_SUCCESS_WHETHER + successOrNot(isSuccess));
        System.out.println(GAME_ATTEMPT_COUNT + attemptNumber);
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    private String successOrNot(boolean success) {
        if (success) {
            return GAME_SUCCESS;
        }
        return GAME_FAILURE;
    }

    private String formatBridge(List<String> bridge, StringBuilder sb) {
        sb.append(START_BRIDGE);
        for (String bridgeStatus : bridge) {
            sb.append(bridgeStatus);
            sb.append(BRIDGE_DIVISION);
        }
        sb.setLength(sb.length() - BRIDGE_DIVISION.length());
        sb.append(END_BRIDGE);
        return sb.toString();
    }

    public void printErrorMessage(Exception e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }
}
