package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = inputContent(InputViewData.BRIDGE_LENGTH);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return inputContent(InputViewData.MOVING_ROUTE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return inputContent(InputViewData.RETRY);
    }

    private String inputContent(InputViewData data) {
        try {
            return tryInputContent(data);
        } catch (IllegalArgumentException exception) {
            System.out.println(data.getErrorMessage());
            return inputContent(data);
        }
    }

    private String tryInputContent(InputViewData data) {
        System.out.println(data.getRequestMessage());
        String input = Console.readLine();

        if (!data.isCorrect(input)) {
            throw new IllegalArgumentException(data.getErrorMessage());
        }
        return input;
    }
}
