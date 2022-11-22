package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    final CheckNum checkNum = new CheckNum();

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

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String _input = Console.readLine();
        checkNum.checkVoidOrSpace(_input);
        checkNum.checkInputSize(_input);
        checkNum.checkUpOrDownInputRange(_input);
        return _input;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String _input = Console.readLine();
        checkNum.checkVoidOrSpace(_input);
        checkNum.checkInputSize(_input);
        checkNum.checkRestartInputRange(_input);
        return _input;
    }
}
