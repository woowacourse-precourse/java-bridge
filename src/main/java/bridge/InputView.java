package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static int BRIDGE_SIZE_MINIMUM = 3;
    private static int BRIDGE_SIZE_MAXIMUM = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String line = Console.readLine();
        if (!isAllDigit(line))
            throw new IllegalArgumentException("다리의 길이에는 숫자만 입력할 수 있습니다");
        int bridgeSize = Integer.parseInt(line);
        if (!(BRIDGE_SIZE_MINIMUM <= bridgeSize && bridgeSize <= BRIDGE_SIZE_MAXIMUM))
            throw new IllegalArgumentException("다리의 길이는 3이상 20이하이어야만 합니다");
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String line = Console.readLine();
        if (!(line.equals("U") || line.equals("D")))
            throw new IllegalArgumentException("이동할 칸의 입력은 U또는 D여야 합니다");
        return line;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String line = Console.readLine();
        if (!(line.equals("R") || line.equals("Q")))
            throw new IllegalArgumentException("게임 커맨드의 입력은 R또는 Q여야 합니다");
        return line;
    }

    private boolean isAllDigit(String string) {
        return string.chars()
                .allMatch(Character::isDigit);
    }
}
