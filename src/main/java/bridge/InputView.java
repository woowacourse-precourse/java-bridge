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
        while(true) {
            try {
                return getBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeRange(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NotNumberFormat.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true) {
            try {
                return getMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String userMovement = Console.readLine();

        validateUserMovement(userMovement);

        return userMovement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true) {
            try {
                return getCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String userCommand = Console.readLine();

        validateUserCommand(userCommand);

        return userCommand;
    }

    private void validateBridgeRange(int bridgeSize) {
        if(bridgeSize < 3 || 20 < bridgeSize) {
            throw new IllegalArgumentException(ErrorMessage.NotValidBridgeSize.getMessage());
        }
    }

    private void validateUserMovement(String userMovement) {
        if(! (userMovement.equals(Command.UP.getValue()) || userMovement.equals(Command.DOWN.getValue()))) {
            throw new IllegalArgumentException(ErrorMessage.NotValidUserMovement.getMessage());
        }
    }

    private void validateUserCommand(String userCommand) {
        if(! (userCommand.equals(Command.RETRY.getValue()) || userCommand.equals(Command.QUIT.getValue()))) {
            throw new IllegalArgumentException(ErrorMessage.NotValidUserCommand.getMessage());
        }
    }
}
