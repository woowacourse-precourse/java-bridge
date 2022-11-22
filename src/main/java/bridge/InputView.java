package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        int result = Integer.parseInt(bridgeSize);
        if (result < 3 || result > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        List<String> validMove = List.of("U", "D");

        if (!validMove.contains(moving)) {
            throw new IllegalArgumentException("이동할 칸에 대한 입력이 올바르지 않습니다.");
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        List<String> validCommand = List.of("R", "Q");

        if (!validCommand.contains(gameCommand)) {
            throw new IllegalArgumentException("게임을 다시 시도할지 여부에 대한 입력이 올바르지 않습니다.");
        }
        return gameCommand;
    }
}
