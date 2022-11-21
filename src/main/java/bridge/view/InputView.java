package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        isNumber(bridgeSize);
        checkScope(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String upDown = Console.readLine();
        isMovingCommand(upDown);
        return upDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        checkCommand(command);
        return command;
    }

    public void isNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자를 입력해야 합니다.");
        }
    }

    public void checkScope(String number) {
        if (Integer.parseInt(number) < 3 || Integer.parseInt(number) > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void isMovingCommand(String alphabet) {
        if (!(alphabet.equals("U") || alphabet.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 윗칸(U)과 아래칸(D) 중 하나를 입력해야 합니다.");
        }
    }

    public void checkCommand(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시작(R)과 종료(Q) 중 하나를 입력해야 합니다.");
        }
    }
}
