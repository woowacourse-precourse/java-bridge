package bridge.Controller;

import bridge.View.Message;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private String size;
    private String moving;
    private String retry;

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.printf(Message.CHOICE_BRIDGE_SIZE.getView());
        size = readLine();
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.printf(Message.CHOICE_MOVE.getView());
        moving = readLine();
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.printf(Message.CHOICE_GAME.getView());
        retry = readLine();
        return retry;
    }
}
