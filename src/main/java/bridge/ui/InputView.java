package bridge.ui;

import bridge.vo.GameCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력 받아 반환 한다.
     *
     * @return 다리의 길이 반환
     */
    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            int bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize >= 3 && bridgeSize <= 20)
                return bridgeSize;
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력 받아 반환 한다.
     *
     * @return 사용자가 이동할 칸 반환
     */
    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String nextCell = Console.readLine();
            if ("U".equals(nextCell) || "D".equals(nextCell))
                return nextCell;
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : U, D 입력 요구");
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     *
     * @return 게임 재진행 여부 반환
     */
    public GameCommand readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String gameCommand = Console.readLine();
            if ("R".equals(gameCommand)) return GameCommand.RETRY;
            if ("Q".equals(gameCommand)) return GameCommand.QUIT;
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : R, Q 입력 요구");
            return readGameCommand();
        }
    }
}
