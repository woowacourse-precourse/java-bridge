package bridge.view;

import bridge.utils.enums.MoveFormat;
import bridge.utils.enums.RetryFormat;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return Console.readLine();
    }

    public String readMoving() {
        System.out.printf("\n이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n",
                MoveFormat.MOVE_UP.getLabel(),
                MoveFormat.MOVE_DOWN.getLabel());
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.printf("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n",
                RetryFormat.RETRY.getLabel(),
                RetryFormat.QUIT.getLabel());
        return Console.readLine();
    }
}
