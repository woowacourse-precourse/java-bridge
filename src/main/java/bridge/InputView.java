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
        String bridgeSize = Console.readLine();
        checkBridgeLength(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public void checkBridgeLength(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if(size > 20 || size < 3) {
                throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        checkReadMoving(move);
        return move;
    }

    public void checkReadMoving(String move) {
        if( !(move.equals("U") || move.equals("D")) ) {
            throw new IllegalArgumentException("[ERROR] 잘못된 움직임 입력입니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
