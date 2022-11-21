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
            return checkBridgeSize(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자를 입력하여야 합니다.");
        }
    }

    public int checkBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || 20 < bridgeSize)
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자를 입력하여야 합니다.");
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return checkMoving(Console.readLine());
    }

    public String checkMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D"))
            throw new IllegalArgumentException("[ERROR] U 와 D 중 하나의 문자를 입력하여야 합니다.");
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return checkGameCommand(Console.readLine());
    }

    public String checkGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q"))
            throw new IllegalArgumentException("[ERROR] R 와 Q 중 하나의 문자를 입력하여야 합니다.");
        return gameCommand;
    }
}
