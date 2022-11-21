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
        System.out.println(SystemMessage.BRIDGE_SIZE_INPUT_MESSAGE);
        String temp = Console.readLine();
        int size = Integer.parseInt(temp);
//        validation
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(SystemMessage.MOVING_SPACE_INPUT_MESSAGE);
        String moving_space = Console.readLine();
        //        validation
        return moving_space;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

        System.out.println(SystemMessage.RETRY_GAME_INPUT_MESSAGE);
        String command = Console.readLine();
        //        validation
        return command;
    }
}
