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
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String bridgeSize = Console.readLine();

            /* 예외 처리에 대한 내용 */
            InputException.validate(bridgeSize);
            return Integer.parseInt(bridgeSize);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String upOrDown = Console.readLine();
        // 예외 처리에 대한 내용

        return upOrDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String askTryGame = Console.readLine();

        return askTryGame;
    }
}
