package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = 0;
        try {
            bridgeSize = ExceptionCase.isInputAllNumber(readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bridgeSize = readBridgeSize();
        }
        return bridgeSize;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveUpOrDown = readLine();
        try {
            ExceptionCase.isInputUpOrDown(moveUpOrDown);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveUpOrDown = readMoving();
        }
        return moveUpOrDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = readLine();
        try {
            ExceptionCase.isInputTry(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gameCommand = readMoving();
        }
        return gameCommand;
    }
}
