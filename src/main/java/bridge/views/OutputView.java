package bridge.views;

import static bridge.messages.OutputMessage.ATTEMPTS_NUMBER;
import static bridge.messages.OutputMessage.FINISH_GAME_RESULT;
import static bridge.messages.OutputMessage.START_MESSAGE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final String movingResultMap) {
        System.out.println(movingResultMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final String movedMessage, final int gameCount) {
        System.out.println(FINISH_GAME_RESULT);
        System.out.println(movedMessage);
        System.out.println(ATTEMPTS_NUMBER + gameCount);
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}
