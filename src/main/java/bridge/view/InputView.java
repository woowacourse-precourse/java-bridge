package bridge.view;

import bridge.util.BridgeGameStandard;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVALID_DIRECTION_ERROR_MESSAGE = "[ERROR] 이동할 칸을 올바르게 선택해주세요.(위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            validateInteger(input);
            int convertedInput = Integer.parseInt(input);
            validateBridgeSize(convertedInput);
            return convertedInput;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }

    /**
     * 정수로 변환할 수 없으면 IllegalArgumentException을 발생시키는 메서드
     */
    private void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * 다리 길이가 유효하지 않으면 IllegalArgumentException을 발생시키는 메서드
     */
    private void validateBridgeSize(int bridgeSize) {
        BridgeGameStandard bridgeGameStandard = new BridgeGameStandard();

        if (!bridgeGameStandard.isValidBridgeSize(bridgeSize)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String directcion = Console.readLine();
            validateDirectcion(directcion);
            return directcion;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(INVALID_DIRECTION_ERROR_MESSAGE);
        }
    }
    
    /**
     * U 또는 D 문자열과 다르면 IllegalArgumentException을 발생시키는 메서드
     */
    private void validateDirectcion(String directcion) {
        if (!"U".equals(directcion) && !"D".equals(directcion)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
