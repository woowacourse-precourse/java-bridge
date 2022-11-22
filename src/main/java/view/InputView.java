package view;

import controller.Util;

import static controller.Util.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() {
        System.out.println(InputMessage.SIZE_MESSAGE.getInputMessage());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void readMoving() {
        System.out.println(InputMessage.MOVING_MESSAGE.getInputMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public void readGameCommand() {
        System.out.println(InputMessage.RETRY_MESSAGE.getInputMessage());
    }

}
