package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.Moving;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return Integer.parseInt(readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(
                "이동할 칸을 선택해주세요. (" + Moving.UP.getExpression() + ": " + Moving.UP.getDescription()
                        + ", " + Moving.DOWN.getExpression() + ": " + Moving.DOWN.getDescription()
                        + ")");
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
