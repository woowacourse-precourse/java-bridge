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
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String userMovement = Console.readLine();

        validateUserMovement(userMovement);

        return userMovement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateBridgeRange(int bridgeSize) {
        if(bridgeSize < 3 || 20 < bridgeSize) {
            throw new IllegalArgumentException(ErrorMessage.NotValidBridgeSize.getMessage());
        }
    }

    private void validateUserMovement(String userMovement) {
        if(userMovement.equals(Movement.UP.getValue()) || userMovement.equals(Movement.DOWN.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.NotValidUserMovement.getMessage());
        }
    }
}
