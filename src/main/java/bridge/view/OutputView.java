package bridge.view;

import bridge.enums.KeyboardCommand;
import bridge.enums.OutputMessage;

import java.security.Key;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String upSideIndex = "";
    private String downSideIndex = "";

    public void printStartMessage() {
        System.out.println(OutputMessage.GAME_START_MESSAGE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int count, String moving, boolean isPass) {
        if (moving.equals(KeyboardCommand.UP.getCommand())) {
            setUpSideIndex(count, isPass);
        }
        if (moving.equals(KeyboardCommand.DOWN.getCommand())) {
            setDownSideIndex(count, isPass);
        }
        System.out.println("[" + upSideIndex + "]");
        System.out.println("[" + downSideIndex + "]");
    }

    public void setUpSideIndex(int count, boolean isPass) {
        if (isPass) {
            upSideIndex += addDelimiter(count) + OutputMessage.SUCCESS.getValue();
            downSideIndex += addDelimiter(count) + OutputMessage.NOTHING.getValue();
            return;
        }
        upSideIndex += addDelimiter(count) + OutputMessage.FAILURE.getValue();
        downSideIndex += addDelimiter(count) + OutputMessage.NOTHING.getValue();
    }

    public void setDownSideIndex(int count, boolean isPass) {
        if (isPass) {
            upSideIndex += addDelimiter(count) + OutputMessage.NOTHING.getValue();
            downSideIndex += addDelimiter(count) + OutputMessage.SUCCESS.getValue();
            return;
        }
        upSideIndex += addDelimiter(count) + OutputMessage.NOTHING.getValue();
        downSideIndex += addDelimiter(count) + OutputMessage.FAILURE.getValue();
    }

    public String addDelimiter(int count) {
        if (count > 1) {
            return OutputMessage.DELIMITER.getValue();
        }
        return OutputMessage.NO_DELIMITER.getValue();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int totalNumberOfAttempts) {
        System.out.println(OutputMessage.GAME_RESULT_MESSAGE.getMessage());
        String result = OutputMessage.FAILURE.getMessage();
        if (isSuccess) {
            result = OutputMessage.SUCCESS.getMessage();
        }
        System.out.println(OutputMessage.GAME_SUCCESS_OR_FAILURE.getMessage() + result);
        System.out.println(OutputMessage.TOTAL_ATTEMPTS.getMessage() + totalNumberOfAttempts);
    }
}
