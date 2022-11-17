package bridge.view;

import bridge.domain.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    private static final String REQUEST_INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(REQUEST_INPUT_BRIDGE_LENGTH);
        try {
            int size = Integer.parseInt(Console.readLine());
            validateLength(size);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            return Direction.from(validateMoving(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            return validateReplayGame(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private String validateReplayGame(String command) {
        if ("Q".equals(command) || "R".equals(command)) {
            return command;
        }
        throw new IllegalArgumentException(" 재시작: R, 종료: Q로 입력해야 합니다.");
    }

    private String validateMoving(String moving) {
        if ("U".equals(moving) || "D".equals(moving)) {
            return moving;
        }
        throw new IllegalArgumentException("이동할 칸은 위: U, 아래: D로 입력해야 합니다.");
    }

    private void validateLength(int length) {
        if (length < MIN_BRIDGE_LENGTH || MAX_BRIDGE_LENGTH < length) {
            throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하의 값만 입력 가능합니다.");
        }
    }
}
