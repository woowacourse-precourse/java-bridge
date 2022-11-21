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
        System.out.println("\n다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        checkIsDigit(input);

        int bridgeSize = Integer.parseInt(input);
        checkBridgeLength(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        checkMoving(moving);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        checkCommand(command);

        return command;
    }

    public void checkIsDigit(String checkNumber) {
        for (int i = 0; i < checkNumber.length(); i++) {
            checkEachIsDigit(checkNumber.charAt(i));
        }
    }

    public void checkEachIsDigit(char checkNumber) {
        if (!Character.isDigit(checkNumber)) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력해야 합니다.");
        }
    }

    public void checkBridgeLength(int length) {
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하로 입력해야 합니다.");
        }
    }

    public void checkMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동은 U 또는 D만 입력 가능합니다.");
        }
    }

    public void checkCommand(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 입력은 R 또는 Q만 가능합니다.");
        }
    }
}
