package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView outputView = new OutputView();
    private final Exception exception = new Exception();

    public int readBridgeSize() {
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    // 검증 메소드
    private void validateBridgeSize(String input) {
        int bridgeSize = 0;
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (NumberFormatException e){
            exception.exceptionBridgeSize();
        }

        if (bridgeSize < 3 || bridgeSize > 20){
            exception.exceptionBridgeSize();
        }
    }
}
