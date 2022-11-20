package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View {

    private static final String ERROR_NUMBER_FORMAT = "숫자 형태로 입력해주세요.";
    private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_MOVING_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        print(REQUEST_BRIDGE_SIZE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
        }
    }

    public String readMoving() {
        print(REQUEST_MOVING_COMMAND);
        return Console.readLine();
    }

    public String readGameCommand() {
        print(REQUEST_RETRY_COMMAND);
        return Console.readLine();
    }
}
