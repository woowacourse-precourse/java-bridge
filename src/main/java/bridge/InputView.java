package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        int size = changeToNumber(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해야 합니다.");
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해야 합니다.");
        }
        return gameCommand;
    }

    public int changeToNumber(String input) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        return number;
    }
}
