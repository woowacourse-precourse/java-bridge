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
        String errorMessage = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
        int bridgeLength = getIntegerFromConsole(errorMessage);
        if (bridgeLength < 3 || bridgeLength > 20) {
            throw new IllegalArgumentException(errorMessage);
        }
        return bridgeLength;
    }

    private int getIntegerFromConsole(String errorMessage) {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = Console.readLine();
        if (direction.equals("U") || direction.equals("D")) {
            return direction;
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D이어야 합니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String choice = Console.readLine();
        if (choice.equals("R") || choice.equals("Q")) {
            return choice;
        }
        throw new IllegalArgumentException("[ERROR] 명령어는 R 또는 Q이어야 합니다.");
    }
}
