package bridge;

import static bridge.OutputMessage.START_MESSAGE;
import static bridge.OutputMessage.BRIDGE_SIZE_MESSAGE;
import static bridge.OutputMessage.CHOICE_REQUEST_MESSAGE;
import static bridge.OutputMessage.RESTART_OR_QUIT_MESSAGE;
import static bridge.OutputMessage.RESULT_MESSAGE;
import static bridge.OutputMessage.SUMMARY_MESSAGE;

import static bridge.BridgeGameConstants.NEW_LINE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map + NEW_LINE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String map, String passOrFail, int tryCount) {
        System.out.println(RESULT_MESSAGE);
        printMap(map);
        System.out.printf(SUMMARY_MESSAGE.toString(), passOrFail, tryCount);
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printBridgeSizeRequest() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public void printChoiceRequest() {
        System.out.println(CHOICE_REQUEST_MESSAGE);
    }

    public void printRestartOrQuit() {
        System.out.println(RESTART_OR_QUIT_MESSAGE);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printNewline() {
        System.out.println();
    }
}
