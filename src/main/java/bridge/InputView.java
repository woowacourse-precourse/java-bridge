package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public List<String> readBridgeSize() {
        String size = Console.readLine();
        BridgeMaker test = new BridgeMaker(new BridgeRandomNumberGenerator());
        return test.makeBridge(Integer.parseInt(size));
    }

    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
