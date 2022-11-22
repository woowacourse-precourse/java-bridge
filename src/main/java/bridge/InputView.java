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
        String size = Console.readLine();

        if (InvalidSizeCheck(size)) {
            throw new IllegalArgumentException(Messages.INVALID_SIZE.getErrorMsg());
        }
        System.out.println(Integer.valueOf(size) + "\n");
        return Integer.valueOf(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = Console.readLine();

        if (checkInvalidDirection(direction)) {
            throw new IllegalArgumentException(Messages.INVALID_DIRECTION.getErrorMsg());
        }
        System.out.println(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();

        if (checkInvalidCommand(command)) {
            throw new IllegalArgumentException(Messages.INVALID_COMMAND.getErrorMsg());
        }
        return command;
    }

    // 숫자 형식, 3-20 범위 확인
    private boolean InvalidSizeCheck(String size) {
        if (!size.matches("[3-9]|1[0-9]|2[0]")) {
            return true;
        }
        return false;
    }

    private boolean checkInvalidDirection(String direction) {
        if (direction.equals("U") || direction.equals("D")) {
            return false;
        }
        return true;
    }

    private boolean checkInvalidCommand(String command) {
        if (command.equals("R") || command.equals("Q")) {
            return false;
        }
        return true;
    }
}
