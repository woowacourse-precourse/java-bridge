package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        return Console.readLine();
    }

    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
