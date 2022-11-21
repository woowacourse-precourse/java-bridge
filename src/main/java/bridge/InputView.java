package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * @return 입력받은 다리 사이즈. 숫자로 입력받는다.
     * @Exception IllegalArgumentException 숫자가 아니거나 3-20이내의 숫자가 아니면 예외가 발생한다.
     * <p>
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        int mappedBridgeSize = 0;
        try {
            mappedBridgeSize = Integer.parseInt(bridgeSize);
        } catch (Exception e) {
            throw new IllegalArgumentException("다리 길이는 숫자여야 합니다.");
        }
        if (!(3 <= mappedBridgeSize && mappedBridgeSize <= 20))
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return mappedBridgeSize;
    }

    /**
     * @return 입력받은 이동 위치. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * @Exception IllegalArgumentException 현재 D와 U 이외의 값은 지원하지 않는다.
     * <p>
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if (input.equals("U") || input.equals("D")) return input;
        throw new IllegalArgumentException("이동 위치는 U 또는 D 이어야합니다.");
    }

    /**
     * @return 입력받은 이동 위치. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * @Exception IllegalArgumentException 현재 D와 U 이외의 값은 지원하지 않는다.
     * <p>
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        if (input.equals("R") || input.equals("Q")) return input;
        throw new IllegalArgumentException("지원하는 입력 커맨드는 R과 Q입니다.");
    }
}
