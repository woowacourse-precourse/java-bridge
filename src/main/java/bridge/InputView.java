package bridge;

import bridge.utils.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static bridge.utils.constant.Constant.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        int length;
        try {
            length =  Integer.parseInt(size);
            if(length <3 || length > 20) {
                throw new IllegalArgumentException("[ERROR] Not in range 3 to 20");
            }
        } catch(NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] " + e.getMessage());
        }
        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if(!(move.equals(UP.getValue()) || move.equals(DOWN.getValue()))) {
            throw new IllegalArgumentException("[ERROR] invalid input not U or D");
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String quit =  Console.readLine();

        if(!(quit.equals(QUIT.getValue()) || quit.equals(RESTART.getValue()))) {
            throw new IllegalArgumentException("[ERROR] invalid input not Q or R");
        }
        return quit;
    }
}
