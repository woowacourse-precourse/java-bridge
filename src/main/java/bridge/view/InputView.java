package bridge.view;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_INPUT_MSG);
        int result = BRIDGE_LENGTH_INPUT_ERROR;
        while (result == BRIDGE_LENGTH_INPUT_ERROR) {
            result = tryBridgeSizeInput();
        }
        return result;
    }

    private int tryBridgeSizeInput() {
        try {
            String bridgeLengthInput = Console.readLine();
            Validation.checkBridgeSizeInput(bridgeLengthInput);
            return Integer.parseInt(bridgeLengthInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return BRIDGE_LENGTH_INPUT_ERROR;
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

}
