package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        OutputView.messageGameStart();
        OutputView.messageInputBridge();
        int bridgelength = 0;
        try {
            bridgelength = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력하세요. (3~20)");
        }
        validateOfBridgeLength(bridgelength);
        return bridgelength;
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

    private void validateOfBridgeLength(int bridgelength) {
        if ((bridgelength < 3) || (bridgelength > 20)) {
            System.out.println("[ERROR] 올바른 범위의 값을 입력하세요. (3~20)");
            throw new IllegalArgumentException();
        }
    }

    }
