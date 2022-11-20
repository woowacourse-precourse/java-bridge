package bridge.View;

import bridge.Model.BridgeSize;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String number = readLine();
        int size;
        try {
            size = Integer.parseInt(number);
        } catch(NumberFormatException numberFormatException){
            throw new NumberFormatException("올바른 값을 입력해주세요");
        }

        return new BridgeSize(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
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
