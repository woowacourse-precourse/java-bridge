package bridge.view;

import bridge.constant.Direction;
import bridge.util.BridgeGameStandard;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String DIRECTION_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    
    private static final String BRIDGE_SIZE_ERROR_MESSAGE = 
            "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVALID_DIRECTION_ERROR_MESSAGE =
            "[ERROR] 이동할 칸을 올바르게 선택해주세요.(위: U, 아래: D)";
    private static final String INVALID_GAME_COMMAND_ERROR_MESSAGE =
            "[ERROR] 게임을 다시 시도할지 여부를 올바르게 선택해주세요.(위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
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
    public Direction readMoving() {
        try {
            System.out.println(DIRECTION_INPUT_MESSAGE);
            String directcion = Console.readLine();
            validateDirectcion(directcion);
            return Direction.getDirection(directcion);
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
    public boolean readGameCommand() {
        try {
            System.out.println(GAME_COMMAND_INPUT_MESSAGE);
            String gameCommand = Console.readLine();
            validateGameCommand(gameCommand);
            return convertGameCommand(gameCommand);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR_MESSAGE);
        }
    }
    
    /**
     * R 또는 Q 문자열과 다르면 IllegalArgumentException을 발생시키는 메서드
     */
    private void validateGameCommand(String directcion) {
        if (!"R".equals(directcion) && !"Q".equals(directcion)) {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * R 또는 Q 문자열을 boolean 타입으로 변환하는 메서드
     */
    private boolean convertGameCommand(String directcion) {
        if (directcion.equals("Q")) {
            return false;
        }
        
        return true;
    }
}
