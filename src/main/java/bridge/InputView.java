package bridge;

import static bridge.ErrorCheck.isItNumber;
import static bridge.ErrorCheck.stringToInt;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String inputBridgeLength = camp.nextstep.edu.missionutils.Console.readLine();
        isItNumber(inputBridgeLength);
        return stringToInt(inputBridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() { // U, D
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() { // R, Q
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
