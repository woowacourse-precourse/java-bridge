package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    CheckNum checkNum;

    public InputView(CheckNum checkNum) {
        this.checkNum = new CheckNum();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String _input = Console.readLine();
        checkNum.checkVoidOrSpace(_input);
        checkNum.checkString(_input);
        int bridgeSize = Integer.parseInt(_input);
        checkNum.checkNegative(bridgeSize);
        checkNum.checkRange(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String _input = Console.readLine();
        checkNum.checkVoidOrSpace(_input);
        checkNum.checkInputSize(_input);
        checkNum.checkUpOrDownInputRange(_input);
        return _input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
