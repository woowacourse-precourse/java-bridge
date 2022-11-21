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
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSizeInput = Console.readLine();
        try {
            validateBridgeSizeRange(Integer.parseInt(bridgeSizeInput));
            return Integer.parseInt(bridgeSizeInput);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(Error.ERROR_BRIDGE_LENGTH.getErrorMessage());
            return readBridgeSize();
        }
    }

    public void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalStateException();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputDirection = Console.readLine();
        try {
            validateMovingDirection(inputDirection);
            return inputDirection;
        } catch (IllegalStateException e) {
            System.out.println(Error.ERROR_MOVING.getErrorMessage());
            return readMoving();
        }
    }

    public void validateMovingDirection(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalStateException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        try {
            validateGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalStateException e) {
            System.out.println(Error.ERROR_RETRY.getErrorMessage());
            return readGameCommand();
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalStateException();
        }
    }
}
