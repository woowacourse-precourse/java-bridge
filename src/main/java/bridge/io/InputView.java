package bridge.io;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * - Package 변경 가능
 * - Method 인자, 이름, 반환 타입 변경 가능
 * - 필요 method 추가 가능
 */
public class InputView {

    public String readBridgeLength() {
        return Console.readLine();
    }

    public String readMovement() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
