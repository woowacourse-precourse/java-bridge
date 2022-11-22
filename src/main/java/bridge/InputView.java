package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public InputView() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            String bridgeSize = Console.readLine();
            Exception.validateByNull(bridgeSize);
            Exception.validateByNotNumber(bridgeSize);
            int size = Integer.parseInt(bridgeSize);
            Exception.validateByOverRange(size);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            String move = Console.readLine();
            Exception.validateByNull(move);
            Exception.validateByNotUOrD(move);
            return move;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "[ERROR]";
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
