package bridge.view;

import static bridge.util.ConsoleInput.readInt;

import bridge.model.BridgeSize;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            printReadBridgeSizeMenu();
            return new BridgeSize(readInt()).intValue();
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            return readBridgeSize();
        }
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

    private void printReadBridgeSizeMenu() {
        print("다리 길이를 입력해 주세요.");
    }

    private void print(String message) {
        System.out.println(message);
    }
}
