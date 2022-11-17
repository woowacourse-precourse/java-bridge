package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int inputBridgeSize() {
        System.out.println(Message.INPUT_SIZE.getMessage());
        String inputSize = readLine();
        System.out.println();
        int bridgeSize = Integer.parseInt(inputSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String inputMovingDirection() {
        System.out.println(Message.SELECT_DIRECTION.getMessage());
        String inputDirection = readLine();
        return inputDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String inputGameRestart() {
        System.out.println(Message.ASK_RESTART.getMessage());
        String inputRestart = readLine();
        return inputRestart;
    }
}
