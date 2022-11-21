package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        boolean validBridgeSize = false;
        String inputBridgeSize = null;

        while (!validBridgeSize) {
            System.out.println("다리의 길이를 입력해주세요.");
            inputBridgeSize = Console.readLine();
            validBridgeSize = isValidBridgeSize(inputBridgeSize);
        }

        return Integer.parseInt(inputBridgeSize);
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

    private boolean isValidBridgeSize(String bridgeSize) {
        try {
            validateInteger(bridgeSize);
            validateBridgeSizeRange(Integer.parseInt(bridgeSize));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void validateInteger(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize >= BRIDGE_SIZE_MIN && bridgeSize >= BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidMoveCommand(String command) {

    }

    private void validateOneWord() {

    }

    private void validateFormat() {

    }
}
